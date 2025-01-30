package pojoClass;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClassUtility.Project;

public class Jackson_deserial_Test {
    public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objmap = new ObjectMapper();
		Project pobj = objmap.readValue(new File("./project.json"), Project.class);
		System.out.println(pobj.getProjectName());
		System.out.println(pobj.getTeamSize());
		System.out.println(pobj.getStatus());
		System.out.println(pobj.getCreatedBy());
	}
}
