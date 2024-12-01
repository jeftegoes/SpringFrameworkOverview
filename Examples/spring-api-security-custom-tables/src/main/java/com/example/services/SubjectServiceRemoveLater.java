package com.example.services;

import com.example.entities.Subject;
import com.example.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectServiceRemoveLater {
    private final EntityManager entityManager;

    @Autowired
    public SubjectServiceRemoveLater(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Subject> getAll() {
        TypedQuery<Subject> query = entityManager.createQuery("SELECT d FROM Subject d", Subject.class);

        return query.getResultList();
    }

    public Subject findById(int id) {
        return entityManager.find(Subject.class, id);
    }

    @Transactional
    public void save(Subject subject) {
        Teacher teacher = entityManager.find(Teacher.class, subject.getTeacher().getId());

        subject.setTeacher(teacher);

        entityManager.persist(subject);
    }

    @Transactional
    public void delete(int id) {
        Subject subject = entityManager.find(Subject.class, id);

        entityManager.remove(subject);
    }

    @Transactional
    public void update(int id, Subject subject) {
        Subject subjectInDb = entityManager.find(Subject.class, id);

        subjectInDb.setName(subject.getName());
        subjectInDb.setHours(subject.getHours());

        entityManager.merge(subjectInDb);
    }
}
