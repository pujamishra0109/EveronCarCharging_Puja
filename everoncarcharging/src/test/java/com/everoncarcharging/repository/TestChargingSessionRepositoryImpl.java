package com.everoncarcharging.repository;

import com.everoncarcharging.dto.ChargingSessionRequest;
import com.everoncarcharging.dto.ChargingSessionResponse;
import com.everoncarcharging.exception.ChargingSessionException;
import com.everoncarcharging.mapper.IModelMapper;
import com.everoncarcharging.model.ChargingSession;
import com.everoncarcharging.util.ChargingSessionStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Puja on 05/07/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestChargingSessionRepositoryImpl {
    private static final Logger log = LoggerFactory.getLogger(TestChargingSessionRepositoryImpl.class);


    @Autowired
    ChargingSessionRepositoryImpl chargingSessionRepository;

    @Test
    public void testCreateChargingSession() throws Exception{
        ChargingSessionRequest chargingSessionRequest=new ChargingSessionRequest("merlin");
       ChargingSession chargingSession=this. chargingSessionRepository.mapToChargingSession(chargingSessionRequest);
        ChargingSession chargingSession1=this.chargingSessionRepository.createChargingSession(chargingSessionRequest);
        Assert.assertNotNull(chargingSession1);
        Assert.assertEquals(chargingSession.getStationId(),chargingSession1.getStationId());
        Assert.assertEquals(chargingSession.getStatus(),chargingSession1.getStatus());
      }

      @Test
      public void testMapToChargingSession(){
          ChargingSessionRequest chargingSessionRequest=new ChargingSessionRequest("merlin");

          ChargingSession chargingSession=this.chargingSessionRepository.mapToChargingSession(chargingSessionRequest);
          Assert.assertNotNull(chargingSession);
          Assert.assertEquals(chargingSessionRequest.getStationId(),chargingSession.getStationId());
      }
      @Test
    public void testFindAllChargingSessions(){

          List<ChargingSession>chargingSessionList=this.chargingSessionRepository.findAllChargingSessions();
          Assert.assertNotNull(chargingSessionList);
      }

      @Test(expected= IllegalArgumentException.class)
      public void testValidate() throws Exception{

          this.chargingSessionRepository.validate("hello");
      }


}