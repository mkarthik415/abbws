package ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ws.beans.Job;
import ws.beans.User;

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

  @RequestMapping("/runningJobs")
  public List<Job> runningJobs() {

    return daoImpl.runningJobs();
  }

}
