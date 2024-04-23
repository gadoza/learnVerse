package com.example.learnverse.repositories;

import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query("""
//            SELECT S FROM Student S WHERE S.studentName = :studentName
//            """)
//    Optional<Student> findStudentByStudentName(@Param("studentName") String studentName);


    @Modifying
    @Transactional
    @Query("""
        update Student 
        set isDeleted = 1 
        where id = :id
""")
    void softDeleteStudentById(@Param("id") Long id);


}
