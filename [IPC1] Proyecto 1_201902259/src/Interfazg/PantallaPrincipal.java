/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class PantallaPrincipal extends JFrame implements ActionListener {
    private JPanel panelpestañas;
    JButton close, actualizar;
    JLabel imagen;
    Color rosadito = new Color(255,183,227);
    Color rosita = new Color(250, 219, 216 );
    Color moradito = new Color(235, 222, 240);
    Color celestito = new Color(174, 214, 241);
    Color verdi = new Color(189, 238, 194);


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
        //colores
        conjpest.setBackgroundAt(0, verdi);
        conjpest.setBackgroundAt(1, celestito);
        conjpest.setBackgroundAt(2, moradito);
        conjpest.setBackgroundAt(3, rosadito);
        
        //imagen 
        Image imag = new ImageIcon("img/c.png").getImage();
        ImageIcon imge = new ImageIcon(imag.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        imagen = new JLabel(imge);
        imagen.setLayout(null);
        imagen.setBounds(700,10, 500, 30);
        imagen.setVisible(true);
        this.add(imagen);

        
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
        this.getContentPane().setBackground(rosita);
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
