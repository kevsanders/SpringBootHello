package sandkev.hello.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sandkev.hello.entity.Role;

import static org.junit.Assert.*;

public class RolesControllerTest extends AbstractRestControllerTest{

    public static final String URI = "/api/v1/roles";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getRolesList() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Role[] roles = super.mapFromJson(content, Role[].class);
        assertTrue(roles.length > 0);
    }
    @Test
    public void createRole() throws Exception {
        Role role = new Role();
        role.setName("TEST_ROLE");
        String inputJson = super.mapToJson(role);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("\"name\":\""+ role.getName() +"\""));
    }
    @Test
    @Ignore("not yet implemented")
    public void updateRole() throws Exception {
        Role role = new Role();
        role.setName("Lemon");
        role.setId(1);
        String inputJson = super.mapToJson(role);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Role is updated successsfully");
    }
    @Test
    public void deleteRole() throws Exception {
        String uri = URI + "/1";

        //pre-check
        MvcResult check = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        assertEquals(200, check.getResponse().getStatus());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        //post-check
        check = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), check.getResponse().getStatus());

    }
}