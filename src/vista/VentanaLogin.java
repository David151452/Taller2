/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.VentanaTrabajadorControlador;
import dao.ProductoDao;
import dao.TrabajadorDao;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Producto;
import modelo.Trabajador;

/**
 * Felipe Alveal Oliva - Jefe Equipo /María José Arias Valenzuela /José Barra
 * Reyes /Juan Pablo Beltrán Oñate /David Bravo Bachler /Lucianno Valdebenito
 * San Martín
 */
public class VentanaLogin extends JFrame {

    //Atributos de la ventana
    //Se ponen los atributos en publico para ser estos usados dentro de la VistaControlador
    public JPanel panel;
    public JLabel iniciarSesionLB;
    public JLabel nombreLB;
    public JLabel passwordLB;
    public JTextField nombreTX;
    public JTextField passwordTX;
    public JButton registrarBTN;
    public JButton iniciarBTN;

    public VentanaLogin(Trabajador t, TrabajadorDao td, Ventana view1, Producto p, ProductoDao pd) {
        super("Ventana Login");
        this.panel = new JPanel();
        this.iniciarSesionLB = new JLabel("Iniciar Sesion");
        this.nombreLB = new JLabel("Nombre:");
        this.passwordLB = new JLabel("Password:");
        this.nombreTX = new JTextField();
        this.passwordTX = new JTextField();
        this.registrarBTN = new JButton("Registrar");
        this.iniciarBTN = new JButton("Iniciar Sesion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.agregarComponentes();

        VentanaTrabajadorControlador vc = new VentanaTrabajadorControlador(this, t, td, view1, p, pd);
        this.registrarBTN.addActionListener(vc);
        this.registrarBTN.setActionCommand("registrar");
        this.iniciarBTN.addActionListener(vc);
        this.iniciarBTN.setActionCommand("iniciar");

    }

    public void agregarComponentes() {
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(iniciarSesionLB))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(passwordLB)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(passwordTX))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(nombreLB)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(nombreTX, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(88, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(registrarBTN)
                                .addGap(18, 18, 18)
                                .addComponent(iniciarBTN)
                                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(iniciarSesionLB)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nombreLB)
                                        .addComponent(nombreTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLB)
                                        .addComponent(passwordTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(iniciarBTN)
                                        .addComponent(registrarBTN))
                                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
