package com.websites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/websites")
@CrossOrigin
public class WebsitesController {

    @Autowired
    private WebsitesService websitesService;

    @GetMapping("/{name}")
    public WebpagesResponse getCollegeWebsites(@PathVariable String name) {
        return new WebpagesResponse(websitesService.getWebsitesByName(name));
    }
}
