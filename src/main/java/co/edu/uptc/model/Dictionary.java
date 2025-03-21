package co.edu.uptc.model;

public class Dictionary {

    private BinaryTree<Word> words;
    private String language;

    public String getLanguage() {
        return language;
    }

    public Dictionary(String language){
        this.language = language;
        words = new BinaryTree<>(new WordComparator());
    }

    public boolean addWord(String inEnglish, String translation){
        Word newWord = new Word(inEnglish, translation);
        return words.add(newWord);
    }

    public int size(){
        return words.size();
    }

    public String searchWordTranslation(String inEnglish){
        Word toFind = new Word(inEnglish, "");
        Word found = words.find(toFind);
        if (found != null) {
            return found.getTranslation();
        } return null;
    }
}
