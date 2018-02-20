package fr.esiea.archi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void updateQualityTest() {
        Item item= new Item("testItem",14,10);
        Item[] items=new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(item.quality).as("Qualité").isEqualTo(9);
    }

        @Test
        public void UpdateQualityNegativeSellIn10QualityAgedBrie(){
        Item agedBrie = new Item("Aged Brie", 50, 10);
        Item[] items=new Item[]{agedBrie};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(agedBrie.quality).as("qualité de Aged Brie ").isEqualTo(11);
    }
}
