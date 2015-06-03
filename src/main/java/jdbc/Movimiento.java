/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package jdbc;

/**
 *
 * @author Martin
 */
public class Movimiento {
    public String noMovimiento;
    public String codTMov;
    public String consTMov;
    public String codFrac;
    public String exp;
    public String codMon;
    public String fechaVencimiento;
    public String importe;
    public String saldo;
    public String fechaPago;
     
    

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = formatFecha(fechaVencimiento);
    }

   

    public void setFechaPago(String fechaPago) {
        this.fechaPago = formatFecha(fechaPago);
    }
   
    
    public String formatFecha(String fecha){
    
        String yyyy = fecha.substring(0, 4); 
                String mm = fecha.substring(4, 6); 
                String dd = fecha.substring(6, 8); 
                
                return yyyy+"/"+mm+"/"+dd;
    }
}