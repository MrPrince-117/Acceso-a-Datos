package BasesDatos;
import java.sql.*;

public class EjemploDataBaseMetaDatos {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
            // Establecemos la conexión con la base de datos hospital
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hospitalet", "user1", "Password_123");

            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = null;

            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("====================================");
            System.out.printf("Nombre: %s %n", nombre);
            System.out.printf("Driver : %s %n", driver);
            System.out.printf("URL : %s %n", url);
            System.out.printf("Usuario: %s %n", usuario);
            resul = dbmd.getTables(null, "user1", null, null);
            while (resul.next()) {
                String catalogo = resul.getString(1);
                String esquema = resul.getString(2);
                String tabla = resul.getString(3);
                String tipo = resul.getString(4);
                System.out.printf("Esquema: %s - Catálogo: %s, Esquema: %s, Tabla: %s%n", tipo, catalogo, esquema, tabla);
            }
            System.out.println("\nCOLUMNAS TABLA EMPLEADOS:");
            System.out.println("====================================");
            ResultSet columnas = null;
            columnas = dbmd.getColumns(null, "hospitalet", "EMP", null);
            while (columnas.next()) {
                String nombCol = columnas.getString("COLUMN_NAME");  // getString(4)
                String tipoCol = columnas.getString("TYPE_NAME");    // getString(6)
                String tamCol = columnas.getString("COLUMN_SIZE");   // getString(7)
                String nula = columnas.getString("IS_NULLABLE");     // getString(18)
                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula?: %s %n", nombCol, tipoCol, tamCol, nula);
            }
            ResultSet pk = dbmd.getPrimaryKeys(null, "hospitalet", "EMP");
            String pkDep = "", separador = "";
            while (pk.next()) {
                pkDep = pkDep + separador + pk.getString("COLUMN_NAME"); // getString(4)
                separador = "+";
            }
            System.out.println("Clave Primaria: " + pkDep);
            ResultSet proc = dbmd.getProcedures(null, "ejemplo", null);
            while (proc.next()) {
                String proc_name = proc.getString("PROCEDURE_NAME");
                String proc_type = proc.getString("PROCEDURE_TYPE");
                System.out.printf("Nombre Procedimiento: %s - Tipo: %s%n", proc_name, proc_type);
            }
            proc.close();


            conexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // fin de main
}



