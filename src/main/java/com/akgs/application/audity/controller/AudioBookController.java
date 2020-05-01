package com.akgs.application.audity.controller;

import com.akgs.application.audity.data.entity.AudioBook;
import com.akgs.application.audity.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/audiobooks", produces = "application/json")
public class AudioBookController {
    @Autowired
    AudiobookService audiobookService;

    @GetMapping
    public List<AudioBook> getAll(){
        return audiobookService.get();
    }
    @PostMapping
    public void addAudioBook(@RequestBody AudioBook audioBook){
        audiobookService.add(audioBook);
    }
}
