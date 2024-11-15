package BasesDatos;

import java.sql.*;

public class Ejemplo8_InsertarDep {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
            // Establecemos la conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospitalet", "user1", "Password_123");

            // Recuperar argumentos de main
            String dep = args[0];      // número de departamento
            String dnombre = args[1];  // nombre
            String loc = args[2];      // localidad

            // Construir orden INSERT
            String sql = String.format("INSERT INTO DEPT VALUES (%s, '%s', '%s')", dep, dnombre, loc);

            System.out.println(sql);

            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);
            System.out.printf("Filas afectadas: %d %n", filas);

            sentencia.close(); // Cerrar Statement
            conexion.close();  // Cerrar conexión
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
