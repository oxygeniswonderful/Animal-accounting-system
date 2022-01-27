package org.example.animals;

import java.util.List;

public class OneRowOfRules {

    private final List<RuleGroup> oneRowOfRules;

    public OneRowOfRules(List<RuleGroup> ruleGroupList) {
        this.oneRowOfRules = ruleGroupList;
    }

    public boolean compareParameters(String[] animal) {

        for (String animalParameter : animal) {
            for (RuleGroup ruleGroup : oneRowOfRules) {
                return ruleGroup.compare(animalParameter);

            }
// todo: поразвлекаться
        }

        return false;
    }

    public List<RuleGroup> getOneRowOfRules() {
        return oneRowOfRules;
    }
}
