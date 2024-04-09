package ca.mcmaster.se2aa4.mazerunner.utils;

import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;

import java.util.LinkedList;

public class Converter {
    public static Path convertToCoordinates(LinkedList<Position> pathPositions) {
        Path path = new Path();
        for (Position pos : pathPositions) {
            System.out.println("(" + pos.x() + "," + pos.y() + ")");
        }
        return path;
    }
}