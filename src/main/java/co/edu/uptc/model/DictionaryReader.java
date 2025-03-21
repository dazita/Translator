package co.edu.uptc.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DictionaryReader {
    
    public List<String> getAnimalNames(String filePath) {
        List<String> names = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<Map<String, List<Map<String, String>>>>() {}.getType();

            Map<String, List<Map<String, String>>> data = gson.fromJson(reader, type);
            List<Map<String, String>> animals = data.get("animals");

            for (Map<String, String> animal : animals) {
                names.add(animal.get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }
}
