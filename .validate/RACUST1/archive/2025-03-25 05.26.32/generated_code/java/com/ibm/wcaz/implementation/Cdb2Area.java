package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.ExternalDecimalAsLongField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class Cdb2Area implements Cloneable, Comparable<Cdb2Area> {
    private String d2RequestId = "";
    private int d2ReturnCode;
    private long d2CustomerNum;
    private String d2CustsecrPass = "";
    private String d2CustsecrCount = "";
    private char d2CustsecrState = ' ';
    private String d2CustsecrData = "";
    
    public Cdb2Area() {}
    
    public Cdb2Area(String d2RequestId, int d2ReturnCode, long d2CustomerNum, String d2CustsecrPass, String d2CustsecrCount, char d2CustsecrState, String d2CustsecrData) {
        this.d2RequestId = d2RequestId;
        this.d2ReturnCode = d2ReturnCode;
        this.d2CustomerNum = d2CustomerNum;
        this.d2CustsecrPass = d2CustsecrPass;
        this.d2CustsecrCount = d2CustsecrCount;
        this.d2CustsecrState = d2CustsecrState;
        this.d2CustsecrData = d2CustsecrData;
    }
    
    protected Cdb2Area(final Cdb2Area that) {
        this.d2RequestId = that.d2RequestId;
        this.d2ReturnCode = that.d2ReturnCode;
        this.d2CustomerNum = that.d2CustomerNum;
        this.d2CustsecrPass = that.d2CustsecrPass;
        this.d2CustsecrCount = that.d2CustsecrCount;
        this.d2CustsecrState = that.d2CustsecrState;
        this.d2CustsecrData = that.d2CustsecrData;
    }
    
    @Override
    public Cdb2Area clone() {
        return new Cdb2Area(this);
    }
    
    protected Cdb2Area(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Cdb2Area(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Cdb2Area fromBytes(byte[] bytes, int offset) {
        return new Cdb2Area(bytes, offset);
    }
    
    public static Cdb2Area fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Cdb2Area fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getD2RequestId() {
        return this.d2RequestId;
    }
    
    public void setD2RequestId(String d2RequestId) {
        this.d2RequestId = d2RequestId;
    }
    
    public int getD2ReturnCode() {
        return this.d2ReturnCode;
    }
    
    public void setD2ReturnCode(int d2ReturnCode) {
        this.d2ReturnCode = d2ReturnCode;
    }
    
    public long getD2CustomerNum() {
        return this.d2CustomerNum;
    }
    
    public void setD2CustomerNum(long d2CustomerNum) {
        this.d2CustomerNum = d2CustomerNum;
    }
    
    public String getD2CustsecrPass() {
        return this.d2CustsecrPass;
    }
    
    public void setD2CustsecrPass(String d2CustsecrPass) {
        this.d2CustsecrPass = d2CustsecrPass;
    }
    
    public String getD2CustsecrCount() {
        return this.d2CustsecrCount;
    }
    
    public void setD2CustsecrCount(String d2CustsecrCount) {
        this.d2CustsecrCount = d2CustsecrCount;
    }
    
    public char getD2CustsecrState() {
        return this.d2CustsecrState;
    }
    
    public void setD2CustsecrState(char d2CustsecrState) {
        this.d2CustsecrState = d2CustsecrState;
    }
    
    public String getD2CustsecrData() {
        return this.d2CustsecrData;
    }
    
    public void setD2CustsecrData(String d2CustsecrData) {
        this.d2CustsecrData = d2CustsecrData;
    }
    
    public void reset() {
        d2RequestId = "";
        d2ReturnCode = 0;
        d2CustomerNum = 0;
        d2CustsecrPass = "";
        d2CustsecrCount = "";
        d2CustsecrState = ' ';
        d2CustsecrData = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ d2RequestId=\"");
        s.append(getD2RequestId());
        s.append("\"");
        s.append(", d2ReturnCode=\"");
        s.append(getD2ReturnCode());
        s.append("\"");
        s.append(", d2CustomerNum=\"");
        s.append(getD2CustomerNum());
        s.append("\"");
        s.append(", d2CustsecrPass=\"");
        s.append(getD2CustsecrPass());
        s.append("\"");
        s.append(", d2CustsecrCount=\"");
        s.append(getD2CustsecrCount());
        s.append("\"");
        s.append(", d2CustsecrState=\"");
        s.append(getD2CustsecrState());
        s.append("\"");
        s.append(", d2CustsecrData=\"");
        s.append(getD2CustsecrData());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(Cdb2Area that) {
        return this.d2RequestId.equals(that.d2RequestId) &&
            this.d2ReturnCode == that.d2ReturnCode &&
            this.d2CustomerNum == that.d2CustomerNum &&
            this.d2CustsecrPass.equals(that.d2CustsecrPass) &&
            this.d2CustsecrCount.equals(that.d2CustsecrCount) &&
            this.d2CustsecrState == that.d2CustsecrState &&
            this.d2CustsecrData.equals(that.d2CustsecrData);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Cdb2Area other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof Cdb2Area;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(d2RequestId);
        result = 31 * result + Integer.hashCode(d2ReturnCode);
        result = 31 * result + Long.hashCode(d2CustomerNum);
        result = 31 * result + Objects.hashCode(d2CustsecrPass);
        result = 31 * result + Objects.hashCode(d2CustsecrCount);
        result = 31 * result + Character.hashCode(d2CustsecrState);
        result = 31 * result + Objects.hashCode(d2CustsecrData);
        return result;
    }
    
    @Override
    public int compareTo(Cdb2Area that) {
        int c = 0;
        c = this.d2RequestId.compareTo(that.d2RequestId);
        if ( c != 0 ) return c;
        c = Integer.compare(this.d2ReturnCode, that.d2ReturnCode);
        if ( c != 0 ) return c;
        c = Long.compare(this.d2CustomerNum, that.d2CustomerNum);
        if ( c != 0 ) return c;
        c = this.d2CustsecrPass.compareTo(that.d2CustsecrPass);
        if ( c != 0 ) return c;
        c = this.d2CustsecrCount.compareTo(that.d2CustsecrCount);
        if ( c != 0 ) return c;
        c = Character.compare(this.d2CustsecrState, that.d2CustsecrState);
        if ( c != 0 ) return c;
        c = this.d2CustsecrData.compareTo(that.d2CustsecrData);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField D_2_REQUEST_ID = factory.getStringField(6);
    private static final ExternalDecimalAsIntField D_2_RETURN_CODE = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsLongField D_2_CUSTOMER_NUM = factory.getExternalDecimalAsLongField(10, true);
    private static final StringField D_2_CUSTSECR_PASS = factory.getStringField(32);
    private static final StringField D_2_CUSTSECR_COUNT = factory.getStringField(4);
    private static final StringField D_2_CUSTSECR_STATE = factory.getStringField(1, false);
    private static final StringField D_2_CUSTSECR_DATA = factory.getStringField(32445);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        D_2_REQUEST_ID.putString(d2RequestId, bytes, offset);
        D_2_RETURN_CODE.putInt(d2ReturnCode, bytes, offset);
        D_2_CUSTOMER_NUM.putLong(d2CustomerNum, bytes, offset);
        D_2_CUSTSECR_PASS.putString(d2CustsecrPass, bytes, offset);
        D_2_CUSTSECR_COUNT.putString(d2CustsecrCount, bytes, offset);
        D_2_CUSTSECR_STATE.putString(Character.toString(d2CustsecrState), bytes, offset);
        D_2_CUSTSECR_DATA.putString(d2CustsecrData, bytes, offset);
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
        d2RequestId = D_2_REQUEST_ID.getString(bytes, offset);
        d2ReturnCode = D_2_RETURN_CODE.getInt(bytes, offset);
        d2CustomerNum = D_2_CUSTOMER_NUM.getLong(bytes, offset);
        d2CustsecrPass = D_2_CUSTSECR_PASS.getString(bytes, offset);
        d2CustsecrCount = D_2_CUSTSECR_COUNT.getString(bytes, offset);
        d2CustsecrState = D_2_CUSTSECR_STATE.getString(bytes, offset).charAt(0);
        d2CustsecrData = D_2_CUSTSECR_DATA.getString(bytes, offset);
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
