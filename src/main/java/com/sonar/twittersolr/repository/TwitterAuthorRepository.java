package com.sonar.twittersolr.repository;

import com.sonar.twittersolr.model.TwitterAuthor;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;

@Repository
public interface TwitterAuthorRepository extends SolrCrudRepository<TwitterAuthor, LinkedHashMap<String, Object>> {
}
