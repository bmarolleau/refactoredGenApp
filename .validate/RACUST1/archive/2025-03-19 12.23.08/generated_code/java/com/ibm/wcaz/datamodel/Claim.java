package com.ibm.wcaz.datamodel;

import com.ibm.jzos.fields.ByteArrayField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Claim implements Cloneable, Comparable<Claim> {
    private int claimnumber;
    private Date claimdate = new Date(0);
    private int paid;
    private int value;
    private String cause = "";
    private String observations = "";
    private Policy policy = new Policy();
    
    public Claim() {}
    
    public Claim(int claimnumber, Date claimdate, int paid, int value, String cause, String observations, Policy policy) {
        this.claimnumber = claimnumber;
        this.claimdate = claimdate;
        this.paid = paid;
        this.value = value;
        this.cause = cause;
        this.observations = observations;
        this.policy = policy;
    }
    
    protected Claim(final Claim that) {
        this.claimnumber = that.claimnumber;
        this.claimdate = that.claimdate;
        this.paid = that.paid;
        this.value = that.value;
        this.cause = that.cause;
        this.observations = that.observations;
        this.policy = that.policy.clone();
    }
    
    @Override
    public Claim clone() {
        return new Claim(this);
    }
    
    protected Claim(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Claim(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Claim fromBytes(byte[] bytes, int offset) {
        return new Claim(bytes, offset);
    }
    
    public static Claim fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Claim fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getClaimnumber() {
        return this.claimnumber;
    }
    
    public void setClaimnumber(int claimnumber) {
        this.claimnumber = claimnumber;
    }
    
    public Date getClaimdate() {
        return this.claimdate;
    }
    
    public void setClaimdate(Date claimdate) {
        this.claimdate = claimdate;
    }
    
    public int getPaid() {
        return this.paid;
    }
    
    public void setPaid(int paid) {
        this.paid = paid;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public String getCause() {
        return this.cause;
    }
    
    public void setCause(String cause) {
        this.cause = cause;
    }
    
    public String getObservations() {
        return this.observations;
    }
    
    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    public Policy getPolicy() {
        return this.policy;
    }
    
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ claimnumber=\"");
        s.append(getClaimnumber());
        s.append("\"");
        s.append(", claimdate=\"");
        s.append(getClaimdate());
        s.append("\"");
        s.append(", paid=\"");
        s.append(getPaid());
        s.append("\"");
        s.append(", value=\"");
        s.append(getValue());
        s.append("\"");
        s.append(", cause=\"");
        s.append(getCause());
        s.append("\"");
        s.append(", observations=\"");
        s.append(getObservations());
        s.append("\"");
        s.append(", policy=\"");
        s.append(getPolicy());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(Claim that) {
        return this.claimnumber == that.claimnumber &&
            this.claimdate.equals(that.claimdate) &&
            this.paid == that.paid &&
            this.value == that.value &&
            this.cause.equals(that.cause) &&
            this.observations.equals(that.observations) &&
            this.policy.equals(that.policy);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Claim other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof Claim;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(claimnumber);
        result = 31 * result + Objects.hashCode(claimdate);
        result = 31 * result + Integer.hashCode(paid);
        result = 31 * result + Integer.hashCode(value);
        result = 31 * result + Objects.hashCode(cause);
        result = 31 * result + Objects.hashCode(observations);
        result = 31 * result + Objects.hashCode(policy);
        return result;
    }
    
    @Override
    public int compareTo(Claim that) {
        int c = 0;
        c = Integer.compare(this.claimnumber, that.claimnumber);
        if ( c != 0 ) return c;
        c = this.claimdate.compareTo(that.claimdate);
        if ( c != 0 ) return c;
        c = Integer.compare(this.paid, that.paid);
        if ( c != 0 ) return c;
        c = Integer.compare(this.value, that.value);
        if ( c != 0 ) return c;
        c = this.cause.compareTo(that.cause);
        if ( c != 0 ) return c;
        c = this.observations.compareTo(that.observations);
        if ( c != 0 ) return c;
        c = this.policy.compareTo(that.policy);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField CLAIMNUMBER = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField CLAIMDATE = factory.getStringField(8);
    private static final DateTimeFormatter CLAIMDATE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final ExternalDecimalAsIntField PAID = factory.getExternalDecimalAsIntField(5, true);
    private static final ExternalDecimalAsIntField VALUE = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField CAUSE = factory.getStringField(254);
    private static final StringField OBSERVATIONS = factory.getStringField(254);
    private static final ByteArrayField POLICY = factory.getByteArrayField(Policy.SIZE);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CLAIMNUMBER.putInt(claimnumber, bytes, offset);
        CLAIMDATE.putString(claimdate.toLocalDate().format(CLAIMDATE_FMT), bytes, offset);
        PAID.putInt(paid, bytes, offset);
        VALUE.putInt(value, bytes, offset);
        CAUSE.putString(cause, bytes, offset);
        OBSERVATIONS.putString(observations, bytes, offset);
        policy.getBytes(bytes, POLICY.getOffset() + offset);
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
        claimnumber = CLAIMNUMBER.getInt(bytes, offset);
        claimdate = Date.valueOf(LocalDate.parse(CLAIMDATE.getString(bytes, offset), CLAIMDATE_FMT));
        paid = PAID.getInt(bytes, offset);
        value = VALUE.getInt(bytes, offset);
        cause = CAUSE.getString(bytes, offset);
        observations = OBSERVATIONS.getString(bytes, offset);
        policy.setBytes(bytes, POLICY.getOffset() + offset);
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
