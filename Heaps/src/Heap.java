import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Samanyu Parvathaneni
 */

public class Heap<K,V> implements PriorityQueue<K,V>{

    public List<Entry<K,V>> entries;
    public Comparator<K> comparator;

    public Heap(Comparator<K> comparator){
        this.entries = new ArrayList<Entry<K,V>>();
        this.comparator = comparator;
    }

    /**
     * Insert a new entry with the given key and value to the end of the heap. 
     * Then, bubbleUp so that the heap properties are not violated
     * 
     * @param a An integer that is used to compare against b 
     * @param b An integer that is used to compare against a
     * @return 
     */
    @Override
    public void add(K k, V v){
        this.entries.add(new Entry<K,V>(k,v));
        this.bubbleUp(this.entries.size()-1);
    }


    /**
     * Remove and return the root element in the heap.
     * Set the last entry in the heap to the root. Use bubbleDown to fix the heap after the removal. 
     * If the size is zero, throw NoSuchElementException()
     * 
     * @return The entry at the first index of the heap
     */
    @Override
    public Entry<K,V> poll(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Entry<K,V> result = this.peek();
            this.swap(0, this.size()-1);
            this.entries.remove(this.size()-1);
            this.bubbleDown(0);
            return result;
        }
    }

    /**
     * Return the root element of the heap. If the size is zero, 
     * throw NoSuchElementException()
     * 
     * @return the entry found at the root of the heap
     */
    @Override
    public Entry<K,V> peek(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.toArray().get(0);
        }
    }

    /**
     * 
     * @return the list of entries in the Heap
     */
    @Override
    public List<Entry<K,V>> toArray(){
        return this.entries;
    }

    /**
     * 
     * @return the truth value of this.entries being empty
     */
    public boolean isEmpty(){
        return this.size() == 0;
    }

    // Helper Methods
    /**
     * 
     * @param index index of the node that is being passed
     * @return the index of the parent of the index of the node that was passed
     */
    public int parent(int index){
        if (index == 0){
            return 0;
        }
        return (index-1)/2;
    }

    /**
     * 
     * @param index index of the node that is being passed
     * @return the index of the left child of the index of the node that was passed
     */
    public int left(int index){
        return 2*index+1;
    }

    /**
     * 
     * @param index index of the node that is being passed
     * @return the index of the right child of the index of the node that was passed
     */
    public int right(int index){
        return 2*index+2;
    }

    /**
     * 
     * @param i1 index of one of the elements being swapped
     * @param i2 index of one of the elements being swapped
     */
    public void swap(int i1, int i2){
        Entry<K,V> entry1 = this.entries.get(i1);
        Entry<K,V> entry2 = this.entries.get(i2);
        this.entries.set(i1, entry2);
        this.entries.set(i2, entry1);
    }

    /**
     * A recursive method that moves the entry at the specified index to a smaller index (up the tree) 
     * while maintaining the heap structure. 
     * In the case where the element is equal to the parent, 
     * you should not swap.
     * 
     * @param index index of the node that is being passed
     */
    public void bubbleUp(int index){
        if (this.existsAndGreater(this.parent(index), index)){
            this.swap(this.parent(index), index);
            if (this.existsAndGreater(index, this.left(index))){
                this.swap(index, this.left(index));
            }
            else{
                this.bubbleUp(this.parent(index));
            }

        }
        else{
            return;
        }

    }

    /**
     * A recursive method that moves the entry at the specified index to a larger index (down the tree) 
     * while maintaining the heap structure. Swap with the child with higher priority. 
     * If both chilren are equal and swapping is needed, swap with the left child. 
     * In the case where the element is equal to the smaller child, you should not swap. 
     * However, if the child with high priority has greater priority than the parent, 
     * you still must swap.
     * 
     * @param index index of the node that is being passed
     */
    public void bubbleDown(int index){
        // there is a child node greater than the node at the index
        if (this.existsAndGreater(index, this.left(index)) || 
        this.existsAndGreater(index, this.right(index))){
            if (this.existsAndGreater(this.left(index), this.right(index))){ // right has higher priority
                this.swap(index, this.right(index)); // swap with right
                this.bubbleDown(this.right(index));
            }
            else{ // left has higher priority or is equal to right
                this.swap(index, this.left(index)); // swap with left
                this.bubbleDown(this.left(index));
            }
        }
        else{ // index is greater than both child nodes
            return;
        }
    }

    /**
     * 
     * @param index1
     * @param index2
     * @return true if there is a second node that is greater than the first node
     */
    public boolean existsAndGreater(int index1, int index2){
        if (index1 < this.toArray().size() && index2 < this.toArray().size()){
            return (this.comparator.compare(this.toArray().get(index1).getKey(), 
            this.toArray().get(index2).getKey()) < 0);
        }
        return false;
    }


    /**
     * 
     * @return the number of elements in this.entries
     */
    public int size(){
        return this.entries.size();
    }


    /**
     * 
     * @return string representation of the elements in Entries
     */
    public String toString(){
        String result = "";
        for (Entry<K,V> entry : this.entries){
            result += (entry.toString() + "\n");
        }
        return result;
    }
}
