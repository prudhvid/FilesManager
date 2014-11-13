

package FilesManager;

import java.util.prefs.Preferences;



public class StoredPath {
    String path;
    final String NOPATH_GIVEN="NO_PATH_GIVEN",STORED_PATH="PATH";
    Preferences pathPreferences;
    public StoredPath(){
        path=NOPATH_GIVEN;
        pathPreferences=Preferences.userRoot();
//        pathPreferences.put(STORED_PATH, NOPATH_GIVEN);
    }
    public boolean isPathPres(){
        String t=pathPreferences.get(STORED_PATH, NOPATH_GIVEN);
        return !t.equals(NOPATH_GIVEN);
    }
    public void storePath(String p){
        pathPreferences.put(STORED_PATH, p);
    }
    public String getPath(){
        return pathPreferences.get(STORED_PATH, NOPATH_GIVEN);
    }
}
