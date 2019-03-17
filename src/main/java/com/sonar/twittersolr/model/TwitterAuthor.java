package com.sonar.twittersolr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Map;

@SolrDocument(collection = "twitter_author")
public class TwitterAuthor {

    public TwitterAuthor(Map<String, Object> fields) {
        this.fields = fields;
    }

    public TwitterAuthor() {}

    @Id
    @Indexed
    @Field("*")
    private Map<String, Object> fields;

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
