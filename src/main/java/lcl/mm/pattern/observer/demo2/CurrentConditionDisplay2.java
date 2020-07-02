package lcl.mm.pattern.observer.demo2;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
public class CurrentConditionDisplay2 implements Observer, DisplayElement2 {

    private int temperature;
    private int humidity;
    private int pressure;
    private Observable observable;
    @Override
    public void display() {
        log.info("CurrentConditionDisplay2：{},{},{}",temperature,humidity,pressure);
    }

    public CurrentConditionDisplay2(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData = (WeatherData2) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }
}
