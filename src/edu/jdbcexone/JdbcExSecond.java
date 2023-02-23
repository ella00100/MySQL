package edu.jdbcexone;

import java.sql.*;

public class JdbcExSecond {

    private static void printData(
            ResultSet srs, String col1, String col2, String col3) throws SQLException {
        while (srs.next()) {
            if (!col1.equals(""))
                System.out.print(srs.getString("name"));
            if (!col2.equals(""))
                System.out.printf("\t|%10s",
                        srs.getString("dept"));
            if (!col3.equals(""))
                System.out.println("\t|\t" +
                        srs.getString("id"));
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
                System.out.println("---------------------------------------------");
                System.out.println("\t\t전체 레코드 검색\n");
                ResultSet srs = stmt.executeQuery("select * from student");
                printData(srs, "name", "dept", "id" );

                stmt.executeUpdate(
                        "delete from student where id = '12433875'");
                System.out.println("--------------------------------------------");
                System.out.println("\t\t\t레코드 삭제 후\n");
                ResultSet s2 = stmt.executeQuery("select * from student");
                printData(s2, "id", "dept", "name" );


                stmt.executeUpdate(
                        "insert into student(name, dept, id) value ('꼬물이', '꼬물꼬물학과', '12433875')");
                System.out.println("---------------------------------------------");
                System.out.println("\t\t\t레코드 삽입 후\n");
                ResultSet s3 = stmt.executeQuery("select * from student");
                printData(s3, "id", "dept", "name" );

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