package ch.bbw.m326;

import ch.bbw.m326.database.Reader;
import ch.bbw.m326.persons.PersonManager;
import ch.bbw.m326.persons.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * This class contains junit5 test functions for the {@link ch.bbw.m326.persons.PersonManager} class. 
 * @author Leandro Ferrer
 * @version 1.0
 */
class PersonManagerTest {

    /**
     * This test function tests the {@link ch.bbw.m326.persons.PersonManager#addUser(User)} 
     *      and {@link ch.bbw.m326.persons.PersonManager#removeUser(int)} method.
     */
    @Test
    void addUserAndRemoveUserTest() {
        PersonManager manager = new PersonManager();
        User u = new User("mail", "username", "password");
        try {
            manager.addUser(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader = new Reader();
        try {
            JSONArray userArray = reader.readUserDB();
            int index = userArray.length() - 1;
            JSONObject obj = userArray.getJSONObject(index);
            assertEquals(obj.getInt("id"), u.getId());
            assertTrue(obj.getString("token").length() > 0);
            manager.removeUser(obj.getInt("id"));
            JSONArray userArray2 = reader.readUserDB();
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> userArray2.getJSONObject(index));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        
    }
}
