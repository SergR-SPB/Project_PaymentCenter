package gov.paymentCenter.validator;
import gov.paymentCenter.ansver.Ansver_CityRegisterDepartment;
import gov.paymentCenter.run.StudentApplicationForm;

public class Validator_CityRegisterDepartment {

    public String hostName;
    public String login;

    public String password;



     public Ansver_CityRegisterDepartment check_CityRegisterDepartment(StudentApplicationForm studentForm) {
        System.out.println("--- Checking the questionnaire in the Department of the city register......"+hostName+
                "......"+login+ "........"+password);
        return new Ansver_CityRegisterDepartment();
    }
}
