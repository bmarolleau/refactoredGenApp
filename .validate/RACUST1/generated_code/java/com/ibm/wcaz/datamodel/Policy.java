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

public class Policy implements Cloneable, Comparable<Policy> {
    private int policynumber;
    private Date issuedate = new Date(0);
    private Date expirydate = new Date(0);
    private String policytype = "";
    private Date lastchanged = new Date(0);
    private int brokerid;
    private String brokersreference = "";
    private int payment;
    private int commission;
    private Customer customer = new Customer();
    
    public Policy() {}
    
    public Policy(int policynumber, Date issuedate, Date expirydate, String policytype, Date lastchanged, int brokerid, String brokersreference, int payment, int commission, Customer customer) {
        this.policynumber = policynumber;
        this.issuedate = issuedate;
        this.expirydate = expirydate;
        this.policytype = policytype;
        this.lastchanged = lastchanged;
        this.brokerid = brokerid;
        this.brokersreference = brokersreference;
        this.payment = payment;
        this.commission = commission;
        this.customer = customer;
    }
    
    protected Policy(final Policy that) {
        this.policynumber = that.policynumber;
        this.issuedate = that.issuedate;
        this.expirydate = that.expirydate;
        this.policytype = that.policytype;
        this.lastchanged = that.lastchanged;
        this.brokerid = that.brokerid;
        this.brokersreference = that.brokersreference;
        this.payment = that.payment;
        this.commission = that.commission;
        this.customer = that.customer.clone();
    }
    
    @Override
    public Policy clone() {
        return new Policy(this);
    }
    
    protected Policy(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Policy(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Policy fromBytes(byte[] bytes, int offset) {
        return new Policy(bytes, offset);
    }
    
    public static Policy fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Policy fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getPolicynumber() {
        return this.policynumber;
    }
    
    public void setPolicynumber(int policynumber) {
        this.policynumber = policynumber;
    }
    
    public Date getIssuedate() {
        return this.issuedate;
    }
    
    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }
    
    public Date getExpirydate() {
        return this.expirydate;
    }
    
    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }
    
    public String getPolicytype() {
        return this.policytype;
    }
    
    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }
    
    public Date getLastchanged() {
        return this.lastchanged;
    }
    
    public void setLastchanged(Date lastchanged) {
        this.lastchanged = lastchanged;
    }
    
    public int getBrokerid() {
        return this.brokerid;
    }
    
    public void setBrokerid(int brokerid) {
        this.brokerid = brokerid;
    }
    
    public String getBrokersreference() {
        return this.brokersreference;
    }
    
    public void setBrokersreference(String brokersreference) {
        this.brokersreference = brokersreference;
    }
    
    public int getPayment() {
        return this.payment;
    }
    
    public void setPayment(int payment) {
        this.payment = payment;
    }
    
    public int getCommission() {
        return this.commission;
    }
    
    public void setCommission(int commission) {
        this.commission = commission;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ policynumber=\"");
        s.append(getPolicynumber());
        s.append("\"");
        s.append(", issuedate=\"");
        s.append(getIssuedate());
        s.append("\"");
        s.append(", expirydate=\"");
        s.append(getExpirydate());
        s.append("\"");
        s.append(", policytype=\"");
        s.append(getPolicytype());
        s.append("\"");
        s.append(", lastchanged=\"");
        s.append(getLastchanged());
        s.append("\"");
        s.append(", brokerid=\"");
        s.append(getBrokerid());
        s.append("\"");
        s.append(", brokersreference=\"");
        s.append(getBrokersreference());
        s.append("\"");
        s.append(", payment=\"");
        s.append(getPayment());
        s.append("\"");
        s.append(", commission=\"");
        s.append(getCommission());
        s.append("\"");
        s.append(", customer=\"");
        s.append(getCustomer());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    private boolean equals(Policy that) {
        return this.policynumber == that.policynumber &&
            this.issuedate.equals(that.issuedate) &&
            this.expirydate.equals(that.expirydate) &&
            this.policytype.equals(that.policytype) &&
            this.lastchanged.equals(that.lastchanged) &&
            this.brokerid == that.brokerid &&
            this.brokersreference.equals(that.brokersreference) &&
            this.payment == that.payment &&
            this.commission == that.commission &&
            this.customer.equals(that.customer);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Policy other) && other.canEqual(this) && this.equals(other);
    }
    
    public boolean canEqual(Object that) {
        return that instanceof Policy;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(policynumber);
        result = 31 * result + Objects.hashCode(issuedate);
        result = 31 * result + Objects.hashCode(expirydate);
        result = 31 * result + Objects.hashCode(policytype);
        result = 31 * result + Objects.hashCode(lastchanged);
        result = 31 * result + Integer.hashCode(brokerid);
        result = 31 * result + Objects.hashCode(brokersreference);
        result = 31 * result + Integer.hashCode(payment);
        result = 31 * result + Integer.hashCode(commission);
        result = 31 * result + Objects.hashCode(customer);
        return result;
    }
    
    @Override
    public int compareTo(Policy that) {
        int c = 0;
        c = Integer.compare(this.policynumber, that.policynumber);
        if ( c != 0 ) return c;
        c = this.issuedate.compareTo(that.issuedate);
        if ( c != 0 ) return c;
        c = this.expirydate.compareTo(that.expirydate);
        if ( c != 0 ) return c;
        c = this.policytype.compareTo(that.policytype);
        if ( c != 0 ) return c;
        c = this.lastchanged.compareTo(that.lastchanged);
        if ( c != 0 ) return c;
        c = Integer.compare(this.brokerid, that.brokerid);
        if ( c != 0 ) return c;
        c = this.brokersreference.compareTo(that.brokersreference);
        if ( c != 0 ) return c;
        c = Integer.compare(this.payment, that.payment);
        if ( c != 0 ) return c;
        c = Integer.compare(this.commission, that.commission);
        if ( c != 0 ) return c;
        c = this.customer.compareTo(that.customer);
        if ( c == 0 && !(that.canEqual(this) && this.canEqual(that)) ) c = this.getClass().getTypeName().compareTo(that.getClass().getTypeName());
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField POLICYNUMBER = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField ISSUEDATE = factory.getStringField(8);
    private static final DateTimeFormatter ISSUEDATE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final StringField EXPIRYDATE = factory.getStringField(8);
    private static final DateTimeFormatter EXPIRYDATE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final StringField POLICYTYPE = factory.getStringField(2);
    private static final StringField LASTCHANGED = factory.getStringField(14);
    private static final DateTimeFormatter LASTCHANGED_FMT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final ExternalDecimalAsIntField BROKERID = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField BROKERSREFERENCE = factory.getStringField(11);
    private static final ExternalDecimalAsIntField PAYMENT = factory.getExternalDecimalAsIntField(5, true);
    private static final ExternalDecimalAsIntField COMMISSION = factory.getExternalDecimalAsIntField(3, true);
    private static final ByteArrayField CUSTOMER = factory.getByteArrayField(Customer.SIZE);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        POLICYNUMBER.putInt(policynumber, bytes, offset);
        ISSUEDATE.putString(issuedate.toLocalDate().format(ISSUEDATE_FMT), bytes, offset);
        EXPIRYDATE.putString(expirydate.toLocalDate().format(EXPIRYDATE_FMT), bytes, offset);
        POLICYTYPE.putString(policytype, bytes, offset);
        LASTCHANGED.putString(lastchanged.toLocalDate().format(LASTCHANGED_FMT), bytes, offset);
        BROKERID.putInt(brokerid, bytes, offset);
        BROKERSREFERENCE.putString(brokersreference, bytes, offset);
        PAYMENT.putInt(payment, bytes, offset);
        COMMISSION.putInt(commission, bytes, offset);
        customer.getBytes(bytes, CUSTOMER.getOffset() + offset);
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
        policynumber = POLICYNUMBER.getInt(bytes, offset);
        issuedate = Date.valueOf(LocalDate.parse(ISSUEDATE.getString(bytes, offset), ISSUEDATE_FMT));
        expirydate = Date.valueOf(LocalDate.parse(EXPIRYDATE.getString(bytes, offset), EXPIRYDATE_FMT));
        policytype = POLICYTYPE.getString(bytes, offset);
        lastchanged = Date.valueOf(LocalDate.parse(LASTCHANGED.getString(bytes, offset), LASTCHANGED_FMT));
        brokerid = BROKERID.getInt(bytes, offset);
        brokersreference = BROKERSREFERENCE.getString(bytes, offset);
        payment = PAYMENT.getInt(bytes, offset);
        commission = COMMISSION.getInt(bytes, offset);
        customer.setBytes(bytes, CUSTOMER.getOffset() + offset);
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
