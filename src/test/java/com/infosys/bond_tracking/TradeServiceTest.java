package com.infosys.bond_tracking.service;

import com.infosys.bond_tracking.model.Trade;
import com.infosys.bond_tracking.repository.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TradeServiceTest {

    @Mock
    private TradeRepository tradeRepository; // Mock the TradeRepository

    @InjectMocks
    private TradeService tradeService; // The service to be tested

    private List<Trade> openTrades;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks before each test

        openTrades = new ArrayList<>();
        Trade trade1 = new Trade();
        trade1.setId(1L);
        trade1.setStatus("open");

        Trade trade2 = new Trade();
        trade2.setId(2L);
        trade2.setStatus("open");

        openTrades.add(trade1);
        openTrades.add(trade2);
    }

    @Test
    void testGetOpenTrades() {
        when(tradeRepository.findByStatus("open")).thenReturn(openTrades);

        List<Trade> trades = tradeService.getOpenTrades();

        assertNotNull(trades);
        assertEquals(2, trades.size());

        assertEquals("open", trades.get(0).getStatus());
        assertEquals("open", trades.get(1).getStatus());

        verify(tradeRepository, times(1)).findByStatus("open");
    }
}

