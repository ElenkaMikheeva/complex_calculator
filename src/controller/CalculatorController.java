package controller;

import dto.AnyNumber;
import model.Calculator;

public class CalculatorController implements Controller {
    private final Calculator model;

    public CalculatorController(Calculator model){
        this.model = model;
    }

    @Override
    public AnyNumber add(AnyNumber a, AnyNumber b) {
        return model.add(a, b);
    }

    @Override
    public AnyNumber multiply(AnyNumber a, AnyNumber b) {
        return model.multiply(a, b);
    }

    @Override
    public AnyNumber divide(AnyNumber a, AnyNumber b) {
        return model.divide(a, b);
    }
}
