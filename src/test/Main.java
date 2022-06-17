/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.VentanaControlador;
import controlador.VentanaTrabajadorControlador;
import dao.ProductoDao;
import dao.TrabajadorDao;
import modelo.Producto;
import modelo.Trabajador;
import vista.Ventana;
import vista.VentanaLogin;

/**
 * Felipe Alveal Oliva - Jefe Equipo /María José Arias Valenzuela /José Barra
 * Reyes /Juan Pablo Beltrán Oñate /David Bravo Bachler /Lucianno Valdebenito
 * San Martín
 */
public class Main {

    public static void main(String[] args) {
        Producto p = new Producto();
        ProductoDao pd = new ProductoDao();
        Ventana vista1 = new Ventana(p, pd);
        //vista1.setVisible(true);
        VentanaControlador ctrl = new VentanaControlador(vista1, p, pd);
        Trabajador t = new Trabajador();
        TrabajadorDao td = new TrabajadorDao();
        VentanaLogin vista2 = new VentanaLogin(t, td, vista1, p, pd);
        vista2.setVisible(true);
        VentanaTrabajadorControlador ctrl1 = new VentanaTrabajadorControlador(vista2, t, td, vista1, p, pd);
        /*if (ctrl1.ingresar() == true) {
            vista1.setVisible(true);
        }*/
    }
}
