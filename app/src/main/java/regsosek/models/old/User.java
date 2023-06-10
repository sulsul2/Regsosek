package regsosek.models.old;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private int id;
    private String username;
    private String pass;
    private String role;

    public User(){

    }
    public User(String username, String pass){
        this.username = username;
        this.pass = pass;
        this.role = "USER";
    }

    public String getInsertStatement(){
        return "INSERT INTO user (username, pass, role, id) VALUES (?,?,?,?)";
    }

    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException{
        pstmt.setString(1, username);
        pstmt.setString(2, pass);
        pstmt.setString(3, "USER");
        pstmt.setInt(4, 0);
    }

    public void register() throws SQLException{
        this.id = Database.getInstance().register(this);
    }

    public void login(String username, String pass) throws SQLException{
        User temp = new User();
        temp = Database.getInstance().login(username, pass);
        this.id = temp.getId();
        this.username = temp.getUsername();
        this.pass = temp.getPass();
        this.role = temp.getRole();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getUsername(){
        return username;
    }

    public void serUsername(String username){
        this.username = username;
    }

    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getRole(){
        return role;
    }

    public void setRole (String role){
        this.role = role;
    }
}

