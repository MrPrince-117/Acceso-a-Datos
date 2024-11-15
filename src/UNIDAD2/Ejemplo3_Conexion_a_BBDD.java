package UNIDAD2;

import java.sql.*;

public class Ejemplo3_Conexion_a_BBDD {
    public class Ejemplo3_Conecxion_a_BDD {
        private static final String url = "jdbc:mysql://localhost/prueba1";
        private static final String user = "prueba1";
        private static final String password = "prueba1";

        private static Connection conectar() {
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error en la conexión: " + e.getMessage());
                return null;
            }
        }

        private static Statement crearStatement(Connection con) {
            try {
                return con.createStatement();
            } catch (SQLException e) {
                System.out.println("Error al crear el statement: " + e.getMessage());
                return null;
            }
        }

        private static void hacerConsulta(Statement instruccion) {
            try {
                String consulta = "SELECT * FROM notas";
                ResultSet resultado = instruccion.executeQuery(consulta);
                while (resultado.next()) {
                    System.out.println("------------------");
                    int idnota = resultado.getInt("idnota");
                    System.out.println("Id de la nota: "+idnota);
                    String nombreasig = resultado.getString("nombreasig");
                    System.out.println("Nombre de la asignatura: "+nombreasig);
                    int nota = resultado.getInt("nota");
                    System.out.println("Nota: "+nota);
                    int Codalumno = resultado.getInt("Codalumno");
                    System.out.println("Codigo del alumno: "+Codalumno);
                    System.out.println("------------------");
                }
                resultado.close();
            } catch (SQLException e) {
                System.out.println("Error al hacer la consulta: " + e.getMessage());
            }
        }

        private static void cerrar(Connection con, Statement instruccion) {
            try {
                instruccion.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            Connection con = conectar();
            Statement instrucion = crearStatement(con);
            hacerConsulta(instrucion);
            cerrar(con, instrucion);
        }//Fin main
    }//Fin Ejemplo
}
