package com.sonar.twittersolr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.lang.Object;
import java.util.Map;

@SolrDocument(collection = "twitter_data")
public class TwitterData {

    public TwitterData(Map<String, Object> fields) {
        this.fields = fields;
    }

    public TwitterData() {}

    @Id
    @Indexed
    @Field("*")
    private Map<String, Object> fields;

    public Map<String, Object> getValues() {
        return fields;
    }

    public void setValues(Map<String, Object> fields) {
        this.fields = fields;
    }
}
