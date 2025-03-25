package com.ibm.wcaz.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.cics.server.Channel;
import com.ibm.cics.server.ContainerIterator;
import com.ibm.cics.server.Task;

// import java.sql.Statement;
import java.sql.DriverManager;

import java.sql.Connection;



public class Racust1 {
    private static Racust1 racust1 = new Racust1();
    private String lgacNcs = "ON";
    private int db2CustomernumInt=1;
    
    public Racust1() {}
    public String getLgacNcs() {
        return this.lgacNcs;
    }
    
    public void setLgacNcs(String lgacNcs) {
        this.lgacNcs = lgacNcs;
    }
    
    public int getDb2CustomernumInt() {
        return this.db2CustomernumInt;
    }
    
    public void setDb2CustomernumInt(int db2CustomernumInt) {
        this.db2CustomernumInt = db2CustomernumInt;
    }
    
    
    public static Racust1 getInstance() {
        return racust1;
    }
    
    public void mainlineInsertCustomer(CaCustomerRequest caCustomerRequest) {
    Dfhcommarea1 dfhcommarea1 = new Dfhcommarea1();
    ErrorMsg errorMsg = new ErrorMsg();
    
    errorMsg.getEmVariable().setEmSqlreq(" INSERT CUSTOMER");

    if (this.getLgacNcs().equals("ON")) {
        try {
            String sql = "INSERT INTO CUSTOMER(CUSTOMERNUMBER, FIRSTNAME, LASTNAME, DATEOFBIRTH, HOUSENAME, HOUSENUMBER, POSTCODE, PHONEMOBILE, PHONEHOME, EMAILADDRESS)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            /// PreparedStatement ps = JdbcConnection.connection.prepareStatement(sql);
            Connection conn =    DriverManager.getConnection("endpoint_url");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, this.getDb2CustomernumInt());
            ps.setString(2, caCustomerRequest.getCustomer().getFirstname());
            ps.setString(3, caCustomerRequest.getCustomer().getLastname());
            ps.setDate(4, caCustomerRequest.getCustomer().getDateofbirth());
            ps.setString(5, caCustomerRequest.getCustomer().getHousename());
            ps.setString(6, caCustomerRequest.getCustomer().getHousenumber());
            ps.setString(7, caCustomerRequest.getCustomer().getPostcode());
            ps.setString(8, caCustomerRequest.getCustomer().getPhonemobile());
            ps.setString(9, caCustomerRequest.getCustomer().getPhonehome());
            ps.setString(10, caCustomerRequest.getCustomer().getEmailaddress());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException exception) {
            caCustomerRequest.setCaReturnCode(Integer.parseInt("90"));
            mainlineWriteErrorMessage(dfhcommarea1, errorMsg);
            return;
        }
    } else {
        try {
            String sql = "INSERT INTO CUSTOMER(FIRSTNAME, LASTNAME, DATEOFBIRTH, HOUSENAME, HOUSENUMBER, POSTCODE, PHONEMOBILE, PHONEHOME, EMAILADDRESS)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // PreparedStatement ps = JdbcConnection.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Connection conn =    DriverManager.getConnection("endpoint_url");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, caCustomerRequest.getCustomer().getFirstname());
            ps.setString(2, caCustomerRequest.getCustomer().getLastname());
            ps.setDate(3, caCustomerRequest.getCustomer().getDateofbirth());
            ps.setString(4, caCustomerRequest.getCustomer().getHousename());
            ps.setString(5, caCustomerRequest.getCustomer().getHousenumber());
            ps.setString(6, caCustomerRequest.getCustomer().getPostcode());
            ps.setString(7, caCustomerRequest.getCustomer().getPhonemobile());
            ps.setString(8, caCustomerRequest.getCustomer().getPhonehome());
            ps.setString(9, caCustomerRequest.getCustomer().getEmailaddress());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException exception) {
            caCustomerRequest.setCaReturnCode(Integer.parseInt("90"));
            mainlineWriteErrorMessage(dfhcommarea1, errorMsg);
            return;
        }
        try {
            // ResultSet rs = JdbcConnection.connection.createStatement()
            ResultSet rs;
            Connection conn = DriverManager.getConnection("endpoint_url");
            rs =  conn.createStatement().executeQuery("SELECT IDENTITY_VAL_LOCAL() FROM SYSIBM.SYSDUMMY1");
            rs.next();
            this.setDb2CustomernumInt(rs.getInt(1));
        } catch (SQLException exception) {
            System.out.println(exception);
            return;
        }
    }
    caCustomerRequest.setCaCustomerNum(this.getDb2CustomernumInt());

}

    
    public void mainlineFirstSentences(Dfhcommarea1 dfhcommarea1) {
        // TODO: generate mainlineFirstSentences() method with IBM watsonx Code Assistant for Z
    }
    
    public void mainlineObtainCustomerNumber() {
    String genAcount = "GENACUSTNUM";
    String genApool = "GENA";
    int lastCustNum;
    int wsResp;

    genAcount = "GENACUSTNUM";
    genApool = "GENA";
    Task jdeclTask = Task.getTask();
    Channel jdeclChannel = jdeclTask.getCurrentChannel();
    ContainerIterator jdeclContainerIterator = jdeclChannel.containerIterator();
    jdeclContainerIterator.next();
    //genAcount = jdeclContainerIterator.getName();
    //lastCustNum = jdeclContainerIterator.getLengthNoConvert();
    //byte[] jdeclByteOutputData = jdeclContainerIterator.getNoConvert(0, lastCustNum);
    String jdeclLocalCcsid = System.getProperty("com.ibm.cics.jvmserver.local.ccsid");
    //String jdeclStringOutputData = new String(jdeclByteOutputData, Charset.forName(jdeclLocalCcsid));
    //genAcount = jdeclStringOutputData;
    //wsResp = jdeclContainerIterator.getRESP();
    //if (wsResp != 0) {
    //     this.setLgacNcs("NO");
    //    this.setDb2CustomernumInt(0);
    //} else {
    //    this.setDb2CustomernumInt(lastCustNum);
    //}

}


    
    public void mainlineWriteErrorMessage(Dfhcommarea1 dfhcommarea1, ErrorMsg errorMsg) {
        // TODO: generate mainlineWriteErrorMessage() method with IBM watsonx Code Assistant for Z
    }
    
    //public static void main(String[] args) {
    //    getInstance().mainlineFirstSentences();
    //}
}
