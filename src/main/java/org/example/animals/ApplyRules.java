package org.example.animals;

import java.util.List;

public class ApplyRules {

    public long countAnimals(OneRowOfRules oneRowOfRules, List<String[]> animals) {
        long counter = 0;

        for (String[] animal : animals) {
            if (oneRowOfRules.compareParameters(animal)) {
                counter++;
            }
        }
        return counter;
    }
}
