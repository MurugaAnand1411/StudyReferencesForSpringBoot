package com.rubix.timesheet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.timesheet.Domain.Project;
import com.rubix.timesheet.Service.ProjectService;
@CrossOrigin(origins = { "http://localhost:4200", "https://rubix-timesheet-client.herokuapp.com" })
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
    private ProjectService projectService;

    @GetMapping("/getprojectlist")
    public List<Project> getAllProject() {
        return projectService.getProject();
    }

   @GetMapping("/getprojectbyid/{id}")
    public Project getProjectById(@PathVariable(value="id") long id){
       return projectService.getProjectById(id);
        
    }
    
    @PostMapping("/createproject")
    public Project createProject(@RequestBody Project project) {
    	 return projectService.createProject(project);
    }
    @PutMapping("/updateproject/{id}")
    public String updateProject(@PathVariable(value = "id") long id,@RequestBody Project project){
    	
    	return projectService.updateProject(id, project);
    }
    @DeleteMapping("/deleteprojectbyid/{id}")
    public String deleteProject(@PathVariable(value="id") long id) {
    	return projectService.deleteProject(id);
    }


}
