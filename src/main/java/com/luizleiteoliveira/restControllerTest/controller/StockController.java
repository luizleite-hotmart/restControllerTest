package com.luizleiteoliveira.restControllerTest.controller;

import com.luizleiteoliveira.restControllerTest.service.StockServices;
import com.luizleiteoliveira.restControllerTest.vo.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StockController {

    private final StockServices stockServices;

    public StockController(StockServices stockServices) {
        this.stockServices = stockServices;
    }

    @GetMapping(value = "/stocks")
    public @ResponseBody
    List<Stock> getStocks(@RequestParam("howMany") int howMany) {
        return stockServices.createMockStocks(howMany);
    }
}
