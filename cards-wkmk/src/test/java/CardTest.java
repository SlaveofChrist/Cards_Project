package cards;

import org.junit.jupiter.api.Test;

import static cards.Card.*;
import static cards.Card.Rank.ACE;
import static cards.Card.Rank.FOUR;
import static cards.Card.Suit.DIAMONDS;
import static cards.Card.Suit.SPADES;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercises the Card class.
 *
 * @author <a href="mailto:sander@unice.fr">Peter Sander</a>
 */
class CardTest {
    private static final Card D4 = new Card(DIAMONDS, FOUR);
    private static final Card SA = new Card(SPADES, ACE);

    @Test
    void testToString() {
        assertEquals("ace of spades", SA.toString());
    }

    @Test
    void compare() {
        assertAll(
            () -> assertEquals(LESS, D4.compareTo(SA)),
            () -> assertEquals(MORE, SA.compareTo(D4)),
            () -> assertEquals(SAME, D4.compareTo(D4))
        );
    }
}
