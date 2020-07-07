# EveronCarCharging_Puja

Tech Stack/Framework  used 

Java 8 
Spring Boot 
JUnit 
Lombok
Mockito
Maven

How to run it

Prerequisite
Java 8
Maven 

Steps to run it :

1.Clone the git repository or unzip the compressed folder of the source code.
2.To build - mvn clean compile install
3. To run - use any one of the following commands :
(i)  mvn spring-boot:run
(ii) Run the EveroncarchargingApplication


Steps to run the test cases :

1.mvn clean test-compile test
2.Application.properties ->
Number_of_sessions - It denotes the number of sessions a station can occupy. It can be changed and checked for the same.



Assumptions 

stationId is unique and represents a charging station
A limited number of charging sessions per charging station is available for use at any given time. The default value set in the application is 5. If the maximum number of active sessions is already reached for a station, an appropriate error message is sent in the response.
A charging session if started and ended within a minute would appear in both startedCount and stoppedCount 

Explanation of some design choices

Use of ConcurrentHashMap for chargingsession

Storing sessionId as the key and the chargingSession object as the value.
Since map is an in-memory data structure, it is being used to ensure constant-time operation of O(1) for creating and reading a session
ConcurrentHashMap is the map chosen for thread safety purpose as multiple threads can access it for read operation and hence doesn’t lead to concurrent modification as it also provides a locking mechanism during updation. 

How the session summary is being computed 

PriorityBlockingQueue is used to store the session time to retrieve the last one-minute session count. 
PriorityQueue has the offer and poll method to retrieve and add an object in log(n) time complexity and PriorityBlockingQueue is a thread-safe Priority Queue that prevents from any concurrent modification.

SessionId - UUID mapping is done to check if a station has reached the maximum number of sessions or not.

ConcurrentHashMap is used to store the sessionId as the key and set of UUID as the value. 
Set is used to provide add, remove and contains operation for a uuid at O(1) time complexity.
