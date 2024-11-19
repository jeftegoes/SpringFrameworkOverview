package com.example.controllers;

import com.example.entities.Teacher;
import com.example.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable int id) {
        Teacher teacher = teacherService.findById(id);

        if (teacher == null)
            throw new RuntimeException("Teacher id not found: " + id);

        return teacher;
    }

    @PostMapping("/")
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PutMapping("/")
    public Teacher updade(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        teacherService.deleteById(id);
    }
}
