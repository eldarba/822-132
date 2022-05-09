package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerA {

//	@Autowired
//	private DiscoveryClient discoveryClient;
//	@Autowired
//	private LoadBalancerClient lbClient;
	@Autowired
	private RestTemplate rt;

	@HystrixCommand(fallbackMethod = "fallbackForhandleA")
	@GetMapping("/service/a")
	public String handleA() {
		String url = "http://service-b/service/b";
		String resFromB = rt.getForObject(url, String.class);
		return "Service A calls: " + resFromB;
	}

	public String fallbackForhandleA(Throwable t) {
		return "service-a fallback: " + t;
	}

//	// a method for getting the base uri for instances of a service
//	public URI getServiceInsanceBaseUri(String serviceId) {
//		return this.lbClient.choose(serviceId).getUri();
//	}

//	@GetMapping("/service/a")
//	public String handleA() {
//		URI baseUri = this.getServiceInsanceBaseUri("service-b");
//		String url = baseUri + "/service/b";
//		String resFromB = rt.getForObject(url, String.class);
//		return "Service A calls: " + resFromB;
//	}

	// a method for getting the base uri for instances of a service
//	private URI getServiceInsanceBaseUri(String serviceId) {
//		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//		for (ServiceInstance serviceInstance : instances) {
//			System.out.println(serviceInstance.getUri());
//		}
//		System.out.println("==========");
//		ServiceInstance instance = instances.get(0);
//		URI serviceBaseUri = instance.getUri();
//		return serviceBaseUri;
//	}

}
