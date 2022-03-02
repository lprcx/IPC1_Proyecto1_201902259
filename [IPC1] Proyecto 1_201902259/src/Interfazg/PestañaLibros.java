/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PestañaLibros extends JPanel implements ActionListener{
    JLabel ID, libro, autor, cop, tip;
    JTextField numID, Nlibro, Aut, Copi;
    JButton regis, cargas;
    JComboBox tipo;
    static JTable tablita;
    static Object[][] datos;
    public PestañaLibros(){
                
        //inicio ID
        ID = new JLabel("ID Libro:");
        ID.setBounds(15, 10, 80, 30);
        ID.setFont(new Font("Biome Light", Font.BOLD, 14));
        ID.setVisible(true);
        this.add(ID);

        numID = new JTextField();
        numID.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        numID.setBounds(100, 15, 100, 28);
        numID.setVisible(true);
        numID.addActionListener(this);
        this.add(numID);
        
         //inicio libro
        libro = new JLabel("Libro:");
        libro.setBounds(15,50,80,30);
        libro.setFont(new Font("Biome Light", Font.BOLD,14));
        libro.setVisible(true);
        this.add(libro);
        
        Nlibro = new JTextField();
        Nlibro.setFont(new Font("Century Gothic",Font.PLAIN,12));
        Nlibro.setBounds(100,55,100,28);
        Nlibro.setVisible(true);
        Nlibro.addActionListener(this);
        this.add(Nlibro);
        
         //inicio Autor
        autor = new JLabel("Autor:");
        autor.setBounds(15,90,80,30);
        autor.setFont(new Font("Biome Light", Font.BOLD,14));
        autor.setVisible(true);
        this.add(autor);
        
        Aut = new JTextField();
        Aut.setFont(new Font("Century Gothic",Font.PLAIN,12));
        Aut.setBounds(100,95,100,28);
        Aut.setVisible(true);
        Aut.addActionListener(this);
        this.add(Aut);
        
         //inicio copias
        cop = new JLabel("Copias:");
        cop.setBounds(15,130,80,30);
        cop.setFont(new Font("Biome Light", Font.BOLD,14));
        cop.setVisible(true);
        this.add(cop);
        
        Copi = new JTextField();
        Copi.setFont(new Font("Century Gothic",Font.PLAIN,12));
        Copi.setBounds(100,135,100,28);
        Copi.setVisible(true);
        Copi.addActionListener(this);
        this.add(Copi);
        
        //combo box tipo
        tip = new JLabel("Tipo:");
        tip.setBounds(15,170,80,30);
        tip.setFont(new Font("Biome Light", Font.BOLD,14));
        tip.setVisible(true);
        this.add(tip);
        
        String[] tipoo = {"Libro","Revista","Libro Electronico"};
        tipo = new JComboBox(tipoo);
        tipo.setBounds(100,175,100,28);
        this.add(tipo);
        
        //Tablaxd
        String[] encabezado = {"ID Libro", "Nombre Libro", "Autor", "Tipo", "Copias", "Disponibles", "Ocupados"};
        Object[][] xx = {
            {"1", "Libro 1", "USAC", "Libro", "10", "2", "8"},
            {"2", "Libro 2", "USAC", "Revista", "10", "2", "8"}
        };
        tablita = new JTable(xx, encabezado);
        JScrollPane scroll = new JScrollPane(tablita);
        scroll.setBounds(220, 10, 725,400);
        scroll.setVisible(true);
        this.add(scroll);
        
        //Boton de Registrar libros
        regis = new JButton("Registrar");
        regis.setBounds(20,250,115,25);
        regis.setFont(new Font("Biome Light", Font.BOLD, 15));
        regis.addActionListener(this);
        regis.setBackground(Color.lightGray);
        this.add(regis);

        //Boton de Carga masiva en la tabla
        cargas = new JButton("Carga Masiva");
        cargas.setBounds(20,300,150,25);
        cargas.setFont(new Font("Biome Light", Font.BOLD, 15));
        cargas.addActionListener(this);
        cargas.setBackground(Color.lightGray);
        this.add(cargas);
        
        //Diseño del Panel
        this.setLayout(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
