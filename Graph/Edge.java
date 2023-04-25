package Graph;

import java.lang.*;
import java.util.*;

public class Edge<N, E> {

    private N source;
    private N dest;
    private E label;

    public Edge(N source, N dest, E label) {
        this.source = source;
        this.dest = dest;
        this.label = label;
    }

    public N getSource() {
        return source;
    }

    public N getDest() {
        return dest;
    }

    public E getLabel() {
        return label;
    }
    /*
    public Edge<N, E> add(Edge<N, E> other) {
        E newLabel = null;
        if (this.label instanceof Integer && other.label instanceof Integer) {
            newLabel = (E) Integer.valueOf(this.label.intValue() + other.label.intValue());
        } else if (this.label instanceof Double && other.label instanceof Double) {
            newLabel = (E) Double.valueOf(this.label.doubleValue() + other.label.doubleValue());
        } else if (this.label instanceof Float && other.label instanceof Float) {
            newLabel = (E) Float.valueOf(this.label.floatValue() + other.label.floatValue());
        } else {
            throw new IllegalArgumentException("Edge add: Illegal Arguments");
        }
        return new Edge<>(this.source, other.dest, newLabel);
    }
*/
    //find on stackOverflow, used to don't show the warnings
  @SuppressWarnings("unchecked")
    public Edge<N, E> add(Edge<N, E> other) throws Exception {
        if (other == null) {
            throw new Exception("Edge add: Illegal Arguments");
        }
        
        if (label instanceof Number && other.label instanceof Number) {
            Number thisNumber = (Number) label;
            Number otherNumber = (Number) other.label;
            
            if (thisNumber instanceof Integer && otherNumber instanceof Integer) {
                int sum = thisNumber.intValue() + otherNumber.intValue();
                return new Edge<>(source, dest, (E) Integer.valueOf(sum));
            } else if (thisNumber instanceof Double && otherNumber instanceof Double) {
                double sum = thisNumber.doubleValue() + otherNumber.doubleValue();
                System.out.println("Somma= "+sum);
                return new Edge<>(source, dest, (E) Double.valueOf(sum));
            } else if (thisNumber instanceof Float && otherNumber instanceof Float) {
                float sum = thisNumber.floatValue() + otherNumber.floatValue();
                return new Edge<>(source, dest, (E) Float.valueOf(sum));
            } else {
                throw new Exception("Edge add: Illegal Arguments");
            }
        } else {
            throw new Exception("Edge add: Illegal Arguments");
        }
    }
    @SuppressWarnings("unchecked")
   public int compareTo(Edge<N, E> other) {
        if (label instanceof Comparable && other.label instanceof Comparable) {
            return ((Comparable<E>) label).compareTo(other.label);
        } else {
            throw new ClassCastException("Edge compareTo: Labels are not comparable");
        }
    }
    @Override
    public String toString() {
        return source.toString() + " --(" + label.toString() + ")--> " + dest.toString();
    }

}