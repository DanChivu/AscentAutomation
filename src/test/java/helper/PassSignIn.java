package helper;

import pageObjects.Page;

public class PassSignIn extends Page {
    private static String loginName = "ivan.kravchenko@k2corporatemobility.com";
    private static String password = "J4f!*$@*AG%$!18";
    private static String environmentName = "dev";
    public static String getLoginName(){
        return loginName;
        // return 'sergey.zhizhoma@k2corporatemobility.com'
    }
    public static String getPassword() {
        return password;
        // return "E@stersun12345"
    }
    public static String getEnvironmentName() {
        return environmentName;
        // return "rc"
    }
    public String getClientId(){
        if (this.environmentName.equals("rc")) {
            return "2609";
        }
        return "330";
    }
    public String getClientSetupPagesId() {
        if (this.environmentName.equals("rc")) {
            return "2609";
        }
        return "474";
    }
    public String getAssignmentId(){
        if (this.environmentName.equals("rc")) {
            return "53899";
        }
        return "31970";
    }
    public String getAssigneeTestsAssignmentsId() {
        if (this.environmentName.equals("rc")) {
            return "54529";
        }
        return "31994";
    }
    public String getNeedAnalysisAssignmentId() {
        if (this.environmentName.equals("rc")) {
            return "54528";
        }
        return "32110";
    }
    public String getTrainingClientId() {
        if (this.environmentName.equals("rc")) {
            return "238";
        }
        return "238";
    }
}

