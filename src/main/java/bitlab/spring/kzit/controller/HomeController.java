package bitlab.spring.kzit.controller;

import bitlab.spring.kzit.db.DBManager;
import bitlab.spring.kzit.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model ){
        ArrayList<Student> StudentArray= DBManager.getStudents();
        model.addAttribute("studentter",StudentArray);
        return "index";
    }
    @GetMapping(value = "/add")
    public String addPage(Model model ){
        ArrayList<Student> StudentArray= DBManager.getStudents();
        model.addAttribute("studentter",StudentArray);
        return "addstudent";
    }

    @PostMapping(value = "/addstudent")
    public String  addStudent(Student student){
        DBManager.addStudent(student);
        int examResult = student.getExam();
        String ball = "";
        if (examResult >= 90) {
            ball = "A";
        } else if (examResult >= 75 && examResult <=89) {
            ball = "B";
        } else if (examResult >= 60 && examResult <= 74) {
            ball = "C";
        } else if (examResult >= 50 && examResult <=59) {
            ball = "D";
        } else {
            ball = "F";
        }

        student.setMark(ball);
        return "redirect:/";
    }
}
