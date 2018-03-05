package fr.esiea.archi;

import java.util.Objects;

public class Item {

	private Integer id;
	
    private String name;

    private int sellIn;

    private int quality;

	public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
	
	public Integer getId() {
		return id;
	}

	void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sellIn, quality);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Item && Integer.valueOf(obj.hashCode()).equals(hashCode());
	}
	
	@Override
   	public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}