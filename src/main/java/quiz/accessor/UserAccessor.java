package quiz.accessor;

import java.util.List;

import quiz.model.User;

public class UserAccessor {
    private static UserAccessor accessor;
    private List<User> users;

    public UserAccessor(){

    }




    public User getUser(Long id) throws Exception {
        if(users==null ||users.isEmpty()){
            throw new Exception("users not present");
        }
        for (User user : users){
            if (user.getId()==id)
                return user;
        }
        throw new Exception("users not present");
    }

    public User getUserbyName(String name) throws Exception {
        if(users==null ||users.isEmpty()){
            throw new Exception("users not present");
        }
        for (User user : users){
            if (user.getName().equals(name))
                return user;
        }
         throw new Exception("users not present");
    }

    public void setUserScore( Long id , Long score) throws Exception {
       User user  = getUser(id);
       user.setLatestScore(score);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
