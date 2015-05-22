package soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
 @CrossOriginResourceSharing(
        allowOrigins = true, 
        allowCredentials = true, 
        /*maxAge = 1,*/ 
        allowHeaders = true, 
        exposeHeaders = true
)
@WebService
public interface HelloService {

	@WebMethod
	String sayHi(String input);
	
	@WebMethod
	String hola(String input);
}
