package cards;

import cards.Card.Suit;
import org.junit.jupiter.api.Test;

import static cards.Card.Suit.CLUBS;
import static cards.Card.Suit.HEARTS;
import static org.junit.jupiter.api.Assertions.*;

class SuitTest {
    private final Suit s1 = CLUBS;
    private final Suit s2 = HEARTS;

    @Test
    void compare() {
        assertAll(
            () -> assertTrue(s1.compareTo(s2) < 0),
            () -> assertTrue(s2.compareTo(s1) > 0),
            () -> assertEquals(0, s1.compareTo(s1))
        );
    }
}
