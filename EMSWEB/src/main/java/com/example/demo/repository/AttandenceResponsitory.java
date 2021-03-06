package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Attandence;

public interface AttandenceResponsitory extends JpaRepository<Attandence, String>{
	Attandence findByid(String id);
	@Query("SELECT e FROM Attandence e where e.date=?1")
	public List<Attandence> findcustomdate(String date);
	
	@Query("SELECT e FROM Attandence e where e.student.id=?1")
	public List<Attandence> findcustomstudent(String studentid);
}
