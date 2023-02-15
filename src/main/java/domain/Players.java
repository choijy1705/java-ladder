package domain;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public String getResult(String playerName) {
        if ("all".equals(playerName)) {
            return players.stream()
                .map(player -> String.format("%s : %s", player.getName(), player.getResult()))
                .reduce("", (s1, s2) -> s1 + "\n" + s2);
        }

        return players.stream()
            .filter(player -> playerName.equals(player.getName()))
            .findAny()
            .orElseThrow()
            .getResult();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getPlayerNumber() {
        return players.size();
    }
}
