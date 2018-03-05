package fr.esiea.archi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ItemTest {

	@Test
	public void settersTest(){
		Item item=new Item("testItem",14,10);
		item.setName("Test Item");
		item.setSellIn(12);
		item.setQuality(8);
		
		Assertions.assertThat(item).as("Item").isEqualTo(new Item("Test Item",12,8));
		
	}
}
