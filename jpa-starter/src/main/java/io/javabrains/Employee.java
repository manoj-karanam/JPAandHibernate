package io.javabrains;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue
    private int Id;

    @OneToOne
    private AccessCard card;

    @Column(name="employeename", length = 120)
    private String name;

    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(unique = true, length = 10, nullable = false)
    private String  ssn;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Transient
    private String debugString;

    @OneToMany(mappedBy = "employee")
    private List<PayStub> payStub;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
              joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
                inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_EMAIL_ID"))
    private  List<EmailGroup> emailGroups = new ArrayList<>();

    public EmployeeType getType() {
        return type;
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", card=" + card +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", type=" + type +
//                ", payStub=" + payStub +
                '}';
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public void addEmailSubscription(EmailGroup group) {
        this.emailGroups.add(group);
    }
}
