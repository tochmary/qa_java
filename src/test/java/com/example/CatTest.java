package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Feline mockPredator;

    Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(mockPredator);
    }

    @Test
    @DisplayName("Получение \"Мяу\" при вызове getSound()")
    void getSoundReturnsValueMeow() {
        assertEquals("Мяу", cat.getSound(), "Получено значение, отличное от \"Мяу\"");
    }

    @Test
    @DisplayName("Вызов eatMeat() класса Feline при вызове getFood()")
    void getFoodInvokeEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(mockPredator, Mockito.times(1)).eatMeat();
    }
}