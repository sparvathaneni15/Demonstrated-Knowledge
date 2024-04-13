package cse12pa1student;

public class Basket4 implements Basket {

	private Item[] items;
	
	public Basket4() {
		this.items = new Item[10];
	}
	
	@Override
	/*
	 * Loops through the array and checks each element if it is a null element.
	 * If not, then the tracker variable is iterated by 1.
	 */
	public int count() {
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] != null)  { count += 1; }
		}
		return count;
	}

	@Override
	/*
	 * Loops through the array to find elements that have the same reference in memory to the argument passed.
	 * If so, iterate the tracker variable by 1.
	 * If the argument is null, return 0.
	 * PICK ON THIS ONE
	 */
	public int countItem(Item item) {
		if(item == null) { return 0; }
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  { count += 1; }
		}
		return count;
	}

	@Override
	/*
	 * Loops through the array and adds each elements priceInCents to the tracker variable.
	 */
	public int totalCost() {
		int total = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			total += this.items[i].priceInCents;
		}
		return total;
	}

	@Override
	/*
	 * Loops through the array to check if each element is null.
	 * If true, sets tracker variable to true and assigns index to argument.
	 */
	public void addToBasket(Item t) {
		boolean setSomething = false;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == null)  {
				setSomething = true;
				this.items[i] = t;
				return;
			}
		}
		if(!setSomething) {
			Item[] oldItems = this.items;
			this.items = new Item[this.items.length * 2];
			for(int i = 0; i < items.length; i += 1) {
				this.items[i] = oldItems[i];
			}
			this.items[oldItems.length] = t; //assigns it to index value next to the end of the original length; CREATES GAP OF NULLS
		}
	}

	@Override
	/*
	 * Loops through the array to find if the element is equal to the argument.
	 * If so, sets that index to null and returns true.
	 * Otherwise, returns false.
	 * PICK ON THIS ONE
	 */
	public boolean removeFromBasket(Item item) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * Loops through the array to find if the element is equal to the argument.
	 * If so, sets that index to null and updates the tracker variable to true.
	 * Then returns tracker variable.
	 * PICK ON THIS ONE
	 */
	public boolean removeAllFromBasket(Item item) {
		boolean found = false;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				found = true;
			}
		}
		return found;
	}
	@Override
	/*
	 * Loops through the array and sets all indices equal to null.
	 */
	public void empty() {
		for(int i = 0; i < this.items.length; i += 1) {
			this.items[i] = null;
		}
	}
}
