package controller;

import dto.AnyNumber;

public interface Controller {
    AnyNumber add(AnyNumber a, AnyNumber b);
    AnyNumber multiply(AnyNumber a, AnyNumber b);
    AnyNumber divide(AnyNumber a, AnyNumber b);
}
