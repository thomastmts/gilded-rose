package fr.esiea.archi;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //createItem();
    }
    
    /*public static void createItem(){
    	System.out.println("Créer un item");
    	System.out.println("Choisissez un nom : ");
    	
    	System.out.println("1. Backstage passes to a TAFKAL80ETC concert");
    	System.out.println("2. Sulfuras, Hand of Ragnaros");
    	System.out.println("3. Aged Brie");
    	System.out.println("4. Confiture");
    	
    	Scanner keyboard = new Scanner(System.in);
    	boolean error = false;
    	int numname;
    	int sellin;
    	int quality;
    	
    	do{
    		System.out.println("Entrez un des chiffres de la liste : ");
        	numname = keyboard.nextInt();
        	if(numname <= 0 || numname > 4) error = true;
        	
        	System.out.println("Donnez le nombre de jours restant pour vendre l'article : ");
        	sellin = keyboard.nextInt();
        	
        	System.out.println("Donnez un nombre pour définir la qualité de l'article (entre 0 et 50) : ");
        	quality = keyboard.nextInt();
    	} while(error == true);
    	
    	String name = new String();
    	
    	switch (numname) {
		case 1:
			name = "Backstage passes to a TAFKAL80ETC concert";
			break;
			
		case 2:
			name = "Sulfuras, Hand of Ragnaros";
			break;
			
		case 3:
			name = "Aged Brie";
			break;
			
		case 4:
			name = "Confiture";
			break;

		default:
			break;
		}
    	
    	Item item = new Item(name, sellin, quality);
    	
    	keyboard.close();
    }*/
}
