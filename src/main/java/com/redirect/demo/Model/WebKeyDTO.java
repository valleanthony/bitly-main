package com.redirect.demo.Model;

public class WebKeyDTO {

    //Short code
    private String key;
    // Redirect destination
    private String url;

    public WebKeyDTO(String key, String url) {
        this.key = key;
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUri(String url) {
        this.url = url;
    }
}
