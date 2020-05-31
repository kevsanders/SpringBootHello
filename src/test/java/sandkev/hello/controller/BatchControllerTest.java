package sandkev.hello.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import sandkev.hello.batch.Transaction;
import sandkev.hello.repo.TransactionRepository;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class BatchControllerTest extends AbstractRestControllerTest{

    //public static final String URI = "/batch?batchJobName=firstBatchJob";
    public static final String URI = "/batch/firstBatchJob";

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getRolesList() throws Exception {

        //TODO: why does this run twice
        transactionRepository.deleteAll();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI )
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();


        assertEquals(3, transactionRepository.count());

        List<Transaction> transactions = transactionRepository.findAll();
        assertThat(transactions, hasItem(Matchers.<Transaction> hasProperty("username",
                equalTo("devendra"))));
        assertThat(transactions, hasItem(Matchers.<Transaction> hasProperty("username",
                equalTo("john"))));
        assertThat(transactions, hasItem(Matchers.<Transaction> hasProperty("username",
                equalTo("robin"))));

//        checkXml(Input.fromFile("build/xml/output.xml"),
//                Input.fromFile("src/test/resources/batch/expected/transactionRecords.xml"));


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