/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
    
    Color rosita = new Color(250, 219, 216 );
    Color moradito = new Color(235, 222, 240);
    Color celestito = new Color(174, 214, 241);

    //Label
    JLabel titulo, use, pass;
    JButton botlogin, botcarga;
    JTextField texuser;
    JPasswordField texpass;
    static String user;

    public login() {

        //titulo 
        titulo = new JLabel("Login");
        titulo.setBounds(150, 35, 100, 40);
        titulo.setFont(new Font("Biome Light", Font.BOLD, 32));
        titulo.setVisible(true);
        this.add(titulo);

        //label de usuario
        use = new JLabel("Usuario:");
        use.setBounds(10, 125, 100, 25);
        use.setFont(new Font("Biome Light", Font.PLAIN, 20));
        use.setVisible(true);
        this.add(use);

        //Entrada de texto usuario
        texuser = new JTextField();
        texuser.setFont(new Font("Biome Light", Font.PLAIN, 18));
        texuser.setBounds(115, 125, 250, 30);
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
        texpass = new JPasswordField();
        texpass.setFont(new Font("Biome Light", Font.PLAIN, 18));
        texpass.setBounds(140, 175, 225, 30);
        texpass.setVisible(true);
        texpass.addActionListener(this);
        this.add(texpass);

        //Boton de login
        botlogin = new JButton("Ingresar");
        botlogin.setBounds(120, 250, 150, 30);
        botlogin.setFont(new Font("Biome Light", Font.BOLD, 18));
        botlogin.addActionListener(this);
        botlogin.setBackground(moradito);
        this.add(botlogin);

        //Boton de carga masiva
        botcarga = new JButton("Carga Masiva");
        botcarga.setBounds(250, 335, 115, 20);
        botcarga.setFont(new Font("Biome Light", Font.BOLD, 12));
        botcarga.addActionListener(this);
        botcarga.setBackground(moradito);
        this.add(botcarga);

        //ICONO DE LA APLICACION
        this.setIconImage(new ImageIcon(getClass().getResource("Usac_logo.png")).getImage());

        //ventana
        this.setTitle("Login");
        this.setLayout(null);
        this.setBounds(500, 150, 400, 400);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(rosita);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botlogin) {

            user = texuser.getText();
            String pass = texpass.getText();
            if (IPC1Proyecto1_201902259.entrusuario(user) == true) {
                if (IPC1Proyecto1_201902259.retornus(user).getPassword().equals(pass)) {
                    if (IPC1Proyecto1_201902259.retornus(user).getTipo() == 1) {
                        PantallaPrincipal p = new PantallaPrincipal();
                        this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Usuario sin permisos para acceder al sistema");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña Inválida");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no válido");
            }
        } else if (e.getSource() == botcarga) {
            CargaUsuario c = new CargaUsuario();
            this.dispose();

        }
    }

}
