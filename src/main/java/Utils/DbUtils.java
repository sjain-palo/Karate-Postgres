package Utils;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DbUtils {
    private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);
    private static Connection con = null;

    public Map<String, Object> readRowDB(String query) throws SQLException {
        Map<String, Object> response = readRow(query, con);
        return response;
    }

    private Map<String, Object> readRow(String query, Connection con) {
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                return parseRow(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    private HashMap parseRow(ResultSet rs) throws SQLException {
        int columnCount = rs.getMetaData().getColumnCount();
        HashMap row = new HashMap(columnCount);
        for (int i = 1; i <= columnCount; ++i) {
            row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
        }
        return row;
    }

    public static void createDBConnection() {
        try {
            con = DbConnetion.getInstance().getDBConnection();
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        }
    }
}
