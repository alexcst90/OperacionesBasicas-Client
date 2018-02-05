package com.example.demo.client;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableDiscoveryClient
@RestController
@RequestMapping("/")
public class OperacionesClient {

	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("sm/")
	public ResponseEntity<?> sumar(@RequestParam("n1") double n1, @RequestParam("n2") double n2) {
		String uri = "http://localhost:8765/operaciones/suma/?n1="+n1+"&n2="+n2;
		
		return restTemplate.getForEntity(uri, String.class);
	}
	
	@GetMapping("rs/")
	public ResponseEntity<?> restar(@RequestParam("n1") double n1, @RequestParam("n2") double n2) {
		String uri = "http://localhost:8765/operaciones/resta/?n1="+n1+"&n2="+n2;
		
		return restTemplate.getForEntity(uri, String.class);
	}
	
	@GetMapping("ml/")
	public ResponseEntity<?> multiplicar(@RequestParam("n1") double n1, @RequestParam("n2") double n2) {
		String uri = "http://localhost:8765/operaciones/multi/?n1="+n1+"&n2="+n2;
		
		return restTemplate.getForEntity(uri, String.class);
	}
		
	@GetMapping("dv/")
	public ResponseEntity<?> dividir(@RequestParam("n1") double n1, @RequestParam("n2") double n2) {
		String uri = "http://localhost:8765/operaciones/div/?n1="+n1+"&n2="+n2;
		
		return restTemplate.getForEntity(uri, String.class);
	}
	
}
