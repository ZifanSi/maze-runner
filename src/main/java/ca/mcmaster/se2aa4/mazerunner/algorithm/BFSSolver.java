package ca.mcmaster.se2aa4.mazerunner.algorithm;

import ca.mcmaster.se2aa4.mazerunner.builder.BFSBuilder;
import ca.mcmaster.se2aa4.mazerunner.parameter.Maze;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.parameter.Path;
import ca.mcmaster.se2aa4.mazerunner.parameter.Position;
import ca.mcmaster.se2aa4.mazerunner.graph.Node;

import java.util.*;
/*
Cite[1]: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
Cite[2]: https://algs4.cs.princeton.edu/41graph/Graph.java.html
See my step-by-step illustration in README
*/

public class BFSSolver implements MazeSolver {
    private Maze maze;

    /**
     * Solves the maze using Breadth First Search (BFS) algorithm.
     *
     * @param maze The maze to be solved
     * @return The path solution
     */
    @Override
    public Path solve(Maze maze) {
        this.maze = maze;
        Position start = maze.getStart();
        Position end = maze.getEnd();

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();

        Node startNode = new Node(start.x(), start.y(), null);
        q.add(startNode);
        visited.put(startNode, null);

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == end.x() && current.y == end.y()) {
                return tracePath(current);
            }

            for (Node neighbor : getNeighbors(current)) {
                if (!visited.containsKey(neighbor) && !maze.isWall(new Position(neighbor.x, neighbor.y))) {
                    q.add(neighbor);
                    visited.put(neighbor, current);
                }
            }
        }
        return new Path();
    }

    /**
     * Get the neighboring nodes of a given node.
     *
     * @param node The node for which neighbors are to be found
     * @return The list of neighboring nodes
     */
    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int newX = node.x + dir[0];
            int newY = node.y + dir[1];

            if (newX >= 0 && newX < maze.getSizeX() && newY >= 0 && newY < maze.getSizeY()) {
                Node newNode = new Node(newX, newY, node);
                if (!maze.isWall(new Position(newX, newY))) {
                    neighbors.add(newNode);
                }
            }
        }

        return neighbors;
    }

    /**
     * Trace the path from the end node back to the start node.
     *
     * @param endNode The end node of the path
     * @return The traced path
     */
    private Path tracePath(Node endNode) {
        LinkedList<Position> pathPositions = new LinkedList<>();
        Node current = endNode;

        while (current != null) {
            pathPositions.addFirst(new Position(current.x, current.y));
            current = current.parent;
        }
        BFSBuilder builder = new BFSBuilder();
        return builder.buildPath(pathPositions);
    }
}
