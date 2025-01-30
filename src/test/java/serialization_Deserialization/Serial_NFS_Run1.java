package serialization_Deserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial_NFS_Run1 {
   public static void main(String[] args) throws IOException {
	NFSgame userObj1 = new NFSgame("ASR", 10, 5000, 2);
	FileOutputStream fileout = new FileOutputStream("./f.txt");
	ObjectOutputStream objout = new ObjectOutputStream(fileout);
	objout.writeObject(userObj1);
	objout.close();
}
}
