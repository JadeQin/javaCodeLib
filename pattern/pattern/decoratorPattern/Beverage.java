package pattern.decoratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 装饰者模式
 * 
 * @author AAA
 * 
 */
public abstract class Beverage {

	private List<Beverage> beverageList = new ArrayList<Beverage>();

	public Beverage() {
	}

	public Beverage(List<Beverage> beverageList) {
		this.beverageList = beverageList;
	}

	public List<Beverage> getBeverageList() {
		return beverageList;
	}

	public void setBeverageList(List<Beverage> beverageList) {
		this.beverageList = beverageList;
	}

	public void add(Beverage beverage) {
		beverageList.add(beverage);
	}

	public void remove(Beverage beverage) {
		beverageList.remove(beverage);
	}

	public double cost(String s) {
		double cost = 0;
		for (Beverage b : beverageList) {
			cost += b.cost(s);
		}
		return cost;
	}

}
