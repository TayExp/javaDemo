package learnjava.jdbc.datasourcewarp;

public class CarWarp implements Car {
	private Car car;
	public CarWarp(Car car){ //可以是Car1 Car2
		this.car = car;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		car.stop();
		
	}
	
}
