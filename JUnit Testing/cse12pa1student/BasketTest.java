package cse12pa1student;

import java.util.Collection;
import java.beans.Transient;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS = Arrays.asList(new Object[][] { { 0 }, { 1 }, { 2 }, { 3 }, { 4 },
			{ 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 }, { 12 } });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}

	private Basket makeBasket() {
		switch (this.bagType) {
		case 0:
			return new Basket0();
		case 1:
			return new Basket1();
		case 2:
			return new Basket2();
		case 3:
			return new Basket3();
		case 4:
			return new Basket4();
		case 5:
			return new Basket5();
		case 6:
			return new Basket6();
		case 7:
			return new Basket7();
		case 8:
			return new Basket8();
		case 9:
			return new Basket9();
		case 10:
			return new Basket10();
		case 11:
			return new Basket11();
		case 12:
			return new Basket12();
		}
		return null;
	}

	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		basketToTest.addToBasket(new Item("Shampoo", 5));
		assertEquals(1, basketToTest.count());
	}
	
	@Test
	public void countItemDifferentReference(){
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(new Item("Conditioner", 8));
		assertEquals(3, basketToTest.countItem(new Item("Shampoo", 5)));
	}
	
	@Test
	public void countItemSameReference() {
		Basket basketToTest = makeBasket();
		

		Item i = new Item("Shampoo", 5);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(new Item("Conditioner", 8));
		assertEquals(2, basketToTest.countItem(i));
	}

	@Test
	public void countAfterRemoveAllSameReference(){
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 8);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(2, basketToTest.count());
	}
	
	@Test
	public void countAfterRemoveAllDifferentReference() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 8);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(new Item("Shampoo", 5));

		assertEquals(2, basketToTest.count());		
	}
	
	@Test
	public void countItemAfterRemoveAllSameReference(){
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 8);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.countItem(new Item("Shampoo", 5)));
	}
	
	@Test
	public void countItemAfterRemoveAllDifferentReference() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 8);

		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		assertEquals(true, basketToTest.removeAllFromBasket(new Item("Shampoo", 5)));

		assertEquals(0, basketToTest.countItem(new Item("Shampoo", 5)));		
	}

	@Test
	public void addNullItem(){
		Basket basketToTest = makeBasket();

		basketToTest.addToBasket(new Item("Shampoo", 5));
		basketToTest.addToBasket(null);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void removeNullItem(){
		Basket basketToTest = makeBasket();

		basketToTest.addToBasket(new Item("Shampoo", 5));
		basketToTest.addToBasket(new Item("Conditioner", 8));
		
		basketToTest.removeFromBasket(null);

		assertEquals(2, basketToTest.count());
	}
	
	@Test
	public void removeNullItemEmptyList() {
		Basket basketToTest = makeBasket();
				
		assertEquals(false, basketToTest.removeFromBasket(null));
	}
	
	@Test
	public void totalCost() {
		Basket basketToTest = makeBasket();
		
		basketToTest.addToBasket(new Item("Shampoo", 5));
		basketToTest.addToBasket(new Item("Shampoo", 5));
		basketToTest.addToBasket(new Item("Conditioner", 8));
		basketToTest.addToBasket(new Item("Table", 40));
		
		assertEquals(58, basketToTest.totalCost());
	}
	
	@Test
	public void incorrectRemoveAll() {
		Basket basketToTest = makeBasket();
		
		basketToTest.addToBasket(new Item("Shampoo", 5));
		
		basketToTest.removeAllFromBasket(new Item("Shampoo", 5));
		
		assertEquals(-1, basketToTest.countItem(new Item("Shampoo", 5)));
	}
	
	@Test
	public void countAfterRemoveAndAdd() {
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		Item j = new Item("Conditioner", 8);
		
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.addToBasket(i);
		
		assertEquals(1, basketToTest.countItem(new Item("Shampoo", 5)));
	}
	
	
}
