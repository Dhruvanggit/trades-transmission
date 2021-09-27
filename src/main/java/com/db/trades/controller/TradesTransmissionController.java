package com.db.trades.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trades.model.Trade;
import com.db.trades.service.TradeService;

@RestController
@RequestMapping(value = "/trade")
public class TradesTransmissionController {
	
	@Autowired
	private TradeService tradeService;

	@PostMapping(value = "/process",
				 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	             produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Trade> processTrades(@RequestBody Trade trade) {
		
		Trade persistedTrade = tradeService.saveTrade(trade);
        return ResponseEntity
            .created(URI
                     .create(String.format("/trade/%s", trade.getId())))
            .body(persistedTrade);
	}
	
}
