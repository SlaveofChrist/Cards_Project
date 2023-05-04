
import org.junit.jupiter.api.Test;
import static cards.cards.wkmk.Card.*;
import static cards.cards.wkmk.Card.Rank.*;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    private final Rank r1 = TEN;
    private final Rank r2 = KING;

    @Test
    void compare() {
        assertAll(
            () -> assertTrue(r1.compareTo(r2) < 0),
            () -> assertTrue(r2.compareTo(r1) > 0),
            () -> assertEquals(0, r1.compareTo(r1))
        );
    }
}
