package com.colleges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colleges")
@CrossOrigin
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping
    public CollegeResponse getAllColleges() {
        return new CollegeResponse(collegeService.getAllColleges());
    }

    @GetMapping("/{name}")
    public CollegeResponse getCollegesByName(@PathVariable String name) {
        return new CollegeResponse(collegeService.getCollegesByName(name));
    }
}

