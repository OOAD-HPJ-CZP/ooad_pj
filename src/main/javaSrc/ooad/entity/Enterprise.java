package ooad.entity;

import javax.persistence.*;

/**
 * Created by admin on 2017/6/19.
 */
@Entity
public class Enterprise {
    private int id;
    private String enterpriseName;
    private String state;
    private String enterpriseNumber;
    private String enterprisecol;
    private Integer tradeId;
    private String businessClass;
    private String contacts;
    private String contactsPhone;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "enterprise_name")
    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "enterprise_number")
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber;
    }

    @Basic
    @Column(name = "enterprisecol")
    public String getEnterprisecol() {
        return enterprisecol;
    }

    public void setEnterprisecol(String enterprisecol) {
        this.enterprisecol = enterprisecol;
    }

    @Basic
    @Column(name = "trade_id")
    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    @Basic
    @Column(name = "business_class")
    public String getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(String businessClass) {
        this.businessClass = businessClass;
    }

    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "contacts_phone")
    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enterprise that = (Enterprise) o;

        if (id != that.id) return false;
        if (enterpriseName != null ? !enterpriseName.equals(that.enterpriseName) : that.enterpriseName != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (enterpriseNumber != null ? !enterpriseNumber.equals(that.enterpriseNumber) : that.enterpriseNumber != null)
            return false;
        if (enterprisecol != null ? !enterprisecol.equals(that.enterprisecol) : that.enterprisecol != null)
            return false;
        if (tradeId != null ? !tradeId.equals(that.tradeId) : that.tradeId != null) return false;
        if (businessClass != null ? !businessClass.equals(that.businessClass) : that.businessClass != null)
            return false;
        if (contacts != null ? !contacts.equals(that.contacts) : that.contacts != null) return false;
        if (contactsPhone != null ? !contactsPhone.equals(that.contactsPhone) : that.contactsPhone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (enterpriseName != null ? enterpriseName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (enterpriseNumber != null ? enterpriseNumber.hashCode() : 0);
        result = 31 * result + (enterprisecol != null ? enterprisecol.hashCode() : 0);
        result = 31 * result + (tradeId != null ? tradeId.hashCode() : 0);
        result = 31 * result + (businessClass != null ? businessClass.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (contactsPhone != null ? contactsPhone.hashCode() : 0);
        return result;
    }
}
