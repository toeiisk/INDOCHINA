package maven.app.firstapp;

import java.util.ArrayList;
//import java.util.List;
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
	
	//get
	@RequestMapping(value = "/car/{carId}")
	public ResponseEntity<Car> get(@PathVariable("carId") int carId) {
		Car instanceCar = carlist.get(carId-1);
		return new ResponseEntity<Car>(instanceCar, HttpStatus.OK);
	}
	
	//post
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<Car> create(@RequestBody Car car) {
		Car.carlist.add(car);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	//patch
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.PATCH)
	public ResponseEntity<ArrayList<Car>> update(@RequestBody Car car, @PathVariable("carId") int carId) {
		carlist.set(carId-1, car);
		return new ResponseEntity<ArrayList<Car>>(carlist, HttpStatus.OK);
	}
	

	//delete
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.DELETE)
	public ResponseEntity<ArrayList<Car>> delete(@PathVariable("carId") int carId) {
		carlist.remove(carId-1);
		return new ResponseEntity<ArrayList<Car>>(carlist, HttpStatus.OK);
	}
}

