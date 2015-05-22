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
		
		 Message message = PhaseInterceptorChain.getCurrentMessage();

        SoapMessage soapMessage = (SoapMessage) message;
        List<Header> list = soapMessage.getHeaders();
        for (Header header : list) {
            System.out.println("Country: "+((Element)header.getObject()).getTextContent());
        }
		
		
		System.out.println("Hello invoked : " + input);
		return String.format("Hello '%s'", input);
	}
}
