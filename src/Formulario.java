import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class Formulario {
    public JPanel mainPanel2;
    private JTable table1;

    public Formulario() {
        String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
        String user = "root";
        String password = "123456";

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setNumRows(0);
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("b1");
        model.addColumn("b2");


        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM  estudiantes";
            ResultSet rs =stmt.executeQuery(query);

        while (rs.next()){
            model.addRow(new Object[]{rs.getString("Cedula"),rs.getString("Nombre"),rs.getString("b1"),rs.getString("b2")});
        }
        conn.close();

    } catch (Exception e) {throw new RuntimeException(e);

        }
    }

}


