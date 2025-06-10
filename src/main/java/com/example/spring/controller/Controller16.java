package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("CustomerId"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setContactName(resultSet.getString("ContactName"));
            customerDto.setCountry(resultSet.getString("Country"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerList", customerDtoList);

        return "main16/sub1";
    }

    @PostMapping("sub1")
    public String process1(CustomerDto customer) throws Exception {
//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); // select
        statement.executeUpdate();

        return "redirect:/main16/sub1";
    }

    // 연습 :
    // 새 공급자 등록 로직 작성
    // handler method * 2 (get, post)
    // html

    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(resultSet.getInt("SupplierId"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setContact(resultSet.getString("ContactName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPhone(resultSet.getString("Phone"));

            supplierDtoList.add(supplierDto);
        }
        model.addAttribute("supplierList", supplierDtoList);

        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContact());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());

        statement.executeUpdate();

        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws Exception {

        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));

                model.addAttribute("customer", customerDto);

            }
        }
        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Customers
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);
        statement.executeUpdate(); // delete, update, insert

        rttr.addAttribute("id", id); // query String에 붙임

        return "redirect:/main16/sub3";
    }

    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setId(resultSet.getInt("SupplierId"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContact(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));

                model.addAttribute("supplier", supplierDto);
            }
        }

        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Suppliers
                WHERE SupplierId = ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);
        statement.executeUpdate();

        rttr.addAttribute("id", id);

        return "redirect:/main16/sub4";
    }
}
