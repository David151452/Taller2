/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProductoDao;
import dao.TrabajadorDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Trabajador;
import vista.Ventana;
import vista.VentanaLogin;

/**
 *
 * @author david
 */
public class VentanaTrabajadorControlador implements ActionListener {

    //Se instancia los atributos necesarios para conectar el modelo,dao,vista
    private VentanaLogin view;
    private Trabajador t;
    private TrabajadorDao td;
    private Producto p;
    private ProductoDao pd;
    private Ventana view1;
    DefaultTableModel modelo;

    public VentanaTrabajadorControlador(VentanaLogin view, Trabajador t, TrabajadorDao td, Ventana view1, Producto p, ProductoDao pd) {
        this.view = view;
        this.t = t;
        this.td = td;
        this.view1 = view1;
        this.p = p;
        this.pd = pd;
    }

    /*public void iniciar() {
        view.setTitle("Vista");
        view.setLocationRelativeTo(null);
    }*/
    public void iniciar() {
        boolean aux = false;
        ArrayList<Trabajador> trabajadores = td.listarDatos(); //A la lista le entrego los datos obtenidos desde el metodo del DAO
        String aux1 = view.nombreTX.getText();
        String aux2 = view.passwordTX.getText();
        for (int i = 0; i < trabajadores.size(); i++) {
            //El nombre puede estar escrito con mayuscula o minuscula
            if (trabajadores.get(i).getNombre().equalsIgnoreCase(aux1)) {
                //Mientras que la contraseña se debe escribir necesariamente igual a la que se encuentra en la BD
                if (trabajadores.get(i).getPassword().equals(aux2)) {
                    Ventana v1 = new Ventana(p, pd);
                    v1.setVisible(true);
                    view.nombreTX.setText("");
                    view.passwordTX.setText("");
                    this.view.setVisible(false);
                    aux = true;
                }
            }
        }
        if (aux == false) {
            JOptionPane.showMessageDialog(null, "El trabajador no existe");
        }
    }

    public void registrar() {
        //Al objeto tipo Trabajador se le instancia las variables que se obtienen desde los JTextfield
        t.setNombre(view.nombreTX.getText());
        t.setPassword(view.passwordTX.getText());
        //Los datos del objeto tipo Trabajador se les entrega a un objeto tipo TrabajadorDao para ser almacenados en la base de datos
        if (td.insertarDatos(t.getNombre(), t.getPassword())) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ups");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.passwordTX.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "iniciar") {
            iniciar();
        } else if (comando == "registrar") {
            registrar();
        }
    }
}
