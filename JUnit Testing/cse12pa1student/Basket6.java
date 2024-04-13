package cse12pa1student;

import java.util.ArrayList;

public class Basket6 implements Basket {

	public Basket6() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	/*
	 * Returns the size of this.items
	 */
	public int count() {
		return this.items.size();
	}

	@Override
	/*
	 * Loops through this.items to check if each element is actually equal to the argument i.
	 * If so, iterates the tracker variable by 1.
	 */
	public int countItem(Item i) {
		int countItem = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			if (this.items.get(j).equals(i)) {
				countItem += 1;
			}
		}
		return countItem;
	}

	@Override
	/*
	 * Loops through this.items and adds each object's priceInCents to the tracker variable.
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
	 * If Item i is null, returns false.
	 * Else, returns this.items.remove(i)
	 */
	public boolean removeFromBasket(Item i) {
		if(i == null) { return false; }
		return this.items.remove(i);
	}

	@Override
	/*
	 * If Item i is null, returns false.
	 * Checks if this.items  contains the argument i.
	 * If so, updates tracker variable to true and removes Item i.
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
