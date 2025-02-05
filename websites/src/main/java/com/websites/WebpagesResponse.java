package com.websites;

import java.util.List;

public class WebpagesResponse {
    private List<String> Webpages;

    public WebpagesResponse(List<String> webpages) {
        this.Webpages = webpages;
    }

    public List<String> getWebpages() {
        return Webpages;
    }

    public void setWebpages(List<String> webpages) {
        this.Webpages = webpages;
    }
}
