package com.example.services;

import com.example.entities.Subject;
import com.example.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject findById(int id) {
        Optional<Subject> result = subjectRepository.findById(id);

        Subject subject = null;

        if (result.isPresent())
            return result.get();

        return null;
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteById(int id) {
        subjectRepository.deleteById(id);
    }
}
