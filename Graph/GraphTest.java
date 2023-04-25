package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
public class GraphTest {
  @Test
  public void EmptyGraphZeroEl() {
    Graph<String,Edge<String,Double>> graph = new Graph<String,Edge<String, Double>>(true);
    assertEquals(graph.getNumEdges(),0);
    assertEquals(graph.getNumNodes(),0);
  }
  @Test
  public void EmptyGraphOneEl() throws Exception {
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","end",6.0);
    assertNotEquals(graph.getNumEdges(),0);
    assertNotEquals(graph.getNumNodes(),0);
  }
  @Test
  public void GraphCorrectAdd() throws Exception{
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","end",(double) 6);
    assertTrue(graph.containsNode("start"));
    assertTrue(graph.containsNode("end"));
    assertTrue(graph.containsEdge("start","end"));
    assertEquals((double)graph.getLabel("start","end"), 6.0, 0.001);
  }
  @Test
  public void GraphCorrectAdjVertex() throws Exception{
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","way1",6.0);
    graph.addEdge("start","way2",8.0);
    graph.addEdge("start","way3",10.0);
    List<Edge<String,Double>> check = new ArrayList<>();
    check.add(new Edge<>("start","way1",6.0));
    check.add(new Edge<>("start","way2",8.0));
    check.add(new Edge<>("start","way3",10.0));
    assertEquals(graph.getAdjacentNodes("start").get(0).getDest(),check.get(0).getDest());
    assertEquals(graph.getAdjacentNodes("start").get(1).getDest(),check.get(1).getDest());
    assertEquals(graph.getAdjacentNodes("start").get(2).getDest(),check.get(2).getDest());
    assertEquals(graph.getAdjacentNodes("start").get(0).getLabel(),check.get(0).getLabel());
    assertEquals(graph.getAdjacentNodes("start").get(1).getLabel(),check.get(1).getLabel());
    assertEquals(graph.getAdjacentNodes("start").get(2).getLabel(),check.get(2).getLabel());
    //assertEquals(graph.getAdjacentNodes("start"),check);
  }
  @Test
  public void CorrectEdgeOperation() throws Exception {
    Edge<String,Double> edge1 = new Edge<>("start","way1",10.0);
    Edge<String,Double> edge2 = new Edge<>("start","way2",15.5);
    Edge<String,Double> support= edge1.add(edge2);
    double result= (double)support.getLabel();
    assertEquals(result,25.5, 0.001);
  }
 }
