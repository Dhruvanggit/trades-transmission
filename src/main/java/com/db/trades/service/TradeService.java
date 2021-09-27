package com.db.trades.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.db.trades.exception.InvalidMaturityDateException;
import com.db.trades.exception.LowerVersionException;
import com.db.trades.model.Trade;

@Service
public class TradeService {	
			
	public Trade getPersistedTrade(String tradeId) {
		Trade trade = new Trade();
		
		return trade;
	}
	
	public Trade saveTrade(Trade trade) {
		Trade dbTrade = getPersistedTrade(trade.getId());
		boolean result = false;
		result = validateTrade(dbTrade,trade);
		if(!result) {
			
		}
		return trade;
	}
	
	private boolean validateTrade(Trade dbTrade,Trade outTrade) {
		boolean result = false; 
		result = validateVersion(dbTrade, outTrade);
		if(result)
			validateMaturityDate(dbTrade, outTrade);
				
		return result;
	}
	
	/*
	 * inTrade - Trade record stored in db
	 * outTrade- Trade record which needs to be stored in db
	 */
	private boolean validateVersion(Trade dbTrade,Trade outTrade) {	
		if (dbTrade.getVersion() > outTrade.getVersion()) {
			throw new LowerVersionException("Given Trade "+dbTrade.getId()+" version: "+dbTrade.getVersion()+" is lower than stored version.");
		}
		return true;		
	}

	private boolean validateMaturityDate(Trade dbTrade,Trade outTrade) {		
		Date cd = new Date();
		Date rd = outTrade.getMaturity_date();
		
		if (rd.before(cd)) {
			throw new InvalidMaturityDateException("Given Trade "+outTrade.getId()+" ,maturity date: "+outTrade.getMaturity_date()+" is before current date. Hence this trade cannot be store.");			
		}				
		return true;
	}
}
