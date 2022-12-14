package com.repository;

import com.entities.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends CrudRepository<Reading, Integer> {
}
