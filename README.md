RuleEngine
Overview:
This project implements a simple Rule Engine in Java that allows users to define and evaluate rules based on JSON data. It constructs an abstract syntax tree (AST) from user-defined rules and evaluates the conditions against provided data.

Features:
Rule Creation: Supports defining rules using logical operators (AND, OR).
AST Construction: Converts rules into a tree structure for easy evaluation.
Rule Evaluation: Evaluates rules against JSON objects, supporting both string and integer comparisons.

Usage:
Create rules using the format: key = 'value' AND key = 'value'.
Combine multiple rules for complex evaluations.
Use the evaluateRule method to check if the data meets the defined rules.
