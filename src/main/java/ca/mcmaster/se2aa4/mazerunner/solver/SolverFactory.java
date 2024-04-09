package ca.mcmaster.se2aa4.mazerunner.solver;

import ca.mcmaster.se2aa4.mazerunner.algorithm.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithm.TremauxSolver;

public class SolverFactory {

    public static MazeSolver createSolver(String method) throws Exception {
        switch (method) {
            case "righthand":
                return new RightHandSolver();
            case "tremaux":
                return new TremauxSolver();
            case "BFS":
                return new BFSSolver();
            default:
                throw new Exception("Maze solving method '" + method + "' not supported.");
        }
    }
}
