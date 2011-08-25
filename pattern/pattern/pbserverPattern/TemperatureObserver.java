package pattern.pbserverPattern;

public class TemperatureObserver implements Observer<Weather> {

	public void update(Weather weather) {
		System.out.println(weather.getHumidity());
		System.out.println(weather.getPressure());
		System.out.println(weather.getTemperature());
	}

}
