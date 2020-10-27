package RegisteringMicroservie.ServiceDiscovery.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import RegisteringMicroservice.ServiceDiscovery.bean.Student;

@RestController
public class StudentService {
	private String jsonString = "{'61070003':'นายกฤตนัย  พหนการ','61070004':'นางสาวกฤติมา  จันทะชาลี','61070006':'นายกฤษฎาภา  ง่วนจร'}";
	private JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping("/v1/student/{studentId}")
	public Student getStudent(@PathVariable String studentId) {
		Student s = new Student();
		s.setId(studentId);
		s.setName(jsonObject.get(studentId).getAsString());
		return s;
	}
}