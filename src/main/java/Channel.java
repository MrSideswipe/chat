import java.util.ArrayList;

public class Channel {

    protected String channelName;
    protected ArrayList<User> userList;

    public Channel (String roomName){
        this.channelName = roomName;
        userList = new ArrayList<>();
    }
    
    public void addUser(User user)
    {
        userList.add(user);
    }
    public void deleteUser(User user) throws IllegalArgumentException
    {
        if(!userList.remove(user))
            throw new IllegalArgumentException("Could not find user");
    }

    public String getChannelName() 
    {
        return channelName;
    }

    public ArrayList<User> getUserList() 
    {
        return userList;
    }
    public Channel containsUser(User user)
    {
        if(userList.contains(user)){
            return this;
        }
        return null;
    }

}