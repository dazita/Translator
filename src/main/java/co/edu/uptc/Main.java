package co.edu.uptc;

import co.edu.uptc.model.Translator;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        System.out.println(translator.translation("Espanol", "bison"));
    }
}