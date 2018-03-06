package fr.esiea.archi;

class GildedRose implements Runnable {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            // On modifie tous les items sauf Sulfuras
            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {

                items[i].setSellIn(items[i].getSellIn() - 1);

                // Si l'item est Aged Brie
                if (items[i].getName().equals("Aged Brie")) {
                    updateQualityBrie(i);
                } // Si l'item est Backstage Passes
                else if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    updateQualityPasses(i);
                } // Si l'item n'est ni Aged Brie ni Backstage Passes (ni Sulfuras)
                else {
                    updateQualityOthers(i);
                }
            }

        }
    }

    public void updateQualityBrie(int i) {
        // Si sa qualité est inférieur à la qualité maximale
        if (items[i].getQuality() < 50) {

            items[i].setQuality(items[i].getQuality() + 1);

            // Après la date de péremption de l'item, on augmente de nouveau sa qualité : elle aura augmenté de 2 au final
            if (items[i].getSellIn() < 0) {
                items[i].setQuality(items[i].getQuality() + 1);
            }

        }
    }

    private void updateQualityPasses(int i) {
        // Si sa qualité est inférieur à la qualité maximale
        if (items[i].getQuality() < 50) {

            items[i].setQuality(items[i].getQuality() + 1);

            // S'il reste 10 jours ou moins avant le concert, on augmente sa qualité : elle aura augmenté de 2 au final
            if (items[i].getSellIn() < 11) {
                items[i].setQuality(items[i].getQuality() + 1);

                // S'il reste 6 jours ou moins avant le concert, on augmente de nouveau sa qualité : elle aura augmenté de 3 au final
                if (items[i].getSellIn() < 6) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    // Sa qualité tombe à 0 après le concert
                    if (items[i].getSellIn() < 0) {
                        items[i].setQuality(0);
                    }
                }
            }

        }

    }

    private void updateQualityOthers(int i) {
        if (items[i].getQuality() > 0) {
            items[i].setQuality(items[i].getQuality() - 1);

            // Après la date de péremption de l'item, on diminue de nouveau sa qualité : elle aura diminué de 2 au final
            if (items[i].getSellIn() < 0) {
                items[i].setQuality(items[i].getQuality() - 1);
            }
        }

    }

    @Override
    public void run() {
        updateQuality();
    }
    
}