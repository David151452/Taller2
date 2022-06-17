/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Felipe Alveal Oliva - Jefe Equipo /María José Arias Valenzuela /José Barra
 * Reyes /Juan Pablo Beltrán Oñate /David Bravo Bachler /Lucianno Valdebenito
 * San Martín
 */
public class Producto {

    //Atributos de la clase producto
    private int codigo;
    private String nombre;
    private int precio;
    private String descripcion;

    //Constructor lleno para crear un objeto tipo persona con todos los atributos
    public Producto(String nombre, int precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    //Constructor vacido para poder instanciar un objeto tipo producto sin atributos
    public Producto() {
    }

    //Setters and getters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //toString
    @Override
    public String toString() {
        return "Codigo=" + codigo + " Nombre=" + nombre + " Precio=" + precio + " Descripcion=" + descripcion;
    }

}
