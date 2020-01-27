package com.luizleiteoliveira.restControllerTest.controller;

import com.luizleiteoliveira.restControllerTest.service.StockServices;
import com.luizleiteoliveira.restControllerTest.vo.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockServices stockServices;

    @Test
    public void callingWithoutParameterShouldReturnBadRequest() throws Exception {
        List<Stock> result = new ArrayList<>();
        result.add(new Stock(new Date(),"NEWSTOCK", BigDecimal.TEN));
        Mockito.when(stockServices.createMockStocks(5)).thenReturn(result);
        this.mockMvc.perform(get("/stocks")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnJustOneFromResult() throws Exception {
        List<Stock> result = new ArrayList<>();
        result.add(new Stock(new Date(),"NEWSTOCK", BigDecimal.TEN));
        Mockito.when(stockServices.createMockStocks(1)).thenReturn(result);
        this.mockMvc.perform(get("/stocks").queryParam("howMany", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().string(containsString("NEWSTOCK")));
    }
}
