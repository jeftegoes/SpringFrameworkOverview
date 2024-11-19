package com.example.services;

import com.example.entities.Teacher;
import com.example.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(int id) {
        Optional<Teacher> result = teacherRepository.findById(id);

        Teacher teacher = null;

        if (result.isPresent())
            return result.get();

        return null;
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}
