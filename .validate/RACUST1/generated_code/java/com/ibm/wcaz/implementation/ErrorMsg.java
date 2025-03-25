package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

public class ErrorMsg implements Cloneable, Comparable<ErrorMsg> {
    private String emDate = "";
    private String emTime = "";
    private EmVariable emVariable = new EmVariable();
    
    public ErrorMsg() {
        initFiller();
    }
    
    public ErrorMsg(String emDate, String emTime, EmVariable emVariable) {
        this.emDate = emDate;
        this.emTime = emTime;
        this.emVariable = emVariable;
        initFiller();
    }
    
    protected ErrorMsg(final ErrorMsg that) {
        this.emDate = that.emDate;
        this.emTime = that.emTime;
        this.emVariable = that.emVariable.clone();
        this.filler1 = that.filler1;
        this.filler2 = that.filler2;
    }
    
    @Override
    public ErrorMsg clone() {
        return new ErrorMsg(this);
    }
    
    protected ErrorMsg(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected ErrorMsg(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static ErrorMsg fromBytes(byte[] bytes, int offset) {
        return new ErrorMsg(bytes, offset);
    }
    
    public static ErrorMsg fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static ErrorMsg fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getEmDate() {
        return this.emDate;
    }
    
    public void setEmDate(String emDate) {
        this.emDate = emDate;
    }
    
    public String getEmTime() {
        return this.emTime;
    }
    
    public void setEmTime(String emTime) {
        this.emTime = emTime;
    }
    
    public EmVariable getEmVariable() {
        return this.emVariable;
    }
    
    public void setEmVariable(EmVariable emVariable) {
        this.emVariable = emVariable;
    }
    
    public void reset() {
        emDate = "";
        emTime = "";
        emVariable.reset();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ emDate=\"");
        s.append(getEmDate());
        s.append("\"");
        s.append(", filler1=\"");
        s.append(new String(filler1, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", emTime=\"");
        s.append(getEmTime());
        s.append("\"");
        s.append(", filler2=\"");
        s.append(new String(filler2, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", emVariable=\"");
        s.append(getEmVariable());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(ErrorMsg that) {
        return this.emDate.equals(that.emDate) &&
            Arrays.equals(this.filler1, that.filler1) &&
            this.emTime.equals(that.emTime) &&
            Arrays.equals(this.filler2, that.filler2) &&
            this.emVariable.equals(that.emVariable);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof ErrorMsg other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof ErrorMsg;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(emDate);
        result = 31 * result + Arrays.hashCode(filler1);
        result = 31 * result + Objects.hashCode(emTime);
        result = 31 * result + Arrays.hashCode(filler2);
        result = 31 * result + Objects.hashCode(emVariable);
        return result;
    }
    
    @Override
    public int compareTo(ErrorMsg that) {
        int c = 0;
        c = this.emDate.compareTo(that.emDate);
        if ( c != 0 ) return c;
        c = Arrays.compare(this.filler1, that.filler1);
        if ( c != 0 ) return c;
        c = this.emTime.compareTo(that.emTime);
        if ( c != 0 ) return c;
        c = Arrays.compare(this.filler2, that.filler2);
        if ( c != 0 ) return c;
        c = this.emVariable.compareTo(that.emVariable);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField EM_DATE = factory.getStringField(8);
    private static final ByteArrayField FILLER_1 = factory.getByteArrayField(1);
    private byte[] filler1 = new byte[1];
    private static final StringField EM_TIME = factory.getStringField(6);
    private static final ByteArrayField FILLER_2 = factory.getByteArrayField(9);
    private byte[] filler2 = new byte[9];
    private static final ByteArrayField EM_VARIABLE = factory.getByteArrayField(EmVariable.SIZE);
    private void initFiller() {
        new StringField(0, 1).putString(Character.toString(' '), filler1);
        new StringField(0, 9).putString(" LGACDB01", filler2);
    }
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        EM_DATE.putString(emDate, bytes, offset);
        FILLER_1.putByteArray(filler1, bytes, offset);
        EM_TIME.putString(emTime, bytes, offset);
        FILLER_2.putByteArray(filler2, bytes, offset);
        emVariable.getBytes(bytes, EM_VARIABLE.getOffset() + offset);
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
        emDate = EM_DATE.getString(bytes, offset);
        FILLER_1.getByteArray(bytes, offset);
        emTime = EM_TIME.getString(bytes, offset);
        FILLER_2.getByteArray(bytes, offset);
        emVariable.setBytes(bytes, EM_VARIABLE.getOffset() + offset);
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
