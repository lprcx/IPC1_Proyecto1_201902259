/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Compufire
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int tipo;
    private int copias;
    private int disponibles;
    private int ocupados;

    public Libro(int id, String titulo, String autor, int tipo, int copias, int disponibles, int ocupados) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.copias = copias;
        this.disponibles = disponibles;
        this.ocupados = ocupados;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the copias
     */
    public int getCopias() {
        return copias;
    }

    /**
     * @param copias the copias to set
     */
    public void setCopias(int copias) {
        this.copias = copias;
    }

    /**
     * @return the disponibles
     */
    public int getDisponibles() {
        return disponibles;
    }

    /**
     * @param disponibles the disponibles to set
     */
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    /**
     * @return the ocupados
     */
    public int getOcupados() {
        return ocupados;
    }

    /**
     * @param ocupados the ocupados to set
     */
    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }
    
    
}
