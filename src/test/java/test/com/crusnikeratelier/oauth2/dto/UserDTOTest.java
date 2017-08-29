package test.com.crusnikeratelier.oauth2.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.crusnikatelier.oauth2.dto.UserDTO;
import com.crusnikatelier.oauth2.utilities.MarshalUtils;

public class UserDTOTest {

	@Test
	public void testUserDTONilables() throws JAXBException {
		String marshalledString = null;
		UserDTO dto = new UserDTO();
		assertNull(dto.getUsername());
		assertNull(dto.getJoined());
		
		marshalledString = MarshalUtils.marshal(dto);
		dto = MarshalUtils.unmarshal(marshalledString, UserDTO.class);
		
		assertEquals(null, dto.getUsername());
		assertEquals(null, dto.getJoined());
		
		String username = "oauth@crusnikatelier.com";
		dto.setUsername(username);
		Date now = new Date();
		dto.setJoined(now);
		
		marshalledString = MarshalUtils.marshal(dto);
		dto = null;
		
		
		dto = MarshalUtils.unmarshal(marshalledString, UserDTO.class);
		assertEquals(username, dto.getUsername());
		assertEquals(now, dto.getJoined());
	}
}
