import java.util.ArrayList;
import java.util.List;

public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
        this.size = contents.length;
        if (!this.isEmpty()){
            this.front = new Node(contents[0], null);
            Node current = this.front;
            for (int i = 1; i < this.size; i++){
                current.next = new Node(contents[i], null);
                current = current.next;
            }
        }
    }

    // Fill in all methods
    /*
    Return the contents of the list as a new array, 
    with shallow copy of the elements in the same 
    order they appear in the list
    */
    public E[] toArray(){
        E[] result = (E[]) (new Object[this.size]);
        if (this.isEmpty()){
            return result;
        }
        Node current = this.front;
        for (int i = 0; i < this.size; i++){
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
    /*
    Change the contents of the list according to the provided MyTransformer.mt
     */
    public void transformAll(MyTransformer mt){
        Node current = this.front;
        while (current != null){
            current.value = (E) mt.transformElement(current.value);
            current = current.next;
        }
    }
    /*
    Changes the list to contain only elements 
    selected by the MyChooser.mc
     */
    public void chooseAll(MyChooser mc){
        if (!this.isEmpty()){
            while (!mc.chooseElement(this.front.value)){ // checks to make sure that the first node is a chosen Node
                this.front = this.front.next;
                this.size--;
                if (this.front == null){
                    break;
                }
            }
            Node previous = this.front;
            Node current = null;
            if (this.front != null){
                current = this.front.next;
            }
            while (current != null){
                if (!mc.chooseElement(current.value)){
                    previous.next = current.next;
                    current = previous.next;
                    this.size--;
                }
                else{
                    previous = current;
                    current = current.next;
                }
    
            }
        }
    }

    /*
    Returns true if the list has no 
    elements, false otherwise.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
}