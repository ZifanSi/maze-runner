package ca.mcmaster.se2aa4.mazerunner.solver;

import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;

public interface MazeSolver {
    /**
     * Solve maze and return path through maze.
     *
     * @param maze Maze to solve
     * @return Path that solves the provided maze
     */
    Path solve(Maze maze);
}
