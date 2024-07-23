package com.iweb.pojo;

import java.util.Objects;

/**
 * @author Raxcl
 * @date 2024/7/22 15:29
 */


public class Student {
    private Integer sno;
    private String sname;
    private String ssex;
    private String  sbirthday;
    private Integer sclass;

    public Student(Integer sno, String sname, String ssex, String sbirthday, Integer sclass) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.sclass = sclass;
    }

    public Student() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sno, student.sno) && Objects.equals(sname, student.sname) && Objects.equals(ssex, student.ssex) && Objects.equals(sbirthday, student.sbirthday) && Objects.equals(sclass, student.sclass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, sname, ssex, sbirthday, sclass);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday='" + sbirthday + '\'' +
                ", sclass=" + sclass +
                '}';
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public Integer getSclass() {
        return sclass;
    }

    public void setSclass(Integer sclass) {
        this.sclass = sclass;
    }
}
