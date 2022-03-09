/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import Clases.Libro;
import Clases.Prestamo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CargaPrestamos extends JFrame implements ActionListener {

    JButton regresar, botcarga;
    TextArea cuad;
    Color rosita = new Color(250, 219, 216);
    Color moradito = new Color(235, 222, 240);
    Color celestito = new Color(174, 214, 241);

    public CargaPrestamos() {
        //Area del texto 
        cuad = new TextArea();
        cuad.setBounds(10, 10, 480, 300);
        cuad.setVisible(true);
        cuad.setEditable(true);
        cuad.setFont(new Font("Consolas", Font.PLAIN, 12));
        this.add(cuad);

        //Boton de Regresar
        regresar = new JButton("Regresar");
        regresar.setBounds(90, 400, 150, 30);
        regresar.setFont(new Font("Biome Light", Font.BOLD, 18));
        regresar.addActionListener(this);
        regresar.setBackground(moradito);
        this.add(regresar);

        //Boton de carga masiva
        botcarga = new JButton("Cargar al Sistema");
        botcarga.setBounds(250, 400, 150, 30);
        botcarga.setFont(new Font("Biome Light", Font.BOLD, 12));
        botcarga.addActionListener(this);
        botcarga.setBackground(moradito);
        this.add(botcarga);

        //ventana
        this.setTitle("Carga Masiva");
        this.setLayout(null);
        this.setBounds(375, 100, 500, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(rosita);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botcarga) {
            try {

                String car = cuad.getText();
                System.out.println(car);
                if (!car.equals("") || car != null) {
                    JsonParser JSONValue = new JsonParser();
                    Object objeto = JSONValue.parse(car);

                    JsonObject ob = (JsonObject) objeto;
                    Object arreglol = ob.get("Prestamos");
                    JsonArray arreglo = (JsonArray) arreglol;
                    for (int i = 0; i < arreglo.size(); i++) {
                        JsonObject li = arreglo.get(i).getAsJsonObject();
                        int ide = li.get("IDUsuario").getAsInt();
                        String Fecha = li.get("FechaEntrega").getAsString();
                        int idel = li.get("IDLibro").getAsInt();
                        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String hoy = dtf5.format(LocalDateTime.now());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date f1 = dateFormat.parse(Fecha);
                            Date f2 = dateFormat.parse(hoy);
                            if (IPC1Proyecto1_201902259.verfus(ide) == true && IPC1Proyecto1_201902259.verlb(idel) == true) {
                                if (f1.before(f2)) {
                                    Prestamo nuevo = new Prestamo(ide, idel, Fecha, "Entregado");
                                    IPC1Proyecto1_201902259.crearprestamo(nuevo);
                                } else {
                                    Prestamo nuevo = new Prestamo(ide, idel, Fecha, "Ocupado");
                                    IPC1Proyecto1_201902259.crearprestamo(nuevo);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "ID no válido");
                            }

                        } catch (ParseException ex) {

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cuadro de texto vacío, por favor ingrese el texto");
                }
                IPC1Proyecto1_201902259.verprestamos();
                JOptionPane.showMessageDialog(this, "Libros Cargados Exitosamente c:");
            } catch (Exception e) {

            }

        } else if (ae.getSource() == regresar) {
            PestañaPrestamos l = new PestañaPrestamos();
            this.dispose();
        }

    }

}
