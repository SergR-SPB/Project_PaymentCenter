package gov.paymentCenter.validator;
import gov.paymentCenter.ansver.Answer_ChildRegisterDepartment;
import gov.paymentCenter.run.StudentApplicationForm;

public class Validator_ChildRegisterDepartment {

    public static Answer_ChildRegisterDepartment check_ChildRegisterDepartament(StudentApplicationForm studentForm) {
        System.out.println("--- Checking the questionnaire in the Child Department......");
        return new Answer_ChildRegisterDepartment();
    }
}
