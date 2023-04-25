package Dijkstra;

import Graph.*;
import MinHeap.*;
import java.util.*;

/*total time complexity for dense graph:
  build min heap and hashmap: O(n)
  extract min: O(n log(n)) (counting the while condition)
  decrease key: O(n log(n)) (counting the while condition)
  replace the value in hashmap: O(n) (counting the while condition)
  total: O(n log(n))
 */


public class Dijkstra<T,G extends Number> {
  public Map<T, G> dijkstra(Graph<T, G> graph, T start, Comparator<Edge<T, G>> comparator, G startValue,G inf) throws Exception {
    Map<T,G> distances = new HashMap<>();   //Distances from nodes
    MinHeap<Edge<T,G>> pq = new MinHeap<>(comparator); //Priority Queue
    List<T> keys = graph.getNodes();    //All the nodes names from the graph
    Edge<T, G> u;
    // Initialize distances and add all nodes to the priority queue
      for (T node : graph.getNodes()) {
          G support;
          if (node.equals(start)) {
              distances.put(start, startValue);
              support=startValue;
          } else {
              distances.put(node, inf);
              support=inf;
          }
          pq.insert(new Edge<>(node, distances.get(node),support));
      }
      /*
    while (!pq.isEmpty()) { //O(n)
      u = pq.extractMin();    //O(log n)
      //System.out.println("EDGE MIN "+u.toString());
      
      int j=0;
      for(Edge<T,G> i : graph.getAdjacentVertex(u.getEnd())) {    //O(m) for dense graph O(1)
        System.out.println(j);
        //if v is present in min heap and dist[v] > dist[u] + dist(u+v)
        if(pq.contains(new Edge<>(i.getEnd(),distances.get(i.getEnd()))) &&
          Edge.compare(distances.get(i.getEnd()),Edge.add(u.getWeight(),graph.getEdgeLabel(u.getEnd(),i.getEnd()))) > 0) {
          //decrease the actual value in min heap for newer value O(log n)
          //System.out.println("Sono dentro if con "/*+distances.get(i.getEnd())+" e "+Edge.add(u.getWeight(),graph.getEdgeLabel(u.getEnd(),i.getEnd()));
          pq.decreaseKey(new Edge<>(i.getEnd(),distances.get(i.getEnd())),
            new Edge<>(i.getEnd(),Edge.add(u.getWeight(),graph.getEdgeLabel(u.getEnd(),i.getEnd()))));
          //update the value of the edge
          distances.replace(i.getEnd(),Edge.add(u.getWeight(),graph.getEdgeLabel(u.getEnd(),i.getEnd())));
        }
        j++;
      }
    }
    //System.out.println(Collections.singletonList(distances));
    System.out.println(Arrays.asList(distances));
    return distances;
    */
    while (!pq.isEmpty()) {
            Edge<T, G> curr = pq.extractMin(); // Extract node with minimum distance
            G currDist = distances.get(curr.getDest()); // Current distance to curr node

            // Update distances to adjacent nodes
            for (Edge<T, G> edge : graph.getAdjacentNodes(curr.getDest())) {
                T adjNode = edge.getDest();
                G newDist = Edge.add(currDist, edge.getLabel()); // New distance to adjNode

                if (pq.contains(new Edge<>(adjNode, distances.get(adjNode))) &&
                        Edge.compare(newDist, distances.get(adjNode)) < 0) {
                    // Update distance to adjNode and decrease key in priority queue
                    distances.put(adjNode, newDist);
                    pq.decreaseKey(new Edge<>(adjNode, distances.get(adjNode)), new Edge<>(adjNode, newDist));
                }
            }
        }

        return distances;
  }
}




