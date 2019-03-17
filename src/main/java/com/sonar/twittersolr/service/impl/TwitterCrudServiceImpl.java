package com.sonar.twittersolr.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonar.twittersolr.dto.TwitterAuthorDTO;
import com.sonar.twittersolr.dto.TwitterDataDTO;
import com.sonar.twittersolr.model.TwitterAuthor;
import com.sonar.twittersolr.model.TwitterData;
import com.sonar.twittersolr.repository.TwitterAuthorRepository;
import com.sonar.twittersolr.repository.TwitterDataRepository;
import com.sonar.twittersolr.service.TwitterCrudService;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class TwitterCrudServiceImpl implements TwitterCrudService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterCrudServiceImpl.class);

    private final TwitterDataRepository twitterDataRepository;
    private final TwitterAuthorRepository twitterAuthorRepository;

    @Autowired
    public TwitterCrudServiceImpl(TwitterDataRepository twitterDataRepository, TwitterAuthorRepository twitterAuthorRepository) {
        this.twitterDataRepository = twitterDataRepository;
        this.twitterAuthorRepository = twitterAuthorRepository;
    }

    @Override
    @Transactional
    public void saveData(Exchange exchange) {
        try {
            TwitterDataDTO twitterDataDTO = new ObjectMapper().readValue(exchange.getIn().getBody(String.class), TwitterDataDTO.class);
            TwitterData twitterData = new TwitterData(
                    twitterDataDTO.getId(),
                    twitterDataDTO.getUsername(),
                    twitterDataDTO.getSource(),
                    twitterDataDTO.getPostUrl(),
                    twitterDataDTO.getContent(),
                    twitterDataDTO.getUrlUsername(),
                    twitterDataDTO.getPostType(),
                    twitterDataDTO.getRefPostId(),
                    twitterDataDTO.getRefPostUsername(),
                    twitterDataDTO.getRefPost(),
                    twitterDataDTO.getCity(),
                    twitterDataDTO.getProvince(),
                    twitterDataDTO.getCountry(),
                    twitterDataDTO.getLongitude(),
                    twitterDataDTO.getLatitude(),
                    twitterDataDTO.getTransactionDate(),
                    twitterDataDTO.getSentiment()
            );
            twitterDataRepository.save(twitterData);
            exchange.getIn().setBody(twitterData);
        } catch (JsonParseException | JsonMappingException e) {
            LOGGER.error("JsonException: ", e);
        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
        }
    }

    @Override
    @Transactional
    public void saveAuthor(Exchange exchange) {
        try {
            TwitterAuthorDTO twitterAuthorDTO = new ObjectMapper().readValue(exchange.getIn().getBody(String.class), TwitterAuthorDTO.class);
            TwitterAuthor twitterAuthor = new TwitterAuthor(
                    twitterAuthorDTO.getSource(),
                    twitterAuthorDTO.getUsername(),
                    twitterAuthorDTO.getScreenName(),
                    twitterAuthorDTO.getDescription(),
                    twitterAuthorDTO.getSocialMediaRole(),
                    twitterAuthorDTO.getUrlUsername());
            twitterAuthorRepository.save(twitterAuthor);
            exchange.getIn().setBody(twitterAuthor);
        } catch (JsonParseException | JsonMappingException e) {
            LOGGER.error("JsonException: ", e);
        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
        }
    }
}
