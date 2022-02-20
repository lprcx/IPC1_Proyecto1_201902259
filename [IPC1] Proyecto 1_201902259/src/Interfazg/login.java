/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class login extends JFrame implements ActionListener, ItemListener{
    //Label
    JLabel titulo, ID, libro, autor, cop, tip, revista, librelec;
    JButton botlibros, botprestamos, botreportes, botgraf;
    JFrame tipp;
    static JTextField numID, Nlibro, Aut;
    static JPasswordField pass;
    static Scrollbar b;
    
    public login(){
        
        //titulo 
        titulo = new JLabel("p");
        titulo.setBounds(100,80,100,20);
        titulo.setFont(new Font("Biome Light", Font.BOLD,20));
        titulo.setVisible(true);
        this.add(titulo);
        
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Usac_logo.png")).getImage());
        
        //botones
        botlibros = new JButton("Libros");
        botlibros.setBounds(25,40,75,20);
        botlibros.setVisible(true);
        botlibros.setFont(new Font("Biome Light", Font.BOLD, 12));
        botlibros.setBackground(Color.lightGray);
        this.add(botlibros);
        
        botprestamos = new JButton("Prestamos");
        botprestamos.setBounds(100,40,95,20);
        botprestamos.setVisible(true);
        botprestamos.setFont(new Font("Biome Light", Font.BOLD, 12));
        botprestamos.setBackground(Color.lightGray);
        this.add(botprestamos);
        
        botreportes = new JButton("Reportes");
        botreportes.setBounds(195,40,95,20);
        botreportes.setVisible(true);
        botreportes.setFont(new Font("Biome Light", Font.BOLD, 12));
        botreportes.setBackground(Color.lightGray);
        this.add(botreportes);
        
        botgraf = new JButton("Graficas");
        botgraf.setBounds(290,40,95,20);
        botgraf.setVisible(true);
        botgraf.setFont(new Font("Biome Light", Font.BOLD, 12));
        botgraf.setBackground(Color.lightGray);
        this.add(botgraf);
        
        
        //inicio ID
        ID = new JLabel("ID Libro:");
        ID.setBounds(15,90,80,30);
        ID.setFont(new Font("Biome Light", Font.BOLD,14));
        ID.setVisible(true);
        this.add(ID);
        
        numID = new JTextField();
        numID.setFont(new Font("Century Gothic",Font.PLAIN,12));
        numID.setBounds(100,95,100,28);
        numID.setVisible(true);
        numID.addActionListener(this);
        this.add(numID);
        
        
        //inicio libro
        libro = new JLabel("Libro:");
        libro.setBounds(15,140,80,30);
        libro.setFont(new Font("Biome Light", Font.BOLD,14));
        libro.setVisible(true);
        this.add(libro);
        
        Nlibro = new JTextField();
        Nlibro.setFont(new Font("Century Gothic",Font.PLAIN,12));
        Nlibro.setBounds(100,145,100,28);
        Nlibro.setVisible(true);
        Nlibro.addActionListener(this);
        this.add(Nlibro);
        
        
        //inicio Autor
        autor = new JLabel("Autor:");
        autor.setBounds(15,190,80,30);
        autor.setFont(new Font("Biome Light", Font.BOLD,14));
        autor.setVisible(true);
        this.add(autor);
        
        Aut = new JTextField();
        Aut.setFont(new Font("Century Gothic",Font.PLAIN,12));
        Aut.setBounds(100,195,100,28);
        Aut.setVisible(true);
        Aut.addActionListener(this);
        this.add(Aut);
        
        
        //inicio copias
        cop = new JLabel("Copias:");
        cop.setBounds(15,230,80,30);
        cop.setFont(new Font("Biome Light", Font.BOLD,14));
        cop.setVisible(true);
        this.add(cop);
        
        //inicio tipo
        tip = new JLabel("Tipo:");
        tip.setBounds(15,270,80,30);
        tip.setFont(new Font("Biome Light", Font.BOLD,14));
        tip.setVisible(true);
        this.add(tip);
        
         
        String opc[] = {"Libro","Revista","Libro Electronico"};
        JComboBox tiplib = new JComboBox(opc);
        tiplib.setBounds(100,275,100,28);
        this.add(tiplib);
        this.setLayout(null);
        this.setSize(50, 50);
        this.setVisible(true);
        
        
        
        
        
        
        
        
        //ventana
        this.setTitle("Login");
        this.setLayout(null);
        this.setBounds(130,100,1000,500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
