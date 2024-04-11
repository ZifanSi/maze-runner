package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 Goal: Maze Loading
 The Maze class's ability to load and parse different maze files correctly is critical.
 Tests should verify that the maze is loaded correctly, the start and end points are identified correctly, and walls and open spaces are mapped accurately.
 **/


class MazeTest {
    private Maze maze;

    @BeforeEach
    void setUp() throws Exception {
        String filePath = Paths.get("./examples/tiny.maz.txt").toString();
        maze = new Maze(filePath);
    }


    @Test
    void testIsWall() {
        assertTrue(maze.isWall(new Position(0, 0)), "Expected to be a wall.");
        assertFalse(maze.isWall(maze.getStart()), "Start should not be a wall.");
    }

    @Test
    void testFindStart() {
        Position start = maze.getStart();
        assertFalse(maze.isWall(start), "Start position should not be a wall.");
    }

    @Test
    void testFindEnd() {
        Position end = maze.getEnd();
        assertFalse(maze.isWall(end), "End position should not be a wall.");
    }

}
