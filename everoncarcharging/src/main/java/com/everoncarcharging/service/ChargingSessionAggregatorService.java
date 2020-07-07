package com.everoncarcharging.service;

import com.everoncarcharging.dto.ChargingSessionRequest;
import com.everoncarcharging.dto.ChargingSessionSummaryResponse;
import com.everoncarcharging.model.ChargingSession;

/**
 * Created by Puja on 04/07/20.
 */
public interface ChargingSessionAggregatorService {

    ChargingSessionSummaryResponse getSessionSummary() throws Exception;
    void startSession();
    void stopSession();

}
