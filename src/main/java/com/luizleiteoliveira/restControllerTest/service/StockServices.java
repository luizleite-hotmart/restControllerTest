package com.luizleiteoliveira.restControllerTest.service;

import com.luizleiteoliveira.restControllerTest.vo.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StockServices {

    public List<Stock> createMockStocks(int howMany) {
        return IntStream.range(0, howMany).mapToObj(i -> new Stock(new Date(), "STK" + i, BigDecimal.valueOf(i))).collect(Collectors.toList());
    }
}
