package soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;
/**
 * @author chamerling
 * 
 */
 @CrossOriginResourceSharing(allowOrigins = {
        "*"
        }, allowCredentials = true, maxAge = 1, allowHeaders = {
        "X-custom-1", "X-custom-2"
        }, exposeHeaders = {
        "X-custom-3", "X-custom-4"
        }
) 

@WebService
public interface HelloService {

	@WebMethod
	String sayHi(String input);
	
	@WebMethod
	String hola(String input);
}
