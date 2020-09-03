package com.htsc;

import java.sql.*;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public class sql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainhome?" + "characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "zhl136726");
            String sql = "select * from user where username = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "李四");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
