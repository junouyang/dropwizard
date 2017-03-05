package com.learning;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class LearningConfiguration extends Configuration {
    private String dictPath;


    @JsonProperty("dict")
    public void setDictPath(String dictPath) {
        this.dictPath = dictPath;
    }

    @JsonProperty("dict")
    public String getDictPath() {
        return dictPath;
    }
}
