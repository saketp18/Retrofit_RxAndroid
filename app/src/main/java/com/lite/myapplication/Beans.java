package com.lite.myapplication;

/**
 * Created by Saket on 30,July,2019
 */
public class Beans {

    private int id;
    private String title;

    public Beans(int id, String title) {
        this.id = id;
        this.title = title;
    }

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
        return "Beans{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
