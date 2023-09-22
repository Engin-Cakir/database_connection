package Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String kullaniciAdi = "postgres";
        String parola = "123456";
        List<Students> studentsList = null;
        Students insertStudents = new Students("Engin", 6161010, 100.0);
        try (Connection conn = DriverManager.getConnection(jdbcUrl, kullaniciAdi, parola)) { //try-with-resource // no-needed conn.close in finally
            // Veritabanına bağlantı oluşturma

            // INSERT işlemi
            String insertSQL = "INSERT INTO students (student_name, student_number, student_grade) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSQL);
            insertStatement.setString(1, insertStudents.getStudentName());
            insertStatement.setInt(2, insertStudents.getStudentNumber());
            insertStatement.setDouble(3, insertStudents.getStudentGrade());
            int affectedRows = insertStatement.executeUpdate();
            System.out.println("INSERT işlemi sonucunda etkilenen satır sayısı: " + affectedRows);

            // SELECT işlemi
            String selectSQL = "SELECT * FROM students";
            PreparedStatement selectStatement = conn.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            studentsList = new ArrayList<>();
            while (resultSet.next()) {
                // Sonuçları işleme
                String studentName = resultSet.getString("student_name");
                int studentNumber = resultSet.getInt("student_number");
                int studentGrade = resultSet.getInt("student_grade");
                insertStudents = new Students(studentName, studentNumber, studentGrade);
                studentsList.add(insertStudents);
                System.out.println("student_name: " + studentName + ", student_number: " + studentNumber + "student_grade:" + studentGrade);
            }

            // Bağlantıyı kapatma
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(studentsList);
    }


}

