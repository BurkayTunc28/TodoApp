package org.example.todoapp;
import java.sql.*;

public class DatenBank {
    public static void main(String[] args) {

        verbinden();
        tabelleErstellen();
    }

    public static void verbinden(){
        /*
      Jetzt, wo wir verbunden sind, lassen uns eine Tabelle erstellen.
      Denke an eine Tabelle als eine Tabelle in deiner Datenbank.
      Wir werden eine einfache "students" Tabelle erstellen.
         * **/

        Connection conn = null;
        try {
            String url = "jdbc:sqlite:todoapp.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Verbindung zu SQLite erfolgreich hergestellt.");
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void tabelleErstellen(){

        /*
         Dieser Code erstellt eine Tabelle namens "students"
         mit drei Spalten: id, name und grade. Der Teil "IF NOT EXISTS" ist wie ein höfliches Klopfen an der Tür
         es überprüft, ob die Tabelle bereits existiert, bevor es versucht, sie zu erstellen.
         * **/


        String url = "jdbc:sqlite:todoapp.db";

        String sql = "CREATE TABLE IF NOT EXISTS elemente (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "grade INTEGER" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle erfolgreich erstellt!");
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void einfuegen(){
        /*
         * Dieser Code fügt zwei Schüler
         * in unsere Tabelle ein. Die "?" in der SQL-Anweisung sind Platzhalter,
         * die wir mit setString() und setInt() füllen. Es ist wie das Ausfüllen von Lücken in einem Satz!
         * **/

                String url = "jdbc:sqlite:todoapp.db";
        String sql = "INSERT INTO elemente(name,grade) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 85);
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 90);
            pstmt.executeUpdate();

            System.out.println("Daten erfolgreich eingefügt!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lesen(){

        /*
         Dieser Code ruft alle Daten aus unserer "elemente"
         Tabelle ab und gibt sie aus. Die while-Schleife ist wie
         das Durchgehen jeder Zeile unserer Tabelle nacheinander.
         * **/

        String url = "jdbc:sqlite:todoapp.db";
        String sql = "SELECT id, name, grade FROM elemente";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("grade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updated(){
        String url = "jdbc:sqlite:todoapp.db";
        String sql = "UPDATE elemente SET grade = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 95);
            pstmt.setString(2, "Alice");
            pstmt.executeUpdate();
            System.out.println("Daten erfolgreich aktualisiert!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loeschen(){
        String url = "jdbc:sqlite:todoapp.db";
        String sql = "DELETE FROM elemente WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Bob");
            pstmt.executeUpdate();
            System.out.println("Daten erfolgreich gelöscht!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

