package javaCore.ch4;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Item> items = new ArrayList<Item>();

	public void add(Item item) {
		items.add(item);
	}

	public void shipped() {
	}

	public void canceled() {
	}

	public void applied(Payment payment) {
	}

}
