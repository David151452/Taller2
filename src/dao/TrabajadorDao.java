/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Trabajador;

/**
 *
 * @author david
 */
public class TrabajadorDao {
    //Atributos que establecen conexión y ejecución de query sql

    private static Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    //constructor de clase
    public TrabajadorDao() {
    }

    public boolean insertarDatos(String nombreTrabajador, String password) {
        boolean resp = false; //Resultado de la transaccion
        try {
            con = Conector.iniciarConexion(); //inicio la conexion con la BD
            statement = con.createStatement(); //Abro la query
            String sql = "INSERT INTO trabajador VALUES (null, '" + nombreTrabajador + "', '" + password + "')"; //Escribo la consulta en lenguaje SQL
            statement.executeUpdate(sql); //Ejecutando la query
            resp = true; //entrego el valor verdadero cuando se ejecuta correctamente
            statement.close(); //cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL"); //en caso de error de la query
        }
        return resp; //entrego true o false dependiendo del resultado
    }

    public ArrayList<Trabajador> listarDatos() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>(); //Creo un ArrayList para almacenar los trabajadores
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "SELECT * FROM trabajador"; //Query para obtener toda la informacion de la tabla
            resultSet = statement.executeQuery(sql); //Se obtienen los datos de la BD
            while (resultSet.next()) { //Recorriendo los datos obtenidos y almacenados en resultSet
                Trabajador trabajador = new Trabajador(); //Creo el producto
                trabajador.setNombre(resultSet.getString("nombre")); //asigno el nombre
                trabajador.setPassword(resultSet.getString("password")); //asigno la contraseña
                trabajadores.add(trabajador); //Agrego el trabajador al ArrayList de tipo Trabajador
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return trabajadores; //Entrego una lista completa con la informacion de los trabajadores
    }
}
