package com.luizleiteoliveira.restControllerTest.controller;

import com.luizleiteoliveira.restControllerTest.service.StockServices;
import com.luizleiteoliveira.restControllerTest.vo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockServices stockServices;

    @RequestMapping(value = "/stocks",method = RequestMethod.GET)
    public @ResponseBody List<Stock> getStocks (@RequestParam("howMany") int howMany){
        return stockServices.createMockStocks(howMany);
    }
}
