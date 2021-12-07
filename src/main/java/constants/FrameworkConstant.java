package constants;

public class FrameworkConstant {
    private static String projectBasePath = System.getProperty("user.dir");

    private FrameworkConstant() {

    }

    public static String getProjectBasePath() {
        return projectBasePath;
    }
}
