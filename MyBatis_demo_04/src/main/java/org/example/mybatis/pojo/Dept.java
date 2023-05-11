package org.example.mybatis.pojo;

import java.util.List;

/**
 * @Project: MyBatis
 * @Package: org.example.mybatis.pojo
 * @ClassName: Dept
 * @Datetime: 2023/05/11 20:23
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> emps;

    public Dept() {
    }

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

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
