package entity;

public class User
{
    private String username;
    private String deletiondate;

    public User()
    {
    }
    
    public User(String username, String deletiondate)
    {
        this.username = username;
        this.deletiondate = deletiondate;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getDeletiondate()
    {
        return deletiondate;
    }

    public void setDeletiondate(String deletiondate)
    {
        this.deletiondate = deletiondate;
    }

    @Override
    public String toString()
    {
        return "User{" + "username=" + username + ", deletiondate=" + deletiondate + '}';
    }
}
