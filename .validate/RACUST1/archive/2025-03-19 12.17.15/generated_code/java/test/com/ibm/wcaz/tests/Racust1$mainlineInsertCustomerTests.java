package com.ibm.wcaz.tests;

import java.sql.Connection;
import org.mockito.ArgumentMatchers;
import org.junit.runner.RunWith;
import com.ibm.cics.server.ContainerIterator;
import java.util.HashMap;
import java.util.ArrayList;
import org.mockito.stubbing.Answer;
import java.sql.SQLException;
import org.mockito.invocation.InvocationOnMock;
import java.sql.ResultSet;
import java.util.Map;
import org.junit.After;
import org.powermock.core.classloader.annotations.PrepareForTest;
import com.ibm.wcaz.implementation.*;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;
import com.ibm.cics.server.Task;
import org.junit.Before;
import com.ibm.cics.server.Channel;
import org.junit.Test;
import java.sql.PreparedStatement;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import java.util.List;
import java.sql.Statement;
import org.junit.Assert;
import java.sql.DriverManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Racust1.class, DriverManager.class})
public class Racust1$mainlineInsertCustomerTests {

    Map<Integer, Map<String, Object>> resOutputValueMap = new HashMap<Integer, Map<String,Object>>();

    MockedStatic<java.sql.Connection> mockConnection;
    MockedStatic<java.sql.ResultSet> mockResultSet;
    MockedStatic<com.ibm.cics.server.Channel> mockChannel;
    MockedStatic<com.ibm.cics.server.ContainerIterator> mockContainerIterator;
    MockedStatic<java.sql.PreparedStatement> mockPreparedStatement;
    MockedStatic<com.ibm.cics.server.Task> mockTask;
    MockedStatic<java.sql.DriverManager> mockDriverManager;


    @Before
    public void setUp(){
        mockConnection = Mockito.mockStatic(java.sql.Connection.class);
        mockResultSet = Mockito.mockStatic(java.sql.ResultSet.class);
        mockChannel = Mockito.mockStatic(com.ibm.cics.server.Channel.class);
        mockContainerIterator = Mockito.mockStatic(com.ibm.cics.server.ContainerIterator.class);
        mockPreparedStatement = Mockito.mockStatic(java.sql.PreparedStatement.class);
        mockTask = Mockito.mockStatic(com.ibm.cics.server.Task.class);
        mockDriverManager = Mockito.mockStatic(java.sql.DriverManager.class);
    }

    @After
    public void tearDown(){
        mockConnection.close();
        mockResultSet.close();
        mockChannel.close();
        mockContainerIterator.close();
        mockPreparedStatement.close();
        mockTask.close();
        mockDriverManager.close();
    }

    @Test
    public void mainlineInsertCustomerTest_1() throws Exception{
        System.out.println("\n\nTestID: 1");
        // Instantiate the class or method to test
        Racust1 racust1Obj = new Racust1();


        // create local variables
        Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
        ErrorMsg errorMsg = new ErrorMsg();
        String sql = "0";
        Connection conn = Mockito.mock(Connection.class);
        PreparedStatement ps = Mockito.mock(PreparedStatement.class);
        ResultSet rs = Mockito.mock(ResultSet.class);

        // create class level variables
         racust1Obj.setLgacNcs("ON");
         racust1Obj.setDb2CustomernumInt(1);
        Racust1 racust1 = new Racust1();
        String lgacNcs = "0";
        int db2CustomernumInt = 0;

        // create target method parameters
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        caCustomerRequest.getCustomer().setFirstname("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setLastname("xxxxxxxxxxxxxxxxxxxx");
        // COMMENT: Incompatible type found. Value: xxxxxxxxxx Type:Date. 
        //        caCustomerRequest.getCustomer().setDateofbirth("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousename("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousenumber("xxxx");
        caCustomerRequest.getCustomer().setPostcode("xxxxxxxx");
        caCustomerRequest.getCustomer().setPhonemobile("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setPhonehome("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setEmailaddress("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        // mocking static behaviour
        Mockito.doNothing().when(ps).close();
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).close();
        Statement statement__ = Mockito.mock(Statement.class);
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(556,"CUSTOMER.CUSTOMERNUMBER",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setInt(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());
        PowerMockito.when(DriverManager.getConnection(ArgumentMatchers.any())).thenReturn(conn,conn,conn);
        PowerMockito.when(statement__.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);
        PowerMockito.when(conn.createStatement()).thenReturn(statement__);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyString())).thenReturn(0);
        PowerMockito.when(conn.prepareStatement(ArgumentMatchers.anyString())).thenReturn(ps,ps);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyInt())).thenReturn(0);
        PowerMockito.when(rs.next()).thenReturn(true);
        PowerMockito.when(ps.executeUpdate()).thenReturn(0,0);

        // Call the target method  
        try {
            racust1Obj.mainlineInsertCustomer(caCustomerRequest);
        } catch (Exception e) {
            Exception failure = new Exception("Cannot complete the test. Exception while executing mainlineInsertCustomer." + e.getMessage());
            failure.setStackTrace(getMethodStackTrace(e));
            throw failure;
        }


        // Assertions to check the expected outcome
        // Java variable mapping not found for these cobol variables
                // SQLCA
        // COMMENT: Skipping assertion since errorMsg is local var. 
        //        Assert.assertEquals("INSERT CUSTOMER", getValue(errorMsg.getEmVariable().getEmSqlreq()));
        Assert.assertEquals(1, getValue(caCustomerRequest.getCaCustomerNum()));

        // Assertions for resource output
        Assert.assertTrue(resOutputValueMap.size()>0);
        Assert.assertEquals("1", getData(resOutputValueMap,556,"CUSTOMER.CUSTOMERNUMBER"));
    }


    @Test
    public void mainlineInsertCustomerTest_2() throws Exception{
        System.out.println("\n\nTestID: 2");
        // Instantiate the class or method to test
        Racust1 racust1Obj = new Racust1();


        // create local variables
        Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
        ErrorMsg errorMsg = new ErrorMsg();
        String sql = "0";
        Connection conn = Mockito.mock(Connection.class);
        PreparedStatement ps = Mockito.mock(PreparedStatement.class);
        ResultSet rs = Mockito.mock(ResultSet.class);

        // create class level variables
         racust1Obj.setLgacNcs("€€");
        Racust1 racust1 = new Racust1();
        String lgacNcs = "0";
        int db2CustomernumInt = 0;

        // create target method parameters
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        caCustomerRequest.getCustomer().setFirstname("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setLastname("xxxxxxxxxxxxxxxxxxxx");
        // COMMENT: Incompatible type found. Value: xxxxxxxxxx Type:Date. 
        //        caCustomerRequest.getCustomer().setDateofbirth("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousename("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousenumber("xxxx");
        caCustomerRequest.getCustomer().setPostcode("xxxxxxxx");
        caCustomerRequest.getCustomer().setPhonemobile("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setPhonehome("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setEmailaddress("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        // mocking static behaviour
        Mockito.doNothing().when(ps).close();
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).close();
        Statement statement__ = Mockito.mock(Statement.class);
        Mockito.doAnswer(invocation -> { throw new SQLException("Non-zero sql"); }).when(ps).executeUpdate();
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(585,"CUSTOMER.FIRSTNAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 2 : setResourceValues(585,"CUSTOMER.LASTNAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 3 : setResourceValues(585,"CUSTOMER.HOUSENAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 4 : setResourceValues(585,"CUSTOMER.HOUSENUMBER",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 5 : setResourceValues(585,"CUSTOMER.POSTCODE",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 6 : setResourceValues(585,"CUSTOMER.PHONEMOBILE",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 7 : setResourceValues(585,"CUSTOMER.PHONEHOME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 8 : setResourceValues(585,"CUSTOMER.EMAILADDRESS",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(585,"CUSTOMER.DATEOFBIRTH",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        PowerMockito.when(DriverManager.getConnection(ArgumentMatchers.any())).thenReturn(conn,conn,conn);
        PowerMockito.when(statement__.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);
        PowerMockito.when(conn.createStatement()).thenReturn(statement__);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyString())).thenReturn(0);
        PowerMockito.when(conn.prepareStatement(ArgumentMatchers.anyString())).thenReturn(ps,ps);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyInt())).thenReturn(0);
        PowerMockito.when(rs.next()).thenReturn(true);

        // Call the target method  
        try {
            racust1Obj.mainlineInsertCustomer(caCustomerRequest);
        } catch (Exception e) {
            Exception failure = new Exception("Cannot complete the test. Exception while executing mainlineInsertCustomer." + e.getMessage());
            failure.setStackTrace(getMethodStackTrace(e));
            throw failure;
        }


        // Assertions to check the expected outcome
        // Java variable mapping not found for these cobol variables
                // SQLCA
        // COMMENT: Skipping assertion since errorMsg is local var. 
        //        Assert.assertEquals("INSERT CUSTOMER", getValue(errorMsg.getEmVariable().getEmSqlreq()));
        Assert.assertEquals(200040400, getValue(racust1Obj.getDb2CustomernumInt()));
        Assert.assertEquals(200040400, getValue(caCustomerRequest.getCaCustomerNum()));

        // Assertions for resource output
        Assert.assertTrue(resOutputValueMap.size()>0);
        Assert.assertEquals("xxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.POSTCODE"));
        Assert.assertEquals("xxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.FIRSTNAME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.PHONEHOME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.HOUSENAME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.LASTNAME"));
        Assert.assertEquals("xxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.DATEOFBIRTH"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.PHONEMOBILE"));
        Assert.assertEquals("xxxx", getData(resOutputValueMap,585,"CUSTOMER.HOUSENUMBER"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.EMAILADDRESS"));
    }


    @Test
    public void mainlineInsertCustomerTest_3() throws Exception{
        System.out.println("\n\nTestID: 3");
        // Instantiate the class or method to test
        Racust1 racust1Obj = new Racust1();


        // create local variables
        Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
        ErrorMsg errorMsg = new ErrorMsg();
        String sql = "0";
        Connection conn = Mockito.mock(Connection.class);
        PreparedStatement ps = Mockito.mock(PreparedStatement.class);
        ResultSet rs = Mockito.mock(ResultSet.class);

        // create class level variables
         racust1Obj.setLgacNcs("ON");
         racust1Obj.setDb2CustomernumInt(0);
        Racust1 racust1 = new Racust1();
        String lgacNcs = "0";
        int db2CustomernumInt = 0;

        // create target method parameters
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        caCustomerRequest.getCustomer().setFirstname("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setLastname("xxxxxxxxxxxxxxxxxxxx");
        // COMMENT: Incompatible type found. Value: xxxxxxxxxx Type:Date. 
        //        caCustomerRequest.getCustomer().setDateofbirth("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousename("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousenumber("xxxx");
        caCustomerRequest.getCustomer().setPostcode("xxxxxxxx");
        caCustomerRequest.getCustomer().setPhonemobile("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setPhonehome("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setEmailaddress("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        // mocking static behaviour
        Mockito.doNothing().when(ps).close();
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).close();
        Statement statement__ = Mockito.mock(Statement.class);
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(556,"CUSTOMER.CUSTOMERNUMBER",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setInt(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());
        Mockito.doAnswer(invocation -> { throw new SQLException("Non-zero sql"); }).when(ps).executeUpdate();
        PowerMockito.when(DriverManager.getConnection(ArgumentMatchers.any())).thenReturn(conn,conn,conn);
        PowerMockito.when(statement__.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);
        PowerMockito.when(conn.createStatement()).thenReturn(statement__);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyString())).thenReturn(0);
        PowerMockito.when(conn.prepareStatement(ArgumentMatchers.anyString())).thenReturn(ps,ps);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyInt())).thenReturn(0);
        PowerMockito.when(rs.next()).thenReturn(true);

        // Call the target method  
        try {
            racust1Obj.mainlineInsertCustomer(caCustomerRequest);
        } catch (Exception e) {
            Exception failure = new Exception("Cannot complete the test. Exception while executing mainlineInsertCustomer." + e.getMessage());
            failure.setStackTrace(getMethodStackTrace(e));
            throw failure;
        }


        // Assertions to check the expected outcome
        // Java variable mapping not found for these cobol variables
                // SQLCA
        // COMMENT: Skipping assertion since errorMsg is local var. 
        //        Assert.assertEquals("INSERT CUSTOMER", getValue(errorMsg.getEmVariable().getEmSqlreq()));
        Assert.assertEquals(90, getValue(caCustomerRequest.getCaReturnCode()));

        // Assertions for resource output
        Assert.assertTrue(resOutputValueMap.size()>0);
        Assert.assertEquals("0", getData(resOutputValueMap,556,"CUSTOMER.CUSTOMERNUMBER"));
    }


    @Test
    public void mainlineInsertCustomerTest_4() throws Exception{
        System.out.println("\n\nTestID: 4");
        // Instantiate the class or method to test
        Racust1 racust1Obj = new Racust1();


        // create local variables
        Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
        ErrorMsg errorMsg = new ErrorMsg();
        String sql = "0";
        Connection conn = Mockito.mock(Connection.class);
        PreparedStatement ps = Mockito.mock(PreparedStatement.class);
        ResultSet rs = Mockito.mock(ResultSet.class);

        // create class level variables
         racust1Obj.setLgacNcs("\"&");
        Racust1 racust1 = new Racust1();
        String lgacNcs = "0";
        int db2CustomernumInt = 0;

        // create target method parameters
        CaCustomerRequest caCustomerRequest = new CaCustomerRequest();
        caCustomerRequest.getCustomer().setFirstname("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setLastname("xxxxxxxxxxxxxxxxxxxx");
        // COMMENT: Incompatible type found. Value: xxxxxxxxxx Type:Date. 
        //        caCustomerRequest.getCustomer().setDateofbirth("xxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousename("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setHousenumber("xxxx");
        caCustomerRequest.getCustomer().setPostcode("xxxxxxxx");
        caCustomerRequest.getCustomer().setPhonemobile("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setPhonehome("xxxxxxxxxxxxxxxxxxxx");
        caCustomerRequest.getCustomer().setEmailaddress("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        // mocking static behaviour
        Mockito.doNothing().when(ps).close();
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doNothing().when(ps).close();
        Statement statement__ = Mockito.mock(Statement.class);
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(585,"CUSTOMER.DATEOFBIRTH",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setDate(ArgumentMatchers.anyInt(),ArgumentMatchers.any(java.sql.Date.class));
        Mockito.doAnswer(new Answer<Void>() {
            private int invocationCount = 0;
            public Void answer(InvocationOnMock invocation) {
                invocationCount++;
                switch (invocationCount) {
                    case 1 : setResourceValues(585,"CUSTOMER.FIRSTNAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 2 : setResourceValues(585,"CUSTOMER.LASTNAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 3 : setResourceValues(585,"CUSTOMER.HOUSENAME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 4 : setResourceValues(585,"CUSTOMER.HOUSENUMBER",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 5 : setResourceValues(585,"CUSTOMER.POSTCODE",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 6 : setResourceValues(585,"CUSTOMER.PHONEMOBILE",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 7 : setResourceValues(585,"CUSTOMER.PHONEHOME",1,convertByteArrayToString(invocation.getArguments()));break;
                    case 8 : setResourceValues(585,"CUSTOMER.EMAILADDRESS",1,convertByteArrayToString(invocation.getArguments()));
                }
                return null;
        }}).when(ps).setString(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString());
        Mockito.doAnswer(invocation -> { throw new SQLException("Non-zero sql"); }).when(ps).executeUpdate();
        PowerMockito.when(DriverManager.getConnection(ArgumentMatchers.any())).thenReturn(conn,conn,conn);
        PowerMockito.when(statement__.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);
        PowerMockito.when(conn.createStatement()).thenReturn(statement__);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyString())).thenReturn(0);
        PowerMockito.when(conn.prepareStatement(ArgumentMatchers.anyString())).thenReturn(ps,ps);
        PowerMockito.when(rs.getInt(ArgumentMatchers.anyInt())).thenReturn(0);
        PowerMockito.when(rs.next()).thenReturn(true);

        // Call the target method  
        try {
            racust1Obj.mainlineInsertCustomer(caCustomerRequest);
        } catch (Exception e) {
            Exception failure = new Exception("Cannot complete the test. Exception while executing mainlineInsertCustomer." + e.getMessage());
            failure.setStackTrace(getMethodStackTrace(e));
            throw failure;
        }


        // Assertions to check the expected outcome
        // Java variable mapping not found for these cobol variables
                // SQLCA
        // COMMENT: Skipping assertion since errorMsg is local var. 
        //        Assert.assertEquals("INSERT CUSTOMER", getValue(errorMsg.getEmVariable().getEmSqlreq()));
        Assert.assertEquals(90, getValue(caCustomerRequest.getCaReturnCode()));

        // Assertions for resource output
        Assert.assertTrue(resOutputValueMap.size()>0);
        Assert.assertEquals("xxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.POSTCODE"));
        Assert.assertEquals("xxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.FIRSTNAME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.PHONEHOME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.HOUSENAME"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.LASTNAME"));
        Assert.assertEquals("xxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.DATEOFBIRTH"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.PHONEMOBILE"));
        Assert.assertEquals("xxxx", getData(resOutputValueMap,585,"CUSTOMER.HOUSENUMBER"));
        Assert.assertEquals("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", getData(resOutputValueMap,585,"CUSTOMER.EMAILADDRESS"));
    }


    private String getData(Map<Integer, Map<String, Object>> resOutputValueMap, int cobolLine, String fieldname){
	     if (resOutputValueMap.containsKey(cobolLine) && resOutputValueMap.get(cobolLine).containsKey(fieldname) && resOutputValueMap.get(cobolLine).get(fieldname) != null)
		     return resOutputValueMap.get(cobolLine).get(fieldname).toString();

      return null;
    }

    private Object getValue(Object varValue) {
      if (varValue instanceof String)
        return varValue.toString().trim();
      if (varValue instanceof Long)
        return ((Long) varValue).intValue();
      return varValue;
    }

    private StackTraceElement[] getMethodStackTrace(Exception e) {
      List<StackTraceElement> stackTraceList = new ArrayList<>();
	     boolean flag = false;
      for (StackTraceElement element : e.getStackTrace()) {
        if (element.getClassName().startsWith("com.ibm.wcaz.implementation")) {
          flag = true;
        } else if (flag) {
          break;
        }
        stackTraceList.add(element);
      }
      return stackTraceList.toArray(StackTraceElement[]::new);
    }

    private Object[] convertByteArrayToString(Object[] objects) {
      for (int i = 0; i < objects.length; i++) {
        if (objects[i] instanceof byte[]) {
          objects[i] = new String((byte[]) objects[i]);
        }
      }
      return objects;
    }

    private int setResourceValues(int cobolLine, String cobolField, int javaIndex, Object[] args) {
        Map<String, Object> varValue = resOutputValueMap.get(cobolLine);
        if (varValue == null) {
          varValue = new HashMap<String, Object> ();
          resOutputValueMap.put(cobolLine, varValue);
        }
        varValue.put(cobolField, args[javaIndex]);
    return 0;
    }

}
