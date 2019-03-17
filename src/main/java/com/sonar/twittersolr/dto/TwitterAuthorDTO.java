package com.sonar.twittersolr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitterAuthorDTO {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("User_Name")
    private String username;

    @JsonProperty("Screen_Name")
    private String screenName;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Social_Media_Role")
    private String socialMediaRole;

    @JsonProperty("Url_Username")
    private String urlUsername;

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

    public String getUrlUsername() {
        return urlUsername;
    }

    public void setUrlUsername(String urlUsername) {
        this.urlUsername = urlUsername;
    }
}
