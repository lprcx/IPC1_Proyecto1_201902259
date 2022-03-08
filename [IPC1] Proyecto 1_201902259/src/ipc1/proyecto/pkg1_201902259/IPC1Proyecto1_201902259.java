package ipc1.proyecto.pkg1_201902259;

import Interfazg.login;
import Clases.*;
import Interfazg.PantallaPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IPC1Proyecto1_201902259 {

    //Creación del arreglo de libros
    static Libro[] libros = new Libro[100];
    static int contlibros = 0;
    //Creación de arreglo de usuarios
    static Usuario[] usuarios = new Usuario[50];
    static int contusers = 0;
    //Creación de arreglo de prestamos
    static Prestamo[] prestamos = new Prestamo[200];
    static int contpres = 0;
    //CReación de arreglo de reportes
    static Reporte[] reportes = new Reporte[100];
    static int contrep = 0;

    public static void main(String[] args) {

        login ventana = new login();
        //PantallaPrincipal p = new PantallaPrincipal();

    }

    //Metodo para guardar el libro en el arreglo de libros
    public static void crearlibro(Libro nuevo) {
        if (contlibros < libros.length) {
            libros[contlibros] = nuevo;
            contlibros++;

        }
    }

    public static void verlibros() {
        for (int i = 0; i < contlibros; i++) {
            System.out.println("----------------------------------------------");
            if (libros[i] != null) {
                System.out.println("ID: " + libros[i].getId());
                System.out.println("Nombre del Libro: " + libros[i].getTitulo());
                System.out.println("Autor: " + libros[i].getAutor());
                System.out.println("Copias: " + libros[i].getCopias());
                System.out.println("Tipo: " + libros[i].getTipo());
                System.out.println("Disponibles: " + libros[i].getDisponibles());
                System.out.println("Ocupados: " + libros[i].getOcupados());

            }

        }
    }

    public static Libro obtenerlibro(int id) {
        for (int i = 0; i < contlibros; i++) {
            if (id == libros[i].getId()) {
                return libros[i];
            }
        }
        return null;
    }

    public static Object[][] tablitalibros() {
        Object[][] contenido = new Object[contlibros][7];
        for (int i = 0; i < contlibros; i++) {
            contenido[i][0] = libros[i].getId();
            contenido[i][1] = libros[i].getTitulo();
            contenido[i][2] = libros[i].getAutor();
            switch (libros[i].getTipo()) {
                case 1:
                    contenido[i][3] = "Libro";
                    break;
                case 2:
                    contenido[i][3] = "Revista";
                    break;
                case 3:
                    contenido[i][3] = "Libro Electronico";
                    break;
            }
            contenido[i][4] = libros[i].getCopias();
            contenido[i][5] = libros[i].getDisponibles();
            contenido[i][6] = libros[i].getOcupados();

        }
        return contenido;
    }

    public static boolean validid(int id) {
        for (int i = 0; i < contlibros; i++) {
            if (id == libros[i].getId()) {
                return true;
            }
        }
        return false;
    }

    //Metodo para guardar los usuarios en el arreglo de usuarios
    public static void crearuser(Usuario nuevo) {
        if (contusers < usuarios.length) {
            usuarios[contusers] = nuevo;
            contusers++;

        }
    }

    public static void verusuarios() {
        for (int i = 0; i < contusers; i++) {
            System.out.println("----------------------------------------------");
            if (usuarios[i] != null) {
                System.out.println("ID: " + usuarios[i].getId());
                System.out.println("Usuario: " + usuarios[i].getUser());
                System.out.println("Password: " + usuarios[i].getPassword());
                System.out.println("Facultad: " + usuarios[i].getFacultad());
                System.out.println("Carrera: " + usuarios[i].getCarrera());
                System.out.println("Tipo: " + usuarios[i].getTipo());

            }

        }
    }

    //validando si el usuario existe 
    public static boolean entrusuario(String us) {
        for (int i = 0; i < contusers; i++) {
            if (us.equals(usuarios[i].getUser())) {
                return true;
            }
        }
        return false;
    }//parte de la validación del usuario, como contraseña

    public static boolean passusuario(String pas) {
        for (int i = 0; i < contusers; i++) {
            if (pas.equals(usuarios[i].getPassword())) {
                return true;

            }

        }
        return false;
    }

    public static Usuario retornus(String us) {
        for (int i = 0; i < contusers; i++) {
            if (us.equals(usuarios[i].getUser())) {
                return usuarios[i];
            }

        }
        return null;
    }

    //Metodo para guardar los prestamos
    public static void crearprestamo(Prestamo nuevo) {
        if (contpres < prestamos.length) {
            prestamos[contpres] = nuevo;
            contpres++;

        }
    }

    public static void verprestamos() {
        for (int i = 0; i < contpres; i++) {
            System.out.println("----------------------------------------------");
            if (prestamos[i] != null) {
                System.out.println("ID Libro: " + prestamos[i].getIdlibro());
                System.out.println("ID Usuario: " + prestamos[i].getIdestudiante());
                System.out.println("Fecha: " + prestamos[i].getFecha());
                System.out.println("Status: " + prestamos[i].getStatus());

            }

        }
    }

    //función para retornar el nombre del usuario por medio del Id
    public static String nameus(int Id) {
        for (int i = 0; i < contusers; i++) {
            if (Id == usuarios[i].getId()) {
                return usuarios[i].getUser();
            }
        }
        return null;
    }

    public static String namelib(int Id) {
        for (int i = 0; i < contlibros; i++) {
            if (Id == libros[i].getId()) {
                return libros[i].getTitulo();
            }
        }
        return null;
    }

    //Validaciones para verificar que exista el usuario   
    public static boolean verfus(int Id) {
        for (int i = 0; i < contusers; i++) {
            if (Id == usuarios[i].getId()) {
                return true;
            }
        }
        return false;
    }

    //Validaciones para verificar que exista el libro
    public static boolean verlb(int Id) {
        for (int i = 0; i < contlibros; i++) {
            if (Id == libros[i].getId()) {
                return true;
            }
        }
        return false;
    }

    public static Object[][] tablitaprestamos() {
        Object[][] contenido = new Object[contpres][4];
        for (int i = 0; i < contpres; i++) {
            contenido[i][0] = nameus(prestamos[i].getIdestudiante()); //se llamó la funcion nameus para retornar el nombre del usuario por medio del ID
            contenido[i][1] = namelib(prestamos[i].getIdlibro()); //se llamó a namelib para obtener el titulo del libro
            contenido[i][2] = prestamos[i].getFecha();
            contenido[i][3] = prestamos[i].getStatus();

        }
        return contenido;
    }

    //funcion para retornar cantidad de usuarios tipo1
    public static int ust1() {
        int contador = 0;
        for (int i = 0; i < contusers; i++) {
            if (usuarios[i].getTipo() == 1) {
                contador++;
            }
        }
        return contador;
    }

    //funcion para retornar cantidad de usuarios tipo2
    public static int ust2() {
        int contador = 0;
        for (int i = 0; i < contusers; i++) {
            if (usuarios[i].getTipo() == 2) {
                contador++;
            }
        }
        return contador;
    }

    //funcion para retornar la cantidad de libros
    public static int tl1() {
        int contador = 0;
        for (int i = 0; i < contlibros; i++) {
            if (libros[i].getTipo() == 1) {
                contador++;
            }
        }
        return contador;
    }

    //funcion para retornar la cantidad de revistas
    public static int tl2() {
        int contador = 0;
        for (int i = 0; i < contlibros; i++) {
            if (libros[i].getTipo() == 2) {
                contador++;
            }
        }
        return contador;
    }

    //funcion para retornar la cantidad de libros electronicos
    public static int tl3() {
        int contador = 0;
        for (int i = 0; i < contlibros; i++) {
            if (libros[i].getTipo() == 3) {
                contador++;
            }
        }
        return contador;
    }

    //funciones para retornar la cantidad de libros prestados de cada mes
    public static int enero() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("0")) {
                    contador++;

                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int febrero() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("1")) {
                    contador++;

                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int marzo() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("2")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int abril() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("3")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int mayo() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("4")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int junio() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("5")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int julio() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("6")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int agosto() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("7")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int septiembre() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("8")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int octubre() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("9")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int noviembre() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("10")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int diciembre() {
        int contador = 0;
        for (int i = 0; i < contpres; i++) {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = f.parse(prestamos[i].getFecha());
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (String.valueOf(c.get(Calendar.MONTH)).equals("11")) {
                    contador++;
                }
            } catch (Exception e) {

            }

        }
        return contador;
    }

    public static int contadoru() {
        return contusers;
    }

    public static Usuario[] arreglou() {
        return usuarios;
    }

    //Metodo para guardar el libro en el arreglo de libros
    public static void crearreporte(Reporte nuevo) {
        if (contrep < reportes.length) {
            reportes[contrep] = nuevo;
            contrep++;

        }
    }


    public static Object[][] tablitareportes() {
        Object[][] contenido = new Object[contrep][3];
        for (int i = 0; i < contrep; i++) {
            contenido[i][0] = reportes[i].getFecha();
            contenido[i][1] = reportes[i].getUsuario();
            contenido[i][2] = reportes[i].getTipo();
                       
        }
        return contenido;
    }

    
     public static int contadorl() {
        return contlibros;
    }

    public static Libro[] arreglol() {
        return libros;
    }
    
    public static int contadorp() {
        return contpres;
    }

    public static Prestamo[] arreglop() {
        return prestamos;
    }
}
