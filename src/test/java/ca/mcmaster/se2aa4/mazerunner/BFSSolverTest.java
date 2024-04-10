package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.algorithm.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
