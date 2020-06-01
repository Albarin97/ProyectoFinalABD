/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.util.Vector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.ResultSet;

/**
 *
 * @author albar
 */
public class grafica {
    DefaultPieDataset data = new DefaultPieDataset();
    Vector v = new Vector();
    
        public void obtener_info(){
        ResultSet res=Conexion.Conexion.Consulta("SELECT SUM(cantidad), marca FROM productos GROUP BY marca;");
        try {
            while(res.next()){
                data.setValue(res.getString(2).toString()+": "+ new Integer(res.getInt(1)), new Integer(res.getInt(1)));
            }
                
        } catch (Exception e) {
        }
       JFreeChart chart = ChartFactory.createPieChart("Cantidad De Motocicletas Por Marca", data);
       ChartFrame frame = new ChartFrame("Grafica Disponibles", chart);
       frame.pack();
       frame.setSize(400,400);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
    

}
