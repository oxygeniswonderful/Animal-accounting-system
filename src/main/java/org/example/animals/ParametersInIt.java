package org.example.animals;

import java.util.HashMap;

public class ParametersInIt {
    public ParametersInIt() {
    }
    public String[][] getParameters(HashMap<String, Integer> rules) {
        String p1 = "@", p2 = "@", p3 = "@";
        int c = 1;
        String[][] parameters = new String[3][rules.size()];
        for (int i = 0; i < rules.size(); i++) {
            for (int j = 0; j < rules.keySet().toArray()[i].toString().length(); j++) {
                try {
                    if (String.valueOf(rules.keySet().toArray()[i].toString().toCharArray()[j]).equals("("))
                        while (!(String.valueOf(rules.keySet().toArray()[i].toString().toCharArray()[j + c]).equals(")")))
                            c += 1;
                    if (p1.equals("@")) {
                        p1 = String.valueOf(rules.keySet().toArray()[i]).substring(j + 1, j + c);
                        //System.out.println(p1);
                    } else if (p2.equals("@")) {
                        p2 = String.valueOf(rules.keySet().toArray()[i]).substring(j + 1, j + c);
                        //System.out.println(p2);
                    } else if (p3.equals("@")) {
                        p3 = String.valueOf(rules.keySet().toArray()[i]).substring(j + 1, j + c);
                        //System.out.println(p3);
                    }
                } catch (Exception e) {
                    continue;
                }
                c = 0;
            }
            parameters[0][i] = p1;
            parameters[1][i] = p2;
            parameters[2][i] = p3;
            p1 = "@";
            p2 = "@";
            p3 = "@";
        }
        return parameters;
    }
}
