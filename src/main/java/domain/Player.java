package domain;

public class Player {

    private final String name;
    private String result;

    public Player(String name) {
        this.name = name;
    }

    public void ladderResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
