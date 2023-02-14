package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomUtil;

public class Line {

    private final List<Boolean> points;

    public Line(int peopleCount) {
        this.points = initPoints(peopleCount);
    }

    private List<Boolean> initPoints(int peopleCount) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            points.add(createPoint(points, i));
        }

        return points;
    }

    private boolean createPoint(List<Boolean> points, int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return RandomUtil.getRandomNumber() > 5;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
