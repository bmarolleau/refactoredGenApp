package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.BinaryAsIntField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class WsHeader implements Cloneable, Comparable<WsHeader> {
    private String wsEyecatcher = "LGACDB01------WS";
    private String wsTransid = "";
    private String wsTermid = "";
    private int wsTasknum;
    private char wsFiller = ' ';
    private String wsAddrDfhcommarea = "";
    private int wsCalen;
    
    public WsHeader() {}
    
    public WsHeader(String wsEyecatcher, String wsTransid, String wsTermid, int wsTasknum, char wsFiller, String wsAddrDfhcommarea, int wsCalen) {
        this.wsEyecatcher = wsEyecatcher;
        this.wsTransid = wsTransid;
        this.wsTermid = wsTermid;
        this.wsTasknum = wsTasknum;
        this.wsFiller = wsFiller;
        this.wsAddrDfhcommarea = wsAddrDfhcommarea;
        this.wsCalen = wsCalen;
    }
    
    protected WsHeader(final WsHeader that) {
        this.wsEyecatcher = that.wsEyecatcher;
        this.wsTransid = that.wsTransid;
        this.wsTermid = that.wsTermid;
        this.wsTasknum = that.wsTasknum;
        this.wsFiller = that.wsFiller;
        this.wsAddrDfhcommarea = that.wsAddrDfhcommarea;
        this.wsCalen = that.wsCalen;
    }
    
    @Override
    public WsHeader clone() {
        return new WsHeader(this);
    }
    
    protected WsHeader(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected WsHeader(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static WsHeader fromBytes(byte[] bytes, int offset) {
        return new WsHeader(bytes, offset);
    }
    
    public static WsHeader fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static WsHeader fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getWsEyecatcher() {
        return this.wsEyecatcher;
    }
    
    public void setWsEyecatcher(String wsEyecatcher) {
        this.wsEyecatcher = wsEyecatcher;
    }
    
    public String getWsTransid() {
        return this.wsTransid;
    }
    
    public void setWsTransid(String wsTransid) {
        this.wsTransid = wsTransid;
    }
    
    public String getWsTermid() {
        return this.wsTermid;
    }
    
    public void setWsTermid(String wsTermid) {
        this.wsTermid = wsTermid;
    }
    
    public int getWsTasknum() {
        return this.wsTasknum;
    }
    
    public void setWsTasknum(int wsTasknum) {
        this.wsTasknum = wsTasknum;
    }
    
    public char getWsFiller() {
        return this.wsFiller;
    }
    
    public void setWsFiller(char wsFiller) {
        this.wsFiller = wsFiller;
    }
    
    public String getWsAddrDfhcommarea() {
        return this.wsAddrDfhcommarea;
    }
    
    public void setWsAddrDfhcommarea(String wsAddrDfhcommarea) {
        this.wsAddrDfhcommarea = wsAddrDfhcommarea;
    }
    
    public int getWsCalen() {
        return this.wsCalen;
    }
    
    public void setWsCalen(int wsCalen) {
        this.wsCalen = wsCalen;
    }
    
    public void reset() {
        wsEyecatcher = "";
        wsTransid = "";
        wsTermid = "";
        wsTasknum = 0;
        wsFiller = ' ';
        wsAddrDfhcommarea = "";
        wsCalen = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ wsEyecatcher=\"");
        s.append(getWsEyecatcher());
        s.append("\"");
        s.append(", wsTransid=\"");
        s.append(getWsTransid());
        s.append("\"");
        s.append(", wsTermid=\"");
        s.append(getWsTermid());
        s.append("\"");
        s.append(", wsTasknum=\"");
        s.append(getWsTasknum());
        s.append("\"");
        s.append(", wsFiller=\"");
        s.append(getWsFiller());
        s.append("\"");
        s.append(", wsAddrDfhcommarea=\"");
        s.append(getWsAddrDfhcommarea());
        s.append("\"");
        s.append(", wsCalen=\"");
        s.append(getWsCalen());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(WsHeader that) {
        return this.wsEyecatcher.equals(that.wsEyecatcher) &&
            this.wsTransid.equals(that.wsTransid) &&
            this.wsTermid.equals(that.wsTermid) &&
            this.wsTasknum == that.wsTasknum &&
            this.wsFiller == that.wsFiller &&
            this.wsAddrDfhcommarea.equals(that.wsAddrDfhcommarea) &&
            this.wsCalen == that.wsCalen;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof WsHeader other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof WsHeader;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(wsEyecatcher);
        result = 31 * result + Objects.hashCode(wsTransid);
        result = 31 * result + Objects.hashCode(wsTermid);
        result = 31 * result + Integer.hashCode(wsTasknum);
        result = 31 * result + Character.hashCode(wsFiller);
        result = 31 * result + Objects.hashCode(wsAddrDfhcommarea);
        result = 31 * result + Integer.hashCode(wsCalen);
        return result;
    }
    
    @Override
    public int compareTo(WsHeader that) {
        int c = 0;
        c = this.wsEyecatcher.compareTo(that.wsEyecatcher);
        if ( c != 0 ) return c;
        c = this.wsTransid.compareTo(that.wsTransid);
        if ( c != 0 ) return c;
        c = this.wsTermid.compareTo(that.wsTermid);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsTasknum, that.wsTasknum);
        if ( c != 0 ) return c;
        c = Character.compare(this.wsFiller, that.wsFiller);
        if ( c != 0 ) return c;
        c = this.wsAddrDfhcommarea.compareTo(that.wsAddrDfhcommarea);
        if ( c != 0 ) return c;
        c = Integer.compare(this.wsCalen, that.wsCalen);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField WS_EYECATCHER = factory.getStringField(16);
    private static final StringField WS_TRANSID = factory.getStringField(4);
    private static final StringField WS_TERMID = factory.getStringField(4);
    private static final ExternalDecimalAsIntField WS_TASKNUM = factory.getExternalDecimalAsIntField(7, true);
    private static final StringField WS_FILLER = factory.getStringField(1, false);
    private static final StringField WS_ADDR_DFHCOMMAREA = factory.getStringField(4);
    private static final BinaryAsIntField WS_CALEN = factory.getBinaryAsIntField(4, true);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        WS_EYECATCHER.putString(wsEyecatcher, bytes, offset);
        WS_TRANSID.putString(wsTransid, bytes, offset);
        WS_TERMID.putString(wsTermid, bytes, offset);
        WS_TASKNUM.putInt(wsTasknum, bytes, offset);
        WS_FILLER.putString(Character.toString(wsFiller), bytes, offset);
        WS_ADDR_DFHCOMMAREA.putString(wsAddrDfhcommarea, bytes, offset);
        WS_CALEN.putInt(wsCalen, bytes, offset);
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
        wsEyecatcher = WS_EYECATCHER.getString(bytes, offset);
        wsTransid = WS_TRANSID.getString(bytes, offset);
        wsTermid = WS_TERMID.getString(bytes, offset);
        wsTasknum = WS_TASKNUM.getInt(bytes, offset);
        wsFiller = WS_FILLER.getString(bytes, offset).charAt(0);
        wsAddrDfhcommarea = WS_ADDR_DFHCOMMAREA.getString(bytes, offset);
        wsCalen = WS_CALEN.getInt(bytes, offset);
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
