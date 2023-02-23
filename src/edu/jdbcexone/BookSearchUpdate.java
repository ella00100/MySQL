package edu.jdbcexone;

import java.sql.*;
import java.util.Scanner;

public class BookSearchUpdate {
    public static void main(String[] args){
        System.out.println("JDBC Start");

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/bookdb";
            String userName = "root";
            String password = "gging00100!";

            conn = DriverManager.getConnection(url, userName, password);

            if (conn != null){
                System.out.println("DB 연결 완료");
                stmt = conn.createStatement();

                Scanner sc = new Scanner(System.in);
                System.out.println("1) 전체 도서 조회  2) 도서 입력  3) 도서 수정  4) 전체 도서 삭제 > ");
                Integer menu = sc.nextInt();
                String x = sc.nextLine();

                if (menu == 1){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t레코드 검색 결과\n");
                    System.out.println("ID\t\t 제목\t\t\t\t\t 출판사 \t\t\t\t\t 작가");
                    printData(stmt);
                }
                else if (menu ==2){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t  레코드 입력\n");
                    System.out.println("ID\t\t 제목\t\t\t\t\t 출판사 \t\t\t\t\t 작가");
                    stmt.executeUpdate(
                            "insert into book value(0, 'Harry Potter', 'Bloomsbury','J.K.Rowling')");
                    stmt.executeUpdate(
                            "insert into book value(1, 'HThe Load of the rings', 'Allen & Unwin','J.R.R.Tolkein')");
                    stmt.executeUpdate(
                            "insert into book value(2, 'Pride and Prejudice', 'T. Egerton Kingdonm', 'Jane Austen')");
                    printData(stmt);

                }
                else if (menu == 3){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t  레코드 수정\n");
                    stmt.executeUpdate(
                            "Update book set title = 'The Load of the rings' where id = 1");
                    printData(stmt);
                }
                else if (menu == 4){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t전체 레코드 삭제\n");
                    stmt.executeUpdate(
                            "delete from book");
                    printData(stmt);
                }
                else{
                    System.out.println("메뉴에서 골라주세요");
                }
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
