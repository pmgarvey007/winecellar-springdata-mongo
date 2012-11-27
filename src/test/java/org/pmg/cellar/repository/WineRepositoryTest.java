package org.pmg.cellar.repository;


import org.pmg.cellar.domain.Wine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.pmg.cellar.util.RandomUtil.nextLong;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@SuppressWarnings({"SpringJavaAutowiringInspection"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class WineRepositoryTest {
    private static final Logger LOG = LoggerFactory.getLogger(WineRepositoryTest.class);
    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private MongoOperations mongoOperations;
    private static Long idUsed;

    @Test
    public void testSaveWine() {

        if (mongoOperations.collectionExists(Wine.class)) {
            mongoOperations.dropCollection(Wine.class);
        }
        mongoOperations.createCollection(Wine.class);
        
        Wine wine = new Wine();
        wine.setId(nextLong());
        wine.setName("CHATEAU DE SAINT COSME");
        wine.setYear("2009");
        wine.setGrapes("Grenache / Syrah");
        wine.setCountry("France");
        wine.setRegion("Southern Rhone / Gigondas");
        wine.setDescription("The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine.");
        wine.setPicture("saint_cosme.jpg");
        wineRepository.save(wine);
        idUsed = wine.getId();
        assertThat("user was not saved", idUsed > 0L, is(true));
    }


    @Test
    public void testFindOneWine() {
        Wine wine = wineRepository.findOne(idUsed);
        assertThat("wine is null", wine, is(notNullValue()));
    }


    @Test
    public void testFindAndUpdateWine() {
        Wine wine = wineRepository.findOne(idUsed);
        wine.setCountry("USA");
        wineRepository.save(wine);

        Wine updatedWine = wineRepository.findOne(wine.getId());
        assertNotNull("can't find the updated wine", updatedWine);
        assertThat(updatedWine.getCountry(), is(equalTo("USA")));
    }

    @Test
    public void testCountWine() {
        long count = wineRepository.count();
        assertThat(count == 1, is(true));
    }


    @Test
    public void testWineExits() {
        boolean exists = wineRepository.exists(idUsed);
        assertThat(exists, is(true));
    }



    @Test
    public void testDeleteWine() {
        wineRepository.delete(idUsed);
        Wine wine = wineRepository.findOne(idUsed);
        assertThat(wine, is(nullValue()));
    }
}