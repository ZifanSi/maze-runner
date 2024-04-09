package ca.mcmaster.se2aa4.mazerunner.mode;

import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.solver.SolverFactory;
import org.apache.commons.cli.CommandLine;

public class Default {

    private final CommandLine cmd;
    private final Maze maze;

    public Default(CommandLine cmd, Maze maze) {
        this.cmd = cmd;
        this.maze = maze;
    }

    public void run() throws Exception {
        String method = cmd.getOptionValue("method", "righthand");
        MazeSolver solver = SolverFactory.createSolver(method);

        Path path = solver.solve(maze);
        System.out.println(path.getFactorizedForm());
    }
}

