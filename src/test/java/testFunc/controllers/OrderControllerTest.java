package testFunc.controllers;

import org.junit.Test;

import java.util.Date;

import azarenka.dto.OrderDTO;
import azarenka.util.DateTimeUtil;
import testFunc.WebTest;

public class OrderControllerTest extends WebTest {

    @Test
    public void getAllByUser() throws Exception {
       // List<OrderDTO> orderDTOList = dozerBeanMapper.map(buildOrderDTO().
    }

    @Test
    public void remove() {
    }

    @Test
    public void save() {
    }

    private OrderDTO buildOrderDTO(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);
        orderDTO.setName("Шкаф");
        orderDTO.setTelNumber("+375294564563");
        orderDTO.setDateOfCreate(DateTimeUtil.toString(new Date()));
        return orderDTO;
    }
}