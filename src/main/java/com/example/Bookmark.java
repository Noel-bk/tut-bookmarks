package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Noel on 12/5/16.
 */
@Entity
@Getter
public class Bookmark {

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue
    private Long id;

    Bookmark() { // jpa only
    }

    public Bookmark(Account account, String uri, String description) {
        this.uri = uri;
        this.description = description;
        this.account = account;
    }

    public String uri;
    public String description;

}
