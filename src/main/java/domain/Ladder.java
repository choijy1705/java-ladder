package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Player> players;
    private final List<Line> lines;

    public Ladder(List<String> names, int height) {
        this.players = initPlayers(names);
        this.lines = initLines(names.size(), height);
    }

    private List<Player> initPlayers(List<String> names) {
        return names.stream()
            .map(Player::new)
            .collect(Collectors.toList());
    }

    private List<Line> initLines(int length, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(length - 1);
            lines.add(line);
        }

        return lines;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }
}
