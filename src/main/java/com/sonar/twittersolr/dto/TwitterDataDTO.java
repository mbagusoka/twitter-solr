package com.sonar.twittersolr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitterDataDTO {

    @JsonProperty("Post_Id")
    private String id;

    @JsonProperty("User_Name")
    private String username;

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Post_URL")
    private String postUrl;

    @JsonProperty("Content")
    private String content;

    @JsonProperty("Url_Username")
    private String urlUsername;

    @JsonProperty("Post_Type")
    private String postType;

    @JsonProperty("Referenced_Post_Id")
    private String refPostId;

    @JsonProperty("Referenced_Post_Username")
    private String refPostUsername;

    @JsonProperty("Referenced_Post")
    private String refPost;

    @JsonProperty("City")
    private String city;

    @JsonProperty("Province")
    private String province;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Longitude")
    private String longitude;

    @JsonProperty("Latitude")
    private String latitude;

    @JsonProperty("Transaction_Dttm")
    private String transactionDate;

    @JsonProperty("Sentiment")
    private String sentiment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlUsername() {
        return urlUsername;
    }

    public void setUrlUsername(String urlUsername) {
        this.urlUsername = urlUsername;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getRefPostId() {
        return refPostId;
    }

    public void setRefPostId(String refPostId) {
        this.refPostId = refPostId;
    }

    public String getRefPostUsername() {
        return refPostUsername;
    }

    public void setRefPostUsername(String refPostUsername) {
        this.refPostUsername = refPostUsername;
    }

    public String getRefPost() {
        return refPost;
    }

    public void setRefPost(String refPost) {
        this.refPost = refPost;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
