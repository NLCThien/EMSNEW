package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Attandence;
import com.example.demo.entities.Classroom;
import com.example.demo.entities.ClassroomStudent;
import com.example.demo.entities.Course;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.entities.User;
import com.example.demo.repository.AmphiResponsitory;
import com.example.demo.repository.AttandenceResponsitory;
import com.example.demo.repository.ClassroomResponsitory;
import com.example.demo.repository.ClassroomStudentResponsitory;
import com.example.demo.repository.CourseResponsitory;
import com.example.demo.repository.ScheduleResponsitory;
import com.example.demo.repository.SchoolroomResponsitory;
import com.example.demo.repository.StudentResponsitory;
import com.example.demo.repository.StudyShiftResponsitory;
import com.example.demo.repository.TeacherResponsitory;
import com.example.demo.repository.UserResponsitory;

@Controller
public class TeacherController {
	@Autowired
	ScheduleResponsitory scheduleResponsitory;
	@Autowired
	AmphiResponsitory amphiResponsitory;
	@Autowired
	ClassroomResponsitory classroomResponsitory;
	@Autowired 
	CourseResponsitory courseResponsitory;
	@Autowired
	SchoolroomResponsitory schoolroomResponsitory;
	@Autowired
	StudyShiftResponsitory studyShiftResponsitorys;
	@Autowired
	StudentResponsitory studentResponsitory;
	@Autowired
	ClassroomStudentResponsitory classroomStudentrespon;
	@Autowired
	TeacherResponsitory teacherResponsitory;
	@Autowired
	UserResponsitory userResponsitory;
	@Autowired
	AttandenceResponsitory attandenceResponsitory;
	//show list schedule
	@RequestMapping(value = { "teacher/thoikhoabieu" })
	public String loadthoikhoabieu(Model model,@RequestParam("teacherid") String teacherid) {
		List<Course> couseid=courseResponsitory.findcustomteacher(teacherid);
		for (Course u : couseid) {
			System.out.println("outti>>>"+u.getId());
			List<Schedule> schedule= scheduleResponsitory.findcustomCouse(u.getId());
			model.addAttribute("List",schedule);
		}		
		return "/jsp/Page/PageforTeacher/thoikhoabieuTeacher";
	}
	@RequestMapping(value = { "teacher/liststudent" })
	public String loadliststudents(Model model,@RequestParam("teacherid") String teacherid) {
		List<Course> couseid=courseResponsitory.findcustomteacher(teacherid);
		for (Course u : couseid) {
			System.out.println("outti11>>>"+u.getId());
			List<Schedule> schedule= scheduleResponsitory.findcustomCouse(u.getId());
			for (Schedule s : schedule) {
				System.out.println("out lop id>>>"+s.getClassroom().getId());
				Classroom classroom= classroomResponsitory.findByid(s.getClassroom().getId());
				System.out.println("outxxx>>>"+classroom.getId());
				List<ClassroomStudent> croomstudent=classroomStudentrespon.findcustomclass(classroom.getId());
				
				model.addAttribute("List",croomstudent);
			}
			
			
		}		
		return "/jsp/Page/PageforTeacher/DSHocsinhtronglop";
	}
	
	@RequestMapping(value = { "Page/INFOTeacher" })
	public String loadinfo(Model model,@RequestParam("teacherid") String teacherid) {
		List<Teacher> teacher= teacherResponsitory.findcustom(teacherid);
		model.addAttribute("List",teacher);
		return "/jsp/Page/PageforTeacher/lilich";
	}
	@RequestMapping(value = { "Page/UpdatepassTeacher" })
	public String loadUpdatepassTeacher(Model model,@ModelAttribute("passUpdate") User user,@RequestParam("teacherid") String teacherid) {
		List<Teacher> teacher= teacherResponsitory.findcustom(teacherid);
		model.addAttribute("List",teacher);
		List<User> list= userResponsitory.findcusTeacherID(teacherid);
		model.addAttribute("ListTeacher",list);
		return "/jsp/Page/PageforTeacher/doimatkhau";
	}
	@RequestMapping(value = { "/updatePassTeacher" })
	public String doiUpdatepassTeacher(Model model,@ModelAttribute("passUpdate") User user,HttpServletRequest request) {
		User u = userResponsitory.findByusername(user.getUsername());
		System.out.println("===>@@>"+user.getPassword());
		String pass= user.getPassword();
		String passo=u.getPassword();
		String pasnew = request.getParameter("passnew");
		System.out.println("===>>pass trong mang:"+pass);
		if (pass.equals(passo)) {
			User us = userResponsitory.findByusername(user.getUsername());
			us.setPassword(pasnew);
			userResponsitory.save(us);
			model.addAttribute("mess","1");
		}else {
			model.addAttribute("mess","2");
		}
		List<User> list= userResponsitory.findcustom(user.getUsername());
		model.addAttribute("ListTeacher",list);
		return "/jsp/Page/PageforTeacher/doimatkhau";
	}
	

	String idzz=null;
	@RequestMapping(value = { "Page/diemdanh" })
	public String loaddiemdanh(Model model,@ModelAttribute("attandence") Attandence attan,@RequestParam("teacherid") String teacherid) {

		List<Course> couseid=courseResponsitory.findcustomteacher(teacherid);
		for (Course u : couseid) {
			System.out.println("outti11>>>"+u.getId());
			List<Schedule> schedule= scheduleResponsitory.findcustomCouse(u.getId());
			for (Schedule s : schedule) {
				System.out.println("out lop id>>>"+s.getClassroom().getId());
				Classroom classroom= classroomResponsitory.findByid(s.getClassroom().getId());
				System.out.println("outxxx>>>"+classroom.getId());
				List<ClassroomStudent> croomstudent=classroomStudentrespon.findcustomclass(classroom.getId());
				
				model.addAttribute("Lists",croomstudent);
			}
			
			
		}
		idzz=teacherid;
		return "/jsp/Page/PageforTeacher/testdiemdanh";
	}
	@RequestMapping(value = { "/attandence/save" })
	public String loadattandencess(Model model,HttpServletRequest request,@ModelAttribute("attandence") Attandence attan) {
		DateTimeFormatter dtfs = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime nows = LocalDateTime.now();    
		String date = request.getParameter("dobss");
		System.out.println("date hoom nay>>>"+date);
		String namecourse=request.getParameter("course");
		
		List<Course> couseid=courseResponsitory.findcustomteacher(idzz);
		for (Course u : couseid) {
			System.out.println("outti11>>>"+u.getId());
			List<Schedule> schedule= scheduleResponsitory.findcustomCouse(u.getId());
			for (Schedule s : schedule) {
				System.out.println("out lop id>>>"+s.getClassroom().getId());
				Classroom classroom= classroomResponsitory.findByid(s.getClassroom().getId());
				System.out.println("outxxx>>>"+classroom.getId());
				List<ClassroomStudent> croomstudent=classroomStudentrespon.findcustomclass(classroom.getId());
				for (ClassroomStudent classroomStudent : croomstudent) {
					
					List<Attandence> attanlist = attandenceResponsitory.findAll();
					List<Attandence> datelist= attandenceResponsitory.findcustomdate(dtfs.format(nows));
					if (datelist.size()<croomstudent.size()) {
					Attandence lastid = attanlist.get(attanlist.size() - 1);
					System.out.println("==>> " + lastid);
					String id = lastid.getId();
					String splitID = id.substring(2);
					System.out.println("==> " + splitID);
					int idNum = Integer.parseInt(splitID) + 1;
					String outID = null;
					if (idNum < 10) {
						outID = "AT00" + idNum;
					} else if (idNum >= 10 && idNum < 100) {
						outID = "AT0" + idNum;
					} else if (idNum >= 100 && idNum < 1000) {
						outID = "AT" + idNum;
					}
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
					   LocalDateTime now = LocalDateTime.now();  
					   System.out.println(dtf.format(now));  
					
					Course cotest= new Course();
					cotest.setId(couseid.get(0).getId());
					cotest.setName(couseid.get(0).getName());
					Attandence newa= new Attandence();
					newa.setId(outID);
					newa.setDate(dtf.format(now));
					newa.setCourse(cotest);
					Student st= studentResponsitory.findByid(classroomStudent.getStudent().getId());
					newa.setStudent(st);
					attandenceResponsitory.save(newa);
					
						
					}else if (datelist.size()>croomstudent.size()) {
						break;
					}
				}
				model.addAttribute("Lists",croomstudent);
			}
			
			
		}
		
		List<Attandence> attandence= attandenceResponsitory.findcustomdate(dtfs.format(nows));
		model.addAttribute("List",attandence);
		
		return "/jsp/Page/PageforTeacher/testdiemdanh";
	}
	@RequestMapping(value = { "/servlet" })
	public String loadtest(Model model,HttpServletRequest request,@ModelAttribute("attandence") Attandence attan){
		String[] id= request.getParameterValues("id");
		String[] status = request.getParameterValues("statusxx");
		String test=null;
		for (String i : id) {
	        System.out.println("id da chon: "+ i);
	    }
		List<Attandence> lista= new ArrayList<Attandence>();
		Attandence newattan= new Attandence();
		Attandence[] sv= new Attandence[45];
		int i =0;
        for (String s : status) {
        	Attandence saveattan= attandenceResponsitory.findByid(id[i]);
            System.out.println("status da chon: "+ s);
            test=""+s;
            saveattan.setStatus(test);

            attandenceResponsitory.save(saveattan);
           i++;
        }
       
        DateTimeFormatter dtfs = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime nows = LocalDateTime.now();   
        List<Course> couseid=courseResponsitory.findcustomteacher(idzz);
		for (Course u : couseid) {
			System.out.println("outti11>>>"+u.getId());
			List<Schedule> schedule= scheduleResponsitory.findcustomCouse(u.getId());
			for (Schedule s : schedule) {
				System.out.println("out lop id>>>"+s.getClassroom().getId());
				Classroom classroom= classroomResponsitory.findByid(s.getClassroom().getId());
				System.out.println("outxxx>>>"+classroom.getId());
				List<ClassroomStudent> croomstudent=classroomStudentrespon.findcustomclass(classroom.getId());
				
				model.addAttribute("Lists",croomstudent);
			}
			
			
		}
        
        List<Attandence> list= attandenceResponsitory.findcustomdate(dtfs.format(nows));
		model.addAttribute("List",list);
		return "/jsp/Page/PageforTeacher/diemdanh";
	}
}
