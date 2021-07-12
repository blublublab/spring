package com.restapi.lesson1.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String text;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message(String text, String tag, User user) {
        this.user = user;
        this.text = text;
        this.tag = tag;
    }

    public Message(){

    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
