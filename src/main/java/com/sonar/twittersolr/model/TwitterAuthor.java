package com.sonar.twittersolr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.UUID;

@SolrDocument(collection = "twitter_author")
public class TwitterAuthor {

    public TwitterAuthor(String source, String username, String screenName, String description, String socialMediaRole, String urlUserName) {
        this.setId(UUID.randomUUID().toString());
        this.source = source;
        this.username = username;
        this.screenName = screenName;
        this.description = description;
        this.socialMediaRole = socialMediaRole;
        this.urlUserName = urlUserName;
    }

    public TwitterAuthor() {
        this.setId(UUID.randomUUID().toString());
    }

    @Id
    @Indexed("id")
    private String id;

    @Indexed("source")
    private String source;

    @Indexed("username")
    private String username;

    @Indexed("screen_name")
    private String screenName;

    @Indexed("description")
    private String description;

    @Indexed("social_media_role")
    private String socialMediaRole;

    @Indexed("url_username")
    private String urlUserName;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSocialMediaRole() {
        return socialMediaRole;
    }

    public void setSocialMediaRole(String socialMediaRole) {
        this.socialMediaRole = socialMediaRole;
    }

    public String getUrlUserName() {
        return urlUserName;
    }

    public void setUrlUserName(String urlUserName) {
        this.urlUserName = urlUserName;
    }
}
