package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

  @GetMapping("/new_student")
  public String newStudent(Model model) {
    model.addAttribute( "grades", Grade.values() );
    return "new_student";
  }

  @PostMapping("/create_student")
  public String createStudent(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName,
                              @RequestParam(value = "grade") Grade grade, Model model) {
    Student student = new Student();
    student.setFirstName( firstName );
    student.setLastName( lastName );
    student.setGrade( grade );
    model.addAttribute( "student", student );
    return "view_student";
  }
}