package MinHeap;
import java.util.*;
public class MinHeap <T> {
  private final ArrayList<T> heap_array;  //generic array based on min heap rules, the actual size of this array is controlled by .size() function
  private final Comparator<T> comparator;   //comparator function for compare different types of objects
  private final Map<T,Integer> map;   //This HashMap take the object as a key and the position of the object in the array as a value
  //Empty MinHeap Constructor user doesn't need to write the right size of the object at time of compilation
  public MinHeap(Comparator<T> comparator) {
    this.heap_array = new ArrayList<>();
    this.map = new HashMap<>();
    this.comparator = comparator;
  }
  public boolean isEmpty() {
    return heap_array.size() == 0;
  }
  //return the parent position
  private int parent(int pos) {
  		return (pos-1)/2;
      /*int posP=pos/2;
      return posP != 0 ? posP-1 : 0;
      /*return pos <= this.heap_array.size() ? ( (int)Math.floor(pos / 2) ) : null;*/
  }
  //return the right child position
  private int right(int pos) {
    //return pos * 2 ;
    return (pos*2)+2;
  }
  //return the left child position
  private int left(int pos) {
    return (pos*2)+1;
    //return pos * 2 + 1;
  }
  //take in input the object and return the position in the array
  public int getPosition(T elem) {
    return map.get(elem);
  }
  //return all the key set in the hashmap more easy with HashMap
  public Set<T> getKey() {
    return map.keySet();
  }
  private void swap(int pos,int pos2) {
    map.replace(heap_array.get(pos),pos2);
    map.replace(heap_array.get(pos2),pos);
    Collections.swap(heap_array,pos,pos2);
  }
  //insert an element by the rules of min heap
  public void insert(T item) {
    heap_array.add(item);
    int index=heap_array.size()-1;
    map.put(item,index);
    //System.out.println("ELEM: "+(int)heap_array.get(index/*-1*/)+ " PARENT: " +(int)heap_array.get(parent(index)/*-1*/)+ " PARENT POSITION: "+ getPosition(heap_array.get(parent(index)/*-1*/)) );
    while(/*parent(size) != size */index > 0 && comparator.compare(heap_array.get(index/*-1*/),heap_array.get(parent(index/*-1*/))) < 0) {
      swap(index,parent(index/*-1*/));
      index = parent(index/*-1*/);
    }
  }
  //remove the first element in the heap and adjust the heap by his rules
  public T extractMin() throws MinHeapException {
    if(heap_array.size() == 0)
      throw new MinHeapException("extractMin: Min heap EMPTY!");
    else if(heap_array.size() == 1)
      return heap_array.remove(0);
    Collections.swap(heap_array,heap_array.size()-1,0);
    T item = heap_array.remove(heap_array.size()-1);
    map.replace(heap_array.get(0),0);
    minHeapify(0);
    return item;
  }
  //decrease the value based on comparator function of a determinate element in the min heap
  public void decreaseKey(T item,T dcr) throws MinHeapException {
    System.out.println("Sono in decrease "+dcr.toString());
    if(comparator.compare(item,dcr)<0)
     throw new MinHeapException("decreaseKey: Previous item was smaller than this!");
    if(!map.containsKey(item))
      throw new MinHeapException("decreaseKey: Min Heap not contain current value!");
    int size = getPosition(item);
    System.out.println(size);
    heap_array.set(size,dcr);
    map.replace(dcr,size);
    while(size > 0 && comparator.compare(heap_array.get(parent(size)),heap_array.get(size)) > 0) {
      swap(size,parent(size));
      size = parent(size);
    }
  }

  public int getSize(){
    return heap_array.size();
  }

  public int getSingleElem(int pos){
    return (int)heap_array.get(pos);
  }
  /*
 if(index < 0 || index >= this.heap.size())
            throw new MinHeapException("decreaseKey: index "+index+" out of bounds");

        if(this.comparator.compare(key, this.heap.get(index)) > 0)
            throw new MinHeapException("decreaseKey: new key is greater than current key");

        this.heap.set(index, key);

        while(index > 0 && this.comparator.compare(this.heap.get(index), this.heap.get(this.parent(index))) <= 0)
        {
            swap(index, this.parent(index));
            index=this.parent(index);
        }
  */
  //adjust every element by the rules of min heap
  private void minHeapify(int i) {
    int left = left(i);
    int right = right(i);
    int smallest;
    if (left <= heap_array.size() - 1 && comparator.compare(heap_array.get(left),heap_array.get(i)) < 0)
      smallest = left;
    else  
      smallest = i;
    if (right <= heap_array.size() - 1 && comparator.compare(heap_array.get(right),heap_array.get(smallest)) < 0)
      smallest = right;
    if (smallest != i) {
      swap(i, smallest);
      minHeapify(smallest);
    }
  }
  public boolean contains(T k) {
      return map.get(k) != null;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    int index=0;
    for(T i : heap_array){
      System.out.println(index);
      s.append(i).append(",");
      index++;
    }
    return s.toString();
  }


}
