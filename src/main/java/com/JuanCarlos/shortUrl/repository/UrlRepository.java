package com.JuanCarlos.shortUrl.repository;

import com.JuanCarlos.shortUrl.modal.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "select originalurl from Url where shorturl = ?1", nativeQuery = true)
    String findByShortUrl(String id);
}
