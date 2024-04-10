package ca.mcmaster.se2aa4.mazerunner.mode;

import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.solver.SolverFactory;
import org.apache.commons.cli.CommandLine;

public class Benchmark {

    private final CommandLine cmd;
    private final Maze maze;
    private final double mazeLoadTime;

    public Benchmark(CommandLine cmd, Maze maze, double mazeLoadTime) {
        this.cmd = cmd;
        this.maze = maze;
        this.mazeLoadTime = mazeLoadTime;
    }

    public void run() throws Exception {

        // maze loading
        System.out.printf("Time spent loading the maze: %.2f ms\n", mazeLoadTime);

        // optimized
        String method = cmd.getOptionValue("method", "righthand");
        MazeSolver solver = SolverFactory.createSolver(method);
        long startTime = System.currentTimeMillis();
        Path path = solver.solve(maze);
        long endTime = System.currentTimeMillis();
        System.out.printf("Time spent with %s method: %.2f ms\n", method, (endTime - startTime) / 1.0);
        System.out.println("Instructions (optimized): " + path.getPathSteps().size());


        // baseline
        if (cmd.hasOption("baseline")) {
            String baselineMethod = cmd.getOptionValue("baseline");
            MazeSolver baselineSolver = SolverFactory.createSolver(baselineMethod);

            startTime = System.currentTimeMillis();
            Path baselinePath = baselineSolver.solve(maze);
            endTime = System.currentTimeMillis();
            System.out.printf("Time spent with %s method: %.2f ms\n", baselineMethod, (endTime - startTime) / 1.0);
            System.out.println("Instructions (baseline): " + baselinePath.getPathSteps().size());


            double speedup = (double) baselinePath.getPathSteps().size() / path.getPathSteps().size();
            System.out.printf("Speedup: %.2f\n", speedup);
        }
    }
}
