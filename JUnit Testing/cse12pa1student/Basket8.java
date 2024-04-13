package cse12pa1student;

import java.util.ArrayList;

public class Basket8 implements Basket {
	ArrayList<Item> items;

	public Basket8() {
		this.items = new ArrayList<Item>();
	}

	@Override
	/*
	 * Returns the size of this.items
	 */
	public int count() {
		return this.items.size();
	}

	@Override
	/*
	 * Loops through this.items to check if each element is equal in reference memory to the argument passed.
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
	 * Loops through this.items and adds each element's priceInCents to the tracker variable.
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
	 * Adds the element to this.items
	 * NO NULL HANDLING
	 */
	public void addToBasket(Item i) {
		this.items.add(i);
	}

	@Override
	/*
	 * Removes the first instance of the argument passed
	 * NO HULL HANDLING
	 */
	public boolean removeFromBasket(Item i) {
		return this.items.remove(i);
	}

	@Override
	/*
	 * While there exists an element in this.items with the same reference, it will remove the element.
	 * Then returns if this.items contains the argument passed
	 * NO NULL HANDLING
	 */
	public boolean removeAllFromBasket(Item i) {
		while (this.items.contains(i)) {
			this.items.remove(i);
		}
		return this.items.contains(i);
	}
	
	@Override
	/*
	 * Clears the entire ArrayList
	 */
	public void empty() {
		this.items.clear();
	}

}
