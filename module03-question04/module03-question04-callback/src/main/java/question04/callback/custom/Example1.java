package question04.callback.custom;

import question04.callback.custom.evaluator.NumbersEvaluator;
import question04.callback.custom.expression.impl.AddExpressionEvaluator;
import question04.callback.custom.expression.callback.ExpressionEvaluator;
import question04.callback.custom.printer.impl.StandardValuePrinter;
import question04.callback.custom.printer.callback.ValuePrinter;

public class Example1 {

    public static void main(String[] args) {
        new Example1().run();
    }

    private void run() {
        // 2nd way of using a callback is by using an anonymous class (and in this case we will not need a concrete class)
        //ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator() {
        //    @Override
        //    public int evaluate(int a, int b) {
        //        return a + b;
        //    }
        //};

        //ExpressionEvaluator expressionEvaluator = new MinusExpressionEvaluator();

        // 3rd way is to use a lambda instead of an anonymous class
        //ExpressionEvaluator expressionEvaluator = (a, b) -> a + b;
        //ExpressionEvaluator expressionEvaluator = (a, b) -> a - b;

        // 4th way is to use a reference to a method
        //ExpressionEvaluator expressionEvaluator = this::powEvaluator;
        //ExpressionEvaluator expressionEvaluator = Integer::sum;

        // 1st way of using a callback is to use an interface
        // AddExpressionEvaluator of ExpressionEvaluator type will implement a method that will be used inside the evaluate()
        ExpressionEvaluator expressionEvaluator = new AddExpressionEvaluator();

        ValuePrinter valuePrinter = new StandardValuePrinter();
        //ValuePrinter valuePrinter = new DecoratedValuePrinter();

        NumbersEvaluator numbersEvaluator = new NumbersEvaluator();

        numbersEvaluator.evaluate(4, expressionEvaluator, valuePrinter);
    }

    private int powEvaluator(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
