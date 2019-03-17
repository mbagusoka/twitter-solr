package com.sonar.twittersolr.repository;

import com.sonar.twittersolr.model.TwitterData;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;

@Repository
public interface TwitterDataRepository extends SolrCrudRepository<TwitterData, LinkedHashMap<String, Object>> {
}
