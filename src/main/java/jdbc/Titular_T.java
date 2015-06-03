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
public class Titular_T implements Runnable {

    String codFrac, exp, titular;

    public Titular_T(String c, String e) {
        codFrac = c;
        exp = e;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String t) {
        this.titular = t;
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
        String result = cc.getTitular(getCodFrac(), getExp());
        if (result == null) {
            result = " ";
        }

        this.setTitular(result);
    }

}
