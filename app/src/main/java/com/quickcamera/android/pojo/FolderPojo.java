package com.quickcamera.android.pojo;

import android.net.Uri;

public class FolderPojo {

    String name;
    Uri uri;
    String uriString;

    public FolderPojo(String name, Uri uri, String uriString) {
        this.name = name;
        this.uri = uri;
        this.uriString = uriString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getUriString() {
        return uriString;
    }

    public void setUriString(String uriString) {
        this.uriString = uriString;
    }

}
