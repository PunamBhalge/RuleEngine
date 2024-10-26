package ruleengine;
import org.json.JSONObject;

public class RuleEngine {


        public Node createRule(String ruleString) {
            String[] tokens = ruleString.split(" AND | OR ");

            if (tokens.length < 2) {
                throw new IllegalArgumentException("Rule must contain at least two conditions, found:  "+ tokens.length);
            }


            Node left = new Node("operand", tokens[0].trim());
            Node right = new Node("operand", tokens[1].trim());
            Node operator = new Node("operator", left, right);
            return operator;
        }


        public Node combineRules(Node[] rules) {
            Node combined = rules[0];
            for (int i = 1; i < rules.length; i++) {
                combined = new Node("operator", combined, rules[i]);
            }
            return combined;
        }


        public boolean evaluateRule(Node rule, JSONObject data) {
            if (rule.type.equals("operand")) {
                String[] parts = rule.value.split("=");

                if (parts.length != 2) {
                    System.out.println("Invalid operand format: " + rule.value);
                    return false;
                }
                String key = parts[0].trim();
                String expectedValue = parts[1].trim().replace("'", "");



                Object jsonValue = data.get(key);
                if (jsonValue instanceof Integer) {
                    return jsonValue.toString().equals(expectedValue);
                } else if (jsonValue instanceof String) {
                    return jsonValue.equals(expectedValue);
                }
            } else if (rule.type.equals("operator")) {
                boolean leftEval = evaluateRule(rule.left, data);
                boolean rightEval = evaluateRule(rule.right, data);
                return leftEval || rightEval;
            }
            return false;
        }
    }


