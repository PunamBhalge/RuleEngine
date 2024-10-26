package ruleengine;

import org.json.JSONObject;


public class Main {
        public static void main(String[] args) {
            RuleEngine engine = new RuleEngine();


            String rule1 = "age = '35' AND department = 'Sales'";
            String rule2 = "age = '25' AND department = '5'";

            Node ast1 = engine.createRule(rule1);
            Node ast2 = engine.createRule(rule2);


            Node combinedAst = engine.combineRules(new Node[]{ast1, ast2});


            JSONObject data = new JSONObject();
            data.put("age", 35);
            data.put("department", "Sales");


            boolean result = engine.evaluateRule(combinedAst, data);
            System.out.println("Evaluation Result: " + result);
        }
    }


