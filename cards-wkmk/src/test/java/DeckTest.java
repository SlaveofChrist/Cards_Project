import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static cards.cards.wkmk.Card.Rank.*;
import static cards.cards.wkmk.Card.Suit.*;
import cards.cards.wkmk.Card;
import cards.cards.wkmk.Deck;

class DeckTest {
    private static final int WIN_DIFFERENCE = 10;
    private Deck deck;
    private static final Card C2 = new Card(CLUBS, TWO);  // lowest card
    private static final Card SA = new Card(SPADES, ACE);  // highest card
    
    @BeforeEach
    void setUp() {
        deck = new Deck();
    }
    
//    @Test
//    void compare() {
//        assertAll(
//                () -> assertTrue(deck.compare(C2, SA) < 0),  // aces high
//                () -> assertTrue(deck.compare(SA, C2) > 0),  // aces high
//                () -> assertEquals(0, deck.compare(C2, C2))
//        );
//    }

    /*
     * Tests quality of shuffle based on the assumption that a given
     * card in the deck should be of higher value than the succeeding card
     * with a probability of about 0.5.
     * This test may occasionally fail.
     */

    @Test
    void testShuffle() {
        deck.shuffle();
        int beforeWins = 0;
        int afterWins = 0;
        for (int i = 0; i < deck.getCards().size() - 1; i++) {
            if (deck.get(i).compareTo(deck.get(i + 1)) < 0) {
                afterWins++;
            } else {
                beforeWins++;
            }
        }
        assertTrue(Math.abs(beforeWins - afterWins) < WIN_DIFFERENCE);
    }

/* Each deal should reduce the size of the deck by one, until
     * there ain't no mo'.
     */

    @Test
    void testDeal() {
        int fullDeckSize = deck.getCards().size();
        for (int i = 0; i < deck.getCards().size(); i++) {
            assertEquals(fullDeckSize - i, deck.getCards().size());
            deck.draw();
        }
    }
}
