package org.example.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ApplyRulesTest {
    @Test
    void applyRules() throws IOException {
        HashMap<String, Integer> actual, expected = new HashMap<>();
        expected.put("($)&($)&(ТРАВОЯДНОЕ)", 420000);
        expected.put("($)&(!ВЫСОКОЕ)&(ВСЕЯДНОЕ)",300000);
        expected.put("($)&(МАЛЕНЬКОЕ)&(ТРАВОЯДНОЕ|ПЛОТОЯДНОЕ)", 280000);

        ArrayList<String> words = new ArrayList<>();
        String[][] parameters;

        RulesInIt rulesInIt = new RulesInIt("data/rules.csv");
        actual = rulesInIt.rulesInIt();

        AnimalsInIt animalsInIt = new AnimalsInIt("data/animals.csv");
        words = animalsInIt.animalsItIt();

        ParametersInIt parametersInIt = new ParametersInIt();
        parameters = parametersInIt.getParameters(actual);

        ApplyRules applyRules = new ApplyRules(words, actual, parameters);
        actual = applyRules.applyRules();
        Assertions.assertEquals(expected, actual);

    }
}