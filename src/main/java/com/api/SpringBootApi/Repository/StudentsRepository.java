package com.api.SpringBootApi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.SpringBootApi.Model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long>{

	@Query("SELECT s FROM Students s WHERE s.email = ?1")
	Optional<Students> findStudentByEmail(String email);
	
}
