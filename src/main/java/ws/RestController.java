package ws;

import org.springframework.web.bind.annotation.RequestMapping;

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


  @RequestMapping("/greeting")
  public String greeting() {
    return "Hello World ";
  }


}
