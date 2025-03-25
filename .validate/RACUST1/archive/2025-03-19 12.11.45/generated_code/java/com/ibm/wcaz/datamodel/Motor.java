package com.ibm.wcaz.datamodel;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Motor extends Policy {
    private String make = "";
    private String model = "";
    private int value;
    private String regnumber = "";
    private String colour = "";
    private int cc;
    private Date yearofmanufacture = new Date(0);
    private int premium;
    private int accidents;
    
    public Motor() {}
    
    public Motor(int policynumber, Date issuedate, Date expirydate, String policytype, Date lastchanged, int brokerid, String brokersreference, int payment, int commission, Customer policyCustomer, String make, String model, int value, String regnumber, String colour, int cc, Date yearofmanufacture, int premium, int accidents) {
        super(policynumber, issuedate, expirydate, policytype, lastchanged, brokerid, brokersreference, payment, commission, policyCustomer);
        this.make = make;
        this.model = model;
        this.value = value;
        this.regnumber = regnumber;
        this.colour = colour;
        this.cc = cc;
        this.yearofmanufacture = yearofmanufacture;
        this.premium = premium;
        this.accidents = accidents;
    }
    
    protected Motor(final Motor that) {
        super(that);
        this.make = that.make;
        this.model = that.model;
        this.value = that.value;
        this.regnumber = that.regnumber;
        this.colour = that.colour;
        this.cc = that.cc;
        this.yearofmanufacture = that.yearofmanufacture;
        this.premium = that.premium;
        this.accidents = that.accidents;
    }
    
    @Override
    public Motor clone() {
        return new Motor(this);
    }
    
    protected Motor(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Motor(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Motor fromBytes(byte[] bytes, int offset) {
        return new Motor(bytes, offset);
    }
    
    public static Motor fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Motor fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public String getRegnumber() {
        return this.regnumber;
    }
    
    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }
    
    public String getColour() {
        return this.colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public int getCc() {
        return this.cc;
    }
    
    public void setCc(int cc) {
        this.cc = cc;
    }
    
    public Date getYearofmanufacture() {
        return this.yearofmanufacture;
    }
    
    public void setYearofmanufacture(Date yearofmanufacture) {
        this.yearofmanufacture = yearofmanufacture;
    }
    
    public int getPremium() {
        return this.premium;
    }
    
    public void setPremium(int premium) {
        this.premium = premium;
    }
    
    public int getAccidents() {
        return this.accidents;
    }
    
    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ make=\"");
        s.append(getMake());
        s.append("\"");
        s.append(", model=\"");
        s.append(getModel());
        s.append("\"");
        s.append(", value=\"");
        s.append(getValue());
        s.append("\"");
        s.append(", regnumber=\"");
        s.append(getRegnumber());
        s.append("\"");
        s.append(", colour=\"");
        s.append(getColour());
        s.append("\"");
        s.append(", cc=\"");
        s.append(getCc());
        s.append("\"");
        s.append(", yearofmanufacture=\"");
        s.append(getYearofmanufacture());
        s.append("\"");
        s.append(", premium=\"");
        s.append(getPremium());
        s.append("\"");
        s.append(", accidents=\"");
        s.append(getAccidents());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(Motor that) {
        return super.equals(that) &&
            this.make.equals(that.make) &&
            this.model.equals(that.model) &&
            this.value == that.value &&
            this.regnumber.equals(that.regnumber) &&
            this.colour.equals(that.colour) &&
            this.cc == that.cc &&
            this.yearofmanufacture.equals(that.yearofmanufacture) &&
            this.premium == that.premium &&
            this.accidents == that.accidents;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Motor other) && other.canEqual(this) && this.equals(other);
    }
    
    @Override
    public boolean canEqual(Object that) {
        return that instanceof Motor;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * super.hashCode();
        result = 31 * result + Objects.hashCode(make);
        result = 31 * result + Objects.hashCode(model);
        result = 31 * result + Integer.hashCode(value);
        result = 31 * result + Objects.hashCode(regnumber);
        result = 31 * result + Objects.hashCode(colour);
        result = 31 * result + Integer.hashCode(cc);
        result = 31 * result + Objects.hashCode(yearofmanufacture);
        result = 31 * result + Integer.hashCode(premium);
        result = 31 * result + Integer.hashCode(accidents);
        return result;
    }
    
    public int compareTo(Motor that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = this.make.compareTo(that.make);
        if ( c != 0 ) return c;
        c = this.model.compareTo(that.model);
        if ( c != 0 ) return c;
        c = Integer.compare(this.value, that.value);
        if ( c != 0 ) return c;
        c = this.regnumber.compareTo(that.regnumber);
        if ( c != 0 ) return c;
        c = this.colour.compareTo(that.colour);
        if ( c != 0 ) return c;
        c = Integer.compare(this.cc, that.cc);
        if ( c != 0 ) return c;
        c = this.yearofmanufacture.compareTo(that.yearofmanufacture);
        if ( c != 0 ) return c;
        c = Integer.compare(this.premium, that.premium);
        if ( c != 0 ) return c;
        c = Integer.compare(this.accidents, that.accidents);
        if ( c == 0 && !that.canEqual(this) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    @Override
    public int compareTo(Policy that) {
        if (that instanceof Motor other) {
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
        factory.incrementOffset(Policy.SIZE);
    }
    
    private static final StringField MAKE = factory.getStringField(16);
    private static final StringField MODEL = factory.getStringField(16);
    private static final ExternalDecimalAsIntField VALUE = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField REGNUMBER = factory.getStringField(8);
    private static final StringField COLOUR = factory.getStringField(9);
    private static final ExternalDecimalAsIntField CC = factory.getExternalDecimalAsIntField(3, true);
    private static final StringField YEAROFMANUFACTURE = factory.getStringField(8);
    private static final DateTimeFormatter YEAROFMANUFACTURE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final ExternalDecimalAsIntField PREMIUM = factory.getExternalDecimalAsIntField(5, true);
    private static final ExternalDecimalAsIntField ACCIDENTS = factory.getExternalDecimalAsIntField(5, true);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        MAKE.putString(make, bytes, offset);
        MODEL.putString(model, bytes, offset);
        VALUE.putInt(value, bytes, offset);
        REGNUMBER.putString(regnumber, bytes, offset);
        COLOUR.putString(colour, bytes, offset);
        CC.putInt(cc, bytes, offset);
        YEAROFMANUFACTURE.putString(yearofmanufacture.toLocalDate().format(YEAROFMANUFACTURE_FMT), bytes, offset);
        PREMIUM.putInt(premium, bytes, offset);
        ACCIDENTS.putInt(accidents, bytes, offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        make = MAKE.getString(bytes, offset);
        model = MODEL.getString(bytes, offset);
        value = VALUE.getInt(bytes, offset);
        regnumber = REGNUMBER.getString(bytes, offset);
        colour = COLOUR.getString(bytes, offset);
        cc = CC.getInt(bytes, offset);
        yearofmanufacture = Date.valueOf(LocalDate.parse(YEAROFMANUFACTURE.getString(bytes, offset), YEAROFMANUFACTURE_FMT));
        premium = PREMIUM.getInt(bytes, offset);
        accidents = ACCIDENTS.getInt(bytes, offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
