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
    //find on stackOverflow, used to don't show the warnings
    @SuppressWarnings("unchecked")
    public Edge add(Edge other) throws Exception {
            if(other == null) {
                throw new Exception("Edge add: Illegal Arguments");
            }
            if(label instanceof Integer) {
                int sum = label.intValue() + other.label.intValue();
                return new Edge(source, dest, sum);
            } else if(label instanceof Double) {
                double sum = label.doubleValue() + other.label.doubleValue();
                return new Edge(source, dest, sum);
            } else if(label instanceof Float) {
                float sum = label.floatValue() + other.label.floatValue();
                return new Edge(source, dest, sum);
            } else {
                throw new Exception("Edge add: Illegal Arguments");
            }
    }

    public int compareTo(Edge other) {
        return label.compareTo(other.label);
    }
}