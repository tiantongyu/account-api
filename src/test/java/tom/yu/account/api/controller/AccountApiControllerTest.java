package tom.yu.account.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.apache.tomcat.util.http.fileupload.util.Streams.asString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountApiControllerTest {


    @Autowired
    private MockMvc mvc;

    private AccountApiController controller;

    @Test
    public void testRetrieveAccounts() throws Exception {
        final String expectedResponse = asString(new ClassPathResource("accounts-response.json").getInputStream());
        mvc.perform(MockMvcRequestBuilders.get("/v1/accounts"))
                .andExpect(status().isOk()).andExpect(content().json(expectedResponse));
    }

    @Test
    public void testRetrieveTransactions() throws Exception {
        final String expectedResponse = asString(new ClassPathResource("transaction-response-1.json").getInputStream());
        mvc.perform(MockMvcRequestBuilders.get("/v1/account/00001/transactions"))
                .andExpect((status().isOk())).andExpect(content().json(expectedResponse));
    }

    @Test
    public void testRetrieveTransactions_NoTransactions() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/account/00002/transactions"))
                .andExpect((status().isOk())).andExpect(content().json("[]"));
    }

}
