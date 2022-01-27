package org.example.animals;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        //long start = System.nanoTime();

        RulesInIt rulesInIt = new RulesInIt();
        List<OneRowOfRules> allRules = rulesInIt.createRules("rules.csv");

        List<String[]> animals = AnimalsInIt.animalsInIt("animalsTest.csv");

        ApplyRules applyRules = new ApplyRules();

        for (OneRowOfRules oneRowOfRules : allRules) {
            System.out.println(
                    "For: " + oneRowOfRules.getOneRowOfRules() + " - " + applyRules.countAnimals(oneRowOfRules, animals)
            );
        }

        /*long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes/1048576);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Прошло времени, с: " + elapsed / 1000000000); */
    }
}