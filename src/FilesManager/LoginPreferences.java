

package FilesManager;

import java.util.prefs.Preferences;



public class LoginPreferences {
//    String path;
//    final String NOPATH_GIVEN="NO_PATH_GIVEN",STORED_PATH="PATH";
    
    private final String USERNAME="_user_",PASSWORD="_pass_";
    private final String storedUserName="USERNAME",storedPassword="PASSWORD";
    private Preferences loginPreferences;
    public LoginPreferences(){
        
        loginPreferences=Preferences.userRoot();
    }
    public boolean isUserPres(){
        String t=loginPreferences.get(storedUserName, USERNAME);
        String q=loginPreferences.get(storedPassword, PASSWORD);
        return !t.equals(USERNAME) && !q.equals(PASSWORD);
    }
    public void storeDetails(String u,String p){
        loginPreferences.put(storedPassword, p);
        loginPreferences.put(storedUserName, u);
    }
    public void resetDetails()
    {
        loginPreferences.put(storedPassword, PASSWORD);
        loginPreferences.put(storedUserName, USERNAME);
    }
    public String[] getCredentials(){
        String []r=new String[2];
        r[0]=loginPreferences.get(storedUserName, USERNAME);
        r[1]=loginPreferences.get(storedPassword, PASSWORD);
        return r;
    }
    public String[] getAdminDetails()
    {
        String []r=new String[2];
        r[0]=USERNAME;
        r[1]=PASSWORD;
        return r;
    }
}
