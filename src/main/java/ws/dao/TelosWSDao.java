package ws.dao;

import ws.beans.User;

import java.util.List;

/**
 * Created by karthikmarupeddi on 2/6/15.
 */
public interface TelosWSDao {

    public List<User> findUser(String user, String password);
}
