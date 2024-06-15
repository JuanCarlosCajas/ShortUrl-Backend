package com.JuanCarlos.shortUrl.controller;

import com.JuanCarlos.shortUrl.modal.Url;
import com.JuanCarlos.shortUrl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortner")
@CrossOrigin(origins = "http://localhost:4200/")
public class UrlController {

    @Autowired
    private  UrlService urlService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOriginUrl(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, urlService.getOriginalUrl(id))
                .build();
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }
}
