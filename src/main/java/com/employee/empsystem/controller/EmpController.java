package com.employee.empsystem.controller;

import com.employee.empsystem.entity.Employee;
import com.employee.empsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {


    @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model m)
    {

        List<Employee> employee =service.getAllEmployee();
        m.addAttribute("employee",employee);
        return "index";
    }


    @GetMapping("/addemp")
    public String addEmpForm()
    {
        return"add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee,HttpSession session)
    {
        System.out.println(employee);
        service.addEmp(employee);
        session.setAttribute("msg","Employee added successfully");
        return "redirect:/ ";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m)
    {
        Employee employee=service.getEmpById(id);
        m.addAttribute("employee",employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee,HttpSession session)
    {
        service.addEmp(employee);
        session.setAttribute("msg","Employee Data Updated successfully...");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id,HttpSession session){
        service.deleteEmp(id);
        session.setAttribute("msg","Employee Data deleted successfully");
        return "redirect:/";
    }

}
