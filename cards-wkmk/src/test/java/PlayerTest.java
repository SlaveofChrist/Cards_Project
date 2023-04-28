package cards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cards.Card.Rank.*;
import static cards.Card.Suit.*;

class PlayerTest {
    private static final Card C4 = new Card(CLUBS, FOUR);
    private static final Card D10 = new Card(DIAMONDS, TEN);
    private static final Card SJ = new Card(SPADES, JACK);
    private static int HAND_SIZE = 3;
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("John");
    }
    
    @Test
    void init() {
        assertEquals("John has 0 points \nCards in hand: \n",
            player.toString());
    }

    @Test
    void compareByCards() {
        Player playerC4 = new Player("C4");
        playerC4.dealtCard(C4);
        Player playerD10 = new Player("D10");
        playerD10.dealtCard(D10);
        Player playerSJ = new Player("SJ");
        playerSJ.dealtCard(SJ);
        Set<Player> players = new HashSet<>(List.of(playerC4, playerD10, playerSJ));
        players.forEach(p -> p.setComparator(Player.CARDS_COMPARATOR));
        assertAll(
            () -> assertEquals(-1, playerD10.compareTo(playerSJ)),
            () -> assertEquals(0, playerD10.compareTo(playerD10)),
            () -> assertEquals(1, playerD10.compareTo(playerC4))
        );
    }

    @Test
    void compareByPoints() {
        Player player4 = new Player("4");
        player4.points = 4;
        Player player10 = new Player("10");
        player10.points = 10;
        Set<Player> players = new HashSet<>(List.of(player4, player10));
        players.forEach(p -> p.setComparator(Player.POINTS_COMPARATOR));
        assertAll(
            () -> assertTrue(player4.compareTo(player10) < 0),
            () -> assertEquals(0, player10.compareTo(player10)),
            () -> assertTrue(player10.compareTo(player4) > 0)
        );
    }

    private void dealCards() {
        player.dealtCard(SJ);
        player.dealtCard(C4);
        player.dealtCard(D10);
    }

    @Test
    void dealtCards() {
        dealCards();
        assertAll(
            () -> assertEquals(3, player.hand.cards.size()),
            () -> assertEquals(SJ, player.hand.cards.last()),
            () -> assertEquals(C4, player.hand.cards.first())
        );
    }

    @Test
    void testPlay() {
        dealCards();
        player.playCard();
        assertEquals(HAND_SIZE - 1, player.hand.cards.size());
        player.playCard();
        assertEquals(HAND_SIZE - 2, player.hand.cards.size());
    }
}
