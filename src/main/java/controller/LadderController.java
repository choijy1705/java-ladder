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
        for (Line line : ladder.getLines()) {
            List<Boolean> points = line.getPoints();
            View.printLadder(points);
        }
    }
}
