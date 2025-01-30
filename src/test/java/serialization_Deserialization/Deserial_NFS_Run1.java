package serialization_Deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserial_NFS_Run1 {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fileinput = new FileInputStream("./f.txt");
		ObjectInputStream objin = new ObjectInputStream(fileinput);
		NFSgame user1Obj = (NFSgame)objin.readObject();
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.level);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.life);
		objin.close();
	}
}
