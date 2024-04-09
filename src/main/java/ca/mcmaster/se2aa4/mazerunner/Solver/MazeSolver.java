package ca.mcmaster.se2aa4.mazerunner.Solver;

import ca.mcmaster.se2aa4.mazerunner.Parameters.Maze;
import ca.mcmaster.se2aa4.mazerunner.Parameters.Path;

public interface MazeSolver {
    /**
     * Solve maze and return path through maze.
     *
     * @param maze Maze to solve
     * @return Path that solves the provided maze
     */
    Path solve(Maze maze);
}
