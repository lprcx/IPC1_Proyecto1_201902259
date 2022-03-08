/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfazg;

import Clases.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import ipc1.proyecto.pkg1_201902259.IPC1Proyecto1_201902259;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PestañaReportes extends JPanel implements ActionListener {

    JLabel tiprep;
    JButton gen;
    JComboBox tipor;
    static JTable tablita3;
    static Object[][] datos3;

    public PestañaReportes() {
        //Tipo de REporte
        tiprep = new JLabel("Tipo de Reporte:");
        tiprep.setBounds(15, 10, 120, 30);
        tiprep.setFont(new Font("Biome Light", Font.BOLD, 14));
        tiprep.setVisible(true);
        this.add(tiprep);

        //Combo Box tipo de Reporte
        String[] tipoor = {"Reportes de Usuario", "Reportes de Libros", "Reportes de Prestamos"};
        tipor = new JComboBox(tipoor);
        tipor.setBounds(140, 15, 160, 28);
        this.add(tipor);

        //Botoncito generar
        gen = new JButton("Generar Reporte");
        gen.setBounds(40, 70, 75, 20);
        gen.setFont(new Font("Biome Light", Font.BOLD, 12));
        gen.setBackground(Color.lightGray);
        gen.addActionListener(this);
        this.add(gen);

        //Tabla Prestamos
        String[] encabezado3 = {"Fecha de Generación", "Usuario", "Tipo de Reporte"};
        datos3 = IPC1Proyecto1_201902259.tablitareportes();
        tablita3 = new JTable(datos3, encabezado3);
        JScrollPane scroll = new JScrollPane(tablita3);
        scroll.setBounds(350, 10, 600, 400);
        scroll.setVisible(true);
        this.add(scroll);

        //Diseño del Panel
        this.setLayout(null);

    }

    public void reporteusuario() {
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Usuarios.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 1>"
                    + "            <tr>"
                    + "                <td>ID</td>"
                    + "                <td>Usuario</td>"
                    + "                <td>Password</td>"
                    + "                <td>Facultad</td>"
                    + "                <td>Carrera</td>"
                    + "                <td>Tipo</td>"
                    + "            </tr>";

            for (int x = 0; x < IPC1Proyecto1_201902259.contadoru(); x++) {
                if (IPC1Proyecto1_201902259.arreglou()[x] != null) {
                    cadenaHTML += "            <tr>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getId() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getUser() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getPassword() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getFacultad() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getCarrera() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglou()[x].getTipo() + "</td>"
                            + "            </tr>";
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String fecha = "reporteUsuarios_" + dtf3.format(LocalDateTime.now());
            crearPdf(cadenaHTML, fecha);

        } catch (IOException ex) {

        }
    }

    public void crearPdf(String contenido, String nombre) {
        try {

            Document document = new Document(PageSize.LETTER);
            PdfWriter.getInstance(document, new FileOutputStream(nombre + ".pdf"));

            document.open();
            document.addAuthor(login.user);
            document.addCreator("Patty");
            document.addSubject("Reporte de Usuarios");
            document.addCreationDate();
            document.addTitle("Reporte de Usuarios");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(contenido));

            document.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha = dtf3.format(LocalDateTime.now());
            Reporte nuevo = new Reporte(fecha, login.user, "Reporte1");
            IPC1Proyecto1_201902259.crearreporte(nuevo);
            JOptionPane.showMessageDialog(this, "Reporte de Usuarios generado con éxito");

        } catch (Exception e) {

        }
    }

    public void reportelibros() {
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Libros.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 1>"
                    + "            <tr>"
                    + "                <td>ID</td>"
                    + "                <td>Nombre</td>"
                    + "                <td>Autor</td>"
                    + "                <td>Tipo</td>"
                    + "                <td>Copias</td>"
                    + "                <td>Disponibles</td>"
                    + "                <td>Ocupados</td>"
                    + "            </tr>";

            for (int x = 0; x < IPC1Proyecto1_201902259.contadorl(); x++) {
                if (IPC1Proyecto1_201902259.arreglol()[x] != null) {
                    cadenaHTML += "            <tr>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getId() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getTitulo() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getAutor() + "</td>";
                    switch (IPC1Proyecto1_201902259.arreglol()[x].getTipo()) {
                        case 1:
                            cadenaHTML += "                <td>Libro</td>";
                            break;
                        case 2:
                            cadenaHTML += "                <td>Revista</td>";
                            break;
                        case 3:
                            cadenaHTML += "                <td>Libro Electrónico</td>";
                            break;
                    }
                    cadenaHTML += "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getCopias() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getDisponibles() + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglol()[x].getOcupados() + "</td>"
                            + "            </tr>";
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String fecha = " reporteLibros_" + dtf3.format(LocalDateTime.now());
            crearPdf1(cadenaHTML, fecha);

        } catch (IOException ex) {

        }
    }

    public void crearPdf1(String contenido, String nombre) {
        try {

            Document document = new Document(PageSize.LETTER);
            PdfWriter.getInstance(document, new FileOutputStream(nombre + ".pdf"));

            document.open();
            document.addAuthor(login.user);
            document.addCreator("Patty");
            document.addSubject("Reporte de Libros");
            document.addCreationDate();
            document.addTitle("Reporte de Libros");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(contenido));

            document.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha = dtf3.format(LocalDateTime.now());
            Reporte nuevo = new Reporte(fecha, login.user, "Reporte2");
            IPC1Proyecto1_201902259.crearreporte(nuevo);
            JOptionPane.showMessageDialog(this, "Reporte de Libros generado con éxito");

        } catch (Exception e) {

        }
    }

    public void reporteprestamos() {
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Prestamos.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 1>"
                    + "            <tr>"
                    + "                <td>Nombre de Usuario</td>"
                    + "                <td>Libro</td>"
                    + "                <td>Fecha de Entrega</td>"
                    + "                <td>Status</td>"
                    + "            </tr>";

            for (int x = 0; x < IPC1Proyecto1_201902259.contadorp(); x++) {
                if (IPC1Proyecto1_201902259.arreglop()[x] != null) {
                    cadenaHTML += "            <tr>"
                            + "                <td>" + IPC1Proyecto1_201902259.nameus(IPC1Proyecto1_201902259.arreglop()[x].getIdestudiante()) + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.namelib(IPC1Proyecto1_201902259.arreglop()[x].getIdlibro()) + "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglop()[x].getFecha()+ "</td>"
                            + "                <td>" + IPC1Proyecto1_201902259.arreglop()[x].getStatus() + "</td>"
                            + "            </tr>";
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String fecha = "reportePrestamos_" + dtf3.format(LocalDateTime.now());
            crearPdf2(cadenaHTML, fecha);

        } catch (IOException ex) {

        }
    }

    public void crearPdf2(String contenido, String nombre) {
        try {

            Document document = new Document(PageSize.LETTER);
            PdfWriter.getInstance(document, new FileOutputStream(nombre + ".pdf"));

            document.open();
            document.addAuthor(login.user);
            document.addCreator("Patty");
            document.addSubject("Reporte de Prestamos");
            document.addCreationDate();
            document.addTitle("Reporte de Prestamos");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(contenido));

            document.close();
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha = dtf3.format(LocalDateTime.now());
            Reporte nuevo = new Reporte(fecha, login.user, "Reporte3");
            IPC1Proyecto1_201902259.crearreporte(nuevo);
            JOptionPane.showMessageDialog(this, "Reporte de Prestamos generado con éxito");

        } catch (Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gen) {
            switch ((String) tipor.getSelectedItem()) {
                case "Reportes de Usuario":
                    reporteusuario();
                    break;
                case "Reportes de Libros":
                    reportelibros();
                    break;
                case "Reportes de Prestamos":
                    reporteprestamos();
                    break;
            }
        }
    }

}
