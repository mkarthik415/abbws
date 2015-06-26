package ws.mapping;

import org.springframework.jdbc.core.RowMapper;
import ws.beans.Job;
import ws.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USVIHUE on 06/26/2015.
 */
public class JobsRecordMapper implements RowMapper {

    final private static String JOB_NUMBER	=	"job_num";
    final private static String JOB_NAME	=	"job_nme";
    final private static String JOB_STATUS  =	"run_status_cd";
    final private static String START_TIME	=	"start_dt_gmt";
    final private static String DURATION	=	"seconds";

    public Job mapRow(ResultSet rs, int arg1) throws SQLException {
        Job job = new Job(rs.getInt(JOB_NUMBER),rs.getString(JOB_NAME),rs.getString(JOB_STATUS),rs.getDate(START_TIME),rs.getInt(DURATION));
        return job;
    }



}