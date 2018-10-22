package azarenka.functional.web;

import azarenka.entity.Order;
import azarenka.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.MediaType;
import resources.DataOrder;


import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTest extends WebTest {

    @Autowired
    private OrderService service;

    @Before
    public void setUp() throws Exception {
        service.create(DataOrder.ORDER_TEST);
        service.create(DataOrder.ORDER_TEST2);
    }

    @After
    public void tearDown() throws Exception {
        String id = service.getByName("Камод").get(0).getId();
        service.delete(id);
        String id2 = service.getByName("Камод2").get(0).getId();
        service.delete(id2);
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/order/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name':'Камод'},{'name' : 'Камод2'}]"));
    }

    @Test
    public void remove() throws Exception {
        List<Order> orders = service.getAll();
        mockMvc.perform(delete("/order/remove/{id}", orders.get(0).getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(
                post("/order/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(DataOrder.ORDER_TEST)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getOne() throws Exception{
        List<Order> orders = service.getAll();
        mockMvc.perform(get("/orger/get/{id}",orders.get(0).getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'name':'Камод'}"));
    }

    @Test
    public void getByName() throws Exception {
        mockMvc.perform(get("/order/getByName/{name}", "Камод"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name':'Камод'}]"));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
