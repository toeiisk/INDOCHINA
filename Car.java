package maven.appfirst;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Car {
	public static void main(String[] args) {
		SpringApplication.run(Car.class, args);
	}

	@RequestMapping(value = "/get")
	public ResponseEntity<Car> get() {
		Car car = new Car();
		car.setColor("Blue");
		car.setType("Truck");
		car.setDisplacement(1500);
		car.hasSunroof(false);
		car.setSpeed(60);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	// {"test":"message"}

	private String color;
	private String type;
	private int displacement;
	private boolean sunroof;
	private int speed;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public boolean getSunroof() {
		return sunroof;
	}

	public void hasSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@RequestBody Car car) {
		color = car.getColor();
		type = car.getType();
		displacement = car.getDisplacement();
		sunroof = car.getSunroof();
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	// { "color": "red", "type": "sport", "displacement": 1500, "sunroof": true,
	// "speed": 100}

	@RequestMapping(value = "/updateMany", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> updateMany(@RequestBody List<Car> cars) {
		cars.stream().forEach(c -> c.setSpeed(c.getSpeed() + 10));
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	// [
	// {
	// "color": "Red",
	// "type": "Sport",
	// "displacement": "3000",
	// "sunroof": "true",
	// "speed": "210" c.setSpeed(c.getSpeed() + 10)
	// }
	// ]
}
