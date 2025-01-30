package pojoClass;

import java.util.List;

public class Project1_POJO {
	   String projectName;
	   String projectstatus;
	   int teamSize;
	   List<String> teamMember;
	   ProjectManager projectManager;
  public Project1_POJO(String projectName, String projectstatus, int teamSize, List<String> teamMember,ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectstatus(String projectstatus) {
	        this.projectstatus = projectstatus;
	    }
	    public String getProjectstatus() {
	        return projectstatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
}
  class ProjectManager {
	   String name;
	   String empID;
     public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	  }
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpID(String empID) {
	        this.empID = empID;
	    }
	    public String getEmpID() {
	        return empID;
	    }
	    
	}
