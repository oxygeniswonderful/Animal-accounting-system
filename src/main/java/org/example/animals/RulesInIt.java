package org.example.animals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RulesInIt {
    HashMap<String, Integer> rules = new HashMap<>();
    String path;
    public RulesInIt(String path) {
        this.path = path;
    }
    public HashMap<String, Integer> rulesInIt() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.path));
        String line = reader.readLine();
        String rule = "";
        while (line != null) {
            rule = line.replace("[", "").replace("]", "");
            rules.put(rule, 0);
            line = reader.readLine();
        }
        return this.rules;
    }
}
