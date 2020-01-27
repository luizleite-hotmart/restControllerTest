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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockServices stockServices;

    @Test
    public void shouldReturnJustOneFromResult() throws Exception {
        List<Stock> result = new ArrayList<>();
        result.add(new Stock(new Date(),"NEWSTOCK", BigDecimal.TEN));
        Mockito.when(stockServices.createMockStocks(5)).thenReturn(result);
        this.mockMvc.perform(get("/stocks")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
