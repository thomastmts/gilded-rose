package fr.esiea.archi;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GildedRoseTest {

	private Item inputItem;
	private Item expectedItem;
	private GildedRose gildedRose;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{new Item("testItem",14,10),new Item("testItem",14,9)},
			{new Item("testItem",-1,10),new Item("testItem",-1,8)},
			{new Item("Aged Brie", 50, 10),new Item("Aged Brie", 50, 11)},
			{new Item("Aged Brie",-1, 10),new Item("Aged Brie", 50, 12)},
			{new Item("Sulfuras, Hand of Ragnaros", -1, 9),new Item("Sulfuras, Hand of Ragnaros", -1, 9)},
			{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10),new Item("Backstage passes to a TAFKAL80ETC concert", 8, 12)},
			{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10),new Item("Backstage passes to a TAFKAL80ETC concert", 3, 13)},
			{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10),new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0)},
		});
	}
	
	public GildedRoseTest(Item iItem,Item exItem) {
		inputItem=iItem;
		expectedItem=exItem;
		Item[] items=new Item[]{inputItem};
		gildedRose=new GildedRose(items);
	}
	@Test
	public void updateQualityTest() {
        gildedRose.updateQuality();
        Assertions.assertThat(inputItem.getQuality()).as("Qualité").isEqualTo(expectedItem.getQuality());
    }     
    
        
         @Test
    public void toStringTest() {
        Item stringTestItem = new Item("toStringTestItem", 10, 10);
        Assertions.assertThat(stringTestItem.toString()).as("Display of an object").isEqualTo("toStringTestItem, 10, 10"); 
    }
}
