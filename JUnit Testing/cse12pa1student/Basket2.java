package cse12pa1student;

public class Basket2 implements Basket {

	private Item[] items;
	
	public Basket2() {
		this.items = new Item[1000];
	}
	
	@Override
	/*
	 * Loops through all index values of this.items
	 * If the index value is not null, the tracker value is added by 1.
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
	 * If Item item is null returns 0.
	 * Else, loops through this.items to check if the argument is equal to the value found at that index.
	 * Then adds one to the tracker variable
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
	 * Loops through array to check if it is not equal to null.
	 * If so, adds the priceInCents to the tracker variable.
	 */
	public int totalCost() {
		int total = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] != null) {
			  total += this.items[i].priceInCents;
			}
		}
		return total;
	}

	@Override
	/*
	 * Loops through this.items to add Item t at index of first null element.
	 * NO NULL HANDLING
	 */
	public void addToBasket(Item t) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == null)  {
				this.items[i] = t;
				return;
			}
		}
	}

	@Override
	/*
	 * Loops through this.items to check if each index is equal to the argument Item item.
	 * If it is true, then set index equal to null and return true.
	 * Else, returns false.
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
	 * Loops through this.items to check if each index is equal to the argument Item item.
	 * If true, then that index is set to null and found is set to true
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
	 * Loops through this.items and sets all indices to null.
	 */
	public void empty() {
		for(int i = 0; i < this.items.length; i += 1) {
			this.items[i] = null;
		}
	}
}
