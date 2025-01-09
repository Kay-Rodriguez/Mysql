import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    public JPanel mainPanel;
    private JPasswordField passwordField1;
    private JTextField logintxt;
    private JButton button1;

    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
                        String user = "root";
                        String password = "123456";


                        try{

                            Connection con = DriverManager.getConnection(url, user, password);
                            System.out.println("Se a conectado con la base de datos");

                            JFrame frame = new JFrame("----------------- mi login  -----------------");
                            frame.setContentPane( new Formulario().mainPanel2);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(800, 600);
                            frame.setPreferredSize(new Dimension(800, 600));
                            frame.pack();
                            frame.setVisible(true);

                           /*
                            Statement stmt=con.createStatement();
                            String parametro = logintxt.getText();
                            String contraseña= logintxt.getText();


                            String query = "SELECT * FROM  estudiantes where cedula= "+parametro;



                            ResultSet rs =stmt.executeQuery(query);
                            while (rs.next()){
                                System.out.println(rs.getString("cedula"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("b1"));
                                System.out.println(rs.getString("b2"));
                            }
                            con.close();*/

                        }catch( SQLException el){
                            throw new RuntimeException(el);

                    }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

