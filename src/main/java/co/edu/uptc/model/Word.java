package co.edu.uptc.model;

public class Word {

    private String inEnglish;
    private String translation;

    public Word(String inEnglish, String translation){
        this.inEnglish = inEnglish;
        this.translation = translation;
    }

    public String getInEnglish() {
        return inEnglish;
    }
    public void setInEnglish(String inEnglish) {
        this.inEnglish = inEnglish;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }  
}