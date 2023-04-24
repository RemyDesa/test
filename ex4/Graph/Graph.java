package Graph;

import java.util.*;

public class Graph<T,G> {
  private final Map<T,List<Edge<T,G>>> map;   // Hashmap key = from vertex, value = edge attached at from vertex
  private final boolean digraph;
  public Graph(boolean digraph) { 
    map = new HashMap<>();
    this.digraph = digraph;
  }
  public boolean isDigraph() { //check if it's direct
    return this.digraph; 
  } 
  public void addVertex(T newValue) throws GraphException{    //check if the vertex is already present in the hashmap, otherwise add it
    if (newValue == null)
      throw new GraphException("AddVertex: Null vertex cannot be added in the Graph");

    if (hasVertex(newValue))
      throw new GraphException("AddVertex: Vertex already exists in this Graph");

    map.put(newValue, new LinkedList<>()); 
  }
  public void addEdge(T src, T dest, G w) throws GraphException { // This function adds the edge between source to destination node
    if (src == null || dest == null || w == null)
      throw new GraphException("addEdge: you can't insert Edges with null sources,destinations or weight");

    if (!map.containsKey(src))
      addVertex(src);

    if (!map.containsKey(dest))
      addVertex(dest);

    map.get(src).add(new Edge<>(dest, w));  //O(1)

    if (!isDigraph()) { 
    	//System.out.println("SONO NELLA CREAZIONE DELL EDGE AL CONTARIO");
      map.get(dest).add(new Edge<>(src, w)); 
    } 
  }
  public boolean hasVertex(T s) throws GraphException {   //check if the key is present in the hashmap
    if (s == null) 
      throw new GraphException("hasVertex: vertex cannot be NULL");
    return map.containsKey(s); //O(1)
  }
  public boolean hasEdge(T src, T dest) throws GraphException {    //check if the Edge is present in the graph O(m) for dense graph: O(1)
    if (src == null || dest == null) 
      throw new GraphException("hasEdge: source or destination cannot be NULL");
    List<Edge<T,G>> tmp = getAdjacentVertex(src);
    for(Edge<T,G> i : tmp)
      if(i.getEnd().equals(dest))
        return true;
    if(!isDigraph()) {
      List<Edge<T,G>> tmp2 = getAdjacentVertex(dest);
      for(Edge<T,G> i : tmp2)
        if(i.getEnd().equals(src))
          return true;
    }
    return false;
  }
  public void removeVertex(T val) throws GraphException {  //used to remove Node O(m) for dense graph: O(1)
    if (val == null) 
      throw new GraphException("removeVertex: a null vertex cannot be removed");
    if (map.containsKey(val)) {
      for (T k : map.keySet()) { //O(m)
        if (hasEdge(k, val)) {
          removeEdge(val, k);
        }
      }
    map.remove(val);
    } else 
      throw new GraphException("removeVertex: vertex not found. Can't remove this vertex: " + val);
  }
  public void removeEdge(T src, T dest) throws GraphException {   //used to remove edge from source to destination
    if (src == null || dest == null) 
      throw new GraphException("removeEdge: a null edge cannot be removed");
    if (!map.containsKey(src) || !map.containsKey(dest)) 
      throw new GraphException("removeEdge: cannot remove an edge with a undefined key");
    if (hasEdge(src, dest))
      map.get(src).remove(new Edge<>(dest));  
    if (isDigraph())
      map.get(dest).remove(new Edge<>(src));  
  }
  public int get_n_vertex() { 
    return map.keySet().size(); 
  }   
  public int get_n_edge() {   //O(m) for dense graph: O(1)
    int count = 0;
    for (T v : map.keySet()) {
      count += map.get(v).size();
    }
    if (!digraph) { 
      count = count / 2; 
    }
    return count;
  }
  public ArrayList<T> getVertexes() { 
    return  new ArrayList<>(map.keySet());
  }    
  public List<Edge<T,G>> getEdge(){  
    List<Edge<T, G>> list = new ArrayList<>();
    for (T k : map.keySet())
      list.addAll(map.get(k));
    return list;
  }
  public List<Edge<T,G>> getAdjacentVertex(T vertex) throws GraphException {  
    if (vertex == null) 
      throw new GraphException("getAdjacentVertex: vertex null. Adjacent list cannot be printed");
    if (!hasVertex(vertex)) 
      throw new GraphException("getAdjacentVertex: vertex does not exist. Adjacent list cannot be printed");
    return map.get(vertex);
  }
  //find the weigth of the edge between the vertexes
  public G getEdgeLabel(T v1, T v2) throws GraphException {   //O(m) for dense graph: O(1) for indirect non dense graph: O(m^2)
    System.out.println("ELEM1 getEdge: "+v1.toString() +" ELEM2 getEdge: "+ v2.toString());
    if (v1 == null || v2 == null) 
      throw new GraphException("getEdgeLabel: Parameters cannot be null");
    if (hasEdge(v1,v2)) {
      List<Edge<T,G>> tmp = map.get(v1);
      for(Edge<T,G> i : tmp) //O(m) O(1) for dense graph
        if(v2.equals(i.getEnd()))
          return i.getWeight();
    }else if(hasEdge(v2,v1) && !isDigraph()) {
      List<Edge<T,G>> tmp = map.get(v2);
      for(Edge<T,G> i : tmp) //O(m) O(1) for dense graph
        if(v1.equals(i.getEnd()))
          return i.getWeight();
    }
    throw new GraphException("getEdgeLabel: Edge (" + v1 + ", " + v2 + ") doesn't exist");
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (T v : map.keySet()) {
      builder.append("Vertex: " + v + "\n\tAdj_list:");
      for (int i = 0; i < map.get(v).size(); i++) {
        builder.append("\n\t\t\t" + map.get(v).get(i));
      }
      builder.append("\n");
    }
    return (builder.toString());
  }
}
