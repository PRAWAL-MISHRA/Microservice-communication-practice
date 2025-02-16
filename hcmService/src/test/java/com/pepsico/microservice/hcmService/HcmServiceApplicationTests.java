package com.pepsico.microservice.hcmService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class HcmServiceApplicationTests 
{
//	String str = """
//			{
//    "employeeId": "402ffe88-c3cc-4a22-9d78-42713161b5fd",
//    "experince": 1,
//    "yearsInCurrentRole": 1,
//    "goalCompletedForCurrentYear": "yes"
//}
//			""";
//	
//	private static String SPECIFIC_URL = "";
//	
//	@Autowired
//	TestRestTemplate template;
	
	@Test
	void retrieveHCMDetails() 
	{
		//template.getForEntity(null, null);
	}

}
