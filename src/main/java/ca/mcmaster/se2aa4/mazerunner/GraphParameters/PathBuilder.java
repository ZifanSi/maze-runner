package ca.mcmaster.se2aa4.mazerunner.GraphParameters;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.Position;

import java.util.LinkedList;

public class PathBuilder {
    public static Path buildPath(LinkedList<Position> pathPositions) {
        if (pathPositions.isEmpty()) {
            return new Path();
        }

        StringBuilder pathString = new StringBuilder();
        Position p_prev = pathPositions.poll();
        Direction d = getDirection(p_prev, pathPositions.peek());
        int forwardCount = 0;

        for (Position p : pathPositions) {
            Direction newDirection = getDirection(p_prev, p);

            if (newDirection == d && d == Direction.RIGHT) {
                forwardCount++;
            } else {
                if (forwardCount > 0) {
                    pathString.append(forwardCount).append('F').append(' ');
                }
                forwardCount = 1;
                if (newDirection != d) {
                    pathString.append(determineTurn(d, newDirection)).append(' ');
                }
            }

            d = newDirection;
            p_prev = p;
        }

        if (forwardCount > 0) {
            pathString.append(forwardCount).append('F');
        }

        Path path = new Path();
        String[] elements = pathString.toString().trim().split(" ");
        for (String element : elements) {
            if (element.endsWith("F")) {
                int count = Integer.parseInt(element.substring(0, element.length() - 1));
                for (int i = 0; i < count; i++) {
                    path.addStep('F');
                }
            } else {
                path.addStep(element.charAt(0));
            }
        }

        return path;
    }

    private static Direction getDirection(Position from, Position to) {
        if (from.x() == to.x()) {
            return from.y() < to.y() ? Direction.DOWN : Direction.UP;
        } else {
            return from.x() < to.x() ? Direction.RIGHT : Direction.LEFT;
        }
    }

    private static String determineTurn(Direction d, Direction d_target) {
        if (d == Direction.RIGHT) {
            return d_target == Direction.UP ? "L" : "R";
        } else if (d == Direction.LEFT) {
            return d_target == Direction.DOWN ? "L" : "R";
        } else if (d == Direction.UP) {
            return d_target == Direction.LEFT ? "L" : "R";
        } else {
            return d_target == Direction.RIGHT ? "L" : "R";
        }
    }
}
