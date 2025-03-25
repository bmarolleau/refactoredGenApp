package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class CaCustsecrRequest extends Dfhcommarea1 {
    private String caCustsecrPass = "";
    private String caCustsecrCount = "";
    private char caCustsecrState = ' ';
    private String caCustsecrData = "";
    
    public CaCustsecrRequest() {}
    
    public CaCustsecrRequest(String caRequestId, int caReturnCode, long caCustomerNum, String caCustsecrPass, String caCustsecrCount, char caCustsecrState, String caCustsecrData) {
        super(caRequestId, caReturnCode, caCustomerNum);
        this.caCustsecrPass = caCustsecrPass;
        this.caCustsecrCount = caCustsecrCount;
        this.caCustsecrState = caCustsecrState;
        this.caCustsecrData = caCustsecrData;
    }
    
    protected CaCustsecrRequest(final CaCustsecrRequest that) {
        super(that);
        this.caCustsecrPass = that.caCustsecrPass;
        this.caCustsecrCount = that.caCustsecrCount;
        this.caCustsecrState = that.caCustsecrState;
        this.caCustsecrData = that.caCustsecrData;
    }
    
    @Override
    public CaCustsecrRequest clone() {
        return new CaCustsecrRequest(this);
    }
    
    protected CaCustsecrRequest(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CaCustsecrRequest(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CaCustsecrRequest fromBytes(byte[] bytes, int offset) {
        return new CaCustsecrRequest(bytes, offset);
    }
    
    public static CaCustsecrRequest fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CaCustsecrRequest fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCaCustsecrPass() {
        return this.caCustsecrPass;
    }
    
    public void setCaCustsecrPass(String caCustsecrPass) {
        this.caCustsecrPass = caCustsecrPass;
    }
    
    public String getCaCustsecrCount() {
        return this.caCustsecrCount;
    }
    
    public void setCaCustsecrCount(String caCustsecrCount) {
        this.caCustsecrCount = caCustsecrCount;
    }
    
    public char getCaCustsecrState() {
        return this.caCustsecrState;
    }
    
    public void setCaCustsecrState(char caCustsecrState) {
        this.caCustsecrState = caCustsecrState;
    }
    
    public String getCaCustsecrData() {
        return this.caCustsecrData;
    }
    
    public void setCaCustsecrData(String caCustsecrData) {
        this.caCustsecrData = caCustsecrData;
    }
    
    public void reset() {
        super.reset();
        caCustsecrPass = "";
        caCustsecrCount = "";
        caCustsecrState = ' ';
        caCustsecrData = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ caCustsecrPass=\"");
        s.append(getCaCustsecrPass());
        s.append("\"");
        s.append(", caCustsecrCount=\"");
        s.append(getCaCustsecrCount());
        s.append("\"");
        s.append(", caCustsecrState=\"");
        s.append(getCaCustsecrState());
        s.append("\"");
        s.append(", caCustsecrData=\"");
        s.append(getCaCustsecrData());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(CaCustsecrRequest that) {
        return super.equals(that) &&
            this.caCustsecrPass.equals(that.caCustsecrPass) &&
            this.caCustsecrCount.equals(that.caCustsecrCount) &&
            this.caCustsecrState == that.caCustsecrState &&
            this.caCustsecrData.equals(that.caCustsecrData);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CaCustsecrRequest other) && other.canEqual(this) && this.equals(other);
    }
    
    @Override
    public boolean canEqual(Object that) {
        return that instanceof CaCustsecrRequest;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * super.hashCode();
        result = 31 * result + Objects.hashCode(caCustsecrPass);
        result = 31 * result + Objects.hashCode(caCustsecrCount);
        result = 31 * result + Character.hashCode(caCustsecrState);
        result = 31 * result + Objects.hashCode(caCustsecrData);
        return result;
    }
    
    public int compareTo(CaCustsecrRequest that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = this.caCustsecrPass.compareTo(that.caCustsecrPass);
        if ( c != 0 ) return c;
        c = this.caCustsecrCount.compareTo(that.caCustsecrCount);
        if ( c != 0 ) return c;
        c = Character.compare(this.caCustsecrState, that.caCustsecrState);
        if ( c != 0 ) return c;
        c = this.caCustsecrData.compareTo(that.caCustsecrData);
        if ( c == 0 && !that.canEqual(this) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    @Override
    public int compareTo(Dfhcommarea1 that) {
        if (that instanceof CaCustsecrRequest other) {
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
    
    private static final StringField CA_CUSTSECR_PASS = factory.getStringField(32);
    private static final StringField CA_CUSTSECR_COUNT = factory.getStringField(4);
    private static final StringField CA_CUSTSECR_STATE = factory.getStringField(1, false);
    private static final StringField CA_CUSTSECR_DATA = factory.getStringField(32445);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        CA_CUSTSECR_PASS.putString(caCustsecrPass, bytes, offset);
        CA_CUSTSECR_COUNT.putString(caCustsecrCount, bytes, offset);
        CA_CUSTSECR_STATE.putString(Character.toString(caCustsecrState), bytes, offset);
        CA_CUSTSECR_DATA.putString(caCustsecrData, bytes, offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        caCustsecrPass = CA_CUSTSECR_PASS.getString(bytes, offset);
        caCustsecrCount = CA_CUSTSECR_COUNT.getString(bytes, offset);
        caCustsecrState = CA_CUSTSECR_STATE.getString(bytes, offset).charAt(0);
        caCustsecrData = CA_CUSTSECR_DATA.getString(bytes, offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
