package com.andreilorin.springbootintro;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.andreilorin.springbootintro.data.Data;

@SpringBootApplication
public class App {
	
	private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Data data = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Data.class);
        logger.info(data.toString());
    }
}
