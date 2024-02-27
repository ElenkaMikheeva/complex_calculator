package model;

import dto.AnyNumber;
import dto.ComplexNumber;

public class ComplexCalculator implements Calculator {
    @Override
    public ComplexNumber add(AnyNumber a, AnyNumber b) {
        double real = a.getReal() + b.getReal();
        double imaginary = a.getImaginary() + b.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public AnyNumber multiply(AnyNumber a, AnyNumber b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginary = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public AnyNumber divide(AnyNumber a, AnyNumber b) {
        double denominator = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator;
        double imaginary = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}