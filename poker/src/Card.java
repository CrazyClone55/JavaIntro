public class Card {
    int value;
    char suit; //♢♡♣️♠️

    public Card(int newValue, char newSuit) {
        this.value = newValue;
        this.suit = newSuit;
    }

    public void displayCard() {
        System.out.println("|-----|");
        System.out.println("|" + this.value + this.suit + "   |");
        System.out.println("|     |");
        System.out.println("|   " + this.value + this.suit);
        System.out.println("|-----|");
        //TODO make it output A, J, Q, K
    }

    public boolean isEqualTo(Card otherCard) {
        if (otherCard.getValue() == this.value) {
            if (otherCard.getSuit() == this.suit) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getSuit() {
        return this.suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

}

   