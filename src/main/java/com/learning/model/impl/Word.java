package com.learning.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class Word {
    private long id;
    private String word;
    private String meaning;
    private String phoneticSymbol;

    public Word(long id, String word, String meaning, String phoneticSymbol ) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.phoneticSymbol = phoneticSymbol;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @JsonProperty
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @JsonProperty
    public String getPhoneticSymbol() {
        return phoneticSymbol;
    }

    public void setPhoneticSymbol(String phoneticSymbol) {
        this.phoneticSymbol = phoneticSymbol;
    }

}
