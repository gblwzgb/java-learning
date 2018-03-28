package concurrentprogram.part4.p207;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 通过数据库连接池的获取、释放，演示了等待/通知模型的简单应用。
 *
 * 等待方：
 *   1. 获取锁
 *   2. 判断条件，条件不满足则wait（可在这里加上超时处理）
 *   3. 收到通知了，再判断一下条件
 * 通知方：
 *   1. 获取锁
 *   2. 修改某条件
 *   3. notifyAll通知其他wait的线程
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后，通知其他线程
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    // 在mills内无法获取连接，将返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
