/*
package cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static cards.Card.Rank.*;
import static cards.Card.Suit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

*/
/**
 * Exercises the Hand class.
 * @author <a href="mailto:sander@unice.fr">Peter Sander</a>
 *//*

@SuppressWarnings("serial")
class HandTest {
    // the following expression should look pretty mysterious!
    //  try to figure out how it works...
    private static final List<Card> SOME_CARDS = new ArrayList<>() {{
        add(new Card(SPADES, JACK));
        add(new Card(DIAMONDS, SEVEN));
        add(new Card(SPADES, FIVE));
    }};
    private Hand hand;

    @BeforeEach
    void setUp() {
        hand = new Hand();
        SOME_CARDS.forEach(c -> hand.add(c));
    }

    @Disabled
    void print() {
        System.out.println(hand);
        hand.add(new Card(SPADES, TWO));
        hand.add(new Card(CLUBS, QUEEN));
        hand.add(new Card(DIAMONDS, FIVE));
        System.out.println(hand);
    }

    @Test
    void initialOrder() {
        assertEquals(SOME_CARDS.get(2), hand.cards.first());
        assertEquals(SOME_CARDS.get(0), hand.cards.last());
    }
    
    @Test
    void newHighCard() {
        Card hq = new Card(HEARTS, QUEEN);
        hand.add(hq);
        assertEquals(SOME_CARDS.get(2), hand.cards.first());
        assertEquals(hq, hand.cards.last());
    }
    
    @Test
    void newLowCard() {
        Card s3 = new Card(SPADES, THREE);
        hand.add(s3);
        assertEquals(s3, hand.cards.first());
        assertEquals(SOME_CARDS.get(0), hand.cards.last());
    }

    @Test
    void newMiddleCard() {
        hand.add(new Card(CLUBS, TEN));
        assertEquals(SOME_CARDS.get(2), hand.cards.first());
        assertEquals(SOME_CARDS.get(0), hand.cards.last());
    }
}
*/
