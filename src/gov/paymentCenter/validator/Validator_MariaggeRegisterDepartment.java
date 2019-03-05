package gov.paymentCenter.validator;
import gov.paymentCenter.ansver.Answer_MariaggeRegisterDepartment;
import gov.paymentCenter.run.StudentApplicationForm;

public class Validator_MariaggeRegisterDepartment {

    public  String hostName;
    public   String login;
    public  String password;


     public Answer_MariaggeRegisterDepartment check_MariaggeRegisterDepartment(StudentApplicationForm studentForm) {
        System.out.println("--- Checking the questionnaire in the Marriage Department....."+hostName+"....."+login+"....."+password);
        return new Answer_MariaggeRegisterDepartment();
    }
}
