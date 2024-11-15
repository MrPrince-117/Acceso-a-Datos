package BasesDatos;

import java.sql.*;

public class EjemploResultSetMetadata {
    public static void main(String[] args) {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hospitalet", "user1", "Password_123");

            // Create a statement and execute a query on the DEPT table
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM DEPT");

            // Get metadata about the result set
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get the number of columns
            int nColumnas = rsmd.getColumnCount();
            System.out.printf("Número de columnas recuperadas: %d%n", nColumnas);

            // Loop through each column and print metadata information
            for (int i = 1; i <= nColumnas; i++) {
                System.out.printf("Columna %d:%n", i);
                System.out.printf(" Nombre: %s%n", rsmd.getColumnName(i));
                System.out.printf(" Tipo: %s%n", rsmd.getColumnTypeName(i));

                // Check if the column can be null
                String nula = (rsmd.isNullable(i) == ResultSetMetaData.columnNullable) ? "SI" : "NO";
                System.out.printf(" Puede ser nula?: %s%n", nula);

                // Print the maximum column width
                System.out.printf(" Máximo ancho de la columna: %d%n", rsmd.getColumnDisplaySize(i));
            }

            // Close the resources
            rs.close();
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de la base de datos.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de SQL.");
            e.printStackTrace();
        }
    }
}
