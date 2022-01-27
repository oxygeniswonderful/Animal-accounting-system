package org.example.animals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalsInIt {
    private final static String DELIMITER = ",";

    public static List<String[]> animalsInIt(String path) throws IOException {
        List<String[]> animals = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            animals.add(line.split(DELIMITER));
            line = reader.readLine();
        }
        return animals;
    }
}
