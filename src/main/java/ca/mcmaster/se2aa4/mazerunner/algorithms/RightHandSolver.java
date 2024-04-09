package ca.mcmaster.se2aa4.mazerunner.algorithms;

import ca.mcmaster.se2aa4.mazerunner.parameters.Direction;
import ca.mcmaster.se2aa4.mazerunner.parameters.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameters.Path;
import ca.mcmaster.se2aa4.mazerunner.parameters.Position;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path path = new Path();

        Position currentPos = maze.getStart();
        Direction dir = Direction.RIGHT;
        while (!currentPos.equals(maze.getEnd())) {
            if (!maze.isWall(currentPos.move(dir.turnRight()))) {
                // Turn right and move forward if not a wall
                dir = dir.turnRight();
                path.addStep('R');
                currentPos = currentPos.move(dir);
                path.addStep('F');
            } else {
                if (!maze.isWall(currentPos.move(dir))) {
                    // Go forward if not a wall
                    currentPos = currentPos.move(dir);
                    path.addStep('F');
                } else if (!maze.isWall(currentPos.move(dir.turnLeft()))) {
                    // Go left if not a wall
                    dir = dir.turnLeft();
                    path.addStep('L');
                    currentPos = currentPos.move(dir);
                    path.addStep('F');
                } else {
                    // Turn around
                    dir = dir.turnRight().turnRight();
                    path.addStep('R');
                    path.addStep('R');
                }
            }
            logger.debug("Current Position: " + currentPos.toString() + "\n Current Path: " + path.getCanonicalForm());
        }

        return path;
    }
}
