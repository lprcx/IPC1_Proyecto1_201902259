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
import javax.swing.JPanel;



public class PestañaGraficos extends JPanel implements ActionListener {
    JButton h;
    
    public PestañaGraficos() {
        
        //Boton de prueba xd
        h = new JButton("Libros");
        h.setBounds(25,80,75,20);
        h.setFont(new Font("Biome Light", Font.BOLD, 12));
        h.setBackground(Color.lightGray);
        this.add(h);
        
        
        
        //Diseño del Panel
        this.setLayout(null);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
