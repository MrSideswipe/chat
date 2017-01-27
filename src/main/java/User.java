import org.eclipse.jetty.websocket.api.Session;

public class User {
    private String userName;
    private Session userSession;

    public User(String userName, Session userSession)
    {
        this.userName = userName;
        this.userSession = userSession;
    }
    public String getUserName() 
    {
        return userName;
    }

    public Session getUserSession() 
    {
        return userSession;
    }
}
