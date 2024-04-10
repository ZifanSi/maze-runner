package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MazeTest {
    private Maze maze;

    @BeforeEach
    void setUp() throws Exception {
        String filePath = Paths.get("src/test/resources/examples/giant.maz.txt").toString();
        maze = new Maze(filePath);
    }


    @Test
    void testIsWall() {
        assertTrue(maze.isWall(new Position(0, 0)), "Expected to be a wall.");
        assertFalse(maze.isWall(maze.getStart()), "Start should not be a wall.");
    }
}
