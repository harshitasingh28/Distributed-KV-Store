package server;

import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {

    private static ConcurrentHashMap<String, String> store = new ConcurrentHashMap<>();

    public static String set(String key, String value) {
        store.put(key, value);
        return "OK";
    }

    public static String get(String key) {
        return store.getOrDefault(key, "NULL");
    }

    public static String delete(String key) {
        store.remove(key);
        return "DELETED";
    }

    public static ConcurrentHashMap<String, String> getStore(){
        return store;
    }
}