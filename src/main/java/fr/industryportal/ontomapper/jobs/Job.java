package fr.industryportal.ontomapper.jobs;

/**
 * @author AbdelWadoud Rasmi
 * <p>
 * This is a scheduled job that is set to run every x time
 */
public interface Job {
    int MINUTE = 60 * 1000;
    int HOUR = 60 * MINUTE;
    int DAY = 24 * HOUR;
    int WEEK = 7 * DAY;
    int HALF_MONTH = 15 * DAY;
    int MONTH = 2 * HALF_MONTH;
    int TRIMESTER = 3 * MONTH;
    int SEMESTER = 2 * TRIMESTER;
    int YEAR = 2 * SEMESTER;
    //
    String EVERY_DAY_MIDNIGHT = "0 0 0 * * *";
    String EVERY_DAY_MIDNIGHT_AND_HALF = "0 30 0 * * *";


    /**
     * executes the given code every x time
     */
    void execute();
}
