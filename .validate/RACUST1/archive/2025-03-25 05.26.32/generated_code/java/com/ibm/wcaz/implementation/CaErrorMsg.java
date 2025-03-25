package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

public class CaErrorMsg implements Cloneable, Comparable<CaErrorMsg> {
    private String caData = "";
    
    public CaErrorMsg() {
        initFiller();
    }
    
    public CaErrorMsg(String caData) {
        this.caData = caData;
        initFiller();
    }
    
    protected CaErrorMsg(final CaErrorMsg that) {
        this.caData = that.caData;
        this.filler6 = that.filler6;
    }
    
    @Override
    public CaErrorMsg clone() {
        return new CaErrorMsg(this);
    }
    
    protected CaErrorMsg(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CaErrorMsg(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CaErrorMsg fromBytes(byte[] bytes, int offset) {
        return new CaErrorMsg(bytes, offset);
    }
    
    public static CaErrorMsg fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CaErrorMsg fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCaData() {
        return this.caData;
    }
    
    public void setCaData(String caData) {
        this.caData = caData;
    }
    
    public void reset() {
        caData = "";
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ filler6=\"");
        s.append(new String(filler6, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", caData=\"");
        s.append(getCaData());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(CaErrorMsg that) {
        return Arrays.equals(this.filler6, that.filler6) &&
            this.caData.equals(that.caData);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CaErrorMsg other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof CaErrorMsg;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(filler6);
        result = 31 * result + Objects.hashCode(caData);
        return result;
    }
    
    @Override
    public int compareTo(CaErrorMsg that) {
        int c = 0;
        c = Arrays.compare(this.filler6, that.filler6);
        if ( c != 0 ) return c;
        c = this.caData.compareTo(that.caData);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ByteArrayField FILLER_6 = factory.getByteArrayField(9);
    private byte[] filler6 = new byte[9];
    private static final StringField CA_DATA = factory.getStringField(90);
    private void initFiller() {
        new StringField(0, 9).putString("COMMAREA=", filler6);
    }
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        FILLER_6.putByteArray(filler6, bytes, offset);
        CA_DATA.putString(caData, bytes, offset);
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
        FILLER_6.getByteArray(bytes, offset);
        caData = CA_DATA.getString(bytes, offset);
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
