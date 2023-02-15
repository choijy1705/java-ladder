package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final Players players;
    private final List<Line> lines;
    private final List<String> results;
    private final int height;

    public Ladder(List<String> names, int height, List<String> results) {
        this.players = initPlayers(names);
        this.lines = initLines(names.size(), height);
        this.results = results;
        this.height = height;
    }

    public void play() {
        for (int i = 0; i < players.getPlayerNumber(); i++) {
            int index = move(i);

            Player player = players.getPlayer(i);
            player.ladderResult(results.get(index));
        }
    }

    public List<Line> getLines() {
        return lines;
    }


    public String getGameResults(String playerName) {
        return players.getResult(playerName);
    }

    private Players initPlayers(List<String> names) {
        List<Player> players = names.stream()
            .map(Player::new)
            .collect(Collectors.toList());
        return new Players(players);
    }

    private List<Line> initLines(int length, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(length - 1);
            lines.add(line);
        }

        return lines;
    }

    private int move(final int startPosition) {
        int positionHeight = 0;
        int index = startPosition;
        while (positionHeight < height) {
            // 오른쪽에 발판이 있으면 오른쪽으로 이동
            if (index < players.getPlayerNumber() - 1 && lines.get(positionHeight).getPoints().get(index)) {
                index++;
                positionHeight++;
                continue;
            }
            // 왼쪽에 발판이 있으면 왼쪽으로 이동
            if (index > 0 && lines.get(positionHeight).getPoints().get(index - 1)) {
                index--;
            }
            positionHeight++;
        }
        return index;
    }
}
