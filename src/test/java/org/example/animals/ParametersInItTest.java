package org.example.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;

class ParametersInItTest {

    @Test
    void getParameters() throws IOException {
        String[][] parameters;
        int actual, expected = 398110318;
        HashMap<String, Integer> rules = new HashMap<>();
        RulesInIt rulesInIt = new RulesInIt("data/rules.csv");
        rules = rulesInIt.rulesInIt();
        ParametersInIt parametersInIt = new ParametersInIt();
        parameters = parametersInIt.getParameters(rules);
        actual = parameters.hashCode();
        Assertions.assertEquals(actual, expected);
    }
}