package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;

public class Benchmark {

    private final CommandLine cmd;
    private final Maze maze;

    public Benchmark(CommandLine cmd, Maze maze) {
        this.cmd = cmd;
        this.maze = maze;
    }

    public void run() throws Exception {
        String method = cmd.getOptionValue("method", "righthand");
        MazeSolver solver = SolverFactory.createSolver(method);

        long startTime = System.currentTimeMillis();
        Path path = solver.solve(maze);
        long endTime = System.currentTimeMillis();
        System.out.println(path.getFactorizedForm());
        System.out.printf("Time spent with %s method: %.2f ms\n", method, (endTime - startTime) / 1000.0);

        if (cmd.hasOption("baseline")) {
            String baselineMethod = cmd.getOptionValue("baseline");
            MazeSolver baselineSolver = SolverFactory.createSolver(baselineMethod);

            startTime = System.currentTimeMillis();
            Path baselinePath = baselineSolver.solve(maze);
            endTime = System.currentTimeMillis();
            System.out.printf("Time spent with %s method: %.2f ms\n", baselineMethod, (endTime - startTime) / 1000.0);

            double speedup = (double) baselinePath.getPathSteps().size() / path.getPathSteps().size();
            System.out.printf("Speedup: %.2f\n", speedup);
        }
    }
}
