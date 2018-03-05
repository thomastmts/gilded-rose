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
        Assertions.assertThat(item.getQuality()).as("Qualité").isEqualTo(9);
    }     
        @Test
	public void updateQualityNEGTest() {
        Item item= new Item("testItem",-1,10);
        Item[] items=new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(item.getQuality()).as("Qualité").isEqualTo(8);
    }  
        
         @Test
    public void toStringTest() {
        Item stringTestItem = new Item("toStringTestItem", 10, 10);
        Assertions.assertThat(stringTestItem.toString()).as("Display of an object").isEqualTo("toStringTestItem, 10, 10"); 
    }
}
