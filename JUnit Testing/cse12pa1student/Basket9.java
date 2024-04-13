package cse12pa1student;

import java.util.ArrayList;

public class Basket9 implements Basket {

	public Basket9() {
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
	 * If the argument is null, returns 0.
	 * Loops through the array and checks if it is equal to the reference of the argument passed
	 * and iterates the tracker variable by 1.
	 * PICK ON THIS ONE
	 */
	public int countItem(Item i) {
		if(i == null) { return 0; }
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
	 * Loops through the array and adds each elements priceInCents to the tracker variable.
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
	 * Checks if argument Item i is null.
	 * If so, returns nothing.
	 * Else, adds the argument to this.items
	 */
	public void addToBasket(Item i) {
		if(i == null) { return; }
		this.items.add(i);
	}

	@Override
	/*
	 * Checks if argument Item i is null.
	 * If so, returns false.
	 * Else, removes Item i from this.items
	 */
	public boolean removeFromBasket(Item i) {
		if(i == null) { return false; }
		return this.items.remove(i);
	}

	@Override
	/*
	 * Checks if argument Item i is null.
	 * If so, returns false.
	 * While this.items has Item i in it, sets tracker variable to true
	 * and removes Item i from this.items
	 */
	public boolean removeAllFromBasket(Item i) {
		if(i == null) { return false; }
		boolean removed = false;
		while (this.items.contains(i)) {
			removed = true;
			this.items.remove(i);
		}
		return removed;
	}
	
	@Override
	/*
	 * Clears this.items
	 */
	public void empty() {
		this.items.clear();
	}

}
