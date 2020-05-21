package sandkev.hello.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sandkev.hello.entity.Role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BatchControllerTest extends AbstractRestControllerTest{

    public static final String URI = "/batch?firstBatchJob";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getRolesList() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI )
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//        Role[] roles = super.mapFromJson(content, Role[].class);
//        assertTrue(roles.length > 0);
    }
}