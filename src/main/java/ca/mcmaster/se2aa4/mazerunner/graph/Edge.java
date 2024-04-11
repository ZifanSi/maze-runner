package ca.mcmaster.se2aa4.mazerunner.graph;

public class Edge {
    private final Node start;
    private final Node end;
    private final double weight;

    public Edge(Node start, Node end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

}