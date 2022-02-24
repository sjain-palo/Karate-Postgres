package Utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DbConnetion {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    private static DbConnetion instance;

    static {
        try {
            instance = new DbConnetion();
        } catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static DbConnetion getInstance() {
        return instance;
    }

    public DbConnetion() {
        config.setJdbcUrl( System.getProperty("karate.url") );
        config.setUsername( System.getProperty("karate.username"));
        config.setPassword( System.getProperty("karate.password"));
        config.setDriverClassName(System.getProperty("karate.DriverClassName"));
        config.setMinimumIdle(100);
        config.setMaximumPoolSize(500);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public Connection getDBConnection() throws SQLException {
        return ds.getConnection();
    }
}