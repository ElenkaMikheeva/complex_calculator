package controller;

import dto.AnyNumber;

public interface Action {
    AnyNumber Do(AnyNumber a, AnyNumber b);
}
