package org.example.animals;

import java.util.List;

public class RuleGroup {
    private final List<Rule> ruleList;

    public RuleGroup(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public boolean compare(String animalParameter) {
        for (Rule rule : ruleList) {
            if (rule.compare(animalParameter)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RuleGroup{" +
                "ruleList=" + ruleList +
                '}';
    }
}
