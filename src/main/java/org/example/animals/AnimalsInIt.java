package org.example.animals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnimalsInIt {

    ArrayList<String> words = new ArrayList<>();
    String path;
    public AnimalsInIt(String path) {
        this.path = path;
    }
    public ArrayList<String> animalsItIt() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.path));
        String line = reader.readLine();
        while (line != null) {
            this.words.add(line.split(",")[0]);
            this.words.add(line.split(",")[1]);
            this.words.add(line.split(",")[2]);
            line = reader.readLine();
        }
        return this.words;
    }
}
