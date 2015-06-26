package ws.beans;

import java.util.Date;

/**
 * Created by USVIHUE on 06/26/2015.
 */
public class Job {


    private Integer job_num;
    private String job_nme;
    private String run_status_cd;


    public Job(int job_num, String job_nme, String run_status_cd, java.sql.Date start_dt_gmt, int seconds) {
        this.job_num = job_num;
        this.job_nme = job_nme;
        this.run_status_cd = run_status_cd;
        this.start_dt_gmt = start_dt_gmt;
        this.seconds = seconds;
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

    public Date getStart_dt_gmt() {
        return start_dt_gmt;
    }

    public void setStart_dt_gmt(Date start_dt_gmt) {
        this.start_dt_gmt = start_dt_gmt;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    private Date start_dt_gmt;
    private Integer seconds;

    public Integer getJob_num() {
        return job_num;
    }

    public void setJob_num(Integer job_num) {
        this.job_num = job_num;
    }
}
