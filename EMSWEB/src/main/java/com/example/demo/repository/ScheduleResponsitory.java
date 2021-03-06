package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Schedule;

public interface ScheduleResponsitory extends JpaRepository<Schedule, String>{
	Schedule findByid(String id);
	
	@Query("SELECT e FROM Schedule e where e.classroom.id=?1")
	public List<Schedule> findcustom(String classroomid);
	
	@Query("SELECT e FROM Schedule e where e.course.id=?1")
	public List<Schedule> findcustomCouse(String couseid);
	
	@Query("SELECT e FROM Schedule e where e.classroom.id=?1 and e.des=?2")
	public List<Schedule> findcustomlichthi(String classroomid,String des);
}
