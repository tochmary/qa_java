package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private Feline mockFeline;

    Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(mockFeline);
    }

    @Test
    @DisplayName("Получение списка имен друзей")
    void getFriendsReturnsList() {
        List<String> expectedList = List.of("Марти", "Глория", "Мелман");
        assertIterableEquals(expectedList, alex.getFriends(), "Получено значение, отличное от " + expectedList);
    }

    @Test
    @DisplayName("Получение места жительства Алекса")
    void getPlaceOfLivingReturnsNewYorkZoo() {
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, alex.getPlaceOfLiving(), "Получено значение, отличное от " + expected);
    }

    @Test
    @DisplayName("Получение количества детей")
    void getKittens() {
        assertEquals(0, alex.getKittens(), "Получено значение, отличное от 0");
    }
}