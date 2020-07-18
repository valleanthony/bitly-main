package com.redirect.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "WebKey")
public class WebKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    //Short code
    @Column(name = "key")
    private String key;
    // Redirect destination
    @Column(name = "url")
    private String url;

    public WebKey() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setUrl(String uri) {
        this.url = uri;
    }
}
