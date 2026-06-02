package job_portal_system;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import job_portal_system.ui.main_screen;
import job_portal_system.dao.DBConnection;

public class App {
    /** shared DB connection for the whole app */
    public static Connection conn;

    public static void main(String[] args) {
        // 1) Establish your connection via DBConnection
        try {
            conn = DBConnection.get();
            System.out.println("✔ Database connected");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Unable to connect to database:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }

        // 2) Launch your Swing UI on the Event‑Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            main_screen frame = new main_screen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);   // ⬅️ this centers your window
            frame.setVisible(true);
        });
    }
}
