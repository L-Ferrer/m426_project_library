package ch.bbw.m326.persons;

import ch.bbw.m326.database.Reader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The PersonManager class manages all person related functions.
 * @author Leandro Ferrer
 * @version 1.0
 */
public class PersonManager extends Hash {

    /**
     * Adds a new user to the user database.
     * @param user The user to be added.
     * @throws IOException
     */
    public void addUser(User user) throws IOException {
        Reader reader = new Reader();
        JSONArray jsonArray = reader.readUserDB();
        ArrayList<Person> userList = new ArrayList<>();

        // Parses the JSONArray into the userList
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            int id = obj.getInt("id");
            String username = obj.getString("username");
            String password = obj.getString("password");
            String email = obj.getString("email");
            String token = obj.getString("token");
            User u = new User(email, username, password);
            u.setId(id);
            u.setToken(token);
            u.setPrivilege("user");
            userList.add(u);
        }
        // Adds the new user to the userList
        int largestId = 0;
        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId() > largestId) {
                largestId = userList.get(i).getId();
            }
        }
        user.setId(largestId + 1);
        user.setToken(generateNewToken());
        userList.add(user);
        // Writes the updated userList back to the user database
        JSONArray array = new JSONArray();
        for (Person p : userList) {
            JSONObject obj = new JSONObject();
            obj.put("id", p.getId());
            obj.put("username", p.getUsername());
            obj.put("password", p.getPassword());
            obj.put("email", p.getEmail());
            obj.put("token", p.getToken());
            obj.put("privilege", p.getPrivilege());
            array.put(obj);
        }
        PrintWriter pw = new PrintWriter("database/users.json");
        pw.print(array);
        pw.flush();
        pw.close();
    }

    /**
     * Removes a user from the user database.
     * @param idToRemove The id of the user to be removed.
     */
    public void removeUser(int idToRemove) throws IOException {
        Reader reader = new Reader();
        JSONArray jsonArray = reader.readUserDB();
        ArrayList<Person> userList = new ArrayList<>();

        // Parses the JSONArray into the userList
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            int id = obj.getInt("id");
            String username = obj.getString("username");
            String password = obj.getString("password");
            String email = obj.getString("email");
            String token = obj.getString("token");
            User u = new User(email, username, password);
            u.setId(id);
            u.setToken(token);
            u.setPrivilege("user");
            userList.add(u);
        }
        // Removes the user from the userList
        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId() == idToRemove) {
                userList.remove(i);
            }
        }
        // Writes the updated userList back to the user database
        JSONArray array = new JSONArray();
        for (Person p : userList) {
            JSONObject obj = new JSONObject();
            obj.put("id", p.getId());
            obj.put("username", p.getUsername());
            obj.put("password", p.getPassword());
            obj.put("email", p.getEmail());
            obj.put("token", p.getToken());
            obj.put("privilege", p.getPrivilege());
            array.put(obj);
        }
        PrintWriter pw = new PrintWriter("database/users.json");
        pw.print(array);
        pw.flush();
        pw.close();
    }
}
