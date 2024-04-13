public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here
    /*
    Returns the contents of the list as a new array,
    with shallow copy of the elements in the same 
    order they appear in the list. 
    */
    public E[] toArray(){
        E[] result = (E[])(new Object[this.size]);
        for (int i = 0; i < this.size; i++){
            result[i] = elements[i];
        }
        return result;
    }


    /*
    Changes the contents of the list 
    according to the provided MyTransformer.mt 
    */
    public void transformAll(MyTransformer mt){
        for (int i = 0; i < this.size; i++){
            if (this.elements[i] != null){
            this.elements[i] = (E) mt.transformElement(this.elements[i]);
            }
        }
    }


    /*
    Changes the list to contain only 
    elements selected by the MyChooser.mc
     */
    public void chooseAll(MyChooser mc) {
        int counter = 0;
        for (int i = 0; i < this.size; i++){
            if (mc.chooseElement(this.elements[i])){
                counter++;
            }
        }
        E[] result = (E[]) (new Object[counter]);
        int index = 0;
        for (int i = 0; i < this.size; i++){
            if (mc.chooseElement(this.elements[i])){
                result[index] = this.elements[i];
                index++;
            }
        }
        this.elements = result;
        this.size = counter;
    }

    /*
    Returns true if the list has no elements,
    false otherwise.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
}