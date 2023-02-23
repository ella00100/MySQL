package edu.jdbcexone;

import java.sql.*;

public class JdbcExSecond {

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
                System.out.println("\t\t\t전체 레코드 검색\n");
                printData(stmt);

                stmt.executeUpdate(
                        "update student set dept = '체육학과' where id = '12192261'");
                System.out.println("---------------------------------------------");
                System.out.println("\t\t\t\t레코드 변경 후\n");
                printData(stmt);

                stmt.executeUpdate(
                        "delete from student where id = '12433875'");
                System.out.println("--------------------------------------------");
                System.out.println("\t\t\t\t레코드 삭제 후\n");
                printData(stmt);


                stmt.executeUpdate(
                        "insert into student(name, dept, id) value ('꼬물이', '꼬물꼬물학과', '12433875')");
                System.out.println("---------------------------------------------");
                System.out.println("\t\t\t\t레코드 삽입 후\n");
                printData(stmt);

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
    private static void printData(Statement pstatement)
            throws SQLException {
        ResultSet srs = pstatement.executeQuery("select * from student"); // 테이블의 모든 데이터 검색

        while (srs.next()) {
            System.out.print(srs.getString("name")+"\t");
            System.out.print("\t|\t" + srs.getString("id"));
            System.out.println("\t|\t" + srs.getString("dept"));
        }  //end of while(rs.next() )
    }  // end of printData
}