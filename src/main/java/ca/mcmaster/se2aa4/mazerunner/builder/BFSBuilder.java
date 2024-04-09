package ca.mcmaster.se2aa4.mazerunner.builder;

import ca.mcmaster.se2aa4.mazerunner.parameter.Direction;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;

import java.util.LinkedList;

public class BFSBuilder extends Builder {
    @Override
    public Path buildPath(LinkedList<Position> pathPositions) {
        if (pathPositions.isEmpty()) {
            return new Path();
        }

        Path path = new Path();
        Position previous = pathPositions.poll();
        Direction currentDirection = getDirection(previous, pathPositions.peek());
        int forwardCount = 0;

        for (Position current : pathPositions) {
            Direction newDirection = getDirection(previous, current);

            if (newDirection == currentDirection) {
                forwardCount++;
            } else {
                if (forwardCount > 0) {
                    while (forwardCount-- > 0) {
                        path.addStep('F');
                    }
                    forwardCount = 1;
                }
                path.addStep(determineTurn(currentDirection, newDirection));
            }

            currentDirection = newDirection;
            previous = current;
        }

        if (forwardCount > 0) {
            while (forwardCount-- > 0) {
                path.addStep('F');
            }
        }

        return path;
    }
}

