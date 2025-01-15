package question04.callback.custom.printer.impl;

import question04.callback.custom.printer.callback.ValuePrinter;

public class StandardValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.println(value);
    }
}
