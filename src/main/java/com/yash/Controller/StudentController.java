package com.yash.Controller;


import com.yash.Model.Student;
import com.yash.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService StudentService;

    @GetMapping(value={"/","/home"})
    public String home(Model model) {
        model.addAttribute("students", StudentService.getAllStudents());
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        StudentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/find")
    public String findByName(@RequestParam("name") String name, Model model) {
        List<Student> student = StudentService.getStudentByName(name);
        model.addAttribute("student", student);
        return "findStudent";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Student student= StudentService.getStudentById(id);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student) {
        StudentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        StudentService.deleteStudent(id);
        return "redirect:/";
    }

}

