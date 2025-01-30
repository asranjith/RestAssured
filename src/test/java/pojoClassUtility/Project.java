package pojoClassUtility;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

   @JsonPropertyOrder(
		   value = { "createdBy",
				     "projectName",
				     "teamSize",
				     "status"
		           }
		             )
   @JsonIgnoreProperties(
		    value = {
		    	      "teamSize"	
		    },allowSetters = true
		   )	   
   

public class Project {
	private String projectName;
	// @JsonProperty(value = "Created By")
	private String createdBy;
	private int teamSize;
	private String status;

	public Project() {
	}

	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
   class Jackson_serial_Test1 {
		public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
			Project pobj = new Project("Apple", "ASR", 10, "Created");
			ObjectMapper objmap = new ObjectMapper();
			objmap.writeValue(new File("./project.json"), pobj);
		}
	}
 