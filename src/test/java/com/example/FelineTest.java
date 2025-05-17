package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    Feline feline;

    @Test
    @DisplayName("Вызов getFood() при вызове eatMeat()")
    void eatMeatInvokesGetFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    @DisplayName("Получение \"Кошачьи\" при вызове getFamily()")
    void getFamilyReturnsFeline() {
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, feline.getFamily(), "Получено значение, отличное от 'Кошачьи'");
    }

    @Test
    @DisplayName("Вызов getKittens(1) при вызове getKittens() без аргументов")
    void getKittensNoParamInvokesGetKittensWith1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}