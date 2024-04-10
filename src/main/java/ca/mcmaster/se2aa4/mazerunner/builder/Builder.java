package ca.mcmaster.se2aa4.mazerunner.builder;

import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.parameter.Direction;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;

import java.util.LinkedList;

public abstract class Builder {
    protected abstract Path buildPath(LinkedList<Position> pathPositions);

    protected static Direction getDirection(Position from, Position to) {
        if (from.x() == to.x()) {
            return from.y() < to.y() ? Direction.DOWN : Direction.UP;
        } else {
            return from.x() < to.x() ? Direction.RIGHT : Direction.LEFT;
        }
    }

    protected static char getTurn(Direction d, Direction d_target) {
        if (d == Direction.RIGHT) {
            return d_target == Direction.UP ? 'L' : 'R';
        } else if (d == Direction.LEFT) {
            return d_target == Direction.DOWN ? 'L' : 'R';
        } else if (d == Direction.UP) {
            return d_target == Direction.LEFT ? 'L' : 'R';
        } else {
            return d_target == Direction.RIGHT ? 'L' : 'R';
        }
    }
}

