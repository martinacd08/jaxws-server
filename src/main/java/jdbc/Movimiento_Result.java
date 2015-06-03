/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.util.List;

/**
 *
 * @author Martin
 */
public class Movimiento_Result {
    private String saldoVencido, SaldoCorriente,titular;
    private List<Movimiento> movimientos;

    public String getSaldoVencido() {
        return saldoVencido;
    }

    public void setSaldoVencido(String saldoVencido) {
        this.saldoVencido = saldoVencido;
    }

    public String getSaldoCorriente() {
        return SaldoCorriente;
    }

    public void setSaldoCorriente(String SaldoCorriente) {
        this.SaldoCorriente = SaldoCorriente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    
}
