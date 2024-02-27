package model;

import dto.AnyNumber;

public interface Calculator {
    AnyNumber add(AnyNumber a, AnyNumber b);
    AnyNumber multiply(AnyNumber a, AnyNumber b);
    AnyNumber divide(AnyNumber a, AnyNumber b);
}