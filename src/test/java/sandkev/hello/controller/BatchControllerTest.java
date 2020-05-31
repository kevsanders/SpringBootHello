package sandkev.hello.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BatchControllerTest extends AbstractRestControllerTest{

    //public static final String URI = "/batch?batchJobName=firstBatchJob";
    public static final String URI = "/batch/firstBatchJob";

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

        checkXml(Input.fromFile("build/xml/output.xml"),
                Input.fromFile("src/test/resources/batch/expected/transactionRecords.xml"));


    }

    private void checkXml(Input.Builder control, Input.Builder test){
        Diff myDiff = DiffBuilder.compare(control).withTest(test)
                .ignoreComments()
                .ignoreWhitespace()
                .ignoreElementContentWhitespace()
                .checkForSimilar().build();
        assertFalse(myDiff.toString(), myDiff.hasDifferences());
    }
}