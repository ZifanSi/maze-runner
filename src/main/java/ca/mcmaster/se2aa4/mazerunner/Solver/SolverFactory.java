package ca.mcmaster.se2aa4.mazerunner.Solver;

import ca.mcmaster.se2aa4.mazerunner.Algorithms.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithms.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithms.TremauxSolver;
import ca.mcmaster.se2aa4.mazerunner.Solver.MazeSolver;

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
