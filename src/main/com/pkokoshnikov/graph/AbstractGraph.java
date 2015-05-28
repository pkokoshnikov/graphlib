package com.pkokoshnikov.graph;

import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pako1113
 * Date: 22.05.15
 * Abstract class for graphs
 */
abstract public class AbstractGraph<T extends Edge> {
    final static Logger logger = Logger.getLogger(AbstractGraph.class);
    protected GraphDataStructure<T> graphDataStructure;

    public AbstractGraph(GraphDataStructure<T> graphDataStructure) {
        this.graphDataStructure = graphDataStructure;
    }

    public boolean addVertex(Vertex vertex) {
        return graphDataStructure.addVertex(vertex);
    }

    public boolean addVertices(List<? extends Vertex> vertices) {
        return graphDataStructure.addVertices(vertices);
    }

    public boolean addEdge(T edge) {
        return graphDataStructure.addEdge(edge);
    }

    public boolean addEdges(List<T> edges) {
        return graphDataStructure.addEdges(edges);
    }

    public List<Vertex> getVertices() {
        return graphDataStructure.getVertices();
    }

    /**
     * Initialization part of DFS algorithm
     * @param start vertex
     * @param goal vertex
     * @return list of vertex in the path
     */
    private List<Vertex> dfs(Vertex start, Vertex goal) {
        logger.debug("DFS started , start = " + start + " goal =" + goal);
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        List<Vertex> whiteVertices = new LinkedList<Vertex>(graphDataStructure.getVertices());

        dfs(start, goal, path, whiteVertices);
        if (!path.isEmpty()) {
            path.addFirst(start);
        }

        logger.debug("DFS ended, path = " + path);
        return path;
    }

    /**
     * Recursive part of DFS algorithm
     * @param start vertex
     * @param goal vertex
     * @param path is used for storing vertex in path between recursive calls
     * @param whiteVertices
     * @return
     */
    private boolean dfs(Vertex start, Vertex goal, LinkedList<Vertex> path, List<Vertex> whiteVertices) {
        whiteVertices.remove(start);
        List<Vertex> filteredWhiteVertices = filterWhiteVertices(graphDataStructure.getAdjacencyList(start), whiteVertices);
        logger.debug("white vertices = " + filteredWhiteVertices);

        if (start.equals(goal)) {
            logger.debug("goal found " + goal);
            return true;
        }

        for (Vertex vertex : filteredWhiteVertices) {
            if (dfs(vertex, goal, path, whiteVertices)) {
                path.addFirst(vertex);
                logger.debug("vertex has been added to path " + vertex );
                return true;
            }
        }

        return false;
    }

    /**
     * Filtering white vertices form adjacency list
     * It's used in DFS algorithm
     */
    private List<Vertex> filterWhiteVertices(List<Vertex> adjacencyList, List<Vertex> whiteVertices) {
        LinkedList<Vertex> result = new LinkedList<Vertex>();
        for (Vertex vertex : adjacencyList) {
            if (whiteVertices.contains(vertex)) result.add(vertex);
        }

        return result;
    }

    public List<Vertex> getPath(Vertex start, Vertex goal) {
        return dfs(start, goal);
    }

    protected List<T> getEdges() {
        return graphDataStructure.getEdges();
    }

    protected List<Vertex> getAdjacencyList(Vertex u) {
        return graphDataStructure.getAdjacencyList(u);
    }

    @Override
    public String toString() {
        return "AbstractGraph{" +
                "graphDataStructure=" + graphDataStructure +
                "}";
    }
}
