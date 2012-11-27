package org.pmg.cellar.repository;

import org.pmg.cellar.domain.Wine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WineRepository extends CrudRepository<Wine, Long> {
    List<Wine> findByName(String name);
}
