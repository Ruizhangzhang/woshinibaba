package com.iweb.dao;

import com.iweb.pojo.Student;

import java.util.List;

/**
 * @author Raxcl
 * @date 2024/7/22 15:35
 */
public interface StudentDAO {
    //插入一个学生信息  要插入的学生信息 其中主键不需要提供
    void insert(Student student);
    //根据主键删除学生信息   sno要删除学生信息sno
    void delete(Integer sno);
    //根据学生的sno修改学生的所有参数
    //要修改的学生sno和需要被修改的字段值
    void update(Student student);
    //统计表记录总数  如果为0说明没有数据
    Integer count();
    //根据sno查找对应的学生信息，返回的是sno对应的学生记录，如过对应的学生记录不存在则返回null
    Student findBysno(Integer sno);
    //获取所有学生信息，所有学生对应的集合
    List<Student> findALl();
    //根据学生名称模糊查询学生名称
    List<Student> findByNameLike(String sname);
    //根据学生的名称进行模糊分页查询
    //start limit 起始参数，limit冯牧鹅查询的行数
    //找不到就返回null
    List<Student> findByNameLikeWithLimit(String sname,int start,int limit);

    //分页查询学生
    List<Student> findwithLimit(int start,int limit);


}
