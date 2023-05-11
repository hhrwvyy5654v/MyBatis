package org.example.mybatis.pojo;

import java.util.List;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 17:01
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public class Dept {
    private Integer did;    //部门ID
    private String deptName;    //部门名称
    private List<Emp> emps;    //部门员工列表
    // 默认构造函数
    public Dept() { 
    }
    // 带参构造函数
    public Dept(Integer did, String deptName, List<Emp> emps) {
        this.did = did;
        this.deptName = deptName;
        this.emps = emps;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
    // 重写toString方法,将Dept对象转换为字符串形式
    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
