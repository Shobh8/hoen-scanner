package com.hoenscanner.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

    @JsonProperty
    private String city;

    public Search() {}

    public String getCity() {
        return city;
    }
}
