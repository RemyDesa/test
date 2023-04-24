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
    assertEquals(graph.get_n_edge(),0);
    assertEquals(graph.get_n_vertex(),0);
  }
  @Test
  public void EmptyGraphOneEl() throws Exception {
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","end",6.0);
    assertNotEquals(graph.get_n_edge(),0);
    assertNotEquals(graph.get_n_vertex(),0);
  }
  @Test
  public void GraphCorrectAdd() throws Exception{
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","end",(double) 6);
    assertTrue(graph.hasVertex("start"));
    assertTrue(graph.hasVertex("end"));
    assertTrue(graph.hasEdge("start","end"));
    assertEquals((double)graph.getEdgeLabel("start","end"), 6.0, 0.001);
  }
  @Test
  public void GraphCorrectAdjVertex() throws Exception{
    Graph<String,Double> graph = new Graph<String,Double>(true);
    graph.addEdge("start","way1",6.0);
    graph.addEdge("start","way2",8.0);
    graph.addEdge("start","way3",10.0);
    List<Edge<String,Double>> check = new ArrayList<>();
    check.add(new Edge<>("way1",6.0));
    check.add(new Edge<>("way2",8.0));
    check.add(new Edge<>("way3",10.0));
    assertEquals(graph.getAdjacentVertex("start"),check);
  }
  @Test
  public void CorrectEdgeOperation() throws Exception {
    Edge<String,Double> edge1 = new Edge<>("way1",10.0);
    Edge<String,Double> edge2 = new Edge<>("way2",15.5);
    assertEquals((double)Edge.add(edge1.getWeight(),edge2.getWeight()),25.5, 0.001);
  }
 }
