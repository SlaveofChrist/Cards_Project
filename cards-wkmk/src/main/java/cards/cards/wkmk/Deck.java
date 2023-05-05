package cards.cards.wkmk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck(){
        for(Card.Suit s : Card.Suit.values()){
            for(Card.Rank r : Card.Rank.values()){
                cards.add(new Card(s,r));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){
        return cards.remove(cards.size()-1);
    }

    public Card get(int i) {
        if(i < 0 || i > cards.size()) {
            System.out.println("Veuillez saisir un index situé entre 0 et 52");
            System.exit(1);
        }
        return cards.get(i);
    }
}
