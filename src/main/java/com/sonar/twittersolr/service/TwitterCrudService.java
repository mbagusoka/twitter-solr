package com.sonar.twittersolr.service;

import com.sonar.twittersolr.dto.TwitterDTO;
import com.sonar.twittersolr.model.TwitterAuthor;
import com.sonar.twittersolr.model.TwitterData;
import org.apache.camel.Exchange;

public interface TwitterCrudService {

    TwitterData saveData(TwitterDTO twitterDTO);

    TwitterAuthor saveAuthor(TwitterDTO twitterDTO);

    void processData(Exchange exchange);

    void processAuthor(Exchange exchange);
}
