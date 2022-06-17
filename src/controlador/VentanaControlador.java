/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProductoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import vista.Ventana;

/**
 * Felipe Alveal Oliva - Jefe Equipo /María José Arias Valenzuela /José Barra
 * Reyes /Juan Pablo Beltrán Oñate /David Bravo Bachler /Lucianno Valdebenito
 * San Martín
 */
public class VentanaControlador implements ActionListener {

    //Se instancia los atributos necesarios para conectar el modelo,dao,vista
    private Ventana view;
    private Producto p;
    private ProductoDao pd;
    DefaultTableModel modelo;

    public VentanaControlador(Ventana view, Producto p, ProductoDao pd) {
        this.view = view;
        this.p = p;
        this.pd = pd;
    }

    /*public void iniciar() {
        view.setTitle("Vista");
        view.setLocationRelativeTo(null);
    }*/
    public void insertar() {
        //Al objeto tipo producto se le instancia las variables que se obtienen desde los JTextfield
        p.setNombre(view.nombreTX.getText());
        p.setPrecio(Integer.parseInt(view.precioTX.getText()));
        p.setDescripcion(view.descripcionTX.getText());
        //Los datos del objeto tipo Producto se les entrega a un objeto tipo ProductoDao para ser almacenados en la base de datos
        if (pd.insertarDatos(p.getNombre(), p.getPrecio(), p.getDescripcion())) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ups");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.precioTX.setText("");
        view.descripcionTX.setText("");
    }

    public void eliminar() {
        //Entrego un mensaje dependiendo del resultado de la transaccion
        if (pd.eliminarDatos(view.nombreTX.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "El producto que desea eliminar no existe en la base de datos");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.precioTX.setText("");
        view.descripcionTX.setText("");
    }

    public void ver() {
        ArrayList<Producto> personas = pd.listarDatos(); //A la lista le entrego los datos obtenidos desde el metodo del DAO
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        view.tabla.setModel(modelo);
        Object[] object = new Object[4];
        for (int i = 0; i < personas.size(); i++) {
            object[0] = personas.get(i).getCodigo();
            object[1] = personas.get(i).getNombre();
            object[2] = personas.get(i).getPrecio();
            object[3] = personas.get(i).getDescripcion();
            modelo.addRow(object);
        }
        view.tabla.setModel(modelo);
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.precioTX.setText("");
        view.descripcionTX.setText("");
    }

    public void editar() {
        /*Mediante JOptionPane.showInputDialog obtenemos los datos ingresados para luego
        ser utilizados en el metodo de tipo PersonaDao*/
        String nombreProductoActual = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea modificar");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
        int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
        String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripcion");
        if (pd.actualizarDatos(nuevoNombre, nuevoPrecio, nuevaDescripcion, nombreProductoActual) == true) {
            JOptionPane.showMessageDialog(null, "Actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error en la actualización, el producto no existe");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.precioTX.setText("");
        view.descripcionTX.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "crear") {
            insertar();
        } else if (comando == "eliminar") {
            eliminar();
        } else if (comando == "ver") {
            ver();
        } else if (comando == "editar") {
            editar();
        }
    }
}
