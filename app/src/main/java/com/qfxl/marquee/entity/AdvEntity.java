package com.qfxl.marquee.entity;

/**
 * Created by taomin on 2018/11/22.
 */

public class AdvEntity {
    private String title;
    private String content;

    public AdvEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
