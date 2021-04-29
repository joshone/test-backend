package cl.ionix.testbackend;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cl.ionix.testbackend.controller.UsuariosController;
import cl.ionix.testbackend.model.User;
import cl.ionix.testbackend.repository.UserRepository;
import cl.ionix.testbackend.service.SandboxClient;
import cl.ionix.testbackend.service.SandboxService;
import cl.ionix.testbackend.service.UserService;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	
	@Mock
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private SandboxService sandboxService;
	
	@Mock
	private SandboxClient sandboxClient;
	
	@InjectMocks
	private UsuariosController usuarioController;
	
	
	@Test
	public void testUsuarioController_getAll() throws Exception {
		List<User> list = new ArrayList<>();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
		list.add(new User(1, "joshone", "joshone", "jsalinasmagallanes@gmail.com", "973208063"));
		
		when(userService.all()).thenReturn(list);
		
		mockMvc.perform(get("/v1/api/all"))
		.andExpect(status().isOk());
		
		verify(userService).all();
	}
	
	@Test
	public void testUsuarioController_save() throws Exception {
		
		String json =  "{\n" +
                "  \"name\": \"pedro\",\n" +
                "  \"username\": \"pepe2020\",\n" +
                "  \"email\": \"pepe@gmail.com\",\n" +
                "  \"phone\": \"123456789\"\n" +
                "}";
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
		
		mockMvc.perform(post("/v1/api/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void testUsuarioController_find() throws Exception {
		
		String email = "jsalinasmagallanes@gmail.com";
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
		when(userService.findByEmail(email)).thenReturn(new User(1, "joshone", "joshone", "jsalinasmagallanes@gmail.com", "973208063"));
		mockMvc.perform(get("/v1/api/find?email=" + email)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		;
		
		verify(userService).findByEmail(email);
		
	}
	
	
	@Test
	public void testUsuarioController_sandboxApi() throws Exception {
		
		String json =  "{\n" +
                "  \"rut\": \"1-9\"\n" +
                "}";
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
		mockMvc.perform(post("/v1/api/api-sandbox")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isOk());
		
	}
}
