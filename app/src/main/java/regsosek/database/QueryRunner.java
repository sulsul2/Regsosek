package regsosek.database;

import java.util.List;
import java.util.Map;
import java.sql.*;

public interface QueryRunner {
    public void run(Connection con, String query, List<Object> params) throws SQLException;
    public void run(Connection con, String query) throws SQLException;
    public List<Map<String, Object>> query(Connection con, String query, List<Object> params) throws SQLException;
    public List<Map<String, Object>> query(Connection con, String query) throws SQLException;
}
