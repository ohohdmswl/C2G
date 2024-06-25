package ABE.C2G.firstTest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstTestController {

//	@RequestMapping(value = "/testFirst", method = RequestMethod.GET)
	@GetMapping(value = "/testFirst")
	public String firstTest() {
		System.out.println("jsp호출");
		
		return "firstTest";
	}
}
