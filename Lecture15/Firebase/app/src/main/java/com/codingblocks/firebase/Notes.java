package com.codingblocks.firebase;

/**
 * Created by harshitdwivedi on 1/4/18.
 */

public class Notes {
    private String title, description;

    public Notes() {
    }

    public Notes(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
