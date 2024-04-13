package cse12pa1student;

public class Basket0 implements Basket {

	@Override
	public int count() {
		return 0;
	}

	@Override

	/*
	 * Will always return 0
	 */
	public int countItem(Item i) {
		return 0;
	}

	@Override
	/*
	 * Will always return 0
	 */
	public int totalCost() {
		return 0;
	}

	@Override
	/*
	 * Will not add Item t to the basket
	 */
	public void addToBasket(Item t) {
	}

	@Override
	/*
	 * Will not remove Item i from basket
	 */
	public boolean removeFromBasket(Item i) {
		return false;
	}

	@Override
	/*
	 * Will not remove all Item i from basket
	 */
	public boolean removeAllFromBasket(Item i) {
		return false;
	}
	
	@Override
	/*
	 * Will not empty basket
	 */
	public void empty() {
		return;
	}

}
