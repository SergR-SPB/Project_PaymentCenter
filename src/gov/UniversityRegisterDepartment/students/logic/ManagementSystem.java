package gov.UniversityRegisterDepartment.students.logic;

import java.util.*;

public class ManagementSystem {

    private List<Group> groups;
    private Collection<Student> students;

    private static ManagementSystem instance;

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    private ManagementSystem() {
        loadGroups();
        loadStydents();
    }

    private void loadGroups() {
        if (groups == null) {
            groups = new ArrayList<Group>();
        } else {
            groups.clear();
        }
        Group group = null;

        group = new Group();
        group.setGroupId(1);
        group.setNameGroup("A");
        group.setSpeciality("Физика");
        group.setCurator("Проф. Ромм");
        groups.add(group);

        group = new Group();
        group.setGroupId(2);
        group.setNameGroup("B");
        group.setSpeciality("Химия");
        group.setCurator("Проф. Поц");
        groups.add(group);


    }

    private void loadStydents() {
        if (students == null) {
            students = new TreeSet<Student>();
        } else {
            students.clear();
        }
        Student student = null;
        Calendar calendar = Calendar.getInstance();

        student = new Student();
        student.setFirstName("А.");
        student.setSurName("Сергеев");

        calendar.set(1998, 10, 24);
        student.setDateOfBirth(calendar.getTime());

        student.setGroupId(1);
        student.setEducationYear(2016);
        students.add(student);

        student = new Student();
        student.setFirstName("B.");
        student.setSurName("Васильев");

        calendar.set(1997, 11, 22);
        student.setDateOfBirth(calendar.getTime());

        student.setGroupId(2);
        student.setEducationYear(2015);
        students.add(student);

        student = new Student();
        student.setFirstName("И.");
        student.setSurName("Игнатьев");

        calendar.set(1998, 5, 5);
        student.setDateOfBirth(calendar.getTime());

        student.setGroupId(1);
        student.setEducationYear(2016);
        students.add(student);

        student = new Student();
        student.setFirstName("Г.");
        student.setSurName("Грищенков");

        calendar.set(1997, 5, 5);
        student.setDateOfBirth(calendar.getTime());

        student.setGroupId(2);
        student.setEducationYear(2015);
        students.add(student);
    }

//Получить список групп

    public List<Group> getGroups() {
        return groups;
    }

//Получить список всех студентов

    public Collection<Student> getAllStudents() {
        return students;
    }
//Получить список студентов по группе и году

    public Collection<Student> getStudentsFromGroup(Group group, int year) {
        Collection<Student> studentsFromGroup = new TreeSet<>();
        for (Student student : students) {
            if (student.getGroupId() == group.getGroupId()
                    && student.getEducationYear() == year) {
                studentsFromGroup.add(student);
            }
        }
        return studentsFromGroup;
    }

// Перевод студентов из группы в группу

    public void moveStudentToGroup(Group oldGroup, int oldYear,
                                   Group newGroup, int newYear) {
        for (Student student : students) {
            if (student.getGroupId() == oldGroup.getGroupId() && student.getEducationYear() == oldYear) {
                student.setGroupId(newGroup.getGroupId());
                student.setEducationYear(newYear);
            }
        }
    }

// Получить список студентов без определенной группы

    public void removeStudentsFromGroup(Group group, int year){
        Collection<Student> tmp = new TreeSet<>();
        for (Student student:students){
            if(student.getGroupId()==group.getGroupId()
                    ||student.getEducationYear()==year){
                tmp.add(student);
            }
        }
        students = tmp;
    }

// Добавить студента

    public void insertStudent (Student student){
        students.add(student);
    }

//Изменить данные о студенте

    public void updateStudent (Student student) {
        Student updateStudent = null;
        for (Student student1:students){
            if(student1.getStudentId()==student.getStudentId()){
                updateStudent = student1;
                break;
            }
        }
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setSurName(student.getSurName());
        updateStudent.setDateOfBirth(student.getDateOfBirth());
        updateStudent.setGroupId(student.getGroupId());
        updateStudent.setEducationYear(student.getEducationYear());
    }

// Удалить студента

    public void deleteStudent(Student student){
        Student deleteStudent = null;
        for (Student student1:students){
            if(student1.getStudentId() == student.getStudentId()){
                deleteStudent = student1;
                break;
            }
            students.remove(deleteStudent);
        }
    }


}
