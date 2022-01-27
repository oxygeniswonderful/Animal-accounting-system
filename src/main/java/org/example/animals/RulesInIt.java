package org.example.animals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RulesInIt {
    private final static String DELIMITER = ",";
    private final static String OR = " OR ";
    private final static String NEGATE = "! ";
    private final static String EMPTY = "";

    private List<String> readRules(String path) throws IOException {
        List<String> rules = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            rules.add(line);
            line = reader.readLine();
        }
        return rules;
    }

    public List<OneRowOfRules> createRules(String path) throws IOException {
        List<String> groupRulesSource = readRules(path);


        List<OneRowOfRules> allRules = new ArrayList<>();

        for (String groupRuleSource : groupRulesSource) {

            String[] rulesSources = groupRuleSource.split(DELIMITER);

            List<RuleGroup> ruleGroupList = new ArrayList<>();
            for (String ruleSource : rulesSources) {
                ruleGroupList.add(createMultipleRule(ruleSource));
                /*
                isMultipleRule(ruleSource)
                    ? createMultipleRule(ruleSource)
                    : createSingleRule(ruleSource);

                 */
            }
            allRules.add(new OneRowOfRules(ruleGroupList));
        }

        return allRules;
    }

    private RuleGroup createMultipleRule(String ruleSource) {
        String[] multipleRuleSource = ruleSource.split(OR);
        List<Rule> ruleList = new ArrayList<>();
        for (String rule : multipleRuleSource) {
            Rule r = isNegateRule(rule)
                ? createNegateRule(rule)
                : createSingleRule(rule);
            ruleList.add(r);
        }
        return new RuleGroup(ruleList);
    }

    private Rule createSingleRule(String ruleSource) {
        return new Rule(
                ruleSource, false
        );
    }

    private Rule createNegateRule(String ruleSource) {
        String negateRuleSource = ruleSource.replace(NEGATE, EMPTY);
        return new Rule(
                negateRuleSource, true
        );
    }

    private boolean isMultipleRule(String ruleSource) {
        return ruleSource.contains(OR);
    }

    private boolean isNegateRule(String ruleSource) {
        return ruleSource.startsWith(NEGATE);
    }
}
