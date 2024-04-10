package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.algorithm.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.TremauxSolver;
import ca.mcmaster.se2aa4.mazerunner.factory.SolverFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverFactoryTest {

    @Test
    void testCreateBFSSolver() throws Exception {
        MazeSolver solver = SolverFactory.createSolver("BFS");
        assertTrue(solver instanceof BFSSolver, "Should create a BFSSolver instance.");
    }

    @Test
    void testCreateRightHandSolver() throws Exception {
        MazeSolver solver = SolverFactory.createSolver("righthand");
        assertTrue(solver instanceof RightHandSolver, "Should create a RightHandSolver instance.");
    }

    @Test
    void testCreateTremauxSolver() throws Exception {
        MazeSolver solver = SolverFactory.createSolver("tremaux");
        assertTrue(solver instanceof TremauxSolver, "Should create a TremauxSolver instance.");
    }
}
