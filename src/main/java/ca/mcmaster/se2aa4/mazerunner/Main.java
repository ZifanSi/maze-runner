package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Algorithms.BFSSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithms.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithms.TremauxSolver;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(getParserOptions(), args);
            String filePath = cmd.getOptionValue("i");
            String method = cmd.getOptionValue("method", "righthand");
            String baselineMethod = cmd.getOptionValue("baseline");

            Maze maze = new Maze(filePath);

            if (cmd.getOptionValue("p") != null) {
                logger.info("Validating path");
                Path path = new Path(cmd.getOptionValue("p"));
                if (maze.validatePath(path)) {
                    System.out.println("correct path");
                } else {
                    System.out.println("incorrect path");
                }
            } else {
                long startTime = System.currentTimeMillis();
                Path path = solveMaze(method, maze);
                long methodTime = System.currentTimeMillis() - startTime;

                System.out.println(path.getFactorizedForm());
                System.out.printf("Time spent with %s method: %.2f ms\n", method, (double)methodTime);

                if (baselineMethod != null) {
                    startTime = System.currentTimeMillis();
                    Path baselinePath = solveMaze(baselineMethod, maze);
                    long baselineTime = System.currentTimeMillis() - startTime;

                    System.out.printf("Time spent with %s method: %.2f ms\n", baselineMethod, (double)baselineTime);

                    double speedup = (double) baselinePath.getPathSteps().size() / path.getPathSteps().size();
                    System.out.printf("Speedup: %.2f\n", speedup);
                }
            }
        } catch (Exception e) {
            System.err.println("MazeSolver failed. Reason: " + e.getMessage());
            logger.error("MazeSolver failed. Reason: " + e.getMessage());
        }

        logger.info("End of MazeRunner");
    }

    /**
     * Solve provided maze with specified method.
     *
     * @param method Method to solve maze with
     * @param maze Maze to solve
     * @return Maze solution path
     * @throws Exception If provided method does not exist
     */
    private static Path solveMaze(String method, Maze maze) throws Exception {
        MazeSolver solver = null;
        switch (method) {
            case "righthand" -> {
                logger.debug("RightHand algorithm chosen.");
                solver = new RightHandSolver();
            }
            case "tremaux" -> {
                logger.debug("Tremaux algorithm chosen.");
                solver = new TremauxSolver();
            }
            case "BFS" -> {
                logger.debug("Breadth First Search chosen.");
                solver = new BFSSolver();
            }
            default -> {
                throw new Exception("Maze solving method '" + method + "' not supported.");
            }
        }

        logger.info("Computing path");
        return solver.solve(maze);
    }

    /**
     * Get options for CLI parser.
     *
     * @return CLI parser options
     */
    private static Options getParserOptions() {
        Options options = new Options();

        Option fileOption = new Option("i", true, "File that contains maze");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        options.addOption(new Option("p", true, "Path to be verified in maze"));
        options.addOption(new Option("method", true, "Specify which path computation algorithm will be used"));
        options.addOption("baseline", true, "Baseline method for comparison");

        return options;
    }
}
