package com.sonar.twittersolr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "twitter_data")
public class TwitterData {

    public TwitterData(String id, String username, String source, String postUrl, String content, String urlUsername, String postType, String refPostId, String refPostUsername, String refPost, String city, String province, String country, String longitude, String latitude, String transactionDate, String sentiment) {
        this.id = id;
        this.username = username;
        this.source = source;
        this.postUrl = postUrl;
        this.content = content;
        this.urlUsername = urlUsername;
        this.postType = postType;
        this.refPostId = refPostId;
        this.refPostUsername = refPostUsername;
        this.refPost = refPost;
        this.city = city;
        this.province = province;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.transactionDate = transactionDate;
        this.sentiment = sentiment;
    }

    public TwitterData() {}

    @Id
    @Indexed("id")
    private String id;

    @Indexed("username")
    private String username;

    @Indexed("source")
    private String source;

    @Indexed("post_url")
    private String postUrl;

    @Indexed("content")
    private String content;

    @Indexed("url_username")
    private String urlUsername;

    @Indexed("post_type")
    private String postType;

    @Indexed("referenced_post_id")
    private String refPostId;

    @Indexed("referenced_post_username")
    private String refPostUsername;

    @Indexed("referenced_post")
    private String refPost;

    @Indexed("city")
    private String city;

    @Indexed("province")
    private String province;

    @Indexed("country")
    private String country;

    @Indexed("longitude")
    private String longitude;

    @Indexed("latitude")
    private String latitude;

    @Indexed("transaction_date")
    private String transactionDate;

    @Indexed("sentiment")
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
