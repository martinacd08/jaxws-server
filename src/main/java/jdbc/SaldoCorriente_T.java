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
public class SaldoCorriente_T implements Runnable {

    String codFrac, exp, saldoCorriente;

    public SaldoCorriente_T(String c, String e) {
        codFrac = c;
        exp = e;
    }

    public String getSaldoCorriente() {
        return saldoCorriente;
    }

    public void setSaldoCorriente(String sc) {
        this.saldoCorriente = sc;
    }

    public String getCodFrac() {
        return codFrac;
    }

    public String getExp() {
        return exp;
    }

    @Override
    public void run() {
        ConnectionConfiguration cc = new ConnectionConfiguration();

        String result = cc.getSaldoCorriente(getCodFrac(), getExp());
        if (result == null) {
            result = "0";
        }

        this.setSaldoCorriente(result);
    }

}
