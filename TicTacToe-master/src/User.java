public class User {
    String name;
    String symbol;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void init(String[] input) {
        this.name = input[0];
        this.symbol = input[1];
    }
}
