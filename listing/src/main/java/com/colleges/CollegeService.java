package com.colleges;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeService {

    private List<College> colleges;

    private final ObjectMapper objectMapper;

    public CollegeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadColleges() throws IOException {
        ClassPathResource resource = new ClassPathResource("UK_Universities.json");
        colleges = objectMapper.readValue(resource.getInputStream(), 
                     new TypeReference<List<College>>() {});
    }

    public List<String> getAllColleges() {
        return colleges.stream()
                .map(College::getName)
                .collect(Collectors.toList());
    }

    public List<String> getCollegesByName(String name) {
        return colleges.stream()
                .map(College::getName)
                .filter(collegeName -> collegeName.contains(name))
                .collect(Collectors.toList());
    }
}

