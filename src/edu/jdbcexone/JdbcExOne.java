package edu.jdbcexone;

import java.sql.*;

public class JdbcExOne {
    private static void printData(
            ResultSet srs, String col1, String col2, String col3, String col4, String col5, String col6, String col7 ) throws SQLException {
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("userID"));
            if (!col2.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("name"));
            if (!col3.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("birthYear"));
            if (!col4.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("address"));
            if (!col5.equals(""))
                System.out.print("\t|\t" +
                        srs.getString("mobile1"));
            if (!col6.equals(""))
                System.out.print("-"+
                        srs.getString("mobile2"));
            if (!col7.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("mDate"));
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

            String url = "jdbc:mysql://localhost:3306/malldb";
            String userName = "root";
            String password = "gging00100!";

            conn = DriverManager.getConnection(url, userName, password);

            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();
                ResultSet srs = stmt.executeQuery("select * from usertbl");
                printData(srs, "userID", "name", "birthYear","address","mobile1","mobile2", "mDate" );
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
