package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.algorithm.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 Goal: Basic Functionality
 The essential parts of the Maze Runner project are the pathfinding algorithms (BFSSolver, RightHandSolver, TremauxSolver).
 These are essential for the application's main purpose, which is to find a path through the maze.
 Therefore, testing these components to ensure they accurately find the path, handle “contradicted”  cases, and operate efficiently on various maze sizes.
 **/

class BFSSolverTest {

    @Test
    void testSolveTinyMaze() throws Exception {
        Maze maze = new Maze("./examples/tiny.maz.txt");
        BFSSolver solver = new BFSSolver();
        Path path = solver.solve(maze);

        String expected = "3F L 4F R 3F";
        assertEquals(expected, path.getFactorizedForm(), "The BFS solver did not generate the expected path.");
    }
}
