
package ipc1.proyecto.pkg1_201902259;
import Interfazg.login;
import Clases.*;
import Interfazg.PantallaPrincipal;

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
    public static void crearlibro(Libro nuevo){
        if (contlibros < libros.length) {
            libros[contlibros] = nuevo;
            contlibros++;
            
        }
    }
    
    public static void verlibros(){
        for (int i = 0; i < contlibros; i++) {
            System.out.println("----------------------------------------------");
            if (libros[i]!=null) {
                System.out.println("ID: " + libros[i].getId());
                System.out.println("Nombre del Libro: " + libros[i].getTitulo());
                System.out.println("Autor: " + libros[i].getAutor());
                System.out.println("Copias: "+ libros[i].getCopias());
                System.out.println("Tipo: " + libros[i].getTipo());
                System.out.println("Disponibles: " + libros[i].getDisponibles());
                System.out.println("Ocupados: " + libros[i].getOcupados());
                
            }
            
        }
    }
    public static Libro obtenerlibro(int id){
        for (int i = 0; i < contlibros; i++) {
            if (id==libros[i].getId()) {
                return libros[i];
            }
        } return null;
    } 
    
    public static Object[][] tablitalibros(){
        Object[][] contenido = new Object[contlibros][7];
        for (int i = 0; i < contlibros; i++) {
            contenido[i][0] = libros[i].getId();
            contenido[i][1] = libros[i].getTitulo();
            contenido[i][2] = libros[i].getAutor();
            switch(libros[i].getTipo()){
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
    
    public static boolean validid(int id){
        for (int i = 0; i < contlibros; i++) {
            if (id==libros[i].getId()) {
                return true;
            }
        }
        return false;
    }
    
     //Metodo para guardar los usuarios en el arreglo de usuarios
    public static void crearuser(Usuario nuevo){
        if (contusers < usuarios.length) {
            usuarios[contusers] = nuevo;
            contusers++;
            
        }
    }
    
    public static void verusuarios(){
        for (int i = 0; i < contusers; i++) {
            System.out.println("----------------------------------------------");
            if (usuarios[i]!=null) {
                System.out.println("ID: " + usuarios[i].getId());
                System.out.println("Usuario: " + usuarios[i].getUser());
                System.out.println("Password: " + usuarios[i].getPassword());
                System.out.println("Facultad: "+ usuarios[i].getFacultad());
                System.out.println("Carrera: " + usuarios[i].getCarrera());
                System.out.println("Tipo: " + usuarios[i].getTipo());
                               
                
            }
            
        }
    }
    //validando si el usuario existe 
    public static boolean entrusuario(String us){
        for (int i = 0; i < contusers; i++) {
            if (us.equals(usuarios[i].getUser())) {
                return true;
            }
        }
        return false;
    }//parte de la validación del usuario, como contraseña
    public static boolean passusuario(String pas){
        for (int i = 0; i < contusers; i++) {
            if (pas.equals(usuarios[i].getPassword())) {
                return true;
                
            }
            
        }
        return false;
    }
    public static Usuario retornus(String us){
        for (int i = 0; i < contusers; i++) {
            if (us.equals(usuarios[i].getUser())) {
                return usuarios[i];
            }
            
        }
        return null;
    }
    
     //Metodo para guardar los prestamos
    public static void crearprestamo(Prestamo nuevo){
        if (contpres < prestamos.length) {
            prestamos[contpres] = nuevo;
            contpres++;
            
        }
    }
    
    public static void verprestamos(){
        for (int i = 0; i < contpres; i++) {
            System.out.println("----------------------------------------------");
            if (prestamos[i]!=null) {
                System.out.println("ID Libro: " + prestamos[i].getIdlibro());
                System.out.println("ID Usuario: " + prestamos[i].getIdestudiante());
                System.out.println("Fecha: " + prestamos[i].getFecha());
                System.out.println("Status: "+ prestamos[i].getStatus());
                
                               
                
            }
            
        }
    }
    //función para retornar el nombre del usuario por medio del Id
    public static String nameus(int Id){
        for (int i = 0; i < contusers; i++) {
            if (Id == usuarios[i].getId()) {
                return usuarios[i].getUser();
            }
        }return null;
    }
       public static String namelib(int Id){
        for (int i = 0; i < contlibros; i++) {
            if (Id == libros[i].getId()) {
                return libros[i].getTitulo();
            }
        }return null;
    }
    //Validaciones para verificar que exista el usuario   
    public static boolean verfus(int Id){
        for (int i = 0; i < contusers; i++) {
            if (Id == usuarios[i].getId()) {
                return true;
            }
        }return false;
    }
    //Validaciones para verificar que exista el libro
       public static boolean verlb(int Id){
        for (int i = 0; i < contlibros; i++) {
            if (Id == libros[i].getId()) {
                return true;
            }
        }return false;
    }
 
    
    public static Object[][] tablitaprestamos(){
        Object[][] contenido = new Object[contpres][4];
        for (int i = 0; i < contpres; i++) {
            contenido[i][0] = nameus(prestamos[i].getIdestudiante()); //se llamó la funcion nameus para retornar el nombre del usuario por medio del ID
            contenido[i][1] = namelib(prestamos[i].getIdlibro()); //se llamó a namelib para obtener el titulo del libro
            contenido[i][2] = prestamos[i].getFecha();
            contenido[i][3] = prestamos[i].getStatus();
                      
                      
        }
        return contenido;
    }
}
