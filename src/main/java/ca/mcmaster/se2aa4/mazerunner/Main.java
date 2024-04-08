package ca.mcmaster.se2aa4.mazerunner;

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
            Maze maze = new Maze(filePath);

            if (cmd.hasOption("p")) {
                logger.info("Validating path");
                Path path = new Path(cmd.getOptionValue("p"));
                System.out.println(maze.validatePath(path) ? "correct path" : "incorrect path");
            } else {
                // Run STEP #5: BENCHMARK & COMPARE
                Benchmark benchmark = new Benchmark(cmd, maze);
                benchmark.run();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            logger.error("Error: " + e.getMessage());
        }

        logger.info("End of MazeRunner");
    }

    private static Options getParserOptions() {
        Options options = new Options();
        options.addOption("i", true, "File that contains maze");
        options.addOption("p", true, "Path to be verified in maze");
        options.addOption("method", true, "Specify which path computation algorithm will be used");
        options.addOption("baseline", true, "Baseline method for comparison");
        return options;
    }
}
