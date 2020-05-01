package com.akgs.application.audity.service.impl;

import com.akgs.application.audity.data.entity.AudioBook;
import com.akgs.application.audity.data.repository.AudioBookRepository;
import com.akgs.application.audity.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioBookServiceImpl implements AudiobookService {
    @Autowired
    private AudioBookRepository audioBookRepository;

    @Override
    public List<AudioBook> get() {
        return (List<AudioBook>) audioBookRepository.findAll();
    }

    @Override
    public void add(AudioBook audioBook) {
        audioBookRepository.save(audioBook);
    }
}
