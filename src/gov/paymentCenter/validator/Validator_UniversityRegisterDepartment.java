package gov.paymentCenter.validator;
import gov.paymentCenter.ansver.Answer__UniversityRegisterDepartment;
import gov.paymentCenter.run.StudentApplicationForm;

public class Validator_UniversityRegisterDepartment {
    public static Answer__UniversityRegisterDepartment check_UniversityRegisterDepartment(StudentApplicationForm studentForm) {
        System.out.println("--- Checking the questionnaire in the University Department......");
        return new Answer__UniversityRegisterDepartment();
    }
}
