package server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PersistenceManager {

    private static final String FILE = "data/store.txt";

    public static synchronized void save(Map<String,String> store) {

        try(FileWriter writer = new FileWriter(FILE)) {

            for(Map.Entry<String,String> entry : store.entrySet()) {

                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");

            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
