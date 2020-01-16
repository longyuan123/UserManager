package com.course.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String password;
    private int age;
    private String sex;
    private int permission;
    private int isDelete;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{id:").append(id).append(", name:")
                .append(name).append(", password:")
                .append(password).append(", age:").append(age)
                .append(", sex:").append(sex).append(", permission")
                .append(permission).append(", isDelete")
                .append(isDelete).append("}");
        return sb.toString();
    }
}
