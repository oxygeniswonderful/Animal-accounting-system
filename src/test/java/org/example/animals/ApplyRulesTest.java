package org.example.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApplyRulesTest {
    @Test
    void applyRules() throws IOException {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("($)&($)&(ТРАВОЯДНОЕ)", 420000);
        expected.put("($)&(!ВЫСОКОЕ)&(ВСЕЯДНОЕ)",300000);
        expected.put("($)&(МАЛЕНЬКОЕ)&(ТРАВОЯДНОЕ|ПЛОТОЯДНОЕ)", 280000);

//        Map<String, Integer> actualRules = RulesInIt.rulesInIt("data/rules.csv");
//
//        List<String[]> animals = AnimalsInIt.animalsInIt("data/animals.csv");
//
//        ParametersInIt parametersInIt = new ParametersInIt();
//        List<Rule> rules = parametersInIt.getParameters(actualRules);
//
//        ApplyRules applyRules = new ApplyRules(words, actualRules, parameters);
//        actual = applyRules.applyRules();
//        Assertions.assertEquals(expected, actual);

    }
}