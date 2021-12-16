package com.romulomotta.checkpoint.model.entity;

import java.io.Serializable;

public class Jikan implements Serializable {
    private static final long SerialVersionUID = 1L;

    private String request_hash;
    private Boolean request_cached;
    private Integer request_cache_expiry;
    private Top[] top;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(Boolean request_cached) {
        this.request_cached = request_cached;
    }

    public Integer getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(Integer request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

    public Top[] getTop() {
        return top;
    }

    public void setTop(Top[] top) {
        this.top = top;
    }
}
