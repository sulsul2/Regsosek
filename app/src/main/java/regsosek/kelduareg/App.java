// /**
//  * Aplikasi Input Data Regsosek.
//  * Dibuat oleh Kelompok 2:
//  * Ahmad Zein Haddad (222111862)
//  */
// package regsosek.kelduareg;

// import regsosek.controller.Controller;
// import regsosek.controller.RutaController;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import regsosek.database.*;
// import java.sql.SQLException;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// /**
//  *
//  * @author zein
//  */
// public class App {

//     private static Map<String, Controller> controllers = new HashMap<>();

//     /**
//      * @param args the command line arguments
//      */
//     public static void main(String[] args) {
//         controllers.put("ruta", new RutaController());

//         switchController("ruta");

//         /*
//         // contoh tambah data
//         Database db = Database.getInstance();
//         Object data[] = new Object[] { "root@localhost", "root", "ADMIN" };
//         Object data2[] = new Object[] { "testing@gmail.com", "testing", "OPERATOR" };
//         try {
//             db.run("INSERT INTO users (email, password, role) VALUES (?, ?, ?)", Arrays.asList(data2));
//             System.out.println("Saved data");
//         } catch(SQLException e) {
//             System.out.println("Failed to save data");
//         }*/

//         // contoh ambil data
//         /*Database db = Database.getInstance();
//         try {
            
//             List<Map<String, Object>> result = db.query(
//                     "SELECT * FROM users WHERE id = ?", 
//                     Arrays.asList(new Object[] { 1 }
//                     ));
//             for (Map<String, Object> row : result) {
//                 for (Map.Entry<String, Object> field : row.entrySet()) {
//                     System.out.println(field.getKey() + ": " + field.getValue());
//                 }
//                 System.out.println();
//             }
//         } catch(SQLException err) {
//             System.out.println("Failed to get data");
//         }*/
        
//         /*App app = new App();
//         app.addMenu(new DataEntryMenu());
//         app.addMenu(new ViewDataMenu());

//         app.start();*/
//     }

//     public void start() {
//         /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         while(true) {
//             System.out.println("Menu:");

//             for (int i = 0; i < this.menu.size(); i++) {
//                 System.out.println(String.format("%d. %s", i+1, menu.get(i).getMenuName()));
//             }

//             try {
//                 int pilihan = Integer.parseInt(reader.readLine());

//                 Menu m = this.menu.get(pilihan - 1);
//                 m.run(new User("testing", "testing", "admin"));
//             } catch(IOException err) {
//                 System.out.println("Error: " + err);
//             } catch(Exception err) {
//                 System.out.println("Exiting...");
//                 break;
//             }
//         }*/
//     }

//     public static void switchController(String controllerName, Object[] args) {
//         for (Map.Entry<String, Controller> controller : controllers.entrySet()) {
//             if (controller.getKey().equals(controllerName)) {
//                 controller.getValue().activate(args);
//             } else {
//                 controller.getValue().deactivate();
//             }
//         }
//     }

//     public static void switchController(String controllerName) {
//         switchController(controllerName, new Object[] {});
//     }
    
// }
