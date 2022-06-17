/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.VentanaControlador;
import dao.ProductoDao;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.Producto;

/**
 * Felipe Alveal Oliva - Jefe Equipo /María José Arias Valenzuela /José Barra
 * Reyes /Juan Pablo Beltrán Oñate /David Bravo Bachler /Lucianno Valdebenito
 * San Martín
 */
public class Ventana extends JFrame {

    //Atributos de la ventana
    //Se ponen los atributos en publico para ser estos usados dentro de la VistaControlador
    public JPanel panel;
    public JLabel nombreLB;
    public JLabel precioLB;
    public JLabel descripcionLB;
    public JLabel inventarioLB;
    public JTextField nombreTX;
    public JTextField precioTX;
    public JTextField descripcionTX;
    public JButton ingresarBTN;
    public JButton editarBTN;
    public JButton eliminarBTN;
    public JButton verBTN;
    public JTable tabla;
    public JScrollPane scroll;

    public Ventana(Producto p, ProductoDao pd) {
        //Nombre de la vista
        super("VentanaInventario");
        //Definir nombres de los atributos
        this.panel = new JPanel();
        this.nombreLB = new JLabel("Nombre:");
        this.precioLB = new JLabel("Precio:");
        this.descripcionLB = new JLabel("Descripcion:");
        this.inventarioLB = new JLabel("Inventario");
        this.nombreTX = new JTextField();
        this.precioTX = new JTextField();
        this.descripcionTX = new JTextField();
        this.ingresarBTN = new JButton("Ingresar");
        this.editarBTN = new JButton("Editar");
        this.eliminarBTN = new JButton("Eliminar");
        this.verBTN = new JButton("Ver");
        this.tabla = new JTable();
        this.scroll = new JScrollPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.agregarComponentes();

        VentanaControlador vc = new VentanaControlador(this, p, pd);
        //Se le entrega las funcionalidades a los botones mediante el ActionListener que será realiza en la clase VentanControlador
        this.ingresarBTN.addActionListener(vc);
        this.ingresarBTN.setActionCommand("crear");
        this.editarBTN.addActionListener(vc);
        this.editarBTN.setActionCommand("editar");
        this.eliminarBTN.addActionListener(vc);
        this.eliminarBTN.setActionCommand("eliminar");
        this.verBTN.addActionListener(vc);
        this.verBTN.setActionCommand("ver");
    }

    public void agregarComponentes() {
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nombre", "Precio", "Descripcion"
                }
        ));
        scroll.setViewportView(tabla);
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ingresarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(editarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(verBTN)
                                                        .addComponent(eliminarBTN)))
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(inventarioLB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                                        .addComponent(nombreLB)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nombreTX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                                        .addComponent(precioLB)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(precioTX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                                        .addComponent(descripcionLB)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(descripcionTX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(inventarioLB)
                                                .addGap(41, 41, 41)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nombreLB)
                                                        .addComponent(nombreTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(precioLB)
                                                        .addComponent(precioTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(descripcionLB)
                                                        .addComponent(descripcionTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ingresarBTN)
                                                        .addComponent(eliminarBTN))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editarBTN)
                                                        .addComponent(verBTN)))
                                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
}
