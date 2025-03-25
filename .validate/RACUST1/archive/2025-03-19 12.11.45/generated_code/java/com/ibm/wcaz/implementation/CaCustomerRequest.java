package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import com.ibm.wcaz.datamodel.Customer;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class CaCustomerRequest extends Dfhcommarea1 {
    private int caNumPolicies;
    private String caPolicyData = "";
    private Customer customer = new Customer();
    
    public CaCustomerRequest() {}
    
    public CaCustomerRequest(String caRequestId, int caReturnCode, long caCustomerNum, int caNumPolicies, String caPolicyData, Customer customer) {
        super(caRequestId, caReturnCode, caCustomerNum);
        this.caNumPolicies = caNumPolicies;
        this.caPolicyData = caPolicyData;
        this.customer = customer;
    }
    
    protected CaCustomerRequest(final CaCustomerRequest that) {
        super(that);
        this.caNumPolicies = that.caNumPolicies;
        this.caPolicyData = that.caPolicyData;
        this.customer = that.customer.clone();
    }
    
    @Override
    public CaCustomerRequest clone() {
        return new CaCustomerRequest(this);
    }
    
    protected CaCustomerRequest(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CaCustomerRequest(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CaCustomerRequest fromBytes(byte[] bytes, int offset) {
        return new CaCustomerRequest(bytes, offset);
    }
    
    public static CaCustomerRequest fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CaCustomerRequest fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getCaNumPolicies() {
        return this.caNumPolicies;
    }
    
    public void setCaNumPolicies(int caNumPolicies) {
        this.caNumPolicies = caNumPolicies;
    }
    
    public String getCaPolicyData() {
        return this.caPolicyData;
    }
    
    public void setCaPolicyData(String caPolicyData) {
        this.caPolicyData = caPolicyData;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void reset() {
        super.reset();
        caNumPolicies = 0;
        caPolicyData = "";
        customer = new Customer();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ caNumPolicies=\"");
        s.append(getCaNumPolicies());
        s.append("\"");
        s.append(", caPolicyData=\"");
        s.append(getCaPolicyData());
        s.append("\"");
        s.append(", customer=\"");
        s.append(getCustomer());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(CaCustomerRequest that) {
        return super.equals(that) &&
            this.caNumPolicies == that.caNumPolicies &&
            this.caPolicyData.equals(that.caPolicyData) &&
            this.customer.equals(that.customer);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CaCustomerRequest other) && other.canEqual(this) && this.equals(other);
    }
    
    @Override
    public boolean canEqual(Object that) {
        return that instanceof CaCustomerRequest;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * super.hashCode();
        result = 31 * result + Integer.hashCode(caNumPolicies);
        result = 31 * result + Objects.hashCode(caPolicyData);
        result = 31 * result + Objects.hashCode(customer);
        return result;
    }
    
    public int compareTo(CaCustomerRequest that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = Integer.compare(this.caNumPolicies, that.caNumPolicies);
        if ( c != 0 ) return c;
        c = this.caPolicyData.compareTo(that.caPolicyData);
        if ( c != 0 ) return c;
        c = this.customer.compareTo(that.customer);
        if ( c == 0 && !that.canEqual(this) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    @Override
    public int compareTo(Dfhcommarea1 that) {
        if (that instanceof CaCustomerRequest other) {
            return this.compareTo(other);
        } else {
            return super.compareTo(that);
        }
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
        factory.incrementOffset(Dfhcommarea1.SIZE);
    }
    
    private static final ExternalDecimalAsIntField CA_NUM_POLICIES = factory.getExternalDecimalAsIntField(3, true);
    private static final StringField CA_POLICY_DATA = factory.getStringField(32267);
    private static final ByteArrayField CUSTOMER = factory.getByteArrayField(Customer.SIZE);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        CA_NUM_POLICIES.putInt(caNumPolicies, bytes, offset);
        CA_POLICY_DATA.putString(caPolicyData, bytes, offset);
        customer.getBytes(bytes, CUSTOMER.getOffset() + offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        caNumPolicies = CA_NUM_POLICIES.getInt(bytes, offset);
        caPolicyData = CA_POLICY_DATA.getString(bytes, offset);
        customer.setBytes(bytes, CUSTOMER.getOffset() + offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
