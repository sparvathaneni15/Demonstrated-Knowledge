import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	Stack stack = new Stack<Square>();

	public void add(Square c){
		this.stack.push(c);
	}

	public Square remove(){
		return (Square) this.stack.pop();
	}

	public boolean isEmpty(){
		return this.stack.empty();
	}
}

class QueueWorklist implements SearchWorklist {
	Queue queue = new LinkedList<Square>();

	public void add(Square c){
		this.queue.offer(c);
	}

	public Square remove(){
		return (Square) this.queue.remove();
	}

	public boolean isEmpty(){
		return (this.queue.peek() == null);
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
