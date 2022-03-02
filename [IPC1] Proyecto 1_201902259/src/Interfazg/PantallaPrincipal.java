/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class PantallaPrincipal extends JFrame implements ActionListener {
    private JPanel panelpestañas;
    JButton close, actualizar;
    

    public PantallaPrincipal(){
        //Panel de pestañas
        panelpestañas = new JPanel();
        panelpestañas.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(panelpestañas);
        panelpestañas.setLayout(null);
        
        
        //Creación de Pestañas
        JTabbedPane conjpest = new JTabbedPane(JTabbedPane.TOP);
        conjpest.setBounds(10, 11, 960, 450);
        conjpest.setFont(new Font("Century Gothic",Font.PLAIN,12));
        panelpestañas.add(conjpest);
        
        PestañaLibros lib = new PestañaLibros();
        conjpest.addTab("Libros", null, lib, null);
        
        PestañaPrestamos pres = new PestañaPrestamos();
        conjpest.addTab("Prestamos", null, pres, null);
        
        PestañaReportes repor = new PestañaReportes();
        conjpest.addTab("Prestamos", null, repor, null);
        
        
        
         //ICONO DE LA APLICACION
        this.setIconImage(new ImageIcon(getClass().getResource("Usac_logo.png")).getImage());
        
        //ventana
        this.setTitle("Pantalla Principal");
        this.setLayout(null);
        this.setBounds(130,100,1000,500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
}
