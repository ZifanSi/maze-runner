package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.mode.Default;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.mode.Benchmark;
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
            long loadStartTime = System.currentTimeMillis();
            Maze maze = new Maze(filePath);
            long loadEndTime = System.currentTimeMillis();
            double mazeLoadTime = (loadEndTime - loadStartTime) / 1.0;

            if (cmd.hasOption("p")) {
                logger.info("Validating path");
                Path path = new Path(cmd.getOptionValue("p"));
                System.out.println(maze.validatePath(path) ? "correct path" : "incorrect path");
            } else if (cmd.hasOption("baseline")) {

                Benchmark benchmark = new Benchmark(cmd, maze, mazeLoadTime);
                benchmark.run();
            } else {
                Default normalRunner = new Default(cmd, maze);
                normalRunner.run();
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