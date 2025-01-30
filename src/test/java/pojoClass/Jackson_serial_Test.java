package pojoClass;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClassUtility.Project;


public class Jackson_serial_Test {
   public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	Project pobj = new Project("Apple","ASR",10,"Created");
	ObjectMapper objmap = new ObjectMapper();
	objmap.writeValue(new File("./project.json"),pobj);
}
}
