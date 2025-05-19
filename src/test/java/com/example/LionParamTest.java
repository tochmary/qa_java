package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionParamTest {
    @Mock
    private Feline mockFeline;
    Lion lion;

    @ParameterizedTest(name = "#{index} - {0}")
    @DisplayName("Получение hasMane при вызове doesHaveMane() для разных полов")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeWithParamsReturnsHasMane(String sex, Boolean hasMane) throws Exception {
        lion = new Lion(mockFeline, sex);
        assertEquals(hasMane, lion.doesHaveMane(), "Получено значение, отличное от " + hasMane);
    }
}
