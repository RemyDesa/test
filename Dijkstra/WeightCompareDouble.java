package Dijkstra;

import Graph.Edge;
import java.util.Comparator;

public class WeightCompareDouble implements Comparator<Edge<String,Double>> {
  @Override
  public int compare(Edge<String,Double> a, Edge<String,Double> b) {
    return Double.compare(a.getLabel(),b.getLabel());
  }
}
