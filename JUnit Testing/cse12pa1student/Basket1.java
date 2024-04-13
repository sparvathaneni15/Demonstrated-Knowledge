package cse12pa1student;

import java.util.ArrayList;

public class Basket1 implements Basket {

	public Basket1() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	/*
	 * returns the size of ArrayList<Item> items
	 */
	public int count() {
		return this.items.size();
	}

	@Override
	/*
	 * Loops through ArrayList<Item> items and checks if each index value is equal to argument.
	 * If true, adds one to the tracker variable
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
	 * Loops through ArrayList<Items> items and adds the priceInCents of each index value to the tracker variable.
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
	 * Adds the Item i to the ArrayList
	 * NO NULL HANDLING
	 */
	public void addToBasket(Item i) {
		this.items.add(i);
	}

	@Override
	/*
	 * Removes the Item i from the ArrayList<Item> and returns true
	 * Returns false if Item i is not in the ArrayList<Item>
	 * NO NULL HANDLING
	 */
	public boolean removeFromBasket(Item i) {
		return this.items.remove(i);
	}

	@Override
	/*
	 * Checks if ArrayList<Items> items has Item i and removes it while items contains Item i
	 * NO NULL HANDLING
	 */
	public boolean removeAllFromBasket(Item i) {
		boolean removed = false;
		while (this.items.contains(i)) {
			removed = true;
			this.items.remove(i);
		}
		return removed;
	}
	
	@Override
	/*
	 * Clears ArrayList<Items> items of all elements
	 */
	public void empty() {
		this.items.clear();
	}

}
