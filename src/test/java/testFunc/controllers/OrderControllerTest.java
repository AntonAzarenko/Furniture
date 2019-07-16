package testFunc.controllers;

import org.junit.Test;

import java.util.Date;

import azarenka.dto.OrderResponse;
import azarenka.util.DateTimeUtil;
import testFunc.WebTest;

public class OrderControllerTest extends WebTest {

    @Test
    public void getAllByUser() throws Exception {
       // List<OrderResponse> orderDTOList = dozerBeanMapper.map(buildOrderDTO().
    }

    @Test
    public void remove() {
    }

    @Test
    public void save() {
    }

    private OrderResponse buildOrderDTO(){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(1L);
        orderResponse.setName("Шкаф");
        orderResponse.setTelNumber("+375294564563");
        orderResponse.setDateOfCreate(DateTimeUtil.toString(new Date()));
        return orderResponse;
    }
}