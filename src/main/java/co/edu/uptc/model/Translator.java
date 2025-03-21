package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class Translator {

    private List<Dictionary> dictionaries;

    public Translator(){
        dictionaries = new ArrayList<Dictionary>();
        loadDictionaries();
    }

    public void loadDictionaries(){
        DictionaryReader dr = new DictionaryReader();
        List<String> englishWords = dr.getAnimalNames("src\\main\\resources\\diccionarios\\common_en.json");
        List<String> spanishWords = dr.getAnimalNames("src\\main\\resources\\diccionarios\\common_es.json");
        List<String> frenchWords = dr.getAnimalNames("src\\main\\resources\\diccionarios\\common_fr.json");
        loadDictionary("Frances", englishWords, frenchWords);
        loadDictionary("Espanol", englishWords, spanishWords);
    }

    public boolean addWord(String language, String inEnglish, String translation){
        Dictionary dictionary = findDictionary(language);
        return dictionary.addWord(inEnglish, translation);
    }

    public int dicionarySize(String language){
        Dictionary dictionary = findDictionary(language);
        return dictionary.size();
    }

    public void loadDictionary(String laguage, List<String> wordInEnglish, List<String> translations){
        Dictionary newDictionary = new Dictionary(laguage);
        for (int i = 0; i < wordInEnglish.size(); i++) {
            newDictionary.addWord(wordInEnglish.get(i), translations.get(i));
        }
        dictionaries.add(newDictionary);
    }

    public String translation(String language, String inEnglish){
        Dictionary dictionary = findDictionary(language);
        return dictionary.searchWordTranslation(inEnglish);
    }

    private Dictionary findDictionary(String language){
        for (Dictionary d : dictionaries) {
            if (d.getLanguage().equals(language)) {
                return d;
            }
        }
        return null;
    }
}
