package com.ibm.wcaz.implementation;


import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.ExternalDecimalAsLongField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class CaPolicyRequest extends Dfhcommarea1 {
    private long caPolicyNum;
    private String caIssueDate = "";
    private String caExpiryDate = "";
    private String caLastchanged = "";
    private long caBrokerid;
    private String caBrokersref = "";
    private int caPayment;
    
    public CaPolicyRequest() {}
    
    public CaPolicyRequest(String caRequestId, int caReturnCode, long caCustomerNum, long caPolicyNum, String caIssueDate, String caExpiryDate, String caLastchanged, long caBrokerid, String caBrokersref, int caPayment) {
        super(caRequestId, caReturnCode, caCustomerNum);
        this.caPolicyNum = caPolicyNum;
        this.caIssueDate = caIssueDate;
        this.caExpiryDate = caExpiryDate;
        this.caLastchanged = caLastchanged;
        this.caBrokerid = caBrokerid;
        this.caBrokersref = caBrokersref;
        this.caPayment = caPayment;
    }
    
    protected CaPolicyRequest(final CaPolicyRequest that) {
        super(that);
        this.caPolicyNum = that.caPolicyNum;
        this.caIssueDate = that.caIssueDate;
        this.caExpiryDate = that.caExpiryDate;
        this.caLastchanged = that.caLastchanged;
        this.caBrokerid = that.caBrokerid;
        this.caBrokersref = that.caBrokersref;
        this.caPayment = that.caPayment;
    }
    
    @Override
    public CaPolicyRequest clone() {
        return new CaPolicyRequest(this);
    }
    
    protected CaPolicyRequest(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CaPolicyRequest(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CaPolicyRequest fromBytes(byte[] bytes, int offset) {
        return new CaPolicyRequest(bytes, offset);
    }
    
    public static CaPolicyRequest fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CaPolicyRequest fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public long getCaPolicyNum() {
        return this.caPolicyNum;
    }
    
    public void setCaPolicyNum(long caPolicyNum) {
        this.caPolicyNum = caPolicyNum;
    }
    
    public String getCaIssueDate() {
        return this.caIssueDate;
    }
    
    public void setCaIssueDate(String caIssueDate) {
        this.caIssueDate = caIssueDate;
    }
    
    public String getCaExpiryDate() {
        return this.caExpiryDate;
    }
    
    public void setCaExpiryDate(String caExpiryDate) {
        this.caExpiryDate = caExpiryDate;
    }
    
    public String getCaLastchanged() {
        return this.caLastchanged;
    }
    
    public void setCaLastchanged(String caLastchanged) {
        this.caLastchanged = caLastchanged;
    }
    
    public long getCaBrokerid() {
        return this.caBrokerid;
    }
    
    public void setCaBrokerid(long caBrokerid) {
        this.caBrokerid = caBrokerid;
    }
    
    public String getCaBrokersref() {
        return this.caBrokersref;
    }
    
    public void setCaBrokersref(String caBrokersref) {
        this.caBrokersref = caBrokersref;
    }
    
    public int getCaPayment() {
        return this.caPayment;
    }
    
    public void setCaPayment(int caPayment) {
        this.caPayment = caPayment;
    }
    
    public void reset() {
        super.reset();
        caPolicyNum = 0;
        caIssueDate = "";
        caExpiryDate = "";
        caLastchanged = "";
        caBrokerid = 0;
        caBrokersref = "";
        caPayment = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("{ caPolicyNum=\"");
        s.append(getCaPolicyNum());
        s.append("\"");
        s.append(", caIssueDate=\"");
        s.append(getCaIssueDate());
        s.append("\"");
        s.append(", caExpiryDate=\"");
        s.append(getCaExpiryDate());
        s.append("\"");
        s.append(", caLastchanged=\"");
        s.append(getCaLastchanged());
        s.append("\"");
        s.append(", caBrokerid=\"");
        s.append(getCaBrokerid());
        s.append("\"");
        s.append(", caBrokersref=\"");
        s.append(getCaBrokersref());
        s.append("\"");
        s.append(", caPayment=\"");
        s.append(getCaPayment());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(CaPolicyRequest that) {
        return super.equals(that) &&
            this.caPolicyNum == that.caPolicyNum &&
            this.caIssueDate.equals(that.caIssueDate) &&
            this.caExpiryDate.equals(that.caExpiryDate) &&
            this.caLastchanged.equals(that.caLastchanged) &&
            this.caBrokerid == that.caBrokerid &&
            this.caBrokersref.equals(that.caBrokersref) &&
            this.caPayment == that.caPayment;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CaPolicyRequest other) && other.canEqual(this) && this.equals(other);
    }
    
    @Override
    public boolean canEqual(Object that) {
        return that instanceof CaPolicyRequest;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * super.hashCode();
        result = 31 * result + Long.hashCode(caPolicyNum);
        result = 31 * result + Objects.hashCode(caIssueDate);
        result = 31 * result + Objects.hashCode(caExpiryDate);
        result = 31 * result + Objects.hashCode(caLastchanged);
        result = 31 * result + Long.hashCode(caBrokerid);
        result = 31 * result + Objects.hashCode(caBrokersref);
        result = 31 * result + Integer.hashCode(caPayment);
        return result;
    }
    
    public int compareTo(CaPolicyRequest that) {
        int c = 0;
        c = super.compareTo(that);
        if ( c != 0 ) return c;
        c = Long.compare(this.caPolicyNum, that.caPolicyNum);
        if ( c != 0 ) return c;
        c = this.caIssueDate.compareTo(that.caIssueDate);
        if ( c != 0 ) return c;
        c = this.caExpiryDate.compareTo(that.caExpiryDate);
        if ( c != 0 ) return c;
        c = this.caLastchanged.compareTo(that.caLastchanged);
        if ( c != 0 ) return c;
        c = Long.compare(this.caBrokerid, that.caBrokerid);
        if ( c != 0 ) return c;
        c = this.caBrokersref.compareTo(that.caBrokersref);
        if ( c != 0 ) return c;
        c = Integer.compare(this.caPayment, that.caPayment);
        if ( c == 0 && !that.canEqual(this) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    @Override
    public int compareTo(Dfhcommarea1 that) {
        if (that instanceof CaPolicyRequest other) {
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
    
    private static final ExternalDecimalAsLongField CA_POLICY_NUM = factory.getExternalDecimalAsLongField(10, true);
    private static final StringField CA_ISSUE_DATE = factory.getStringField(10);
    private static final StringField CA_EXPIRY_DATE = factory.getStringField(10);
    private static final StringField CA_LASTCHANGED = factory.getStringField(26);
    private static final ExternalDecimalAsLongField CA_BROKERID = factory.getExternalDecimalAsLongField(10, true);
    private static final StringField CA_BROKERSREF = factory.getStringField(10);
    private static final ExternalDecimalAsIntField CA_PAYMENT = factory.getExternalDecimalAsIntField(6, true);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        super.getBytes(bytes, offset);
        CA_POLICY_NUM.putLong(caPolicyNum, bytes, offset);
        CA_ISSUE_DATE.putString(caIssueDate, bytes, offset);
        CA_EXPIRY_DATE.putString(caExpiryDate, bytes, offset);
        CA_LASTCHANGED.putString(caLastchanged, bytes, offset);
        CA_BROKERID.putLong(caBrokerid, bytes, offset);
        CA_BROKERSREF.putString(caBrokersref, bytes, offset);
        CA_PAYMENT.putInt(caPayment, bytes, offset);
        return bytes;
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
        super.setBytes(bytes, offset);
        caPolicyNum = CA_POLICY_NUM.getLong(bytes, offset);
        caIssueDate = CA_ISSUE_DATE.getString(bytes, offset);
        caExpiryDate = CA_EXPIRY_DATE.getString(bytes, offset);
        caLastchanged = CA_LASTCHANGED.getString(bytes, offset);
        caBrokerid = CA_BROKERID.getLong(bytes, offset);
        caBrokersref = CA_BROKERSREF.getString(bytes, offset);
        caPayment = CA_PAYMENT.getInt(bytes, offset);
    }
    
    public int numBytes() {
        return SIZE;
    }
    
}
