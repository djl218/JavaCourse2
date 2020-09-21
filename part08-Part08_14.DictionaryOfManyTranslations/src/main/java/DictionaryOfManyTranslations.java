import java.util.HashMap;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;
    
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, new ArrayList<>());
        
        this.dictionary.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        ArrayList<String> translations = new ArrayList<>();
        ArrayList<String> emptyList = new ArrayList<>();
        
        translations = this.dictionary.get(word);
        
        if (translations == null) {
            return emptyList;
        } else {
            return translations;
        }
    }
    
    public void remove(String word){
        this.dictionary.remove(word);
    }
}
