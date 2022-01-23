package org.example.animals;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplyRules {
    ArrayList<String> words;
    HashMap<String, Integer> rules;
    String[][] parameters;
    public ApplyRules(ArrayList<String> words, HashMap<String, Integer> rules, String[][] parameters) {
        this.words = words;
        this.rules = rules;
        this.parameters = parameters;
    }

    public HashMap<String, Integer> applyRules() {
        String p1 = "@", p2 = "@", p3 = "@";
        String key = "";
        for (int i = 0; i < this.words.size(); i++) {
            try {
                for (int j = 0; j < this.rules.size(); j++) {
                    p1 = this.parameters[0][j];
                    p2 = this.parameters[1][j];
                    p3 = this.parameters[2][j];
                    key = (String) this.rules.keySet().toArray()[j];

                    if ((!p3.contains("!") & (p3.equals("$") | p3.contains(this.words.get(i+2))) |
                            ((p3.contains("!")) & (!p3.substring(1).contains(this.words.get(i+2)))))
                            & (!p1.contains("!") & (p1.equals("$") | p1.contains(this.words.get(i))) |
                            ((p1.contains("!")) & (!p1.substring(1).contains(this.words.get(i)))))
                            & (!p2.contains("!") & (p2.equals("$") | p2.contains(this.words.get(i + 1))) |
                            ((p2.contains("!")) & (!p2.substring(1).contains(this.words.get(i+1))))))  {
                        this.rules.put(key, this.rules.get(key) + 1);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        return this.rules;
    }
}
