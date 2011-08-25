package pattern.strategyPattern;

/**
 * 策略模式
 * @author AAA
 *
 */
public abstract class Duck {

	private IFly fly;
	private IQuack quack;

	public Duck() {
	}

	public Duck(IFly fly, IQuack quack) {
		this.fly = fly;
		this.quack = quack;
	}

	public IFly getFly() {
		return fly;
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public IQuack getQuack() {
		return quack;
	}

	public void setQuack(IQuack quack) {
		this.quack = quack;
	}

	public void fly() {
		fly.fly();
	}

	public void quack() {
		quack.quack();
	}
}
