package cse12pa1student;

import java.util.ArrayList;

public class Basket3 implements Basket {
	static ArrayList<Item> items;

	public Basket3() {
		this.items = new ArrayList<Item>();
	}
	
	@Override
	/*
	 * Returns the list of the ArrayList
	 */
	public int count() {
		return this.items.size();
	}

	@Override
	/*
	 * Loops through ArrayList of this.items and checks if each index is equal to the argument Item i.
	 * Adds the index value of the equal element to the tracker variable.
	 * PICK ON THIS ONE
	 */
	public int countItem(Item i) {
		int count = 0;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j)))
				count += j;
		}
		return count;
	}

	@Override
	/*
	 * Loops through the ArrayList and adds the priceInCents of the element at the first index to the tracker variable.
	 * PICK ON THIS ONE
	 */
	public int totalCost() {
		int price = 0;
		for (int i = 0; i < this.items.size(); i += 1) {
			price += this.items.get(1).priceInCents;
		}
		return price;
	}

	@Override
	/*
	 * Adds the argument to the ArrayList
	 */
	public void addToBasket(Item t) {
		this.items.add(t);
	}

	@Override
	/*
	 * Loops through the ArrayList to check if each element is equal to the argument.
	 * Returns true once the first element equal to the argument is found and removed.
	 * Else, return false.
	 */
	public boolean removeFromBasket(Item i) {
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * Loops through the ArrayList to check if each index is equal to the arugment passed.
	 * If so, removes the element and sets the return variable to true.
	 * Continues checking elements.
	 */
	public boolean removeAllFromBasket(Item i) {
		boolean found = false;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				found = true;
			}
		}
		return found;
	}

	@Override
	/*
	 * Sets this.items to a new empty ArrayList.
	 */
	public void empty() {
		this.items = new ArrayList<Item>();
	}
}
