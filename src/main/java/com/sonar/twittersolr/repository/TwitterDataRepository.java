package com.sonar.twittersolr.repository;

import com.sonar.twittersolr.model.TwitterData;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterDataRepository extends SolrCrudRepository<TwitterData, String> {
}
