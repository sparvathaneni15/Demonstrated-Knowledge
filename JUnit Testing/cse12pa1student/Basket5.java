package cse12pa1student;

import java.util.ArrayList;

public class Basket5 implements Basket {

	public Basket5() {
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
	 * Returns index value. Does not work with argument that is not in data structure
	 */
	public int countItem(Item i) {
		int index = 0;
		for (Item check : this.items) {
			if (check.equals(i)) {
				return this.counts.get(index);
			}
			index += 1;
		}
		return index;
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
	 * If the Item i does not exist in the ArrayList, Item i will be added to this.items
	 * and 1 will be added to this.counts.
	 * If the Item i does exist in this.items, the value of the amount of that item will be iterated by 1.
	 * PICK ON THIS ONE
	 */
	public void addToBasket(Item i) {
		int index = this.items.indexOf(i); // not sure if this works for objects with different references in memory
		if (index == -1) {
			this.items.add(i);
			this.counts.add(1);
		} else {
			this.counts.set(index, this.counts.get(index) + 1);
		}
	}

	@Override
	/*
	 * If the Item i does not exist in the ArrayList, return false.
	 * If the Item i does exist in this.items, subtracts 1 from the index of that Item i.
	 * Does not change this.items
	 */
	public boolean removeFromBasket(Item i) {
		int index = this.items.indexOf(i); // not sure if this works for objects with different references in memory
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, this.counts.get(index) - 1);
			return true;
		}
	}

	@Override
	/*
	 * Gets index of the argument Item i.
	 * If it is not in this.items, return false.
	 * If it is, sets the index that corresponds to that Item as -1.
	 * Does not change this.items
	 * PICK ON THIS ONE
	 */
	public boolean removeAllFromBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, -1);
			return true;
		}
	}
	
	@Override
	/*
	 * Clears both of the field ArrayLists
	 */
	public void empty() {
		this.items.clear();
		this.counts.clear();
	}

}
