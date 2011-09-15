package pattern.pbserverPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {

	private List<Observer<T>> observerList = new ArrayList<Observer<T>>();

	public void registerObserver(Observer<T> observer) {
		observerList.add(observer);
	}

	public void removeObserver(Observer<T> observer) {
		observerList.remove(observer);
	}

	public void notifyObserver(T t) {
		for (Observer<T> observer : observerList) {
			observer.update(t);
		}
	}
}
