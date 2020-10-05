import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.stream()
            .forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public int handValue() {
        int handValue = cards.stream()
            .reduce(0, (sum, card) -> sum + card.getValue(), Integer::sum);
        
        return handValue;
    }
    
    public int compareTo(Hand hand) {
        return this.handValue() - hand.handValue();
    }
    
    public void sortBySuit() {
        Comparator<Card> comparator = Comparator
                .comparing(Card::getSuit)
                .thenComparing(Card::getValue);
        
        Collections.sort(cards, comparator);        
    }
}
