package controller;

import domain.Ladder;
import domain.Line;
import java.util.List;
import view.View;

public class LadderController {

    public void run() {
        List<String> names = View.getNames();
        List<String> results = View.getResults();
        int height = View.getLadderHeight();

        Ladder ladder = new Ladder(names, height, results);
        ladder.play();

        View.printNames(names);
        printLadder(ladder);
        View.printResults(results);

        String playerName = View.selectPlayer();

        View.printGameResult(ladder.getGameResults(playerName));
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            View.printLadder(line.getPoints());
        }
    }
}
