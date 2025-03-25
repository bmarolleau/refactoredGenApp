package com.ibm.wcaz.datamodel;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

public class House extends Policy {
    private String propertytype = "";
    private int bedrooms;
    private int value;
    private String housename = "";
    private String housenumber = "";
    private String postcode = "";
    
    public House() {}
    
    public House(int policynumber, Date issuedate, Date expirydate, String policytype, Date lastchanged, int brokerid, String brokersreference, int payment, int commission, Customer customer, String propertytype, int bedrooms, int value, String housename, String housenumber, String postcode) {
        super(policynumber, issuedate, expirydate, policytype, lastchanged, brokerid, brokersreference, payment, commission, customer);
        this.propertytype = propertytype;
        this.bedrooms = bedrooms;
        this.value = value;
        this.housename = housename;
        this.housenumber = housenumber;
        this.postcode = postcode;
    }
    
    protected House(final House that) {
        super(that);
        this.propertytype = that.propertytype;
        this.bedrooms = that.bedrooms;
        this.value = that.value;
        this.housename = that.housename;
        this.housenumber = that.housenumber;
        this.postcode = that.postcode;
    }
    
    @Override
    public House clone() {
        return new House(this);
    }
    
    protected House(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected House(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static House fromBytes(byte[] bytes, int offset) {
        return new House(bytes, offset);
    }
    
    public static House fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static House fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getPropertytype() {
        return this.propertytype;
    }
    
    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }
    
    public int getBedrooms() {
        return this.bedrooms;
    }
    
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public String getHousename() {
        return this.housename;
    }
    
    public void setHousename(String housename) {
        this.housename = housename;
    }
    
    public String getHousenumber() {
        return this.housenumber;
    }
    
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }
    
    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ propertytype=\"");
        s.append(getPropertytype());
        s.append("\"");
        s.append(", bedrooms=\"");
        s.append(getBedrooms());
        s.append("\"");
        s.append(", value=\"");
        s.append(getValue());
        s.append("\"");
        s.append(", housename=\"");
        s.append(getHousename());
        s.append("\"");
        s.append(", housenumber=\"");
        s.append(getHousenumber());
        s.append("\"");
        s.append(", postcode=\"");
        s.append(getPostcode());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(House that) {
        return super.equals(that) &&
            this.propertytype.equals(that.propertytype) &&
            this.bedrooms == that.bedrooms &&
            this.value == that.value &&
            this.housename.equals(that.housename) &&
            this.housenumber.equals(that.housenumber) &&
            this.postcode.equals(that.postcode);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof House other) && other.canEqual(this) && this.equals(other);
    }
    
    @Override
    public boolean canEqual(Object that) {
        return that instanceof House;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * super.hashCode();
        result = 31 * result + Objects.hashCode(propertytype);
        result = 31 * result + Integer.hashCode(bedrooms);
        result = 31 * result + Integer.hashCode(value);
        result = 31 * result + Objects.hashCode(housename);
        result = 31 * result + Objects.hashCode(housenumber);
        result = 31 * result + Objects.hashCode(postcode);
        return result;
    }
    
    public int compareTo(House that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = this.propertytype.compareTo(that.propertytype);
        if ( c != 0 ) return c;
        c = Integer.compare(this.bedrooms, that.bedrooms);
        if ( c != 0 ) return c;
        c = Integer.compare(this.value, that.value);
        if ( c != 0 ) return c;
        c = this.housename.compareTo(that.housename);
        if ( c != 0 ) return c;
        c = this.housenumber.compareTo(that.housenumber);
        if ( c != 0 ) return c;
        c = this.postcode.compareTo(that.postcode);
        if ( c == 0 && !that.canEqual(this) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    @Override
    public int compareTo(Policy that) {
        if (that instanceof House other) {
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
    
    private static final StringField PROPERTYTYPE = factory.getStringField(16);
    private static final ExternalDecimalAsIntField BEDROOMS = factory.getExternalDecimalAsIntField(3, true);
    private static final ExternalDecimalAsIntField VALUE = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField HOUSENAME = factory.getStringField(21);
    private static final StringField HOUSENUMBER = factory.getStringField(5);
    private static final StringField POSTCODE = factory.getStringField(9);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        PROPERTYTYPE.putString(propertytype, bytes, offset);
        BEDROOMS.putInt(bedrooms, bytes, offset);
        VALUE.putInt(value, bytes, offset);
        HOUSENAME.putString(housename, bytes, offset);
        HOUSENUMBER.putString(housenumber, bytes, offset);
        POSTCODE.putString(postcode, bytes, offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        propertytype = PROPERTYTYPE.getString(bytes, offset);
        bedrooms = BEDROOMS.getInt(bytes, offset);
        value = VALUE.getInt(bytes, offset);
        housename = HOUSENAME.getString(bytes, offset);
        housenumber = HOUSENUMBER.getString(bytes, offset);
        postcode = POSTCODE.getString(bytes, offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
