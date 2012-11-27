package org.pmg.cellar.service.impl;

import org.pmg.cellar.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;

/**
 * Service for initializing MongoDB with sample data using {@link MongoTemplate}
 */
public class InitMongoService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void init() {
        // Drop existing collections
        if(mongoTemplate.collectionExists(Wine.class)){
		   mongoTemplate.dropCollection(Wine.class);
        }
        mongoTemplate.createCollection(Wine.class);

        ArrayList<Wine> wineList = new ArrayList<Wine>();
        wineList.add(new Wine(1L, "CHATEAU DE SAINT COSME", "2009", "Grenache / Syrah", "France", "Southern Rhone / Gigondas", "The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine, which makes an excellent complement to fish dishes.", "saint_cosme.jpg"));
        wineList.add(new Wine(2L, "LAN RIOJA CRIANZA", "2006", "Tempranillo", "Spain", "Rioja", "A resurgence of interest in boutique vineyards has opened the door for this excellent foray into the dessert wine market. Light and bouncy, with a hint of black truffle, this wine will not fail to tickle the taste buds.", "lan_rioja.jpg"));
        wineList.add(new Wine(3L, "MARGERUM SYBARITE", "2010", "Sauvignon Blanc", "USA", "California Central Cosat", "The cache of a fine Cabernet in ones wine cellar can now be replaced with a childishly playful wine bubbling over with tempting tastes of\nblack cherry and licorice. This is a taste sure to transport you back in time.", "margerum.jpg"));
        wineList.add(new Wine(4L, "OWEN ROE\'EX UMBRIS\'", "2009", "Syrah", "USA", "Washington", "A one-two punch of black pepper and jalapeno will send your senses reeling, as the orange essence snaps you back to reality. Don\'t miss\nthis award-winning taste sensation.", "ex_umbris.jpg"));
        wineList.add(new Wine(5L, "REX HILL", "2009", "Pinot Noir", "USA", "Oregon", "One cannot doubt that this will be the wine served at the Hollywood award shows, because it has undeniable star power. Be the first to catch\nthe debut that everyone will be talking about tomorrow.", "rex_hill.jpg"));
        wineList.add(new Wine(6L, "VITICCIO CLASSICO RISERVA", "2007", "Sangiovese Merlot", "Italy", "Tuscany", "Though soft and rounded in texture, the body of this wine is full and rich and oh-so-appealing. This delivery is even more impressive when one takes note of the tender tannins that leave the taste buds wholly satisfied.", "viticcio.jpg"));
        wineList.add(new Wine(7L, "CHATEAU LE DOYENNE", "2005", "Merlot", "France", "Bordeaux", "Though dense and chewy, this wine does not overpower with its finely balanced depth and structure. It is a truly luxurious experience for the\nsenses.", "le_doyenne.jpg"));
        wineList.add(new Wine(8L, "DOMAINE DU BOUSCAT", "2009", "Merlot", "France", "Bordeaux", "The light golden color of this wine belies the bright flavor it holds. A true summer wine, it begs for a picnic lunch in a sun-soaked vineyard.", "bouscat.jpg"));
        wineList.add(new Wine(9L, "BLOCK NINE", "2009", "Pinot Noir", "USA", "California", "With hints of ginger and spice, this wine makes an excellent complement to light appetizer and dessert fare for a holiday gathering.", "block_nine.jpg"));
        wineList.add(new Wine(10L, "DOMAINE SERENE", "2007", "Pinot Noir", "USA", "Oregon", "Though subtle in its complexities, this wine is sure to please a wide range of enthusiasts. Notes of pomegranate will delight as the nutty finish completes the picture of a fine sipping experience.", "domaine_serene.jpg"));
        wineList.add(new Wine(11L, "BODEGA LURTON", "2011", "Pinot Gris", "Argentina", "Mendoza", "Solid notes of black currant blended with a light citrus make this wine an easy pour for varied palates.", "bodega_lurton.jpg"));
        wineList.add(new Wine(12L, "LES MORIZOTTES", "2009", "Chardonnay", "France", "Burgundy", "Breaking the mold of the classics, this offering will surprise and undoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Breaking the mold of the classics, this offering will surprise and\nundoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Sure to please the late-night crowd with the slight jolt of adrenaline it brings.", "morizottes.jpg"));
        wineList.add(new Wine(13L, "SANGSTER\'S RUM CREAM", "2000", "Liqueur", "Jamaica", "Kingston", "Hugely popular rum-based Jamaican cream liqueur, Sangster\'s has a growing following of devotees.", "rum_cream.jpg"));
        wineList.add(new Wine(14L, "APPLETON RUM", "1749", "Liqueur", "Jamaica", "Kingston", "Appleton sits on the island\'s oldest sugar estate and is the country\'s oldest continuously run distillery.", "appleton.jpg"));
        mongoTemplate.insertAll(wineList);
    }
}
