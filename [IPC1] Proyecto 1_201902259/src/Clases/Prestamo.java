/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Compufire
 */
public class Prestamo {
    
    private int idlibro;
    private int idestudiante;
    private String fecha;
    private String status;

    public Prestamo(int idlibro, int idestudiante, String fecha, String status) {
        this.idlibro = idlibro;
        this.idestudiante = idestudiante;
        this.fecha = fecha;
        this.status = status;
    }

    /**
     * @return the idlibro
     */
    public int getIdlibro() {
        return idlibro;
    }

    /**
     * @param idlibro the idlibro to set
     */
    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    /**
     * @return the idestudiante
     */
    public int getIdestudiante() {
        return idestudiante;
    }

    /**
     * @param idestudiante the idestudiante to set
     */
    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
