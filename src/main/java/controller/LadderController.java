package controller;

import domain.Ladder;
import domain.Line;
import java.util.List;
import view.View;

public class LadderController {

    public void run() {
        List<String> names = View.getNames();
        int height = View.getLadderHeight();

        Ladder ladder = new Ladder(names, height);

        View.printNames(names);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            View.printLadder(line.getPoints());
        }
    }
}
