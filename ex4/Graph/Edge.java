package Graph;
import java.lang.*;
import java.util.*;

public class Edge<T,G> {
  T end;
  G weight;
  public Edge(T end) {
    this.end = end;
  }
  public Edge(T end, G weight) {
    this.end = end;
    this.weight = weight;
  }
  //getter and setter methods
  public G getWeight() { 
    return this.weight;
  }
  public T getEnd() { 
    return this.end;
  }
  public void setEnd(T end){ 
    this.end = end; 
  }
  public void setWeight(G weight){ 
    this.weight = weight; 
  }
  
  //find on stackOverflow, used to don't show the warnings
  @SuppressWarnings("unchecked")
  public static <G extends Number> G add(G x,G y) throws Exception {
  	System.out.println("Minimo valore: "+x.doubleValue() + " Valore getEdge" +y.doubleValue());
    if(x == null || y == null)  
        throw new Exception("Edge add: Illegal Arguments");;
    if(y instanceof Integer)
      return (G) Integer.valueOf(x.intValue() + y.intValue());
    if(y instanceof Double)
      return (G) Double.valueOf(x.doubleValue() + y.doubleValue());
    if(y instanceof Float)
      return (G) Float.valueOf(x.floatValue() + y.floatValue());
    throw new Exception("Edge add: Illegal Arguments");
  }
  /*
  public static <G extends Number> G add(G x,G y) throws Exception {
    if(x == null || y == null)  
        throw new Exception("Edge add: Illegal Arguments");;
    if(y.getClass() == Integer.class){
    	int a= 	(int)x;
    	int b= 	(int)y;
      return (G) a+b;
    }
    if(y.getClass() == Double.class){
      double a= 	(double)x;
    	double b= 	(double)y;
      return (G) a+b;
    }
    if(y.getClass() == Float.class){
      float a= 	(float)x;
    	float b= 	(float)y;
      return (G) a+b;
    }
    throw new Exception("Edge add: Illegal Arguments");
  }
	*/
  public static <G extends Number> int compare(G x,G y) throws Exception {
    if(x == null && y == null) 
      throw new Exception("Edge compare: Two number are null!");
    if(x == null) {
      return -1;
    }
    if(y instanceof Integer)
      if(x.intValue() - y.intValue() < 0)
        return -1;
      else if(x.intValue() - y.intValue() > 0)
        return 1;
      else
        return 0;
    if(y instanceof Double)
      if(x.doubleValue() - y.doubleValue() < 0)
          return -1;
      else if(x.doubleValue() - y.doubleValue() > 0)
          return 1;
      else
          return 0;
    if(y instanceof Float)
      if(x.floatValue() - y.floatValue() < 0)
          return -1;
      else if(x.floatValue() - y.floatValue() > 0)
          return 1;
      else
          return 0;

      throw new Exception("Edge compare: Bad input!");
  }
  public boolean compareEdge(T end) { 
    return (end.equals(this.end)); 
  }
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Edge<?, ?> edge = (Edge<?, ?>) o;
    return Objects.equals(end, edge.end);
  }
  @Override
  public int hashCode() {
    return Objects.hash(end,weight);
  }
  @Override
  public String toString() {
    return "\t end: " + end + "\t weight:" + weight;
  }

}
