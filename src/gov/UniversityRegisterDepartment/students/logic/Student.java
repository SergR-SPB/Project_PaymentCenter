package gov.UniversityRegisterDepartment.students.logic;

import java.text.Collator;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable{  //Интерфейс Сравнить;

    private int studentId;
    private String firstName;
    private String surName;
    private Date dateOfBirth;
    private int groupId;
    private int educationYear;



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

 /* protected Student(int studentId, String surName, int groupId) {//??????????????????????????
        this.studentId = studentId;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.educationYear = educationYear;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", groupId=" + groupId +
                ", educationYear=" + educationYear +
                '}';
    }

    @Override
    public int compareTo(Object obj) {
        Collator collator = Collator.getInstance(new Locale
                ("ru"));
        collator.setStrength(Collator.PRIMARY);

        return collator.compare(this.toString(),obj.toString());
    }
}
