/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import Clases.Libro;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PestañaLibros extends JPanel implements ActionListener {
    
    Color rosadito = new Color(255,183,227);

    JLabel ID, libro, autor, cop, tip;
    JTextField numID, Nlibro, Aut, Copi;
    JButton regis, cargas;
    JComboBox tipo;
    static JTable tablita;
    static Object[][] datos;

    public PestañaLibros() {

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
        libro.setBounds(15, 50, 80, 30);
        libro.setFont(new Font("Biome Light", Font.BOLD, 14));
        libro.setVisible(true);
        this.add(libro);

        Nlibro = new JTextField();
        Nlibro.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        Nlibro.setBounds(100, 55, 100, 28);
        Nlibro.setVisible(true);
        Nlibro.addActionListener(this);
        this.add(Nlibro);

        //inicio Autor
        autor = new JLabel("Autor:");
        autor.setBounds(15, 90, 80, 30);
        autor.setFont(new Font("Biome Light", Font.BOLD, 14));
        autor.setVisible(true);
        this.add(autor);

        Aut = new JTextField();
        Aut.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        Aut.setBounds(100, 95, 100, 28);
        Aut.setVisible(true);
        Aut.addActionListener(this);
        this.add(Aut);

        //inicio copias
        cop = new JLabel("Copias:");
        cop.setBounds(15, 130, 80, 30);
        cop.setFont(new Font("Biome Light", Font.BOLD, 14));
        cop.setVisible(true);
        this.add(cop);

        Copi = new JTextField();
        Copi.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        Copi.setBounds(100, 135, 100, 28);
        Copi.setVisible(true);
        Copi.addActionListener(this);
        this.add(Copi);

        //combo box tipo
        tip = new JLabel("Tipo:");
        tip.setBounds(15, 170, 80, 30);
        tip.setFont(new Font("Biome Light", Font.BOLD, 14));
        tip.setVisible(true);
        this.add(tip);

        String[] tipoo = {"Libro", "Revista", "Libro Electronico"};
        tipo = new JComboBox(tipoo);
        tipo.setBounds(100, 175, 100, 28);
        tipo.addActionListener(this);

        this.add(tipo);

        //Tablaxd
        String[] encabezado = {"ID Libro", "Nombre Libro", "Autor", "Tipo", "Copias", "Disponibles", "Ocupados"};
        datos = IPC1Proyecto1_201902259.tablitalibros();
        tablita = new JTable(datos, encabezado);
        JScrollPane scroll = new JScrollPane(tablita);
        scroll.setBounds(220, 10, 725, 400);
        scroll.setVisible(true);
        this.add(scroll);

        //Boton de Registrar libros
        regis = new JButton("Registrar");
        regis.setBounds(20, 250, 115, 25);
        regis.setFont(new Font("Biome Light", Font.BOLD, 15));
        regis.addActionListener(this);
        regis.setBackground(rosadito);
        this.add(regis);

        //Boton de Carga masiva en la tabla
        cargas = new JButton("Carga Masiva");
        cargas.setBounds(20, 300, 150, 25);
        cargas.setFont(new Font("Biome Light", Font.BOLD, 15));
        cargas.addActionListener(this);
        cargas.setBackground(rosadito);
        this.add(cargas);
        

        //Diseño del Panel
        this.setLayout(null);

    }

    
    String textcont = "";
    File archivo;
    FileReader lector;
    BufferedReader buff;

    public void leerarchivo() {
        try {
            JFileChooser busc = new JFileChooser();
            int o = busc.showOpenDialog(this);
            if (o == JFileChooser.APPROVE_OPTION) {
                System.out.println(busc.getSelectedFile());
                archivo = busc.getSelectedFile();

            }
            lector = new FileReader(archivo);
            buff = new BufferedReader(lector);
            String contline;
            while ((contline = buff.readLine()) != null) {
                textcont += contline;
            }
            System.out.println(textcont);
            JsonParser JSONValue = new JsonParser();
            Object objeto = JSONValue.parse(textcont);

            JsonObject ob = (JsonObject) objeto;
            Object arreglol = ob.get("Libros");
            JsonArray arreglo = (JsonArray) arreglol;
            for (int i = 0; i < arreglo.size(); i++) {
                JsonObject li = arreglo.get(i).getAsJsonObject();
                int Id = li.get("ID").getAsInt();
                String Titulo = li.get("Titulo").getAsString();
                String Autor = li.get("Autor").getAsString();
                int Tipo = li.get("Tipo").getAsInt();
                int Copias = li.get("Copias").getAsInt();
                int Disponibles = li.get("Disponibles").getAsInt();
                int Ocupados = li.get("Ocupados").getAsInt();
                Libro nuevo = new Libro(Id, Titulo, Autor, Tipo, Copias, Disponibles, Ocupados);
                IPC1Proyecto1_201902259.crearlibro(nuevo);

            }

        } catch (Exception e) {
            System.out.println("Hubo un error :c");
        } finally {
            try {
                if (null != lector) {
                    lector.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cargas) {
            leerarchivo();
            
        } else if (ae.getSource() == regis) {
            try {
                int id = Integer.parseInt(numID.getText());
                String titulo = Nlibro.getText();
                String autor = Aut.getText();
                int copias = Integer.parseInt(Copi.getText());
                int Tipo = 0;
                switch ((String) tipo.getSelectedItem()) {
                    case "Libro":
                        Tipo = 1;
                        break;
                    case "Revista":
                        Tipo = 2;
                        break;
                    case "Libro Electronico":
                        Tipo = 3;
                        break;
                }
                if (IPC1Proyecto1_201902259.validid(id) == false) {
                    Libro nuevo = new Libro(id, titulo, autor, Tipo, copias, copias, 0);
                    IPC1Proyecto1_201902259.crearlibro(nuevo);
                    IPC1Proyecto1_201902259.verlibros();
                    numID.setText("");
                    Nlibro.setText("");
                    Aut.setText("");
                    Copi.setText("");
                    
                }
                else{
                    JOptionPane.showMessageDialog(this, "ID ya existente");
                }

            } catch (Exception e) {

            }

        }
    }

}
