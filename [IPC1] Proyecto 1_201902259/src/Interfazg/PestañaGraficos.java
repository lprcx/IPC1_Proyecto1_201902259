/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PestañaGraficos extends JPanel implements ActionListener {


    public PestañaGraficos() {
        //grafica pastel de usuarios
        DefaultPieDataset datos1 = new DefaultPieDataset();
        datos1.setValue("Usuarios Administradores", IPC1Proyecto1_201902259.ust1());
        datos1.setValue("Usuarios Estudiantes", IPC1Proyecto1_201902259.ust2());
        JFreeChart graficaus = ChartFactory.createPieChart3D("Tipo de Usuarios Registrados en el Sistema", datos1);
        PiePlot3D pie1 = (PiePlot3D) graficaus.getPlot();
        pie1.setForegroundAlpha(0.40f);
        pie1.setInteriorGap(0.05);
        pie1.setBackgroundPaint(Color.LIGHT_GRAY);
        ChartPanel p1 = new ChartPanel(graficaus);
        p1.setBounds(20, 50, 290, 290);
        this.add(p1);

        //grafica de barras de prestamos
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        datos2.setValue(IPC1Proyecto1_201902259.enero(), "Enero", String.valueOf(IPC1Proyecto1_201902259.enero()));
        datos2.setValue(IPC1Proyecto1_201902259.febrero(), "Febrero", String.valueOf(IPC1Proyecto1_201902259.febrero()));
        datos2.setValue(IPC1Proyecto1_201902259.marzo(), "Marzo", String.valueOf(IPC1Proyecto1_201902259.marzo()));
        datos2.setValue(IPC1Proyecto1_201902259.abril(), "Abril", String.valueOf(IPC1Proyecto1_201902259.abril()));
        datos2.setValue(IPC1Proyecto1_201902259.mayo(), "Mayo", String.valueOf(IPC1Proyecto1_201902259.mayo()));
        datos2.setValue(IPC1Proyecto1_201902259.junio(), "Junio", String.valueOf(IPC1Proyecto1_201902259.junio()));
        datos2.setValue(IPC1Proyecto1_201902259.julio(), "Julio", String.valueOf(IPC1Proyecto1_201902259.julio()));
        datos2.setValue(IPC1Proyecto1_201902259.agosto(), "Agosto", String.valueOf(IPC1Proyecto1_201902259.agosto()));
        datos2.setValue(IPC1Proyecto1_201902259.septiembre(), "Septiembre", String.valueOf(IPC1Proyecto1_201902259.septiembre()));
        datos2.setValue(IPC1Proyecto1_201902259.octubre(), "Octubre", String.valueOf(IPC1Proyecto1_201902259.octubre()));
        datos2.setValue(IPC1Proyecto1_201902259.noviembre(), "Noviembre", String.valueOf(IPC1Proyecto1_201902259.noviembre()));
        datos2.setValue(IPC1Proyecto1_201902259.diciembre(), "Diciembre", String.valueOf(IPC1Proyecto1_201902259.diciembre()));
        JFreeChart barras = ChartFactory.createBarChart("Cantidad de Libros Prestados por Fecha", "mes", "cantidad de libros", datos2, PlotOrientation.VERTICAL, true, false, false);
        barras.setBackgroundPaint(Color.PINK);
        barras.getTitle().setPaint(Color.BLACK);
        barras.getTitle().setFont(new Font ("Century Gothic", Font.PLAIN, 15));
        ChartPanel p2 = new ChartPanel(barras);
        p2.setBounds(330, 50, 290, 290);
        this.add(p2);

        // grafica pastel de tipos de libros
        DefaultPieDataset datos3 = new DefaultPieDataset();
        datos3.setValue("Libro", IPC1Proyecto1_201902259.tl1());
        datos3.setValue("Revista", IPC1Proyecto1_201902259.tl2());
        datos3.setValue("Libro Eléctronico", IPC1Proyecto1_201902259.tl3());
        JFreeChart graficalb = ChartFactory.createPieChart3D("Tipos de Libros Registrados en el Sistema", datos3);
        PiePlot3D pie2 = (PiePlot3D) graficalb.getPlot();
        pie2.setForegroundAlpha(0.40f);
        pie2.setInteriorGap(0.05);
        pie2.setBackgroundPaint(Color.LIGHT_GRAY);
        ChartPanel p3 = new ChartPanel(graficalb);
        p3.setBounds(640, 50, 290, 290);
        this.add(p3);

        //Diseño del Panel
        this.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
