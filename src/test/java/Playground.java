import java.math.BigInteger;
import java.util.UUID;

import org.bouncycastle.crypto.generators.OpenBSDBCrypt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crusnikatelier.oauth2.utilities.Randomizer;
import com.crusnikatelier.oauth2.utilities.Users;

public class Playground {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UUID s = UUID.randomUUID();
		System.out.println(s);
		System.out.println(s.toString().length());
//		
//		
//		SHA3.Digest512 digest = new Digest512();
//		byte [] result = digest.digest("helloWorld".getBytes());
//		System.out.println(Hex.toHexString(result));
//		System.out.println(Hex.toHexString(result).length());
//		
		System.out.println();
		String password = "Hello World";
		Randomizer r = new Randomizer();

		String salt = Users.generateUserSalt();
		System.out.println(salt);
		byte[] bArr = Users.hexToByteArray(salt);
		BigInteger buffer = new BigInteger(1, bArr);
		System.out.println(buffer.toString(16));
		
		System.out.println(OpenBSDBCrypt.generate(password.toCharArray(), r.getBytes(16), 13).length());
		
	}

}
