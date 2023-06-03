// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package regsosek.dao;

// import java.util.List;
// import java.sql.*;
// import java.util.Map;
// import regsosek.database.Database;
// import java.util.ArrayList;
// import java.util.Arrays;
// import regsosek.model.User;

// /**
//  *
//  * @author zein
//  */
// public class UserDao implements Dao<User> {

//     @Override
//     public User get(long id) {
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {id});
//             List<Map<String, Object>> result = db.query("SELECT * FROM users WHERE id = ?", params);

//             if (!result.isEmpty()) {
//                 User user = new User();
//                 Map<String, Object> row = result.get(0);

//                 user.setId((long) row.get("id"));
//                 user.setEmail((String) row.get("email"));
//                 user.setPassword((String) row.get("password"));
//                 user.setRole((String) row.get("role"));

//                 return user;
//             } else {
//                 return null;
//             }

//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<User> getWhere(String attr, Object param) {
//         List<User> filteredUsers = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM users WHERE %s = ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 User user = new User();
//                 user.setId((long) row.get("id"));
//                 user.setEmail((String) row.get("email"));
//                 user.setPassword((String) row.get("password"));
//                 user.setRole((String) row.get("role"));

//                 filteredUsers.add(user);
//             }

//             return filteredUsers;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<User> getLike(String attr, Object param) {
//         List<User> filteredUsers = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Object> params = Arrays.asList(new Object[] {param});
//             List<Map<String, Object>> result = db.query(
//                     String.format("SELECT * FROM users WHERE %s LIKE ?", attr),
//                     params);

//             for (Map<String, Object> row : result) {
//                 User user = new User();
//                 user.setId((long) row.get("id"));
//                 user.setEmail((String) row.get("email"));
//                 user.setPassword((String) row.get("password"));
//                 user.setRole((String) row.get("role"));

//                 filteredUsers.add(user);
//             }

//             return filteredUsers;
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return null;
//         }
//     }

//     @Override
//     public List<User> getAll() {
//         List<User> users = new ArrayList<>();
//         Database db = Database.getInstance();
//         try {
//             List<Map<String, Object>> result = db.query("SELECT * FROM users");
//             for (Map<String, Object> row : result) {
//                 User user = new User();
//                 user.setId((long) row.get("id"));
//                 user.setEmail((String) row.get("email"));
//                 user.setPassword((String) row.get("password"));
//                 user.setRole((String) row.get("role"));

//                 users.add(user);
//             }
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             return new ArrayList<>();
//         }

//         return users;
//     }

//     @Override
//     public void save(User t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{
//             t.getEmail(),
//             t.getPassword(),
//             t.getRole()
//         });

//         try {
//             db.run("INSERT INTO users (email, password, role) VALUES (?, ?, ?)", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void update(User t) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[] {
//             t.getEmail(),
//             t.getPassword(),
//             t.getRole(),
//             t.getId()
//         });

//         try {
//             db.run("UPDATE users SET email = ?, password = ?, role = ? WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }

//     @Override
//     public void delete(long id) {
//         Database db = Database.getInstance();
//         List<Object> params = Arrays.asList(new Object[]{id});
//         try {
//             db.run("DELETE FROM users WHERE id = ?", params);
//         } catch(SQLException ex) {
//             System.out.println("Error: " + ex.getMessage());
//         }
//     }
    
// }
