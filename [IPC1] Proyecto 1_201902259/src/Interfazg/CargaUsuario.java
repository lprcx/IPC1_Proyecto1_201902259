/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import Clases.Libro;
import Clases.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Compufire
 */
public class CargaUsuario extends JFrame implements ActionListener {

    JButton regresar, botcarga;
    TextArea cuad;

    public CargaUsuario() {
        //Area del texto 
        cuad = new TextArea();
        cuad.setBounds(10, 10, 480, 300);
        cuad.setVisible(true);
        cuad.setEditable(true);
        cuad.setFont(new Font("Biome Light", Font.PLAIN, 18));
        this.add(cuad);

        //Boton de login
        regresar = new JButton("Regresar");
        regresar.setBounds(90, 400, 150, 30);
        regresar.setFont(new Font("Biome Light", Font.BOLD, 18));
        regresar.addActionListener(this);
        regresar.setBackground(Color.lightGray);
        this.add(regresar);

        //Boton de carga masiva
        botcarga = new JButton("Cargar al Sistema");
        botcarga.setBounds(250, 400, 150, 30);
        botcarga.setFont(new Font("Biome Light", Font.BOLD, 12));
        botcarga.addActionListener(this);
        botcarga.setBackground(Color.lightGray);
        this.add(botcarga);

        //ventana
        this.setTitle("Carga Masiva");
        this.setLayout(null);
        this.setBounds(375, 100, 500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botcarga) {
            try {

                String car = cuad.getText();
                //System.out.println(car);
                if (!car.equals("") || car != null) {
                    JsonParser JSONValue = new JsonParser();
                    Object objeto = JSONValue.parse(car);
                    JsonObject ob = (JsonObject) objeto;
                    Object arreglol = ob.get("Usuarios");
                    JsonArray arreglo = (JsonArray) arreglol;
                    for (int i = 0; i < arreglo.size(); i++) {
                        JsonObject li = arreglo.get(i).getAsJsonObject();
                        int Id = li.get("ID").getAsInt();
                        String Usuario = li.get("Usuario").getAsString();
                        String Password = li.get("Password").getAsString();
                        int Tipo = li.get("Tipo").getAsInt();
                        String Facultad = li.get("Facultad").getAsString();
                        String Carrera = li.get("Carrera").getAsString();
                        Usuario nuevo = new Usuario(Id, Usuario, Password, Facultad, Carrera, Tipo);
                        IPC1Proyecto1_201902259.crearuser(nuevo);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cuadro de texto vacío, por favor ingrese el texto");
                }
                IPC1Proyecto1_201902259.verusuarios();
                JOptionPane.showMessageDialog(this, "Usuarios Cargados Exitosamente c:");
            } catch (Exception e) {

            }

        } else if (ae.getSource() == regresar) {
            login l = new login();
            this.dispose();
        }

    }

}
