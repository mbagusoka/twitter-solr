package com.sonar.twittersolr.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonar.twittersolr.dto.TwitterDTO;
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
            TwitterDTO twitterDTO = new ObjectMapper().readValue(exchange.getIn().getBody(String.class), TwitterDTO.class);
            TwitterData twitterData = new TwitterData(twitterDTO.getFields());
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
            TwitterDTO twitterDTO = new ObjectMapper().readValue(exchange.getIn().getBody(String.class), TwitterDTO.class);
            TwitterAuthor twitterAuthor = new TwitterAuthor(twitterDTO.getFields());
            twitterAuthorRepository.save(twitterAuthor);
            exchange.getIn().setBody(twitterAuthor);
        } catch (JsonParseException | JsonMappingException e) {
            LOGGER.error("JsonException: ", e);
        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
        }
    }
}
