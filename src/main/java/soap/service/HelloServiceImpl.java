package soap.service;
import jdbc.*;


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
	 public  Movimiento_Result getMovimientoInfo(@WebParam(name = "codFrac") String codFrac, @WebParam(name = "exp") String exp)
	 {
	  Movimiento_Result movResult = new Movimiento_Result();
       
        SaldoVencido_T saldoV = new SaldoVencido_T(codFrac, exp);
        Movimientos_T mov = new Movimientos_T(codFrac, exp);
        SaldoCorriente_T saldoC = new SaldoCorriente_T(codFrac, exp);
        Titular_T titular = new Titular_T(codFrac, exp);
        
        Thread saldo_T = new Thread(saldoV, "t1");
        Thread mov_T = new Thread(mov, "t2");
        Thread saldoC_T = new Thread(saldoC, "t2");
        Thread titular_T = new Thread(titular,"t3");

        saldo_T.start();
        mov_T.start();
        saldoC_T.start();
        titular_T.start();

        try {
            saldo_T.join();
            mov_T.join();
            saldoC_T.join();
            titular_T.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String saldoVencido = saldoV.getSaldoVencido();
        List<Movimiento> movimientos = mov.getMovs();
        String saldoCorriente = saldoC.getSaldoCorriente();
        String nombreTitular = titular.getTitular();
       
        
        
        movResult.movimientos=movimientos;
        movResult.SaldoCorriente=saldoCorriente;
        movResult.saldoVencido=saldoVencido;
        movResult.titular=nombreTitular;
        
	  return movResult;
	 }

	 @WebMethod
	 @WebResult(name = "pagar", targetNamespace = "http://service.soap/")
	 public boolean pagar(@WebParam(name = "noMov")String noMov){
		 
		  ConnectionConfiguration cc = new ConnectionConfiguration();

        return cc.pagar(noMov);
		 
	 }
}
 