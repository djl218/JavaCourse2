package dictionary;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class SaveableDictionary {
    private HashMap<String, String> dictionary1;
    private HashMap<String, String> dictionary2;
    private String file;
    
    public SaveableDictionary(String file) {
        this.file = file;
        this.dictionary1 = new HashMap<>();
        this.dictionary2 = new HashMap<>();
    }
    
    public SaveableDictionary() {
        this.dictionary1 = new HashMap<>();
        this.dictionary2 = new HashMap<>();
    }
    
    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
        
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
            
                dictionary1.put(parts[0], parts[1]);
                dictionary2.put(parts[1], parts[0]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return true;
    }
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)) {
            
            for (String key : dictionary1.keySet()) {
                writer.println(key + ":" + dictionary1.get(key));
            }
            
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public void add(String words, String translation) {
        boolean dictionaryCheck = true;
        
        for (String word : dictionary1.keySet()) {
            if (word.equals(words)) {
                dictionaryCheck = false;
            }
        }
        
        for (String word : dictionary2.keySet()) {
            if (word.equals(words)) {
                dictionaryCheck = false;
            }
        }
        
        if (dictionaryCheck) {
            dictionary1.put(words, translation);
            dictionary2.put(translation, words);
        }
    }
    
    public String translate(String word) {
        String translation = "";
        
        if (!(dictionary1.containsKey(word)) && !(dictionary2.containsKey(word))) {
            return null;
        }
        
        if (dictionary1.get(word) != null) {
            translation = dictionary1.get(word);
        }
        
        if (dictionary2.get(word) != null) {
            translation = dictionary2.get(word);
        }
        
        return translation;
    }
    
    public void delete(String word) {
        String d2Check = dictionary1.get(word);
        String d1Check = dictionary2.get(word);
        
        dictionary1.remove(d1Check);
        dictionary1.remove(word);
        dictionary2.remove(d2Check);
        dictionary2.remove(word);
    }
}
