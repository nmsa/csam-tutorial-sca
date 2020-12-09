/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.SQLException;

/**
 *
 * @author root
 */
public class BookstoreException extends SQLException {

    private Exception e;
    private String sql;

    public BookstoreException(Exception e, String sql) {
        this.e = e;
        this.sql = sql;
    }

    /**
     * @return the e
     */
    public Exception getE() {
        return e;
    }

    /**
     * @return the sql
     */
    public String getSql() {
        return sql;
    }
}
