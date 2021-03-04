package com.example.authtry1;


public class Member {

    private String title;
    private String url;

    private Member(){}

    public Member(String name,String videoUri){
        if (name.trim().equals("")){
            name = " not available";
        }
        title = name;
        url = videoUri;
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
