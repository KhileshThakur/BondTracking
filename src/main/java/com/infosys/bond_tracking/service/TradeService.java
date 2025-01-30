package com.infosys.bond_tracking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.bond_tracking.model.Trade;
import com.infosys.bond_tracking.repository.TradeRepository;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getOpenTrades() {
        return tradeRepository.findByStatus("open");
    }

    public List<Trade> getTradesMaturingInNext5Days() {
        LocalDate today = LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(5);
        return tradeRepository.findBySettlementDateBetween(today, fiveDaysLater);
    }
}