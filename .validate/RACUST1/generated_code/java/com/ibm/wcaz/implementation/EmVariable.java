package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

public class EmVariable implements Cloneable, Comparable<EmVariable> {
    private String emCusnum = "";
    private String emPolnum = "";
    private String emSqlreq = "";
    private int emSqlrc;
    
    public EmVariable() {
        initFiller();
    }
    
    public EmVariable(String emCusnum, String emPolnum, String emSqlreq, int emSqlrc) {
        this.emCusnum = emCusnum;
        this.emPolnum = emPolnum;
        this.emSqlreq = emSqlreq;
        this.emSqlrc = emSqlrc;
        initFiller();
    }
    
    protected EmVariable(final EmVariable that) {
        this.emCusnum = that.emCusnum;
        this.emPolnum = that.emPolnum;
        this.emSqlreq = that.emSqlreq;
        this.emSqlrc = that.emSqlrc;
        this.filler3 = that.filler3;
        this.filler4 = that.filler4;
        this.filler5 = that.filler5;
    }
    
    @Override
    public EmVariable clone() {
        return new EmVariable(this);
    }
    
    protected EmVariable(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected EmVariable(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static EmVariable fromBytes(byte[] bytes, int offset) {
        return new EmVariable(bytes, offset);
    }
    
    public static EmVariable fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static EmVariable fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getEmCusnum() {
        return this.emCusnum;
    }
    
    public void setEmCusnum(String emCusnum) {
        this.emCusnum = emCusnum;
    }
    
    public String getEmPolnum() {
        return this.emPolnum;
    }
    
    public void setEmPolnum(String emPolnum) {
        this.emPolnum = emPolnum;
    }
    
    public String getEmSqlreq() {
        return this.emSqlreq;
    }
    
    public void setEmSqlreq(String emSqlreq) {
        this.emSqlreq = emSqlreq;
    }
    
    public int getEmSqlrc() {
        return this.emSqlrc;
    }
    
    public void setEmSqlrc(int emSqlrc) {
        this.emSqlrc = emSqlrc;
    }
    
    public void reset() {
        emCusnum = "";
        emPolnum = "";
        emSqlreq = "";
        emSqlrc = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ filler3=\"");
        s.append(new String(filler3, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", emCusnum=\"");
        s.append(getEmCusnum());
        s.append("\"");
        s.append(", filler4=\"");
        s.append(new String(filler4, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", emPolnum=\"");
        s.append(getEmPolnum());
        s.append("\"");
        s.append(", emSqlreq=\"");
        s.append(getEmSqlreq());
        s.append("\"");
        s.append(", filler5=\"");
        s.append(new String(filler5, Charset.forName("IBM-1047")));
        s.append("\"");
        s.append(", emSqlrc=\"");
        s.append(getEmSqlrc());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(EmVariable that) {
        return Arrays.equals(this.filler3, that.filler3) &&
            this.emCusnum.equals(that.emCusnum) &&
            Arrays.equals(this.filler4, that.filler4) &&
            this.emPolnum.equals(that.emPolnum) &&
            this.emSqlreq.equals(that.emSqlreq) &&
            Arrays.equals(this.filler5, that.filler5) &&
            this.emSqlrc == that.emSqlrc;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof EmVariable other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof EmVariable;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(filler3);
        result = 31 * result + Objects.hashCode(emCusnum);
        result = 31 * result + Arrays.hashCode(filler4);
        result = 31 * result + Objects.hashCode(emPolnum);
        result = 31 * result + Objects.hashCode(emSqlreq);
        result = 31 * result + Arrays.hashCode(filler5);
        result = 31 * result + Integer.hashCode(emSqlrc);
        return result;
    }
    
    @Override
    public int compareTo(EmVariable that) {
        int c = 0;
        c = Arrays.compare(this.filler3, that.filler3);
        if ( c != 0 ) return c;
        c = this.emCusnum.compareTo(that.emCusnum);
        if ( c != 0 ) return c;
        c = Arrays.compare(this.filler4, that.filler4);
        if ( c != 0 ) return c;
        c = this.emPolnum.compareTo(that.emPolnum);
        if ( c != 0 ) return c;
        c = this.emSqlreq.compareTo(that.emSqlreq);
        if ( c != 0 ) return c;
        c = Arrays.compare(this.filler5, that.filler5);
        if ( c != 0 ) return c;
        c = Integer.compare(this.emSqlrc, that.emSqlrc);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ByteArrayField FILLER_3 = factory.getByteArrayField(6);
    private byte[] filler3 = new byte[6];
    private static final StringField EM_CUSNUM = factory.getStringField(10);
    private static final ByteArrayField FILLER_4 = factory.getByteArrayField(6);
    private byte[] filler4 = new byte[6];
    private static final StringField EM_POLNUM = factory.getStringField(10);
    private static final StringField EM_SQLREQ = factory.getStringField(16);
    private static final ByteArrayField FILLER_5 = factory.getByteArrayField(9);
    private byte[] filler5 = new byte[9];
    private static final ExternalDecimalAsIntField EM_SQLRC = factory.getExternalDecimalAsIntField(5, true);
    private void initFiller() {
        new StringField(0, 6).putString(" CNUM=", filler3);
        new StringField(0, 6).putString(" PNUM=", filler4);
        new StringField(0, 9).putString(" SQLCODE=", filler5);
    }
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        FILLER_3.putByteArray(filler3, bytes, offset);
        EM_CUSNUM.putString(emCusnum, bytes, offset);
        FILLER_4.putByteArray(filler4, bytes, offset);
        EM_POLNUM.putString(emPolnum, bytes, offset);
        EM_SQLREQ.putString(emSqlreq, bytes, offset);
        FILLER_5.putByteArray(filler5, bytes, offset);
        EM_SQLRC.putInt(emSqlrc, bytes, offset);
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
        FILLER_3.getByteArray(bytes, offset);
        emCusnum = EM_CUSNUM.getString(bytes, offset);
        FILLER_4.getByteArray(bytes, offset);
        emPolnum = EM_POLNUM.getString(bytes, offset);
        emSqlreq = EM_SQLREQ.getString(bytes, offset);
        FILLER_5.getByteArray(bytes, offset);
        emSqlrc = EM_SQLRC.getInt(bytes, offset);
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
