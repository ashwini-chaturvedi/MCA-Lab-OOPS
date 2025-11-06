class DatabaseConnection {
    private static DatabaseConnection instance;

    private String dbConnection;
    private String dbUser;
    private String dbPassword;
    private String dbName;

    private DatabaseConnection(String dbConnection, String dbUser, String dbPassword, String dbName) {
        this.dbConnection = dbConnection;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbName = dbName;
    }

    public static DatabaseConnection getInstance(String dbConnection, String dbUser, String dbPassword, String dbName) {
        if (instance == null) {
            instance = new DatabaseConnection(dbConnection, dbUser, dbPassword, dbName);
        }
        return instance;
    }

    public void showConnectionDetails() {
        System.out.println("Connected to " + dbName + " as " + dbUser);
    }
}

public class Que4 {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance(
                "jdbc:postgresql://localhost:5432",
                "ashwini",
                "daaremon",
                "MCA");

        DatabaseConnection db2 = DatabaseConnection.getInstance(
                "jdbc:mysql://localhost:3306",
                "aieshi",
                "aieshi@123",
                "timepass");


        System.out.println(db1 == db2);

        db1.showConnectionDetails();
    }
}
