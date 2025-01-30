package encryptionAndDecryption;

import org.testng.annotations.Test;

public class AESencriptTest {
	@Test
	public void sampleTest() throws Exception {
		String privatekey = "Ac03tEam@j!tu_#1";
		String data = "ASRanjith";
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		System.out.println(ed.encrypt(data, privatekey));
		System.out.println(ed.decrypt("2XKsKWCi7xm43bhazOXprQ==", privatekey));
	}
	@Test
	public void jsonEncryptAndDecrypt() throws Exception {
		String privatekey = "Ac03tEam@j!tu_#1";
		String data = "{ \"name\" : \"AS Ranjith\" , \"id\" : \"tp_256\" }";
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		System.out.println(ed.encrypt(data, privatekey));
		System.out.println(ed.decrypt("+duMC9ifGYJ0qDujDV2hbtHQCGdgC7jF8C2NV/h46QAAY+BcKjQdGAWgmZ+CB8YI", privatekey));
	}
}
