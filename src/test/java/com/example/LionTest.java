package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    private Feline mockFeline;

    Lion lion;

    @BeforeEach
    void setUp() throws Exception {
        String sex = "Самец";
        lion = new Lion(mockFeline, sex);
    }

    @Test
    @DisplayName("Вызов getKittens() класса Feline при вызове getKittens()")
    void getKittensInvokeFelineGetKittens() {
        lion.getKittens();
        Mockito.verify(mockFeline, Mockito.times(1)).getKittens();
    }

    @Test
    @DisplayName("Вызов getFood() класса Feline с аргументом \"Хищник\" при вызове getFood()")
    void getFoodInvokeGetFood() throws Exception {
        lion.getFood();
        Mockito.verify(mockFeline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    @DisplayName("Получение сообщение об ошибке при вызове конструктора Lion с sex = \"it\"")
    void newLionWithItInvokesException() {
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = assertThrows(Exception.class, () -> new Lion(mockFeline, "it"));
        assertEquals(expectedMessage, exception.getMessage(), "Сообщение не соответствует \"" + expectedMessage + "\"");
    }
}