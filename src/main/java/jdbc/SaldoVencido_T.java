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

    public String codFrac, exp, saldoVencido;
	public int page;

    public SaldoVencido_T(String c, String e, int p) {
        codFrac = c;
        exp = e;
		page = p;
    }

    public String getSaldoVencido() {
        return saldoVencido;
    }

    public void setSaldoVencido(String saldoVencido) {
        this.saldoVencido = saldoVencido;
    }

    public String getCodFrac() {
        return codFrac;
    }

    public String getExp() {
        return exp;
    }
	
	public int getPage(){
		return page;
	}

    @Override
    public void run() {
        ConnectionConfiguration cc = new ConnectionConfiguration();
        String result = cc.getSaldoVencido(getCodFrac(), getExp(), getPage());
        if (result == null) {
            result = "0";
        }

        this.setSaldoVencido(result);
    }

}
