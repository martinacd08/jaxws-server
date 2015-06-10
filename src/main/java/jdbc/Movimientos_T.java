/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Movimientos_T implements Runnable {

    public String codFrac, exp;
	public int page;

    public String getCodFrac() {
        return codFrac;
    }

    public String getExp() {
        return exp;
    }

	public int getPage(){
		return page;
	}

    List<Movimiento> movs;

    public Movimientos_T(String c, String e, int p) {
        codFrac = c;
        exp = e;
		page = p;
        movs = new ArrayList<Movimiento>();
    }

    public List<Movimiento> getMovs() {
        return movs;
    }

    public void setMovs(List<Movimiento> movs) {
        this.movs = movs;
    }

    @Override
    public void run() {
        ConnectionConfiguration cc = new ConnectionConfiguration();
        this.setMovs(cc.getMovimientos(getCodFrac(), getExp(), getPage()));
    }

}
