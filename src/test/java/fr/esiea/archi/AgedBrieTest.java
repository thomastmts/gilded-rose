/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiea.archi;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author thomashuang
 */
public class AgedBrieTest {
          @Test
        public void UpdateQualityPosSellIn10QualityAgedBrie(){
        Item agedBrie = new Item("Aged Brie", 50, 10);
        Item[] items=new Item[]{agedBrie};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(agedBrie.quality).as("qualité de Aged Brie ").isEqualTo(11);
    }
        
                 @Test
        public void UpdateQualityNegSellIn10QualityAgedBrie(){
        Item agedBrie = new Item("Aged Brie", -1, 10);
        Item[] items=new Item[]{agedBrie};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assertions.assertThat(agedBrie.quality).as("qualité de Aged Brie ").isEqualTo(12);
    }
}
