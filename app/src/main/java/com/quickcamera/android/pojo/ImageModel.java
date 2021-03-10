package com.quickcamera.android.pojo;

public class ImageModel {
    int count;
    String uri;
    String name;

    public ImageModel(int count, String uri, String name) {
        this.count = count;
        this.uri = uri;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
