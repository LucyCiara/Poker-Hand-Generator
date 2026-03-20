package edu.ntnu.lucy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.ntnu.lucyciara.model.Card;

public class CardTest {
    private static final String[] SYMBOLS = new String[] {
        "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };
    private static final int[][] VALUES = new int[][] {
        new int[] {1, 14},
        new int[] {2},
        new int[] {3},
        new int[] {4},
        new int[] {5},
        new int[] {6},
        new int[] {7},
        new int[] {8},
        new int[] {9},
        new int[] {10},
        new int[] {11},
        new int[] {12},
        new int[] {13},
    };
    public static final String TEST_SYMBOL = SYMBOLS[9];
    public static final String TEST_SUIT = "Hearts";

    @Test
    public void nullSuitThrowsExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Card(null, TEST_SYMBOL));
        assertEquals("suit can't be null", exception.getMessage());
    }

    @Test
    public void blankSuitThrowsExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Card("", TEST_SYMBOL));
        assertEquals("suit can't be blank", exception.getMessage());
    }

    @Test
    public void nullSymbolThrowsExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Card(TEST_SUIT, null));
        assertEquals("symbol can't be null", exception.getMessage());
    }

    @Test
    public void blankSymbolThrowsExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Card(TEST_SUIT, ""));
        assertEquals("symbol can't be blank", exception.getMessage());
    }

    @Test
    public void getSuitGetsSuit() {
        Card card = new Card(TEST_SUIT, TEST_SYMBOL);
        assertEquals(TEST_SUIT, card.getSuit());
    }

    @Test
    public void getSymbolGetsSymbol() {
        Card card = new Card(TEST_SUIT, TEST_SYMBOL);
        assertEquals(TEST_SYMBOL, card.getSymbol());
    }

    @Test
    public void getValueGetsCorrectValue() {
        for (int i = 0; i < SYMBOLS.length; i++) {
            Card card = new Card(TEST_SUIT, SYMBOLS[i]);
            assertTrue(Arrays.equals(VALUES[i], card.getValue()));
        }
    }

    @Test
    public void faultySymbolHasZeroValue() {
        String faultySymbol = "11";
        assertFalse(Arrays.asList(SYMBOLS).contains(faultySymbol));
        Card faultyCard = new Card(TEST_SUIT, faultySymbol);
        assertTrue(Arrays.equals(new int[] {0}, faultyCard.getValue()));
        
        faultySymbol = "1";
        assertFalse(Arrays.asList(SYMBOLS).contains(faultySymbol));
        faultyCard = new Card(TEST_SUIT, faultySymbol);
        assertTrue(Arrays.equals(new int[] {0}, faultyCard.getValue()));


        faultySymbol = "F";
        assertFalse(Arrays.asList(SYMBOLS).contains(faultySymbol));
        faultyCard = new Card(TEST_SUIT, faultySymbol);
        assertTrue(Arrays.equals(new int[] {0}, faultyCard.getValue()));
    }
}
