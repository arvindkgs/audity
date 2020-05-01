package com.akgs.application.audity.data.repository;

import com.akgs.application.audity.data.entity.AudioBook;
import org.springframework.data.repository.CrudRepository;

public interface AudioBookRepository extends CrudRepository<AudioBook, Long> {
}
