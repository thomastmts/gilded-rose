package fr.esiea.archi;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            
        	if(!items[i].name.equals("Sulfuras, Hand of Ragnaros")){
        		
        		items[i].sellIn--;
        		
        		// Si l'item est Aged Brie
        		if (items[i].name.equals("Aged Brie")) updateBrie(i);
        			
            	// Si l'item est Backstage Passes
        		else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) updatePasses(i);
        			
        		// Si l'item n'est ni Aged Brie ni Backstage Passes (ni Sulfuras)
        		else updateOthers(i);
        	}
        	
        }
    }

	public void updateBrie(int i){
    	// Si sa qualité est inférieur à la qualité maximale
		if (items[i].quality < 50) {
            
			items[i].quality++;
            
            // Après la date de péremption de l'item, on augmente de nouveau sa qualité : elle aura augmenté de 2 au final
            if (items[i].sellIn < 0) items[i].quality++;
  
		}
    }
    
	private void updatePasses(int i) {
    	// Si sa qualité est inférieur à la qualité maximale
		if (items[i].quality < 50){
			
			items[i].quality++;
			
			// S'il reste 10 jours ou moins avant le concert, on augmente sa qualité : elle aura augmenté de 2 au final
        	if (items[i].sellIn < 11) {
        		items[i].quality++;
                    
        		// S'il reste 6 jours ou moins avant le concert, on augmente de nouveau sa qualité : elle aura augmenté de 3 au final
        		if (items[i].sellIn < 6) {
        			items[i].quality++;
        		}
            }
        	
        	// Sa qualité tombe à 0 après le concert
        	else if (items[i].sellIn < 0) items[i].quality = 0;
        	
		}
		
	}
	
	private void updateOthers(int i) {
		if(items[i].quality > 0){
			items[i].quality--;
			
			// Après la date de péremption de l'item, on diminue de nouveau sa qualité : elle aura diminué de 2 au final
			if(items[i].sellIn < 0) items[i].quality--;
		}
		
	}
    
}