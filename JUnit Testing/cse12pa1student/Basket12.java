package cse12pa1student;

import java.util.ArrayList;

public class Basket12 implements Basket {

	public Basket12() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	/*
	 * Returns this.items.size()
	 */
	public int count() {
		return this.items.size();
	}

	@Override
	/*
	 * Loops through each element in this.items.
	 * Checks if each element is equal (same reference) to the argument passed.
	 * If so, adds 1 to the tracker variable.
	 * PICK ON THIS ONE
	 */
	public int countItem(Item i) {
		int countItem = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			if (this.items.get(j) == i) {
				countItem += 1;
			}
		}
		return countItem;
	}

	@Override
	/*
	 * Loops through this.items and adds each elements priceInCents to the tracker variable.
	 */
	public int totalCost() {
		int price = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			price += this.items.get(j).priceInCents;
		}
		return price;
	}

	@Override
	/*
	 * Adds the argument to this.items
	 * NO NULL HANDLING
	 */
	public void addToBasket(Item i) {
		this.items.add(i);
	}

	@Override
	/*
	 * returns this.items.remove(i)
	 * NO NULL HANDLING
	 */
	public boolean removeFromBasket(Item i) {
		return this.items.remove(i);
	}

	@Override
	/*
	 * Removes all of the elements
	 * Then, removes the argument from the empty list
	 * Always returns false.
	 * PICK ON THIS ONE
	 */
	public boolean removeAllFromBasket(Item i) {
		this.items.removeAll(this.items);
		return this.items.remove(i);
	}
	
	@Override
	/*
	 * Clears this.items
	 */
	public void empty() {
		this.items.clear();
	}

}
