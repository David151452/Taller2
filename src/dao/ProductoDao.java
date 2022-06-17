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
import modelo.Producto;

/**
 *
 * @author david
 */
public class ProductoDao {

    //Atributos que establecen conexión y ejecución de query sql
    private static Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    //Constructor de la clase
    public ProductoDao() {

    }

    public boolean insertarDatos(String nombreProducto, int precio, String descripcion) {
        boolean resp = false; //Resultado de la transaccion
        try {
            con = Conector.iniciarConexion(); //inicio la conexion con la BD
            statement = con.createStatement(); //Abro la query
            String sql = "INSERT INTO producto VALUES (null, '" + nombreProducto + "', '" + precio + "', '" + descripcion + "')"; //Escribo la consulta en lenguaje SQL
            statement.executeUpdate(sql); //Ejecutando la query
            resp = true; //entrego el valor verdadero cuando se ejecuta correctamente
            statement.close(); //cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL"); //en caso de error de la query
        }
        return resp; //entrego true o false dependiendo del resultado
    }

    public boolean eliminarDatos(String nombreProductoActual) {
        boolean resp = false;
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "DELETE FROM producto WHERE nombre='" + nombreProductoActual + "'"; //Query para elminar
            if (statement.executeUpdate(sql) == 1) { //if utilizado para validar la eliminacion de un producto
                resp = true;
            }
            statement.close();//cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return resp;//entrego true o false dependiendo del resultado
    }

    public boolean actualizarDatos(String nombreProducto, int precio, String descripcion, String nombreProductoActual) {
        boolean resp = false;
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "UPDATE producto "
                    + " SET nombre = '" + nombreProducto + "', precio = '" + precio + "', descripcion='" + descripcion
                    + "' WHERE nombre='" + nombreProductoActual + "'";//Query para modificar
            if (statement.executeUpdate(sql) == 1) { //if utilizado para validar la actualizacion de un producto
                resp = true;
            }
            statement.close();//cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL");//en caso de error de la query
        }
        return resp;//entrego true o false dependiendo del resultado
    }

    public ArrayList<Producto> listarDatos() {
        ArrayList<Producto> productos = new ArrayList<>(); //Creo un ArrayList para almacenar los productos
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "SELECT * FROM producto"; //Query para obtener toda la informacion de la tabla
            resultSet = statement.executeQuery(sql); //Se obtienen los datos de la BD
            while (resultSet.next()) { //Recorriendo los datos obtenidos y almacenados en resultSet
                Producto producto = new Producto(); //Creo el producto
                producto.setCodigo(resultSet.getInt("codigo"));//asigno el codigo
                producto.setNombre(resultSet.getString("nombre")); //asigno el nombre
                producto.setPrecio(resultSet.getInt("precio")); //asigno el precio
                producto.setDescripcion(resultSet.getString("descripcion")); //asigno la descripcion
                productos.add(producto); //Agrego el producto al ArrayList de tipo Producto
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return productos; //Entrego una lista completa con la informacion de las personas
    }
}
