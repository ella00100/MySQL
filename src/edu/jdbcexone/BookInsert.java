package edu.jdbcexone;

import java.sql.*;

public class BookInsert {
    public static void main(String[] args){
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try{
            //forName은 jdbc드라이버에 접속할 수 있도록 해줌
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/bookdb";
            String userName = "root";
            String password = "gging00100!";

            conn = DriverManager.getConnection(url, userName, password);

            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();
                System.out.println("-------------------------------------------------------------");
                System.out.println("\t\t\t\t\t전체 레코드 검색\n");
                System.out.println("ID\t\t 제목\t\t\t\t\t 출판사 \t\t\t\t\t 작가");
                printData(stmt);
                System.out.println();

                System.out.println("-------------------------------------------------------------");
                System.out.println("\t\t\t\t\t전체 레코드 삭제\n");
                stmt.executeUpdate(
                        "delete from book");
                printData(stmt);

                System.out.println("-------------------------------------------------------------");
                System.out.println("\t\t\t\t\t  레코드 입력\n");
                System.out.println("ID\t\t 제목\t\t\t\t\t 출판사 \t\t\t\t\t 작가");
                stmt.executeUpdate(
                        "insert into book value(0, 'Harry Potter', 'Bloomsbury','J.K.Rowling')");
                stmt.executeUpdate(
                        "insert into book value(1, 'The Load of the rings', 'Allen & Unwin','J.R.R.Tolkein')");
                stmt.executeUpdate(
                        "insert into book value(2, 'Pride and Prejudice', 'T. Egerton Kingdonm', 'Jane Austen')");
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
        ResultSet srs = pstatement.executeQuery("select * from book"); // 테이블의 모든 데이터 검색

        while (srs.next()) {
            System.out.print(srs.getString("id"));
            System.out.printf("\t%-25s",srs.getString("title"));
            System.out.printf("%-25s",srs.getString("publisher"));
            System.out.printf("%-20s \n",srs.getString("author"));
        }  //end of while(rs.next() )
    }  // end of printData
}
