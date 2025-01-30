package pojoClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Project1 {
  public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	  List<String> list=new ArrayList<String>();
	  list.add("Jhon");
	  list.add("devid");
	  list.add("stev");
	  ProjectManager pm= new ProjectManager("sagar","tp01");
	Project1_POJO project1_pojo = new Project1_POJO("ASR","Created",10,list,pm);
	ObjectMapper obj= new ObjectMapper();
	obj.writeValue(new File("./project1.json"), project1_pojo);
}
}
