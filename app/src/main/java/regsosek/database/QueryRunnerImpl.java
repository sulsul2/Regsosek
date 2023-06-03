package regsosek.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRunnerImpl implements QueryRunner {

    @Override
    public void run(Connection con, String query, List<Object> params) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) == null) {
                    pstmt.setNull(i + 1, Types.NULL);
                } else {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }

            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Map<String, Object>> query(Connection con, String query, List<Object> params) throws SQLException {
        List<Map<String, Object>> data = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) == null) {
                    pstmt.setNull(i + 1, Types.NULL);
                } else {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        row.put(rsmd.getColumnName(i), rs.getObject(i));
                    }

                    data.add(row);
                }
            }
        }

        return data;
    }

    @Override
    public void run(Connection con, String query) throws SQLException {
        run(con, query, new ArrayList<>());
    }

    @Override
    public List<Map<String, Object>> query(Connection con, String query) throws SQLException {
        return query(con, query, new ArrayList<>());
    }
    
}
