package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String userName;
    private Integer points;
    private List<Widget> widgets;

    public User() {
    }

    public User(String firstName, String lastName, String userName, Integer points, List<Widget> widgets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.points = points;
        this.widgets = widgets;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
