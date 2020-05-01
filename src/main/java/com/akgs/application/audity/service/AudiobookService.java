package com.akgs.application.audity.service;

import com.akgs.application.audity.data.entity.AudioBook;
import com.akgs.application.audity.data.repository.AudioBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public interface AudiobookService {
    public List<AudioBook> get();

    void add(AudioBook audioBook);
}
