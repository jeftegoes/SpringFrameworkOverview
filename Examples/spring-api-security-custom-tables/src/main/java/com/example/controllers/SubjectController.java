package com.example.controllers;

import com.example.entities.Subject;
import com.example.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectServiceRemoveLater;

    public SubjectController(SubjectService subjectServiceRemoveLater) {
        this.subjectServiceRemoveLater = subjectServiceRemoveLater;
    }

    @GetMapping("/")
    public List<Subject> getAll() {
        List<Subject> subjects = subjectServiceRemoveLater.findAll();

        return subjects;
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable int id) {
        Subject subject = subjectServiceRemoveLater.findById(id);

        if (subject == null)
            throw new RuntimeException("Subject id not found: " + id);

        return subject;
    }

    @PostMapping("/")
    public void save(@RequestBody Subject subject) {
        subjectServiceRemoveLater.save(subject);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Subject subject) {
        subjectServiceRemoveLater.save(subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        subjectServiceRemoveLater.deleteById(id);
    }
}
