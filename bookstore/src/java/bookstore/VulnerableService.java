package bookstore;

import java.sql.*;

public class VulnerableService {

    static Connection dbconn;

    public void createAccount(String accNumber, String username,
            String password, String member_level, String first_name,
            String last_name, String email) throws Exception {
        PreparedStatement pstat = dbconn.prepareStatement("INSERT INTO accounts"
                + " (account_number, username, password, "
                + "member_level, first_name, last_name, email)"
                + " values(account_number_seq.nextval, ?, ?, ?, ?, ?, ?) ");
        pstat.setString(1, username);
        pstat.setString(2, password);
        pstat.setInt(3, Integer.parseInt(member_level));
        pstat.setString(4, first_name);
        pstat.setString(5, last_name);
        pstat.setString(6, email);
        pstat.executeUpdate();
    }

    public boolean login(String username, String password) throws Exception {
        PreparedStatement pstat = dbconn.prepareStatement(
                "SELECT * FROM accounts WHERE username= '" + username
                + "' AND password=  '" + password + "'");
        ResultSet rs = pstat.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public void updateAccount(String accNumber, String username,
            String password, String member_level, String first_name,
            String last_name, String email) throws Exception {
        String sql = "UPDATE accounts SET "
                + " username=" + escape(username)
                + ", password=" + escape(password)
                + ", member_level=" + Integer.parseInt(member_level)
                + ", first_name=" + escape(first_name)
                + ", last_name=" + escape(last_name)
                + ", email=" + escape(email)
                + " WHERE account_number=" + Integer.parseInt(accNumber);
        Statement statement = dbconn.createStatement();
        statement.executeUpdate(sql);
    }

    private String escape(String input) {
        input = "'" + input.replaceAll("'", "''") + "'";
        return input;
    }

    public void deleteAccount1(String accNumber) throws Exception {
        PreparedStatement pstat = dbconn.prepareStatement(
                "DELETE FROM accounts WHERE account_number= ?");
        pstat.setString(1, accNumber);
        pstat.executeUpdate();
    }

    public void deleteAccount2(String accNumber) throws Exception {
        int account = Integer.parseInt(accNumber);
        String sql = "DELETE FROM accounts "
                + "WHERE account_number='" + accNumber + "'";
        Statement statement = dbconn.createStatement();
        statement.executeUpdate(sql);
    }
}
