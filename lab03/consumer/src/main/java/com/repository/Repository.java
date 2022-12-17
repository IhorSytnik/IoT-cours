package com.repository;

import com.entities.Reading;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Reading, Integer> {
}
