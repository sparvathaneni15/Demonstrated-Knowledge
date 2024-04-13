
package cse12pa1student;

import java.util.ArrayList;

public class Basket10 implements Basket {

	public Basket10() {
		this.items = new ArrayList<Item>();
		this.counts = new ArrayList<Integer>();
	}

	ArrayList<Item> items;
	ArrayList<Integer> counts;

	@Override
	/*
	 * Loops through this.counts for each integer and iterates the tracker variable by the value of the integer.
	 */
	public int count() {
		int count = 0;
		for (Integer i : this.counts) {
			count += i;
		}
		return count;
	}

	@Override
	/*
	 * Loops through each Item in this.items
	 * If the element is actually equal to the argument Item i, then returns the index of this.counts
	 * corresponding to that item.
	 * Returns tracker variable
	 */
	public int countItem(Item i) {
		int index = 0;
		int count = 0;
		for (Item check : this.items) {
			if (check.equals(i)) {
				count += this.counts.get(index);
			}
			index += 1;
		}
		return count;
	}

	@Override
	/*
	 * Loops through each element in this.items
	 * Adds the Item's priceInCents multiplied by its frequency to the tracker variable
	 * Returns the tracker variable.
	 */
	public int totalCost() {
		int price = 0;
		int index = 0;
		for (Item check : this.items) {
			price += check.priceInCents * this.counts.get(index);
			index += 1;
		}
		return price;
	}

	@Override
	/*
	 * Adds the argument Item i to this.items
	 * Adds 1 to this.counts
	 * Checks if the Item i has already been added to this.items (same reference).
	 * If so, iterates the corresponding index in this.counts by 1
	 * countItem() will not behave correctly after addedToBasket has been called twice for same argument
	 * Will work for different references in memory
	 * PICK ON THIS ONE
	 */
	public void addToBasket(Item i) {
		int index = this.items.indexOf(i);
		this.items.add(i);
		this.counts.add(1);
		if (index > 0) {
			this.counts.set(index, this.counts.get(index) + 1);
		}
	}

	@Override
	/*
	 * Checks if Item i is in this.items
	 * If not, returns false.
	 * If so, subtracts 1 from the corresponding index in this.counts
	 * and returns true.
	 * Does not do anything to this.items
	 */
	public boolean removeFromBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, this.counts.get(index) - 1);
			return true;
		}
	}

	@Override
	/*
	 * Checks if Item i is in this.items
	 * If not, returns false.
	 * If so, sets the corresponding index of this.counts to true
	 * and returns true.
	 */
	public boolean removeAllFromBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, 0);
			return true;
		}
	}

	@Override
	/*
	 * Clears both of the arrays
	 */
	public void empty() {
		this.items.clear();
		this.counts.clear();
	}

}
