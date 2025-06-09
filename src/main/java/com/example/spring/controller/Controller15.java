package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.EmployeeDto;
import com.example.spring.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {
    @GetMapping("sub1")
    public String sub1(
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) throws Exception {

        // 한 페이지에 10개씩 보여준다면
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 총 고객 수
        String countSql = """
                SELECT COUNT(*) AS count 
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        // offset (page - 1) *10
//        statement.setInt(1, 0); // 1 page
//        statement.setInt(1, 10); // 2 page
//        statement.setInt(1, 20); // 2 page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객 수
        int lastPage = (count - 1) / 10 + 1; // 마지막 페이지 번호
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();

        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerId"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setAddress(rs.getString("Address"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setContactName(rs.getString("ContactName"));

            list.add(customerDto);
        }
        model.addAttribute("customerList", list);


        return "main15/sub1";
    }

    // 연습 :
    // 한 페이지에 5개의 공급자가 출력되도록 코드 작성(정렬은 공급자 번호 순)
    // request handle method, html

    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1")
                       Integer page,
                       Model model) throws Exception {
        // 공급자 출력 코드
        String sql = """
                SELECT *
                FROM Employees
                ORDER BY EmployeeID
                LIMIT ?, ?
                """;
        // 공급자 카운트 코드
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Employees
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);


        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지 번호
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<EmployeeDto> list = new ArrayList<>();

        while (rs.next()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(rs.getInt("EmployeeID"));
            employeeDto.setLastName(rs.getString("LastName"));
            employeeDto.setFirstName(rs.getString("FirstName"));
            employeeDto.setBirthDate(rs.getDate("birthDate").toLocalDate());
            employeeDto.setPhoto(rs.getString("Photo"));
            employeeDto.setNotes(rs.getString("Notes"));

            list.add(employeeDto);

        }
        model.addAttribute("employeeList", list);


        return "main15/sub2";
    }

    // 검색 + 페이징
    @GetMapping("sub3")
    public String sub3(
            @RequestParam(defaultValue = "1")
            Integer page,
            @RequestParam(defaultValue = "")
            String keyword,
            Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(2, "%" + keyword + "%");

        int offset = (page - 1) * 5;
        selectStmt.setInt(3, offset);
        selectStmt.setInt(4, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count"); // 총 레코드 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지 번호
        int leftPage = rightPage - 9;//왼쪽 페이지 번호
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지 번호는 마지막 페이지번호 보다 클 수없다.
        model.addAttribute("lastPage", lastPage); // 마지막 페이지
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStmt.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs2.getInt("CustomerID"));
            customerDto.setName(rs2.getString("CustomerName"));
            customerDto.setContactName(rs2.getString("ContactName"));
            customerDto.setAddress(rs2.getString("Address"));
            customerDto.setCity(rs2.getString("City"));
            customerDto.setPostalCode(rs2.getString("PostalCode"));
            customerDto.setCountry(rs2.getString("Country"));
            list.add(customerDto);

        }
        model.addAttribute("customerList", list);

        return "main15/sub3";

    }

    // 연습 :
    // 상품명 조회 로직 작성(w/ paging)
    // 페이지네이션 완성(이전, 다음)
    @GetMapping("sub4")
    public String sub4(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {
        // 카운트 sql 정의
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Products
                WHERE ProductName LIKE ?
                """;
        // 상품명 조회 sql 정의
        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;

        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 갈고리 정의
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");

        int offset = (page - 1) * 5;
        selectStmt.setInt(2, offset);
        selectStmt.setInt(3, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        int rightPage = ((page - 1) / 10 + 1) * 10;
        int leftPage = rightPage - 9;
        int prevPage = leftPage - 10;
        if (prevPage < 1) prevPage = 1;
        int nextPage = rightPage + 1;
        if (nextPage > lastPage) nextPage = lastPage;
        rightPage = Math.min(rightPage, lastPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStmt.executeQuery();
        List<ProductDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(rs2.getInt("ProductID"));
            productDto.setProductName(rs2.getString("ProductName"));
            productDto.setSupplierId(rs2.getInt("SupplierID"));
            productDto.setCategoryId(rs2.getInt("CategoryID"));
            productDto.setUnit(rs2.getString("Unit"));
            productDto.setPrice(rs2.getDouble("Price"));
            list.add(productDto);
        }
        model.addAttribute("productList", list);

        return "main15/sub4";
    }
}

