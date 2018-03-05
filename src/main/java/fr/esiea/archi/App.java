package fr.esiea.archi;

import java.util.concurrent.atomic.AtomicInteger;

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
 * Sample web application.<br/>
 * Run {@link #main(String[])} to launch.
 */
@SpringBootApplication
@RestController
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	private final BiMap<Integer, Item> database = HashBiMap.create();
	private final AtomicInteger sequenceGenerator = new AtomicInteger();
	
    public static void main( String[] args )
    {
    	//App.run(App.class);
    }
    
    @RequestMapping("/create_item")
	int createUser(@RequestParam("name") String name, @RequestParam("sellIn") int sellIn, @RequestParam("quality") int quality) {
		Item c = new Item(name, sellIn, quality);

		final int id;
		if (!database.containsValue(c)) {
			id = sequenceGenerator.incrementAndGet();
			//c.setId(id);
			database.put(id, c);
			LOGGER.info(c + " created with ID: " + database.inverse().get(c));
		} else {
			id = database.inverse().get(c);
			LOGGER.info(c + " already exists with ID: " + database.inverse().get(c));
		}
		return id;
	}
    
}
