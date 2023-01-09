package com.rubix.timesheet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.timesheet.Domain.Project;
import com.rubix.timesheet.Repository.ProjectRepository;



@Service
public class ProjectService {
	
	@Autowired
	 private ProjectRepository projectRepository;
	
	public List<Project> getProject() {
		return projectRepository.findAll();
	}
	
	public Project getProjectById(long id) {
		return projectRepository.findByProjectId(id);
	}
	
	public Project createProject(Project project) {
		System.out.println(project.getClientName());
		return projectRepository.save(project);
		
	}
	public String updateProject(long id,Project project) {
		Project existingproject = projectRepository.findByProjectId(id);
		existingproject.setClientName(project.getClientName());
		existingproject.setProjectName(project.getProjectName());
		existingproject.setProjectType(project.getProjectType());
		existingproject.setProjectDescription(project.getProjectDescription());
		existingproject.setProjectManager(project.getProjectManager());
		existingproject.setStartDate(project.getStartDate());
		existingproject.setEndDate(project.getEndDate());
		projectRepository.save(existingproject);
   	    return "successfully updated";
	}
	
	public String deleteProject(long id) {
		projectRepository.deleteById(id);
		return "successfully deleted";
	}

}
