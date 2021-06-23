package com.tylor.dao;

import com.tylor.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101,"测试部"));
        departments.put(102, new Department(102,"技术部"));
        departments.put(103, new Department(103,"运营部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
