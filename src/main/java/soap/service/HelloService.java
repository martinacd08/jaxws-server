package soap.service;
import jdbc.Movimiento;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
/**
 * @author chamerling
 * 
 */

@WebService
@Remote
public interface CustomerInfo {
 public Movimiento getMovimientoInfo(int MovimientoId);

}