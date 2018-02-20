package fr.esiea.archi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author thomashuang
 */
public class BackstagepassesTest {
            @Test
        public void UpdateQualityBackstageAccess() {
            Item backItem = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10);
            Item[] items=new Item[]{backItem};
            GildedRose gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            Assertions.assertThat(backItem.quality).as("qualité : ").isEqualTo(12);
        }
        
        public void UpdateQualityBackstageAccessINF6() {
            Item backItem = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10);
            Item[] items=new Item[]{backItem};
            GildedRose gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            Assertions.assertThat(backItem.quality).as("qualité : ").isEqualTo(4);
        }
}
