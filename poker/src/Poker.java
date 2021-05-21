public class Poker {
    Card[] deck;
    int nextCardInDeck;

    public Card[] getDeck() {
        return this.deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public int getNextCardInDeck() {
        return this.nextCardInDeck;
    }

    public void setNextCardInDeck(int nextCardInDeck) {
        this.nextCardInDeck = nextCardInDeck;
    }
}