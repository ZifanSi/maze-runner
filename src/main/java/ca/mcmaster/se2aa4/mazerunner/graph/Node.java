package ca.mcmaster.se2aa4.mazerunner.graph;

import java.util.Objects;


public class Node {
    public int x, y;
    public Node parent;

    /**
     * Constructs a new Node with specified coordinates and parent node.
     *
     * @param x      The x-coordinate of the node
     * @param y      The y-coordinate of the node
     * @param parent The parent node in the path
     */
    public Node(int x, int y, Node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
