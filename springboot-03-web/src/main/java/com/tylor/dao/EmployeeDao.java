package com.tylor.dao;

import com.tylor.entity.Department;
import com.tylor.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> employees = null;

    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001,"A","A0123",0,new Department(101,"测试部")));
        employees.put(1002, new Employee(1002,"B","B0123",1,new Department(102,"技术部")));
        employees.put(1003, new Employee(1003,"C","C0123",0,new Department(103,"运营部")));
    }

    //主键自增
    private static Integer inintId = 1004;

    public void save(Employee employee){
        if (employee.getId() == null) {
            employee.setId(inintId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
