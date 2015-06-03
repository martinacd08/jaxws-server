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

    public void setCodTMov(String codTMov) {
        this.codTMov = codTMov;
    }

    public String getConsTMov() {
        return consTMov;
    }

    public void setConsTMov(String consTMov) {
        this.consTMov = consTMov;
    }

    public String getCodFrac() {
        return codFrac;
    }

    public void setCodFrac(String codFrac) {
        this.codFrac = codFrac;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCodMon() {
        return codMon;
    }

    public void setCodMon(String codMon) {
        this.codMon = codMon;
    }

    
    public String getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(String noMovimiento) {
        this.noMovimiento = noMovimiento;
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

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = formatFecha(fechaPago);
    }
    public String fechaPago;
    
    public String formatFecha(String fecha){
    
        String yyyy = fecha.substring(0, 4); 
                String mm = fecha.substring(4, 6); 
                String dd = fecha.substring(6, 8); 
                
                return yyyy+"/"+mm+"/"+dd;
    }
}