package ws.beans;

import java.util.Date;

/**
 * Created by USVIHUE on 06/26/2015.
 */
public class JobCount {

    private Integer job_num;
    private String job_nme;
    private String run_status_cd;
    private Integer times;
    private double percentage;


    public JobCount(int job_num, String job_nme, String run_status_cd, int times, double percentage) {
        this.job_num = job_num;
        this.job_nme = job_nme;
        this.run_status_cd = run_status_cd;
        this.times = times;
        this.percentage = percentage;
    }

    public Integer getJob_num() {
        return job_num;
    }

    public void setJob_num(Integer job_num) {
        this.job_num = job_num;
    }

    public String getJob_nme() {
        return job_nme;
    }

    public void setJob_nme(String job_nme) {
        this.job_nme = job_nme;
    }

    public String getRun_status_cd() {
        return run_status_cd;
    }

    public void setRun_status_cd(String run_status_cd) {
        this.run_status_cd = run_status_cd;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
