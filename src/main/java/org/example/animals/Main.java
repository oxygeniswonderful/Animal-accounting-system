package org.example.animals;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args) throws Exception {

        //long start = System.nanoTime();

        HashMap<String, Integer> rules = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();

        String[][] parameters;

        RulesInIt rulesInIt = new RulesInIt("data/rules.csv");
        rules = rulesInIt.rulesInIt();

        AnimalsInIt animalsInIt = new AnimalsInIt("data/animals.csv");
        words = animalsInIt.animalsItIt();

        ParametersInIt parametersInIt = new ParametersInIt();
        parameters = parametersInIt.getParameters(rules);

        ApplyRules applyRules = new ApplyRules(words, rules, parameters);
        System.out.println(applyRules.applyRules());

        /*long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes/1048576);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, с: " + elapsed / 1000000000); */
}
}