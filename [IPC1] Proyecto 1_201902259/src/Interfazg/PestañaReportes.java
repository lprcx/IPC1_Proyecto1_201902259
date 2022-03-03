/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PestañaReportes extends JPanel implements ActionListener {

    JLabel tiprep;
    JButton gen;
    JComboBox tipor;
    static JTable tablita3;
    static Object[][] datos3;

    public PestañaReportes() {
        //Tipo de REporte
        tiprep = new JLabel("Tipo de Reporte:");
        tiprep.setBounds(15, 10, 120, 30);
        tiprep.setFont(new Font("Biome Light", Font.BOLD, 14));
        tiprep.setVisible(true);
        this.add(tiprep);

        //Combo Box tipo de Reporte
        String[] tipoor = {"Reportes de Usuario", "Reportes de Libros", "Reportes de Prestamos"};
        tipor = new JComboBox(tipoor);
        tipor.setBounds(140, 15, 120, 28);
        this.add(tipor);
        
        //Botoncito generar
        gen = new JButton("Libros");
        gen.setBounds(40,30,75,20);
        gen.setFont(new Font("Biome Light", Font.BOLD, 12));
        gen.setBackground(Color.lightGray);
        this.add(gen);
        
        
        //Tabla Prestamos
        String[] encabezado3 = {"Fecha de Generación", "Usuario", "Tipo de Reporte"};
        Object[][] xx3 = {
            {"enero", "pattyrc", "Reporte de Usuario"},
            {"marzo", "jiji", "Reporte de libros"}
        };
        tablita3 = new JTable(xx3, encabezado3);
        JScrollPane scroll = new JScrollPane(tablita3);
        scroll.setBounds(220, 10, 725,400);
        scroll.setVisible(true);
        this.add(scroll);

        //Diseño del Panel
        this.setLayout(null);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
