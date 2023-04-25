package MinHeap;
import java.util.*;
public class TestPerHeap {
public static void main(String args[])throws Exception{

    MinHeap<Integer> minheap = new MinHeap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });
    minheap.insert(32);
    minheap.insert(14);
    minheap.insert(50);
    minheap.insert(18);
    minheap.insert(41);
    minheap.insert(90);
    minheap.insert(23);
    minheap.insert(87);
    minheap.insert(64);
    minheap.insert(53);
    minheap.insert(43);
    minheap.insert(15);
    System.out.println(minheap.toString());
    StringBuilder sb = new StringBuilder();
    int max=0;
    int sizeM=minheap.getSize();
    for(int i=0;i<minheap.getSize();i++){
        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<sizeM;j++){

            if(j>max){
                max=j;
            }
        }

    }

    for(int i=0;i<sizeM;i++){
        for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<sizeM;j++){

            for(int k=0;(k<max/((int)Math.pow(2, i)));k++){
                sb.append(" ");
            }
            sb.append(minheap.getSingleElem(j+(int)Math.pow(2,i)-1)+" ");

        }
        sb.append("\n");

    }

    minheap.decreaseKey(41,23);

    System.out.println(sb.toString());
    System.out.println(minheap.toString());

}
}