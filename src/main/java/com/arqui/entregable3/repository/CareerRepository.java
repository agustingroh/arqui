package com.arqui.entregable3.repository;
import com.arqui.entregable3.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
    @Query("SELECT DISTINCT c,s.size FROM Career c JOIN c.students s WHERE s.size > 0 ORDER BY s.size DESC")
    List<Career> getAllCareersWithStudents();
}
