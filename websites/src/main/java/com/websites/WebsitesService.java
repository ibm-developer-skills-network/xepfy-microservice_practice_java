package com.websites;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebsitesService {

    private List<Websites> websites;

    private final ObjectMapper objectMapper;

    public WebsitesService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadWebsites() throws IOException {
        ClassPathResource resource = new ClassPathResource("UK_Universities.json");
        websites = objectMapper.readValue(resource.getInputStream(), 
                     new TypeReference<List<Websites>>() {});
    }


    public List<String> getWebsitesByName(String name) {
        return websites.stream()
            .filter(u -> u.getName().equals(name))
            .findFirst()
            .map(Websites::getWebPages)
            .orElse(new ArrayList<>());
    }
}
