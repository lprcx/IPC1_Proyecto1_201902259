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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PestañaPrestamos extends JPanel implements ActionListener {

    JLabel IDus, librro, fecha;
    JTextField IDusu, IDlibro, date;
    JButton preslib, cargas;
    static JTable tablita2;
    static Object[][] datos2;
    Color rosadito = new Color(255,183,227);
    Color rosita = new Color(250, 219, 216 );
    Color moradito = new Color(235, 222, 240);
    Color celestito = new Color(214, 234, 248);

    public PestañaPrestamos() {
        //inicio usuario
        IDus = new JLabel("Usuario:");
        IDus.setBounds(15, 10, 80, 30);
        IDus.setFont(new Font("Biome Light", Font.BOLD, 14));
        IDus.setVisible(true);
        this.add(IDus);

        IDusu = new JTextField();
        IDusu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        IDusu.setBounds(100, 15, 100, 28);
        IDusu.setVisible(true);
        IDusu.addActionListener(this);
        this.add(IDusu);

        //inicio libro
        librro = new JLabel("Libro:");
        librro.setBounds(15, 50, 80, 30);
        librro.setFont(new Font("Biome Light", Font.BOLD, 14));
        librro.setVisible(true);
        this.add(librro);

        IDlibro = new JTextField();
        IDlibro.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        IDlibro.setBounds(100, 55, 100, 28);
        IDlibro.setVisible(true);
        IDlibro.addActionListener(this);
        this.add(IDlibro);

        //inicio fecha
        fecha = new JLabel("Fecha de entrega:");
        fecha.setBounds(15, 90, 80, 30);
        fecha.setFont(new Font("Biome Light", Font.BOLD, 14));
        fecha.setVisible(true);
        this.add(fecha);

        date = new JTextField();
        date.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        date.setBounds(100, 95, 100, 28);
        date.setVisible(true);
        date.addActionListener(this);
        this.add(date);

        //Boton prestar libro
        preslib = new JButton("Prestar libro");
        preslib.setBounds(20, 250, 150, 20);
        preslib.setFont(new Font("Biome Light", Font.BOLD, 15));
        preslib.setBackground(celestito);
        preslib.addActionListener(this);
        this.add(preslib);

        //Tabla Prestamos
        String[] encabezado2 = {"Nombre Usuario", "Libro", "Fecha de Entrega", "Status"};
        datos2 = IPC1Proyecto1_201902259.tablitaprestamos();
        tablita2 = new JTable(datos2, encabezado2);
        JScrollPane scroll = new JScrollPane(tablita2);
        scroll.setBounds(220, 10, 725, 400);
        scroll.setVisible(true);
        this.add(scroll);

        //Boton de Carga masiva en la tabla2
        cargas = new JButton("Carga Masiva");
        cargas.setBounds(20, 300, 150, 25);
        cargas.setFont(new Font("Biome Light", Font.BOLD, 15));
        cargas.addActionListener(this);
        cargas.setBackground(celestito);
        this.add(cargas);

        //Diseño del Panel
        this.setLayout(null);
        this.setBackground(moradito);

    }



    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cargas) {
            CargaPrestamos c = new CargaPrestamos();
        } else if (ae.getSource() == preslib) {
            int ide = Integer.parseInt(IDusu.getText());
            int idl = Integer.parseInt(IDlibro.getText());
            String fech = date.getText();
            DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String hoy = dtf5.format(LocalDateTime.now());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date f1 = dateFormat.parse(fech);
                Date f2 = dateFormat.parse(hoy);
                if (IPC1Proyecto1_201902259.verfus(ide) == true && IPC1Proyecto1_201902259.verlb(idl) == true) {
                    if (IPC1Proyecto1_201902259.obtenerlibro(idl).getDisponibles() != 0) {
                        if (f1.before(f2)) {
                            Prestamo nuevo = new Prestamo(ide, idl, fech, "Entregado");
                            IPC1Proyecto1_201902259.crearprestamo(nuevo);
                            IPC1Proyecto1_201902259.obtenerlibro(idl).setDisponibles(IPC1Proyecto1_201902259.obtenerlibro(idl).getDisponibles() + 1);
                            IPC1Proyecto1_201902259.obtenerlibro(idl).setOcupados(IPC1Proyecto1_201902259.obtenerlibro(idl).getOcupados() - 1);
                        } else {
                            Prestamo nuevo = new Prestamo(ide, idl, fech, "Ocupado");
                            IPC1Proyecto1_201902259.crearprestamo(nuevo);
                            IPC1Proyecto1_201902259.obtenerlibro(idl).setDisponibles(IPC1Proyecto1_201902259.obtenerlibro(idl).getDisponibles() - 1);
                            IPC1Proyecto1_201902259.obtenerlibro(idl).setOcupados(IPC1Proyecto1_201902259.obtenerlibro(idl).getOcupados() + 1);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "No existen copias disponibles");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "ID no válido");
                }

            } catch (ParseException ex) {

            }
            IPC1Proyecto1_201902259.verprestamos();

            IDusu.setText("");
            IDlibro.setText("");
            date.setText("");
        }

    }

}
