package com.example.spring.controller;


import com.example.spring.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
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
    public String sub2(Model model) throws Exception {
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
    public String sub3(Model model) throws Exception {
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
    public String sub4(Model model) throws Exception {

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
    public String sub5(Model model) throws Exception {
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
    public String sub6(Model model) throws Exception {
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
    public String sub7(Model model) throws Exception {
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

    @GetMapping("sub8")
    public String sub8(Model model) throws Exception {
        String sql = """
                SELECT LastName, FirstName 
                FROM Employees
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String lastName = resultSet.getString("LastName");
            String firstName = resultSet.getString("FirstName");

            var name = new HashMap<String, String>();
            name.put("LastName", lastName);
            name.put("FirstName", firstName);

            list.add(name);
        }
        model.addAttribute("nameList", list);
        return "main13/sub8";
    }

    // 연습
    // 고객 테이블에서 미국과 영국에 사는 고객이름과 국가
    // main13/sub9.html 에서 출력

    @GetMapping("sub9")
    public String sub9(Model model) throws Exception {
        String sql = """
                SELECT CustomerName, City, Country
                FROM Customers
                WHERE Country IN ('USA', 'UK')
                ORDER BY Country, City
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String name = resultSet.getString("CustomerName");
            String country = resultSet.getString("Country");
            String city = resultSet.getString("City");

            var customers = new HashMap<String, String>();
            customers.put("CustomerName", name);
            customers.put("Country", country);
            customers.put("City", city);

            list.add(customers);
        }
        model.addAttribute("customerList", list);

        return "main13/sub9";
    }

    @GetMapping("sub10")
    public String sub10(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            Map<String, Object> map = new HashMap<>();
            map.put("productId", productId);
            map.put("productName", productName);
            map.put("supplierID", supplierID);
            map.put("categoryID", categoryID);
            map.put("unit", unit);
            map.put("price", price);
            list.add(map);
        }

        model.addAttribute("productList", list);
        return "main13/sub10";
    }

    @GetMapping("sub11")
    public String sub11(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int id = resultSet.getInt("CustomerId");
            String name = resultSet.getString("CustomerName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String postalCode = resultSet.getString("PostalCode");
            String country = resultSet.getString("Country");

            var map = new HashMap<String, Object>();
            map.put("id", id);
            map.put("name", name);
            map.put("address", address);
            map.put("city", city);
            map.put("postalCode", postalCode);
            map.put("country", country);
            list.add(map);
        }
        model.addAttribute("customerList", list);
        return "main13/sub11";
    }

    @GetMapping("sub12")
    public String sub12(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<CustomerDto>();

        while (resultSet.next()) {
            String customerName = resultSet.getString("CustomerName");
            int customerID = resultSet.getInt("CustomerID");
            String contactName = resultSet.getString("ContactName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String country = resultSet.getString("Country");
            String postalCode = resultSet.getString("PostalCode");

            CustomerDto dto = new CustomerDto();
            dto.setId(customerID);
            dto.setName(customerName);
            dto.setContactName(contactName);
            dto.setAddress(address);
            dto.setCity(city);
            dto.setPostalCode(postalCode);
            dto.setCountry(country);

            list.add(dto);
        }
        model.addAttribute("customerList", list);
        return "main13/sub12";
    }

}
