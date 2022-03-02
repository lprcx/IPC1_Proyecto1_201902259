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
import javax.swing.*;

public class login extends JFrame implements ActionListener {

    //Label
    JLabel titulo, user, pass;
    JButton botlogin, botcarga;
    JTextField texuser, texpass;
    
    public login() {

        //titulo 
        titulo = new JLabel("Login");
        titulo.setBounds(150, 35, 100, 40);
        titulo.setFont(new Font("Biome Light", Font.BOLD, 32));
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de usuario
        user = new JLabel("Usuario:");
        user.setBounds(10, 125, 100, 25);
        user.setFont(new Font("Biome Light", Font.PLAIN, 20));
        user.setVisible(true);
        this.add(user);
        
        //Entrada de texto usuario
        texuser = new JTextField();
        texuser.setFont(new Font("Biome Light",Font.PLAIN,18));
        texuser.setBounds(115,125,250,30);
        texuser.setVisible(true);
        texuser.addActionListener(this);
        this.add(texuser);
        
        //label de password
        pass = new JLabel("Contraseña:");
        pass.setBounds(10, 175, 150, 25);
        pass.setFont(new Font("Biome Light", Font.PLAIN, 20));
        pass.setVisible(true);
        this.add(pass);
        
         //Entrada de texto contraseña
        texpass = new JTextField();
        texpass.setFont(new Font("Biome Light",Font.PLAIN,18));
        texpass.setBounds(140,175,225,30);
        texpass.setVisible(true);
        texpass.addActionListener(this);
        this.add(texpass);
        
        //Boton de login
        botlogin = new JButton("Ingresar");
        botlogin.setBounds(120,250,150,30);
        botlogin.setFont(new Font("Biome Light", Font.BOLD, 18));
        botlogin.addActionListener(this);
        botlogin.setBackground(Color.lightGray);
        this.add(botlogin);
        
         //Boton de carga masiva
        botcarga = new JButton("Carga Masiva");
        botcarga.setBounds(250,335,115,20);
        botcarga.setFont(new Font("Biome Light", Font.BOLD, 12));
        botcarga.addActionListener(this);
        botcarga.setBackground(Color.lightGray);
        this.add(botcarga);

        //ICONO DE LA APLICACION
        this.setIconImage(new ImageIcon(getClass().getResource("Usac_logo.png")).getImage());

        
        //ventana
        this.setTitle("Login");
        this.setLayout(null);
        this.setBounds(500, 150, 400, 400);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botlogin) {
            PantallaPrincipal p = new PantallaPrincipal();
            this.dispose();
            
        }
    }

}
