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
    ArrayList<T> keys = graph.getNodes();    //All the nodes names from the graph
    Edge<T, G> u;
    for (T i : keys) {  //O(n)
      if (i.equals(start)) {
        distances.put(start, startValue);
        pq.insert(new Edge<>(start, startValue));
      } else {
        distances.put(i, inf);
        pq.insert(new Edge<>(i, inf));
      }
    }
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
          //System.out.println("Sono dentro if con "/*+distances.get(i.getEnd())+" e "+Edge.add(u.getWeight(),graph.getEdgeLabel(u.getEnd(),i.getEnd())*/);
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
  }
}




