package org.example.animals;

public class Rule {
    private final String ruleParameter;
    private final boolean negate;

    public Rule(
            String ruleParameter,
            boolean negate
    ) {
        this.ruleParameter = ruleParameter;
        this.negate = negate;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleParameter='" + ruleParameter + '\'' +
                ", negate=" + negate +
                '}';
    }

    public boolean compare(String parameter) {
        if (negate) {
            return !ruleParameter.equals(parameter);
        } else {
            return ruleParameter.equals(parameter);
        }
    }
}
