package com.sonar.twittersolr.router;

import com.sonar.twittersolr.service.TwitterCrudService;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TwitterRouter extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterRouter.class);

    private final ApplicationContext applicationContext;

    @Value("${twitter.data.folder}")
    private String twitterDataFolder;

    @Value("${jms.queue.data}")
    private String jmsQueueData;

    @Value("${jms.data.max.concurrent}")
    private String dataMaxConcurrent;

    @Value("${twitter.author.folder}")
    private String twitterAuthorFolder;

    @Value("${jms.queue.author}")
    private String jmsQueueAuthor;

    @Value("${jms.author.max.concurrent}")
    private String authorMaxConcurrent;

    @Autowired
    public TwitterRouter(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configure() {
        try {
            from("file://".concat(twitterDataFolder).concat("?charset=UTF-8"))
                    .split(body().tokenize("\n")).streaming()
                    .to(jmsQueueData);

            from(jmsQueueData.concat("?maxConcurrentConsumers=".concat(dataMaxConcurrent)))
                    .bean(applicationContext.getBean(TwitterCrudService.class), "processData")
                    .log("Data saved to Solr");

            from("file://".concat(twitterAuthorFolder).concat("?charset=UTF-8"))
                    .split(body().tokenize("\n")).streaming()
                    .to(jmsQueueAuthor);

            from(jmsQueueAuthor.concat("?maxConcurrentConsumers=".concat(authorMaxConcurrent)))
                    .bean(applicationContext.getBean(TwitterCrudService.class), "processAuthor")
                    .log("Author saved to Solr");

            LOGGER.info("Twitter Router Configured");
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }
    }
}
