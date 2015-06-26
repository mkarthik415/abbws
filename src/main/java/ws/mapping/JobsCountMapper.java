package ws.mapping;


import org.springframework.jdbc.core.RowMapper;
import ws.beans.JobCount;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by USVIHUE on 06/26/2015.
 */
public class JobsCountMapper implements RowMapper {

    final private static String JOB_NUMBER	=	"job_num";
    final private static String JOB_NAME	=	"job_nme";
    final private static String JOB_STATUS  =	"run_status_cd";
    final private static String TIMES	    =	"times";
    final private static String PERCENTAGE	=	"percentage";

    public JobCount mapRow(ResultSet rs, int arg1) throws SQLException {
        JobCount job = new JobCount(rs.getInt(JOB_NUMBER),rs.getString(JOB_NAME),rs.getString(JOB_STATUS),rs.getInt(TIMES),rs.getDouble(PERCENTAGE));
        return job;
    }



}