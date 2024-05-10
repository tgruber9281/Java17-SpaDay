package org.launchcode.data;

import org.launchcode.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trevor Gruber
 */
public class UserData {

/** fields */
    private static final Map<Integer, User> users = new HashMap<>();
    
/** Custom methods */
public static Collection<User> getAll(){
    return users.values();
}
    
    public static User getById(int id){
        return users.get(id);
    }
    
    public static void add(User user){
        users.put(user.getUserId(), user);
    }
    
    public static void remove(int id){
        users.remove(id);
    }
}
