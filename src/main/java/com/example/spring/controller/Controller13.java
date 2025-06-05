package com.example.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception{
        // 1. request 분석 / 가공
        //    @GetMapping, PostMapping, RequestParam

        // 2. request 처리 (business logic)
        //    CRUD
        // 2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 2.2 쿼리(sql) 실행
        String sql = """
                SELECT CustomerName
                FROM Customers
                WHERE CustomerID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // 2.3 결과 처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("CustomerName");
        }

        // 3. 결과를 Model(RedirectAttributes)에 담고
        //    model.addAttribute(), rttr.addFlashAttribute(), rttr.addAttribute()
        //    session.setAttribute()
        model.addAttribute("name", name);

        // 4. view로 forwarding
        //    다른 경로로 redirection


        return "main13/sub1";
    }

    // 연습 : 상품 번호 1번인 상품 조회 / 출력
    // get main13/sub2
    // /main13/sub2.html

    @GetMapping("sub2")
    public String sub2(Model model) throws Exception{
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT ProductName 
                FROM Products
                WHERE ProductID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("ProductName");
        }

        model.addAttribute("name", name);


        return "main13/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception{
        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT LastName
                FROM Employees
                """;
        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        // table 형태의 결과
        // 내부에 행(row)을 가리키는 커서가 있음
        // next() 호출하면 다음 행으로 커서를 이동
        // get...() : 컬럼 값을 얻는 메소드
        resultSet.next(); // 1번째 행 가리킴 (true 리턴)
        String name1 = resultSet.getString("LastName");
        resultSet.next(); // 2번째 행 가리킴 (true 리턴)
        String name2 = resultSet.getString("LastName");
        resultSet.next(); // 3번째 행 가리킴 (true 리턴)
        String name3 = resultSet.getString("LastName");
        resultSet.next(); // 4번째 행 가리킴 (true 리턴)
        String name4 = resultSet.getString("LastName");
        resultSet.next(); // 5번째 행 가리킴 (true 리턴)
        String name5 = resultSet.getString("LastName");
        resultSet.next(); // 6번째 행 가리킴 (true 리턴)
        String name6 = resultSet.getString("LastName");
        resultSet.next(); // 7번째 행 가리킴 (true 리턴)
        String name7 = resultSet.getString("LastName");
        resultSet.next(); // 8번째 행 가리킴 (true 리턴)
        String name8 = resultSet.getString("LastName");
        resultSet.next(); // 9번째 행 가리킴 (true 리턴)
        String name9 = resultSet.getString("LastName");
        resultSet.next(); // 10번째 행 가리킴 (없으니까 false 리턴)

        var list = List.of(name1, name2, name3, name4, name5, name6, name7, name8, name9);

        model.addAttribute("nameList", list);

        return "main13/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception{

        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT FirstName
                FROM Employees
                """;
        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        // table 형태의 결과
        // 내부에 행(row)을 가리키는 커서가 있음
        // next() 호출하면 다음 행으로 커서를 이동
        // get...() : 컬럼 값을 얻는 메소드
        var list = new ArrayList<String>();

        while (resultSet.next()) {
            String name = resultSet.getString("FirstName");

            list.add(name);
        }

        model.addAttribute("nameList", list);

        return "main13/sub3";
    }
    @GetMapping("sub5")
    public String sub5(Model model) throws Exception{
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT CategoryName
                FROM Categories
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<String>();
        while (resultSet.next()) {
            String name = resultSet.getString("CategoryName");

            list.add(name);
        }

        model.addAttribute("nameList", list);

        return "main13/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception{
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Price
                FROM Products
                ORDER BY Price
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

//        var list = new ArrayList<String>();
//        while (resultSet.next()) {
//            String price = resultSet.getString("Price");
//            list.add(price);
//        }
        // 모든 데이터는 String 으로 얻어 오는 것이 가능하지만
        // 특별한 이유가 없다면 type 에 맞는 get ... 메소드 사용하자.
        var list = new ArrayList<Double>();
        while (resultSet.next()) {
            double price = resultSet.getDouble("Price");
            list.add(price);
        }
        model.addAttribute("priceList", list);

        return "main13/sub6";
    }

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception{
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Quantity
                FROM OrderDetails
                ORDER BY Quantity DESC 
                LIMIT 5
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Integer>();
        while (resultSet.next()) {
            int quantity = resultSet.getInt("Quantity");
            list.add(quantity);
        }
        model.addAttribute("quantityList", list);
        return "main13/sub7";
    }

}
