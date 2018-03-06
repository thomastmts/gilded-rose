package fr.esiea.archi;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Sample web application.
 * Run {@link #main(String[])} to launch.
 */
@SpringBootApplication
@RestController
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private final BiMap<Integer, Item> database = HashBiMap.create();
    private final AtomicInteger sequenceGenerator = new AtomicInteger();
	
    public static void main(String[] args)
    {   
    	SpringApplication.run(App.class);
    }
    
    @RequestMapping("/")
    List<Item> init() {
        int id;

        Item i1 = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        id = sequenceGenerator.incrementAndGet();
        i1.setId(id);
        database.put(id, i1);

        Item i2 = new Item("Aged Brie", 5, 13);
        id = sequenceGenerator.addAndGet(1);
        i2.setId(id);
        database.put(id, i2);

        Item i3 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
        id = sequenceGenerator.addAndGet(1);
        i3.setId(id);
        database.put(id, i3);

        Item i4 = new Item("Confiture", 15, 18);
        id = sequenceGenerator.addAndGet(1);
        i4.setId(id);
        database.put(id, i4);

        return database.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }

    @RequestMapping("/create_item")
    String createUser(@RequestParam("name") String name, @RequestParam("sellIn") int sellIn, @RequestParam("quality") int quality) {
        Item c = new Item(name, sellIn, quality);

        final int id;
        if (!database.containsValue(c)) {
            id = sequenceGenerator.incrementAndGet();
            c.setId(id);
            database.put(id, c);
            LOGGER.info(c + " created with ID: " + database.inverse().get(c));
        } else {
            id = database.inverse().get(c);
            LOGGER.info(c + " already exists with ID: " + database.inverse().get(c));
        }
        return "<strong>Item " + c.getName() + " created with the ID " + id + ", with sellIn = " + c.getSellIn() + " and with quality = " + c.getQuality() + "</strong>";
    }

    @RequestMapping("/list_items")
    List<Item> listUsers() {

        return database.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }
}
