package com.tejovat.starmart.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WelcomeControllerTests {

	@InjectMocks
	WelcomeController welcomeController;

	static Map<String, String> stateMap = new HashMap<>();

	@BeforeEach
	void setup() {
		stateMap.put("TX", "TEXAS");
		stateMap.put("TN", "Tennessee");
		stateMap.put("NC", "NorthCarilona");
	}

	@Test
	void testGetWelcomeMesage() {
		String messge = welcomeController.getWelcomeMesage();
		assertNotNull(messge);
		assertSame("Hey, I'm up now.", messge);
	}

	@Test
	void testGetWelcomeMesage1() {
		Map<String, String> map = welcomeController.getWelcomeMesage1();
		assertNotNull(map);
		assertSame("Success", map.get("status"));
	}

}
