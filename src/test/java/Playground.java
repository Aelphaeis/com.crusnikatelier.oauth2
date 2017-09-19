import static org.junit.Assert.*;

import java.util.UUID;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.jcajce.provider.digest.SHA3.Digest512;
import org.bouncycastle.util.encoders.Hex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		
		
		SHA3.Digest512 digest = new Digest512();
		byte [] result = digest.digest("helloWorld".getBytes());
		System.out.println(Hex.toHexString(result));
		System.out.println(Hex.toHexString(result).length());
		
		//https://stackoverflow.com/questions/18142745/how-do-i-generate-a-salt-in-java-for-salted-hash
		
	}

}
