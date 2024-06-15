package com.JuanCarlos.shortUrl.service;

import com.JuanCarlos.shortUrl.modal.Url;
import com.JuanCarlos.shortUrl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.JuanCarlos.shortUrl.logic.GenerateShortUrl.getShortUrl;
import static com.JuanCarlos.shortUrl.logic.GenerateShortUrl.isUrlValid;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String getOriginalUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url){
        if(!isUrlValid(url)){
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));
        return urlRepository.save(urlObject);
    }
}
