package com.colleges;

import java.util.List;

public class CollegeResponse {
    private List<String> colleges;

    public CollegeResponse(List<String> colleges) {
        this.colleges = colleges;
    }

    public List<String> getColleges() {
        return colleges;
    }

    public void setColleges(List<String> colleges) {
        this.colleges = colleges;
    }
}