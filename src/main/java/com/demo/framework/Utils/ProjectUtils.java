package com.demo.framework.Utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProjectUtils {

    String ActualRootDir;
    String WorkingDir;
    String currentWorkingDir;


    /**
     * Return users project root directory
     *
     */
    public String getUsersProjectRootDirectory() {
        String envRootDir = System.getProperty("user.dir");
        Path rootDir = Paths.get(".").normalize().toAbsolutePath();
        if ( rootDir.startsWith(envRootDir) ) {
            ActualRootDir= rootDir.toString();
            return ActualRootDir;
        } else {
            throw new RuntimeException("Root dir not found in user directory.");
        }
    }

    /**
     * Return current working directory
     *
     */
    public String currentWorkingDir() {
        getUsersProjectRootDirectory();
//        WorkingDir = getUsersProjectRootDirectory();
        WorkingDir = ActualRootDir;
//        String currentWorkingDir = null;
        if (WorkingDir.contains("circleci")) {
            currentWorkingDir = "/home/circleci/project";
        }
        else{
            currentWorkingDir = WorkingDir;
        }
        return currentWorkingDir;
    }

    /**
     * Return get Number From Month Name
     *
     */
    public int getNumberFromMonthName(String dateFormat) throws ParseException {
        Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(dateFormat);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int getNumberFromMonthName = (cal.get(Calendar.MONTH))+1;
        return getNumberFromMonthName;
    }

}
