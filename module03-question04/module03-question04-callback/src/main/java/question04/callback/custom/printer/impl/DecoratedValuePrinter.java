package question04.callback.custom.printer.impl;

import question04.callback.custom.printer.callback.ValuePrinter;

public class DecoratedValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.printf("Value = [%d]%n", value);
    }
}
