/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ConnectionConfiguration {

    String dbURL = "jdbc:mysql://192.185.4.105:3306/rigarcia_proyecto";
    String username = "rigarcia_proyect";
    String password = "proyecto";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public List<Movimiento> getMovimientos(String c, String e) {
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        try {
            Connection conn = this.getConnection();
            String sql = "SELECT mov.CodMov, mov.FechaV, mov.Importe,mov.SaldoMov,resultado.FechaPag\n"
                    + "FROM rigarcia_proyecto.movimientos as mov\n"
                    + "\n"
                    + "JOIN (SELECT pg.codFrac, Max(pg.fechaPag) FechaPag, pg.Exp\n"
                    + "FROM pagmov as pg \n"
                    + "WHERE pg.CodFrac = " + c + "\n"
                    + "GROUP BY pg.CodFrac, pg.Exp) \n"
                    + "as resultado ON resultado.CodFrac = '012'\n"
                    + "and resultado.Exp =" + e + "\n"
                    + "\n"
                    + "where mov.Exp = " + e + "\n"
                    + "and mov.CodFrac = " + c + "\n"
                    + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                Movimiento mov = new Movimiento();

                mov.setNoMovimiento(result.getString("CodMov"));
                mov.setFechaPago(result.getString("FechaPag"));
                mov.setFechaVencimiento(result.getString("FechaV"));
                mov.setImporte(result.getString("Importe"));
                mov.setSaldo(result.getString("SaldoMov"));

                movimientos.add(mov);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movimientos;
    }

    public String getSaldoVencido(String c, String e) {
        String saldoVencido = " ";
        try {
            Connection conn = this.getConnection();
            String sql = "select  SUM(SaldoMov) AS SaldoVencido \n"
                    + "FROM movimientos \n"
                    + "where Cast(FechaV as datetime) > curdate()\n"
                    + "and\n"
                    + "Exp = " + e + "\n"
                    + "and CodFrac = " + c + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                saldoVencido = result.getString("SaldoVencido");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return saldoVencido;
    }

    public String getSaldoCorriente(String c, String e) {
        String saldoVencido = " ";
        try {
            Connection conn = this.getConnection();
            String sql = "select  SUM(SaldoMov) AS SaldoVencido \n"
                    + "FROM movimientos \n"
                    + "where Cast(FechaV as datetime) <= curdate()\n"
                    + "and\n"
                    + "Exp = " + e + "\n"
                    + "and CodFrac = " + c + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                saldoVencido = result.getString("SaldoVencido");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return saldoVencido;
    }

    public String getTitular(String c, String e) {
        String titular = " ";
        try {
            Connection conn = this.getConnection();
            String sql = "SELECT titular FROM rigarcia_proyecto.contratos\n"
                    + "where exp =" + e + "\n"
                    + "and codfrac =" + c + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                titular = result.getString("titular");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return titular;
    }

    public String getLastCodPag() {
        long codPag = 0;
        try {
            Connection conn = this.getConnection();

            String sql = "SELECT CodPag FROM rigarcia_proyecto.pagmov\n"
                    + "ORDER BY CodPag DESC\n"
                    + "LIMIT 1;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                codPag = Long.parseLong(result.getString("CodPag"));
            }
            codPag++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return codPag + "";
    }

    public Movimiento getMovimientoByCode(String codMov) {
        Movimiento mov = new Movimiento();
        try {
            Connection conn = this.getConnection();

            String sql = "select  * \n"
                    + "FROM movimientos \n"
                    + "where CodMov = " + codMov + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                mov.setNoMovimiento(result.getString("CodMov"));
                mov.setCodTMov(result.getString("CodTMov"));
                mov.setConsTMov(result.getString("ConsTMov"));
                mov.setCodFrac(result.getString("CodFrac"));
                mov.setExp(result.getString("Exp"));
                mov.setImporte(result.getString("Importe"));
                mov.setCodMon(result.getString("CodMon"));
                mov.setSaldo(result.getString("SaldoMov"));
                mov.fechaVencimiento = result.getString("FechaV");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mov;
    }

    public void pagar(String noMov) {
        long codMov = Long.parseLong(noMov);
        String ultimo_importe = "0", codPag;
        Movimiento mov = getMovimientoByCode(noMov);

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearString = String.valueOf(year);
        int month = now.get(Calendar.MONTH);
        String monthString = String.valueOf(month);
        int day = now.get(Calendar.DAY_OF_MONTH);
        String dayString = String.valueOf(day);

        if (month < 10) {
            monthString = "0" + String.valueOf(month);
        }
        if (day < 10) {
            dayString = "0" + String.valueOf(day);
        }

        String currentDate = yearString + monthString + dayString;

        try {
            Connection conn = this.getConnection();

            codPag = this.getLastCodPag();

            if (Double.parseDouble(mov.getSaldo()) > 0) {
                String sql = "INSERT INTO pagmov(CodPag,CodMov,Importe,FechaPag,CodFrac,Exp)VALUES\n"
                        + "('" + codPag.toString() + "',\n"
                        + "'" + noMov + "',\n"
                        + "'" + mov.getSaldo() + "',\n"
                        + "'" + currentDate + "',\n"
                        + "'" + mov.getCodFrac().toString() + "',\n"
                        + "'" + mov.getExp().toString() + "');";

                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                sql = "UPDATE movimientos SET SaldoMov ='0.000' WHERE CodMov ='" + noMov + "';";
                statement.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
