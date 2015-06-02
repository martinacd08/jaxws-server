package soap.service;
import jdbc.Movimiento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
 @Stateless
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class HelloServiceImpl implements HelloService {


	@WebMethod
	 @WebResult(name = "getMovimientoInfoReturn", targetNamespace = "http://service.soap/")
	 public Movimiento getMovimientoInfo(@WebParam(name = "MovimientoId") String MovimientoId)
	 {
	  // Sample Implementation.. do it your way...
	  List<Movimiento> MovimientoList = new ArrayList<Movimiento>();
	  Movimiento c1 = new Movimiento();
	  c1.saldo = "2000";
	  c1.importe = "500";
	  Movimiento c2 = new Movimiento();
	 c2.saldo = "3000";
	  c2.importe = "500";
	  Movimiento c3 = new Movimiento();
	  c3.saldo = "4000";
	  c3.importe = "500";
	  MovimientoList.add(c1);
	  MovimientoList.add(c2);
	  MovimientoList.add(c3);
	  Movimiento Movimiento = null;
	  Iterator<Movimiento> it = MovimientoList.iterator();
	  while (it.hasNext()) {
	   Movimiento element = (Movimiento) it.next();
	   if (MovimientoId == element.saldo) {
		Movimiento = element;
	   }
	  }
	  return Movimiento;
	 }

}
 