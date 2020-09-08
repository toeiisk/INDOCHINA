package maven.app.firstapp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<ArrayList<Car>> get() {

		return new ResponseEntity<ArrayList<Car>>(Car.carlist, HttpStatus.OK);
	}
	
	static ArrayList<Car> carlist = new ArrayList<Car>();
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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Car> create(@RequestBody Car car) {
		Car.carlist.add(car);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{carId}", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@RequestBody Car car, @PathVariable("carId") int id) {
		carlist.set(id, car);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{carId}", method = RequestMethod.DELETE)
	public ResponseEntity<Car> delete(@PathVariable("carId") int id) {
		carlist.remove(id);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}

	@RequestMapping(value = "/updateMany", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Car>> updateMany(@RequestBody ArrayList<Car> cars) {
//		cars.stream().forEach(c -> c.setSpeed(c.getSpeed() + 10));
		cars.stream().forEach(car -> carlist.add(car));
		return new ResponseEntity<ArrayList<Car>>(HttpStatus.OK);
	}
}

