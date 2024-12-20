package io.javabrains;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue
    private int Id;


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

    public EmployeeType getType() {
        return type;
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
}
