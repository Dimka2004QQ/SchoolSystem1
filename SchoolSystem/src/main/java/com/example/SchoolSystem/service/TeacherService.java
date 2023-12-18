package com.example.SchoolSystem.service;

import com.example.SchoolSystem.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    Teacher saveTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Teacher teacher);

    void deleteTeacherById(Long id);
}
