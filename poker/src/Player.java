public class Player{
    String name;
    int gamesWon;
    Card[] hand;
    int cardsInHand;

    Player(String newName) {
        this.name = newName;
        this.gamesWon = 0;
        this.hand;//TODO make this do stuff
        this.cardsInHand;
    }

    public void removedCardFromHand(Card cardToRemove) {
        //TODO make this do things
    }
    
    public void addCardToHand(Card cardToAdd) {
        //TODO make this do things
    }

    public Card getCardFromHand(int index) {
        //TODO make this do things
        return;
    }

    public void displayHand() {
        //TODO make this do things
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public Card[] getHand() {
        return this.hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public int getCardsInHand() {
        return this.cardsInHand;
    }

    public void setCardsInHand(int cardsInHand) {
        this.cardsInHand = cardsInHand;
    }


}
