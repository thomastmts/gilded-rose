package fr.esiea.archi;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author thomashuang
 */
public class SulfurasTest {
    
        @Test
      public void UpdateSulfurasNEGTest() {
            Item sulfu = new Item("Sulfuras, Hand of Ragnaros", -1, 9);
            Item[] items=new Item[]{sulfu};
            GildedRose gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            Assertions.assertThat(sulfu.quality).as("qualité de Sulfuras : ").isEqualTo(9);
        }
      
      @Test
    public void UpdateQualitySulfurasSellIn(){
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 4, 10);
        Item[] items=new Item[]{sulfuras};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(sulfuras.sellIn).as("NBJ pour vendre Sulfuras, Hand of Ragnaros").isEqualTo(4);
    }
}
