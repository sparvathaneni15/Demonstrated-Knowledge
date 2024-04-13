package cse12pa1student;

import java.util.ArrayList;

public class Basket11 implements Basket {

	public Basket11() {
		this.items = new ArrayList<Item>();
		this.counts = new ArrayList<Integer>();
	}

	ArrayList<Item> items;
	ArrayList<Integer> counts;

	@Override
	/*
	 * Loops through this.counts and adds the value to the tracker variable.
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
	 * Loops through this.items and checks if each element is actually equal to the argument Item i.
	 * If so, returns the corresponding value at the index in this.counts
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
	 * Loops through this.items and adds each element's priceInCents to the tracker variable.
	 * PICK ON THIS ONE
	 */
	public int totalCost() {
		int price = 0;
		for (Item i : this.items) {
			price += i.priceInCents;
		}
		return price;
	}

	@Override
	/*
	 * Checks if Item i is in this.items
	 * If not, adds the Item to this.items and adds 1 to this.counts
	 * If so, adds 1 to the corresponding index in this.counts
	 */
	public void addToBasket(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			this.items.add(i);
			this.counts.add(1);
		} else {
			this.counts.set(index, this.counts.get(index) + 1);
		}
	}

	@Override
	/*
	 * Checks if Item i is in this.items
	 * If not, returns false.
	 * If so, subtracts 1 from the corresponding index in this.counts
	 * returns true.
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
	 * Checks if Item i in this.items
	 * If not, returns false.
	 * If so, sets the corresponding index in this.counts to 0
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
	 * Clears both lists
	 */
	public void empty() {
		this.items.clear();
		this.counts.clear();
	}

}
