package ws;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ws.beans.Job;
import ws.beans.JobCount;
import ws.beans.User;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * <p>Title:ws</p>
 * <p/>
 * <p>Description:</p>
 * <p/>
 * <p>Copyright: Copyright (c) 2014 � 2014 Ventyx an ABB Company * Rights
 * Reserved. Confidential and Proprietary</p>
 * <p/>
 * <p>Company: Ventyx an ABB Company</p>
 *
 * @author USKAMAR3
 * @version 1.0
 *          Created on 6/18/2015.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  ws.dao.TelosWSDaoImpl daoImpl;


  final org.slf4j.Logger logger = LoggerFactory.getLogger(RestController.class);


  @RequestMapping("/greeting")
  public String greeting() {
    return "Hello World ";
  }

  @RequestMapping("/findUser")
  public List<User> findUser(String userName, String password) {

    return daoImpl.findUser(userName, password);
  }

  @RequestMapping("/getDBStatus")
  public String getDBStatus() {

     if(daoImpl.findUser("test", "test") != null)
     {
       if (daoImpl.findUser("test", "test").size() >0)
         return "true";
       else
       {
         return "false";
       }
     }
    return "false";
  }

  @RequestMapping("/getAppStatus")
  public String getAppStatus() throws IOException {
    HttpURLConnection connection = null;
    Integer code = null;
    try {
      URL u = new URL("https://www.google.com/");
      connection = (HttpURLConnection) u.openConnection();
      connection.setRequestMethod("HEAD");
      code = connection.getResponseCode();
      System.out.println("" + code);
      // You can determine on HTTP return code received. 200 is success.
    } catch (MalformedURLException e) {
      logger.info("URL google ", e);
      // TODO Auto-generated catch block
      e.printStackTrace();
      return "false";
    } catch (IOException e) {
      logger.info("URL google ", e);
      e.printStackTrace();
      return "false";
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }

    if(code == 200)
    {
      return "true";
    }
    else
    return "false";
  }

  @RequestMapping("/runningJobs")
  public List<Job> runningJobs() {

    return daoImpl.runningJobs();
  }

  @RequestMapping("/jobStats")
  public List<JobCount> jobStats() {

    return daoImpl.jobStats(10);
  }
}
