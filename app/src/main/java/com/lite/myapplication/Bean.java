package com.lite.myapplication;

/**
 * Created by Saket on 28,July,2019
 */
public class Bean {

    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
