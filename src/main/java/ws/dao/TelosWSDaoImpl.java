package ws.dao;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import ws.beans.Job;
import ws.beans.User;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by karthikmarupeddi on 2/6/15.
 */

@Component
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class TelosWSDaoImpl implements TelosWSDao,ServletContextAware {

    final org.slf4j.Logger logger = LoggerFactory.getLogger(TelosWSDaoImpl.class);

    @Value( "${GET_USER_SQL}" )
    private String GET_USER_SQL;
    @Value( "${GET_RUNNING_JOBS_SQL}" )
    private String GET_RUNNING_JOBS_SQL;

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private List<User> returnUsers = null;
    private List<Job> returnJobs = null;
    private ServletContext servletContext;

    @Autowired
    public TelosWSDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<User> findUser(final String user, final String password) {

        logger.debug("inside implementation method");
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("username", user);
        namedParameters.addValue("password", password);

        logger.debug("before query being executed");
        try {
            returnUsers = namedParameterJdbcTemplate.query(
                    GET_USER_SQL, namedParameters, new ws.mapping.UserMapper());
            logger.debug("After query being executed"
                    + returnUsers.get(0).getTeam());
            logger.debug("After query being executed"
                    + returnUsers.get(0).getiD());
        } catch (Exception ex) {
            logger.info("User Not Found ", ex);
            return null;
        }
        return returnUsers;
    }

    @Override
    public List<Job> runningJobs() {

        logger.debug("inside runningJobs method");

        logger.debug("before runningJobs query being executed");
        try {
            returnJobs = namedParameterJdbcTemplate.query(
                    GET_RUNNING_JOBS_SQL, new ws.mapping.JobsRecordMapper());
            logger.debug("After query being executed"
                    + returnJobs.get(0).getJob_num());
            logger.debug("After query being executed"
                    + returnJobs.get(0).getJob_nme());
        } catch (Exception ex) {
            logger.info("Jobs Not Found ", ex);
            return null;
        }
        return returnJobs;
    }


//    @Override
//    public Integer logIn(String user, String password) {
//        StoredProcedureCall storedProcedureCall = new StoredProcedureCall(
//                jdbcTemplate, "xu_security.validate_login_password");
//        SqlParameter idParam = new SqlParameter("i_user_name", Types.VARCHAR);
//        SqlParameter passwordParam = new SqlParameter("i_user_password", Types.VARCHAR);
//        SqlOutParameter outParam = new SqlOutParameter("o_user_id", Types.INTEGER);
//        SqlParameter[] paramArray = { idParam,passwordParam,outParam };
//        storedProcedureCall.setParameters(paramArray);
//        storedProcedureCall.compile();
//        // Call stored procedure
//        Map storedProcResult = storedProcedureCall.execute(1);
//        System.out.println(storedProcResult);
//        return storedProcResult.size();
//    }






    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }


}
