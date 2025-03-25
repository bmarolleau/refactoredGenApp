package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.ExternalDecimalAsLongField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class Dfhcommarea1 implements Cloneable, Comparable<Dfhcommarea1> {
    private String caRequestId = "";
    private int caReturnCode;
    private long caCustomerNum;
    
    public Dfhcommarea1() {}
    
    public Dfhcommarea1(String caRequestId, int caReturnCode, long caCustomerNum) {
        this.caRequestId = caRequestId;
        this.caReturnCode = caReturnCode;
        this.caCustomerNum = caCustomerNum;
    }
    
    protected Dfhcommarea1(final Dfhcommarea1 that) {
        this.caRequestId = that.caRequestId;
        this.caReturnCode = that.caReturnCode;
        this.caCustomerNum = that.caCustomerNum;
    }
    
    @Override
    public Dfhcommarea1 clone() {
        return new Dfhcommarea1(this);
    }
    
    protected Dfhcommarea1(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Dfhcommarea1(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Dfhcommarea1 fromBytes(byte[] bytes, int offset) {
        return new Dfhcommarea1(bytes, offset);
    }
    
    public static Dfhcommarea1 fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Dfhcommarea1 fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCaRequestId() {
        return this.caRequestId;
    }
    
    public void setCaRequestId(String caRequestId) {
        this.caRequestId = caRequestId;
    }
    
    public int getCaReturnCode() {
        return this.caReturnCode;
    }
    
    public void setCaReturnCode(int caReturnCode) {
        this.caReturnCode = caReturnCode;
    }
    
    public long getCaCustomerNum() {
        return this.caCustomerNum;
    }
    
    public void setCaCustomerNum(long caCustomerNum) {
        this.caCustomerNum = caCustomerNum;
    }
    
    public void reset() {
        caRequestId = "";
        caReturnCode = 0;
        caCustomerNum = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ caRequestId=\"");
        s.append(getCaRequestId());
        s.append("\"");
        s.append(", caReturnCode=\"");
        s.append(getCaReturnCode());
        s.append("\"");
        s.append(", caCustomerNum=\"");
        s.append(getCaCustomerNum());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(Dfhcommarea1 that) {
        return this.caRequestId.equals(that.caRequestId) &&
            this.caReturnCode == that.caReturnCode &&
            this.caCustomerNum == that.caCustomerNum;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Dfhcommarea1 other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof Dfhcommarea1;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(caRequestId);
        result = 31 * result + Integer.hashCode(caReturnCode);
        result = 31 * result + Long.hashCode(caCustomerNum);
        return result;
    }
    
    @Override
    public int compareTo(Dfhcommarea1 that) {
        int c = 0;
        c = this.caRequestId.compareTo(that.caRequestId);
        if ( c != 0 ) return c;
        c = Integer.compare(this.caReturnCode, that.caReturnCode);
        if ( c != 0 ) return c;
        c = Long.compare(this.caCustomerNum, that.caCustomerNum);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField CA_REQUEST_ID = factory.getStringField(6);
    private static final ExternalDecimalAsIntField CA_RETURN_CODE = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsLongField CA_CUSTOMER_NUM = factory.getExternalDecimalAsLongField(10, true);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CA_REQUEST_ID.putString(caRequestId, bytes, offset);
        CA_RETURN_CODE.putInt(caReturnCode, bytes, offset);
        CA_CUSTOMER_NUM.putLong(caCustomerNum, bytes, offset);
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
        caRequestId = CA_REQUEST_ID.getString(bytes, offset);
        caReturnCode = CA_RETURN_CODE.getInt(bytes, offset);
        caCustomerNum = CA_CUSTOMER_NUM.getLong(bytes, offset);
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
