package Dijkstra;
import Graph.Edge;
import java.util.Comparator;

public class NameCompare implements Comparator<Edge<String,Float>> {
  @Override
  public int compare(Edge<String,Float> a, Edge<String,Float> b) {
    return a.getEnd().compareTo(b.getEnd());
  }
}

