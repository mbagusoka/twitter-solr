package com.sonar.twittersolr.service;

import org.apache.camel.Exchange;

public interface TwitterCrudService {

    void saveData(Exchange exchange);

    void saveAuthor(Exchange exchange);
}
