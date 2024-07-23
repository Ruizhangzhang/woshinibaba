package com.iweb.dao;

import com.iweb.day.DBUtil;
import com.iweb.pojo.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Raxcl
 * @date 2024/7/22 15:52
 * hfjgjhgjgkjhkjh
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO student (sno, sname, ssex, sbirthday, sclass) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnect();
             //传参麻烦 2.性能较差 3.有存在sql注入攻击问题

             //preparedstatment 先编译后传参，传参方便可以有效防止sql注入攻击的问题
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1,student.getSno());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.setString(3,student.getSsex());
            preparedStatement.setString(4,student.getSbirthday());
            preparedStatement.setInt(5,student.getSclass());
            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer sno) {
        Connection conn = null;
        String sql = "delete from student where sno = ?";
        try {
            conn = DBUtil.getConnect();
            //
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,sno);

            preparedStatement.execute();
            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update student set sno=?,sname=?,ssex=?,sbirthday=?,sclass=? where sno=?";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1,student.getSno());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.setString(3,student.getSsex());
            preparedStatement.setString(4,student.getSbirthday());
            preparedStatement.setInt(5,student.getSclass());
            preparedStatement.setInt(6,student.getSno());
            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //统计表记录总数  如果为0说明没有数据
    @Override
    public Integer count() {
        String sql = "select count(*) from student";
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                //而密茨从结果中读取一行数据
                //根据读取的字段数据不同 使用不同的get方法
                //方法参数有两种 一种是获取的字段再查询结果中出现的顺序
                //可以不写字段出现的顺序 而写字段的名称
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //根据sno查找对应的学生信息，返回的是sno对应的学生记录，如过对应的学生记录不存在则返回null
    @Override
    public Student findBysno(Integer sno) {
        String sql = "select * from student where sno = ?";
        Student student = null;
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1,sno);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                student = new Student();
                student.setSno(sno);
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSbirthday(resultSet.getString("sbirthday"));
                student.setSclass(resultSet.getInt("sclass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findALl() {

        return findwithLimit(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> findByNameLike(String sname) {

        return findByNameLikeWithLimit(sname,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> findByNameLikeWithLimit(String sname, int start, int limit) {
        String sql = "select * from student where sname like concat('%',?,'%') limit ?,?";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,sname);
            preparedStatement.setInt(2,start);
            preparedStatement.setInt(3,limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setSno(resultSet.getInt("sno"));
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSbirthday(resultSet.getString("sbirthday"));
                student.setSclass(resultSet.getInt("sclass"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> findwithLimit(int start, int limit) {
        String sql = "select * from student limit ?,?";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student s = new Student();
                s.setSno(resultSet.getInt("sno"));
                s.setSname(resultSet.getString("sname"));
                s.setSsex(resultSet.getString("ssex"));
                s.setSbirthday(resultSet.getString("sbirthday"));
                s.setSclass(resultSet.getInt("sclass"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
