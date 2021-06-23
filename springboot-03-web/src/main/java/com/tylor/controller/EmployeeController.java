package com.tylor.controller;

import com.tylor.dao.DepartmentDao;
import com.tylor.dao.EmployeeDao;
import com.tylor.entity.Department;
import com.tylor.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String employList(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/add")
    public String toAddEmployee(Model model){
        model.addAttribute("departments", departmentDao.getDepartments());
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/update/{id}")
    public String toUpdateEmployee(@PathVariable("id") int id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentDao.getDepartments());
        return "employee/update";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
