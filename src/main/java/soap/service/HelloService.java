package soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@BindingType(JSONBindingID.JSON_BINDING)  
@WebService 
public interface HelloService {

	/*@WebMethod
	String sayHi(String input);
	
	@WebMethod
	String hola();*/
	
	@WebMethod
    public Book get(@WebParam(name="id") int id);
}
