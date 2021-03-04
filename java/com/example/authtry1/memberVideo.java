package com.example.authtry1;

public class memberVideo {
    private String title;
    private String url;
    public memberVideo(){}

    public memberVideo(String title, String url) {
        this.title = title;
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}