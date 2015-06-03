
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

    public void setSaldoVencido(String sv) {
        this.saldoVencido = sv;
    }

    public String getSaldoCorriente() {
        return SaldoCorriente;
    }

    public void setSaldoCorriente(String sc) {
        this.SaldoCorriente = sc;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String t) {
        this.titular = t;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> m) {
        this.movimientos = m;
    }
    
    
}
