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
public class SaldoVencido_T implements Runnable {

    String codFrac, exp, saldoVencido;

    public SaldoVencido_T(String c, String e) {
        codFrac = c;
        exp = e;
    }

    public String getSaldoVencido() {
        return saldoVencido;
    }

    public void setSaldoVencido(String sv) {
        this.saldoVencido = sv;
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
        String result = cc.getSaldoVencido(getCodFrac(), getExp());
        if (result == null) {
            result = "0";
        }

        this.setSaldoVencido(result);
    }

}
