package com.sonar.twittersolr;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonar.twittersolr.dto.TwitterDTO;
import com.sonar.twittersolr.repository.TwitterDataRepository;
import com.sonar.twittersolr.service.TwitterCrudService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterCrudServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterCrudServiceTest.class);

    @Autowired
    private TwitterDataRepository twitterDataRepository;

    @Autowired
    private TwitterCrudService twitterCrudService;

    @Value("${test.file.path}")
    private String testFilePath;

    private TwitterDTO getDTO() {
        TwitterDTO twitterDTO = null;

        try {
            File file = new File(testFilePath);

            twitterDTO = new ObjectMapper().readValue(file, TwitterDTO.class);
        } catch (JsonParseException | JsonMappingException e) {
            LOGGER.error("JsonException: ", e);
        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
        }

        return twitterDTO;
    }

    @Test
    public void saveDataTest() {
        try {
            twitterCrudService.saveData(this.getDTO());
            Assert.assertNotNull(twitterDataRepository.findAll());
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }
    }
}
