package question04.callback.custom.expression.impl;

import question04.callback.custom.expression.callback.ExpressionEvaluator;

public class AddExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public int evaluate(int a, int b) {
        return a + b;
    }
}
