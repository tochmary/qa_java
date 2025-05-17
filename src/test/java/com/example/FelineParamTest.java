package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParamTest {
    Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest(name = "#{index} - {0}")
    @DisplayName("Получение kittensCount при вызове getKittens() с аргументом kittensCount")
    @ValueSource(ints = {-10, -1, 0, 1, 10})
    void getKittensWithIntReturnsInt(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount), "Получено значение, отличное от " + kittensCount);
    }
}
