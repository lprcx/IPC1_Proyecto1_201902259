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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PestañaPrestamos extends JPanel implements ActionListener {
    JLabel IDus, librro, fecha;
    JTextField IDusu, IDlibro, date;
    JButton preslib, cargas;
    static JTable tablita2;
    static Object[][] datos2;
        public PestañaPrestamos(){
        //inicio usuario
        IDus = new JLabel("Usuario:");
        IDus.setBounds(15, 10, 80, 30);
        IDus.setFont(new Font("Biome Light", Font.BOLD, 14));
        IDus.setVisible(true);
        this.add(IDus);

        IDusu = new JTextField();
        IDusu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        IDusu.setBounds(100, 15, 100, 28);
        IDusu.setVisible(true);
        IDusu.addActionListener(this);
        this.add(IDusu);
        
         //inicio libro
        librro = new JLabel("Libro:");
        librro.setBounds(15,50,80,30);
        librro.setFont(new Font("Biome Light", Font.BOLD,14));
        librro.setVisible(true);
        this.add(librro);
        
        IDlibro = new JTextField();
        IDlibro.setFont(new Font("Century Gothic",Font.PLAIN,12));
        IDlibro.setBounds(100,55,100,28);
        IDlibro.setVisible(true);
        IDlibro.addActionListener(this);
        this.add(IDlibro);
        
         //inicio fecha
        fecha = new JLabel("Fecha de entrega:");
        fecha.setBounds(15,90,80,30);
        fecha.setFont(new Font("Biome Light", Font.BOLD,14));
        fecha.setVisible(true);
        this.add(fecha);
        
        date = new JTextField();
        date.setFont(new Font("Century Gothic",Font.PLAIN,12));
        date.setBounds(100,95,100,28);
        date.setVisible(true);
        date.addActionListener(this);
        this.add(date);

        //Boton prestar libro
        preslib = new JButton("Prestar libro");
        preslib.setBounds(20,60,100,20);
        preslib.setFont(new Font("Biome Light", Font.BOLD, 12));
        preslib.setBackground(Color.lightGray);
        this.add(preslib);
    
        
        //Tabla Prestamos
        String[] encabezado2 = {"Nombre Usuario", "Libro", "Fecha de Entrega", "Status"};
        Object[][] xx2 = {
            {"Patty", "Libro 1", "febrero", "entregado"},
            {"Lourdes", "Libro 2", "marzo", "pendiente"}
        };
        tablita2 = new JTable(xx2, encabezado2);
        JScrollPane scroll = new JScrollPane(tablita2);
        scroll.setBounds(220, 10, 725,400);
        scroll.setVisible(true);
        this.add(scroll);
    
        //Boton de Carga masiva en la tabla2
        cargas = new JButton("Carga Masiva");
        cargas.setBounds(20,300,150,25);
        cargas.setFont(new Font("Biome Light", Font.BOLD, 15));
        cargas.addActionListener(this);
        cargas.setBackground(Color.lightGray);
        this.add(cargas);
    
    
    
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
