package com.websites;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Websites {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("web_pages")
    private List<String> webPages;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }
}
