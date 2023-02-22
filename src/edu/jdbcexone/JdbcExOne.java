package edu.jdbcexone;

import java.sql.*;

public class JdbcExOne {
    private static void printData(
            ResultSet srs, String col1, String col2, String col3) throws SQLException {
        System.out.println("name\t|\t\tid\t\t|\t   dept");
        System.out.println("=======================================");
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("name"));
            if (!col2.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("id"));
            if (!col3.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("dept"));
            else
                System.out.println();
        }//end of while(rs.next() )
    }

    public static void main(String[] args){
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try{
            //forName은 jdbc드라이버에 접속할 수 있도록 해줌
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sampledb";
            String userName = "root";
            String password = "gging00100!";

            conn = DriverManager.getConnection(url, userName, password);

            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();
                ResultSet srs = stmt.executeQuery("select * from student");
                printData(srs, "name", "id", "dept");
            }

        }catch (ClassNotFoundException e){
            System.out.println("JDBC 드라이버 로드 오류");
        }catch (SQLException e){
            System.out.println("DB 연결 오류");
        }finally{
            try{
                stmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
