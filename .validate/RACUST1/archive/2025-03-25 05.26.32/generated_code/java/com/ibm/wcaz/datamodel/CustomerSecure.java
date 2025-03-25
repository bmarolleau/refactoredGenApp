package com.ibm.wcaz.datamodel;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class CustomerSecure implements Cloneable, Comparable<CustomerSecure> {
    private String customerpass = "";
    private String stateIndicator = "";
    private int passChanges;
    private Customer customer = new Customer();
    
    public CustomerSecure() {}
    
    public CustomerSecure(String customerpass, String stateIndicator, int passChanges, Customer customer) {
        this.customerpass = customerpass;
        this.stateIndicator = stateIndicator;
        this.passChanges = passChanges;
        this.customer = customer;
    }
    
    protected CustomerSecure(final CustomerSecure that) {
        this.customerpass = that.customerpass;
        this.stateIndicator = that.stateIndicator;
        this.passChanges = that.passChanges;
        this.customer = that.customer.clone();
    }
    
    @Override
    public CustomerSecure clone() {
        return new CustomerSecure(this);
    }
    
    protected CustomerSecure(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CustomerSecure(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CustomerSecure fromBytes(byte[] bytes, int offset) {
        return new CustomerSecure(bytes, offset);
    }
    
    public static CustomerSecure fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CustomerSecure fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCustomerpass() {
        return this.customerpass;
    }
    
    public void setCustomerpass(String customerpass) {
        this.customerpass = customerpass;
    }
    
    public String getStateIndicator() {
        return this.stateIndicator;
    }
    
    public void setStateIndicator(String stateIndicator) {
        this.stateIndicator = stateIndicator;
    }
    
    public int getPassChanges() {
        return this.passChanges;
    }
    
    public void setPassChanges(int passChanges) {
        this.passChanges = passChanges;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ customerpass=\"");
        s.append(getCustomerpass());
        s.append("\"");
        s.append(", stateIndicator=\"");
        s.append(getStateIndicator());
        s.append("\"");
        s.append(", passChanges=\"");
        s.append(getPassChanges());
        s.append("\"");
        s.append(", customer=\"");
        s.append(getCustomer());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(CustomerSecure that) {
        return this.customerpass.equals(that.customerpass) &&
            this.stateIndicator.equals(that.stateIndicator) &&
            this.passChanges == that.passChanges &&
            this.customer.equals(that.customer);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CustomerSecure other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof CustomerSecure;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(customerpass);
        result = 31 * result + Objects.hashCode(stateIndicator);
        result = 31 * result + Integer.hashCode(passChanges);
        result = 31 * result + Objects.hashCode(customer);
        return result;
    }
    
    @Override
    public int compareTo(CustomerSecure that) {
        int c = 0;
        c = this.customerpass.compareTo(that.customerpass);
        if ( c != 0 ) return c;
        c = this.stateIndicator.compareTo(that.stateIndicator);
        if ( c != 0 ) return c;
        c = Integer.compare(this.passChanges, that.passChanges);
        if ( c != 0 ) return c;
        c = this.customer.compareTo(that.customer);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField CUSTOMERPASS = factory.getStringField(33);
    private static final StringField STATE_INDICATOR = factory.getStringField(2);
    private static final ExternalDecimalAsIntField PASS_CHANGES = factory.getExternalDecimalAsIntField(5, true);
    private static final ByteArrayField CUSTOMER = factory.getByteArrayField(Customer.SIZE);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CUSTOMERPASS.putString(customerpass, bytes, offset);
        STATE_INDICATOR.putString(stateIndicator, bytes, offset);
        PASS_CHANGES.putInt(passChanges, bytes, offset);
        customer.getBytes(bytes, CUSTOMER.getOffset() + offset);
        return bytes;
    }
    
    public final byte[] getBytes(byte[] bytes) {
        return getBytes(bytes, 0);
    }
    
    public final byte[] getBytes() {
        return getBytes(new byte[numBytes()]);
    }
    
    public final String toByteString() {
        try {
            return new String(getBytes(), factory.getStringEncoding()).stripTrailing();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        customerpass = CUSTOMERPASS.getString(bytes, offset);
        stateIndicator = STATE_INDICATOR.getString(bytes, offset);
        passChanges = PASS_CHANGES.getInt(bytes, offset);
        customer.setBytes(bytes, CUSTOMER.getOffset() + offset);
    }
    
    
    public final void setBytes(byte[] bytes) {
        setBytes(bytes, 0);
    }
    
    public final void setBytes(String bytes) {
        try {
            setBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
