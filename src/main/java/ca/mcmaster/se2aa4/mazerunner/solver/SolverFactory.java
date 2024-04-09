package ca.mcmaster.se2aa4.mazerunner.solver;

import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithms.TremauxSolver;

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
