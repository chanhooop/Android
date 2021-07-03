package com.aoslec.network_jsonstudents;

public class JsonStudents {

    private String name;
    private String dept;
    private String phone;
    private String code;

    public JsonStudents(String name, String dept, String phone, String code) {
        this.name = name;
        this.dept = dept;
        this.phone = phone;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
