package soap.service;

/**
 * @author chamerling
 * 
 */
@WebService(endpointInterface = "soap.service.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHi(String input) {
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}

	@Override
	public String hola(String input) {
		

		
		
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}
}
