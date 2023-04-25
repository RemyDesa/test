package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<N, E> {

    private Map<N, List<Edge<N, E>>> adjacencyMap;
    private boolean directed;
    private int numEdges;

    public Graph(boolean directed) {
        this.adjacencyMap = new HashMap<>();
        this.directed = directed;
        this.numEdges = 0;
    }

    public void addNode(N node) {
        if (!adjacencyMap.containsKey(node)) {
            adjacencyMap.put(node, new ArrayList<>());
        }
    }

    public void addEdge(N source, N dest, E label) {
        addNode(source);
        addNode(dest);
        adjacencyMap.get(source).add(new Edge<>(source, dest, label));
        if (!directed) {
            adjacencyMap.get(dest).add(new Edge<>(dest, source, label));
        }
        numEdges++;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean containsNode(N node) {
        return adjacencyMap.containsKey(node);
    }

    public boolean containsEdge(N source, N dest) {
        if (!containsNode(source)) {
            return false;
        }
        for (Edge<N, E> edge : adjacencyMap.get(source)) {
            if (edge.getDest().equals(dest)) {
                return true;
            }
        }
        return false;
    }

    public void removeNode(N node) {
        if (adjacencyMap.containsKey(node)) {
            // remove all edges pointing to node
            for (N other : adjacencyMap.keySet()) {
                if (other.equals(node)) {
                    continue;
                }
                List<Edge<N, E>> edges = adjacencyMap.get(other);
                edges.removeIf(edge -> edge.getDest().equals(node));
                numEdges -= (edges.size() - adjacencyMap.get(other).size());
            }
            numEdges -= adjacencyMap.get(node).size();
            adjacencyMap.remove(node);
        }
    }

    public void removeEdge(N source, N dest) {
        if (containsEdge(source, dest)) {
            adjacencyMap.get(source).removeIf(edge -> edge.getDest().equals(dest));
            if (!directed) {
                adjacencyMap.get(dest).removeIf(edge -> edge.getDest().equals(source));
            }
            numEdges--;
        }
    }

    public int getNumNodes() {
        return adjacencyMap.size();
    }

    public int getNumEdges() {
        int numEdges2 = 0;

        for (N key : adjacencyMap.keySet()) {
            numEdges2 += adjacencyMap.get(key).size();
        }

        if (!directed) {
            numEdges2 /= 2;
        }

        return numEdges2;
    }


    public List<N> getNodes() {
        return new ArrayList<>(adjacencyMap.keySet());
    }

    public List<Edge<N, E>> getEdges() {
        List<Edge<N, E>> edges = new ArrayList<>();
        for (List<Edge<N, E>> adjList : adjacencyMap.values()) {
            edges.addAll(adjList);
        }
        return edges;
    }

    //CONTROLLARE QUALE USARE
    public List<N> getNeighbors(N node) {
        List<N> neighbors = new ArrayList<>();
        if (adjacencyMap.containsKey(node)) {
            for (Edge<N, E> edge : adjacencyMap.get(node)) {
                neighbors.add(edge.getDest());
            }
        }
        return neighbors;
    }

    public List<Edge<N, E>> getAdjacentNodes(N node) {
        if (!containsNode(node)) {
            System.out.println("NULLADJACENT");
            return null;
        }

        return adjacencyMap.get(node);
    }

    public E getLabel(N source, N dest) {
        if (containsEdge(source, dest)) {
            for (Edge<N, E> edge : adjacencyMap.get(source)) {
                if (edge.getDest().equals(dest)) {
                    return edge.getLabel();
                }
            }
        }
        return null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");
        for (Map.Entry<N, List<Edge<N, E>>> entry : adjacencyMap.entrySet()) {
            sb.append(entry.getKey().toString());
            sb.append(": ");
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
