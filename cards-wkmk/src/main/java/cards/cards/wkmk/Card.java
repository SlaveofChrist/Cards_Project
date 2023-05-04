package cards.cards.wkmk;

/**
 * This class define the object Card
 *
 * @author <a href="elielwotobe@gmail.com">Eliel WOTOBE</a>
 */
public class Card implements Comparable<Card>{
    public static final int LESS = -1;
    public static final int MORE = 1 ;
    public static final int SAME = 0 ;
   public enum Rank {

        TWO("two"),
        THREE("three"),
        FOUR("four"),
        FIVE("five"),
        SIX("six"),
        SEVEN("seven"),
        EIGHT("eight"),
        NINE("nine"),
        TEN("ten"),
        JACK("jack"),
        QUEEN("queen"),
        KING("king"),
        ACE("ace");
        private String rankString;
         Rank(String r){
            this.rankString = r;
        }
        public String toString() {
            return rankString;
        }

    }

    public  enum Suit {
        CLUBS("clubs"),
        DIAMONDS("diamonds"),
        HEARTS("hearts"),
        SPADES("spades");

        private String suitString;
        Suit(String s){
            this.suitString = s;
        }
        public String toString() {
            return suitString;
        }

    }

    Rank r ;
    Suit s;
    public Card(Suit suit, Rank rank){
        this.s = suit;
        this.r = rank;
    }

    public int compareTo(Card other){
        if (this.r.compareTo(other.r) > 0)
            return MORE;
        if (this.r.compareTo(other.r) < 0)
            return LESS;
        if (this.r.compareTo(other.r) == 0) {
            if (this.s.compareTo(other.s) < 0){
                return LESS;
            }
            if(this.s.compareTo(other.s) > 0)
                return MORE;
            return SAME;
        }
        return -2;
    }

    public String toString(){
        return this.r + " of " + this.s;
    }
}
