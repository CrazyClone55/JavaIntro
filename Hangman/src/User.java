public class User {
    String name;
    int score;
    boolean guesser;

    public User(String name) {
        this.name = name;
        this.score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addPoint() {
        this.score++;
    }

    public void setGuesser(boolean x) {
        this.guesser = x;
    }

    public boolean getGuesser() {
        return this.guesser;
    }
}
