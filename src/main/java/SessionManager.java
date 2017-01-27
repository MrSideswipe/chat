import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

public class SessionManager {

    private ArrayList<User> chatUserList = new ArrayList<>();
    private ArrayList<Channel> channelList = new ArrayList<>();

    public SessionManager(){
        channelList.add(new Chatbot());
    }

    public String addChannel (String channelName){
        if (channelListContains(channelName)){
            return "failure";
        }
        Channel channel = new Channel(channelName);
        channelList.add(channel);
        return "successful";
    }

    public String addUser (String userName, Session session){
        if (userListContains(userName))
            return "failure";
        User user = new User(userName, session);
        chatUserList.add(user);
        return "successful";
    }

    public String addUserToChannel(Session session, String channelName){
        User user = getUserBySession(session);
        Channel channel = getChannelByName(channelName);

        channel.addUser(user);
        return "successful";
    }

    public String deleteUserFromChannel(Session session, String channelName){
        User user = getUserBySession(session);
        Channel channel = getChannelByName(channelName);
        if (channel.getUserList().contains(user)){
            channel.deleteUser(user);
            return "successful";
        }
        return "failure";
    }

    public void deleteUserFromChat(User user){
        chatUserList.remove(user);
    }

    public User getUserBySession(Session session) throws IllegalArgumentException {
        for (User u: chatUserList) {
            if (u.getUserSession().equals(session))
                return u;
        }
        throw new IllegalArgumentException("No user connected to this session");
    }

    public Channel getChannelByName(String channelName) {
        for (Channel r : channelList) {
            if (r.getChannelName().equals(channelName))
                return r;
        }
        return null;
    }

    public Channel getCurrentUserChannel(User user){
        for (Channel r: channelList){
            if(r.containsUser(user) != null)
                return r;
        }
        return null;
    }

    public String generateAnswerFromChatBot(String message) throws IOException, JSONException {
        return ((Chatbot) channelList.get(0)).generateAnswer(message);
    }


    public void sendMessegeToEveryUserInChannel(String channelName, String sender, JSONObject message, String messageToShow)
    {
    	return;
    }

    private boolean userListContains(String userName) {
        for (User u: chatUserList){
            if(u.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    private boolean channelListContains(String channelName){
        for (Channel r: channelList) {
            if(r.getChannelName().equals(channelName))
                return true;
        }
        return false;
    }

    
    // generateSessionList

    public ArrayList<Channel> getChannelList()
    { 
    	return channelList; 
    }
}
