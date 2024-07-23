package com.iweb.day;
import com.iweb.dao.StudentDAO;
import com.iweb.dao.StudentDAOImpl;
import com.iweb.pojo.Student;

import java.sql.*;

/**
 * @author Raxcl
 * @date 2024/7/22 14:49
 */
public class Test {
    public static void main(String[] args) {
//        //驱动加载
//        try {
//            //通过类的路径加载一个类
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("驱动加载成功！");
//
//
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
//        String username = "root";
//        String password = "a12345";
//
//        Connection connection = null;
//        //获取jdbc的链接
//        try {
//            connection = DriverManager.getConnection(url,username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("获取链接成功");
//
//        Statement s = null;
//        try {
//            s = connection.createStatement();
//            //准备一个sql语句
//            String sql ="INSERT INTO student"+
//                    "(sno,sname,ssex,sbirthday,class)\n" +
//                    "VALUES" + "(888,'呵呵呵','男','1976-02-20 00:00:00',95033)";
//            //运行sql语句
//            s.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Student s1 = new Student(111,"张三","男","1976-02-20 00:00:00",95033);
        StudentDAO studentDAO = new StudentDAOImpl();
//        studentDAO.insert(s1);
        Student s2 = new Student(111,"张四","男","1976-02-20 00:00:00",95033);
        studentDAO.update(s2);
    }
}
