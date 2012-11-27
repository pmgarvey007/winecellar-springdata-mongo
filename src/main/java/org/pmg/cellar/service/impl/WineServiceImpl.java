package org.pmg.cellar.service.impl;


import org.pmg.cellar.domain.Wine;
import org.pmg.cellar.repository.WineRepository;
import org.pmg.cellar.service.WineService;
import org.pmg.cellar.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "wineService")
public class WineServiceImpl implements WineService {
    private static final Logger LOG = LoggerFactory.getLogger(WineServiceImpl.class);

    @Autowired
    private WineRepository wineRepository;

    public List<Wine> findAll(){
        return (ArrayList<Wine>)wineRepository.findAll();
    }

    public Wine findById(Long id) {
        return wineRepository.findOne(id);
    }

    public List<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }

    public Wine save(Wine wine)	{
       if(wine == null) return null;

       //if an Id exists then attempt to do an update
       if(wine.getId() != null){
           return update(wine);
       }

       //save the new wine
       wine.setId(Long.valueOf(RandomUtil.nextLong()));
       return wineRepository.save(wine);
	}

	public Wine update(Wine wine) {
        if(wine == null) return null;

        //check if the wine already exists
		boolean exists = wineRepository.exists(wine.getId());

        //inserts a new wine if wine don't exists
		if (!exists) {
            wine.setId(RandomUtil.nextLong());
			return wineRepository.save(wine);
		}

        //update wine since it already exists
		Wine retWine = new Wine();
        retWine.setId(wine.getId());
        retWine.setName(wine.getName());
        retWine.setGrapes(wine.getGrapes());
        retWine.setCountry(wine.getCountry());
        retWine.setRegion(wine.getRegion());
        retWine.setPicture(wine.getPicture());
        retWine.setYear(wine.getYear());
        retWine.setDescription(wine.getDescription());
		return wineRepository.save(retWine);
	}

    public boolean remove(Long id) {
        //check if the wine to be removed already exists
        boolean exists = wineRepository.exists(id);
        //if wine to be removed doesn't exists then return false
        if (!exists) {
			return false;
		}
        //wine does exists so remove it
        wineRepository.delete(id);
        return true;
    }
}
