package BasesDatos;

import java.sql.*;
import java.util.*;

public class Ejemplo9_InsertDepEscrito {
    public static void main(String[] args) {

        // Configuración para la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/hospitalet"; // Cambia el nombre de la BD si es necesario
        String usuario = "user1"; // Cambia a tu usuario de MySQL
        String contraseña = "Password_123"; // Cambia a tu contraseña de MySQL

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario los valores para insertar en la tabla DEPT
        System.out.print("Introduce el número de departamento (DEPT_NO): ");
        int deptNo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Introduce el nombre del departamento (DNOMBRE): ");
        String dnombre = scanner.nextLine();

        System.out.print("Introduce la localidad del departamento (LOC): ");
        String loc = scanner.nextLine();

        // Definir la sentencia SQL
        String sql = "INSERT INTO DEPT (DEPT_NO, DNOMBRE, LOC) VALUES (?, ?, ?)";

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Preparar la sentencia SQL
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            // Asignar los parámetros a la consulta
            sentencia.setInt(1, deptNo);       // Número de departamento
            sentencia.setString(2, dnombre);   // Nombre del departamento
            sentencia.setString(3, loc);       // Localidad

            // Ejecutar la sentencia
            int filas = sentencia.executeUpdate(); // Número de filas afectadas
            System.out.println("Filas afectadas: " + filas);

            // Cerrar recursos
            sentencia.close();
            conexion.close();
            scanner.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la conexión o en la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
