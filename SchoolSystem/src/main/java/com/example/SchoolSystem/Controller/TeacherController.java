package com.example.SchoolSystem.Controller;

import com.example.SchoolSystem.entity.Teacher;
import com.example.SchoolSystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping( "/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("")
    private String index(Model model){
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "/teacher/index";
    }

    @GetMapping("/create")
    private String createNew(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teachers", teacher);
        return "/teacher/create";
    }

    @PostMapping("")
    private String saveTeacher(@ModelAttribute("teachers") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/editTeacher/{id}")
    private String editTeacher(@PathVariable Long id, Model model){
        model.addAttribute("teachers", teacherService.getTeacherById(id));
        return "/teacher/editTeacher";
    }

    @PostMapping("/{id}")
    private String edit(@PathVariable Long id, @ModelAttribute("teachers") Teacher teacher,  Model model){
        Teacher updatedTeacher = teacherService.getTeacherById(id);
        updatedTeacher.setId(id);
        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setLastName(teacher.getLastName());
        updatedTeacher.setObject(teacher.getObject());
        teacherService.updateTeacher(updatedTeacher);
        return "redirect:/teacher";
    }

    @GetMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "redirect:/teacher";
    }


}
