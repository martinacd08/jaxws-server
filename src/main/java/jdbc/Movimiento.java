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

    public String getCodTMov() {
        return codTMov;
    }

    public void setCodTMov(String cm) {
        this.codTMov = cm;
    }

    public String getConsTMov() {
        return consTMov;
    }

    public void setConsTMov(String cm) {
        this.consTMov = cm;
    }

    public String getCodFrac() {
        return codFrac;
    }

    public void setCodFrac(String cf) {
        this.codFrac = cf;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String e) {
        this.exp = e;
    }

    public String getCodMon() {
        return codMon;
    }

    public void setCodMon(String cm) {
        this.codMon = cm;
    }

    
    public String getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(String nm) {
        this.noMovimiento = nm;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = formatFecha(fechaVencimiento);
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String i) {
        this.importe = i;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String s) {
        this.saldo = s;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fp) {
        this.fechaPago = formatFecha(fp);
    }
    public String fechaPago;
    
    public String formatFecha(String fecha){
    
        String yyyy = fecha.substring(0, 4); 
                String mm = fecha.substring(4, 6); 
                String dd = fecha.substring(6, 8); 
                
                return yyyy+"/"+mm+"/"+dd;
    }
}