package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.algorithm.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.TremauxSolver;
import ca.mcmaster.se2aa4.mazerunner.factory.SolverFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
Goal: Error Handling
 Ensuring the runner handles invalid inputs or unsolvable mazes is important.
 Tests should cover scenarios like invalid file paths, improperly formatted maze files, mazes without a valid start or end point, and mazes that are unsolvable.
**/
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

    @Test
    void testCreateSolverWithUnsupportedType() {
        assertThrows(Exception.class, () -> SolverFactory.createSolver("unsupported"), "Should throw an exception for unsupported solver types.");
    }

    @Test
    void testCreateSolverWithEmptyString() {
        assertThrows(Exception.class, () -> SolverFactory.createSolver(""), "Should throw an exception for empty solver type.");
    }

    @Test
    void testCreateSolverWithNull() {
        assertThrows(Exception.class, () -> SolverFactory.createSolver(null), "Should throw an exception for null solver type.");
    }
}
