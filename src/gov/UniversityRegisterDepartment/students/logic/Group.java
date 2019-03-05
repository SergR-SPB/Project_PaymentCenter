package gov.UniversityRegisterDepartment.students.logic;

public class Group {

    private int groupId;

    private String nameGroup;

    private String curator;

    private String speciality;

    public int getGroupId() {
        return groupId;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getCurator() {
        return curator;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", nameGroup='" + nameGroup + '\'' +
                ", curator='" + curator + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
