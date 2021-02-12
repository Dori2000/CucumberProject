import cucumber.api.cli.Main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import seleniumtest.utils.WebDriverFactory;

public class MainCucumber {

    public MainCucumber() {
    }

    public static void main(String[] args) throws Exception {
        List<String> argList = new ArrayList();
        argList.add("--plugin");
        argList.add("json:test-output/cucumber.json");
        argList.add("--plugin");
        argList.add("html:test-output/cucumber-html-report");
        argList.add("--glue");
        argList.add("al.seleniumtest/helper/selenium/cucumber");
        argList.add("--glue");
        String packageGlue = System.getProperty("JAVA_PACKAGE_WITH_CUCUMBER_TESTS");
        System.out.println(packageGlue + "-----------------------------");
        if (StringUtils.isEmpty(packageGlue)) {
            throw new RuntimeException("System property JAVA_PACKAGE_WITH_CUCUMBER_TESTS is missing");
        } else {
            argList.add(packageGlue);
            String tags = System.getProperty("CUCUMBERTAGS");
            if (!StringUtils.isEmpty(tags) && !"ALL".equalsIgnoreCase(tags)) {
                String[] tagsSplitted = tags.split(",");
                String[] var5 = tagsSplitted;
                int var6 = tagsSplitted.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    String tag = var5[var7];
                    argList.add("--tags");
                    argList.add(tag);
                }
            }

            String featureDir = System.getProperty("FEATUREDIR");
            if (StringUtils.isEmpty(featureDir)) {
                throw new RuntimeException("System property FEATUREDIR is missing");
            } else {
                String featureFile = System.getProperty("FEATUREFILE");
                if (!StringUtils.isEmpty(featureFile) && !"ALL".equalsIgnoreCase(featureFile)) {
                    argList.add(featureDir + "/" + featureFile);
                } else {
                    argList.add(featureDir);
                }

                String[] argListArray = (String[]) argList.toArray(new String[0]);
                byte exit = Main.run(argListArray, Thread.currentThread().getContextClassLoader());
                WebDriverFactory.getInstance().quit();

                if (0 != exit) {
                    System.exit(1);
                }

            }
        }
    }
}
