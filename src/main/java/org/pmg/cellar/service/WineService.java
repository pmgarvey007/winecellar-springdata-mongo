package org.pmg.cellar.service;

import org.pmg.cellar.domain.Wine;

import java.util.List;


public interface WineService {
    List<Wine> findAll();

    Wine findById(Long id);

    List<Wine> findByName(String name);

    Wine save(Wine wine);

    Wine update(Wine wine);

    boolean remove(Long id);
}
