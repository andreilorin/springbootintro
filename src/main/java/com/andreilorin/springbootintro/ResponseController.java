package com.andreilorin.springbootintro;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
	
	private static final String template = "Hi, %s!";
	private final AtomicLong count = new AtomicLong();
	
	@RequestMapping("/main")
	public Response response(@RequestParam(value="name", defaultValue="Andrei") String name) {
		return new Response(count.incrementAndGet(), String.format(template, name));
	}
}
