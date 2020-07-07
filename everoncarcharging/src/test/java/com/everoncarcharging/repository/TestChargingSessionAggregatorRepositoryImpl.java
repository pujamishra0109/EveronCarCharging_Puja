package com.everoncarcharging.repository;

import com.everoncarcharging.dto.ChargingSessionSummaryResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Puja on 05/07/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestChargingSessionAggregatorRepositoryImpl {

    @Autowired
    ChargingSessionAggregatorRepository chargingSessionAggregatorRepository;


    @Test
    public void testGetSessionSummary() throws Exception{
        this.chargingSessionAggregatorRepository=new ChargingSessionAggregatorRepositoryImpl();

        ChargingSessionSummaryResponse response=this.chargingSessionAggregatorRepository.getSessionSummary();
        Assert.assertNotNull(response);

        System.out.print("repository "+ response.getStoppedCount()+" "+ response.getStartedCount()+" "+ response.getTotalCount());
     }

    @Test
    public void testStartSession(){
        LocalDateTime localDateTime=LocalDateTime.now();
        chargingSessionAggregatorRepository.startSession(localDateTime);
        Assert.assertTrue(this.chargingSessionAggregatorRepository.getStartSessionQueue().contains(localDateTime));


    }
    @Test
    public void testStoppedSession(){

        LocalDateTime localDateTime=LocalDateTime.now();
        chargingSessionAggregatorRepository.stopSession(localDateTime);
        Assert.assertTrue(this.chargingSessionAggregatorRepository.getStoppedSession().contains(localDateTime));
    }

    @Test
    public void testGetStartSessionQueue(){

        PriorityBlockingQueue priorityBlockingQueue=this.chargingSessionAggregatorRepository.getStartSessionQueue();
        Assert.assertNotNull(priorityBlockingQueue);
    }

    @Test
    public void testGetStoppedSession(){

        PriorityBlockingQueue priorityBlockingQueue=this.chargingSessionAggregatorRepository.getStoppedSession();
        Assert.assertNotNull(priorityBlockingQueue);
    }



}
