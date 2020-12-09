package bookstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author root
 */
public final class SQLHistory {

    private static final ArrayList<String> sql = new ArrayList<String>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    public static void add(String cmd) {
        lock.writeLock().lock();
        sql.add(cmd);
        lock.writeLock().unlock();
    }

    public static Object[] getSql() {
        lock.readLock().lock();
        Object[] array = sql.toArray();
        lock.readLock().unlock();
        return array;
    }

    public static String logException(Exception e, JspWriter out) {
        try {
            StringBuilder sb = new StringBuilder();
            if (e instanceof BookstoreException) {
                BookstoreException ste = (BookstoreException) e;
                sb.append(ste.getE().toString());
                sb.append("<br/>Caused by SQL:<br/>");
                sb.append(ste.getSql());
            } else {
                sb.append(e.toString());
            }
            out.println(sb.toString());
            return sb.toString();
        } catch (IOException ioe) {
            return ioe.toString();
        }
    }

    private SQLHistory() {
    }
}
