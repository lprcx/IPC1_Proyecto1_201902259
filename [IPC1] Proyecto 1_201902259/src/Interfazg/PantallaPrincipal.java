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
import javax.swing.border.EmptyBorder;



public class PantallaPrincipal extends JFrame implements ActionListener {
    private JPanel panelpestañas;
    JButton close, actualizar;
    Color rosadito = new Color(255,183,227);


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
        conjpest.addTab("Reportes", null, repor, null);
        
        PestañaGraficos graf = new PestañaGraficos();
        conjpest.addTab("Graficos", null, graf, null);
        
          //Boton Actualizar
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(750, 5, 150, 20);
        actualizar.setFont(new Font("Biome Light", Font.BOLD, 15));
        actualizar.setBackground(rosadito);
        actualizar.addActionListener(this);
        this.add(actualizar);
        
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
        if (e.getSource()==actualizar) {
            PantallaPrincipal p = new PantallaPrincipal();
            this.dispose();
        }
    }
    
}
