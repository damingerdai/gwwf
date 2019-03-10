package org.daming.gwwf.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JDBCToolsTest {

    @Test
    public void getConnection() {
        Connection connection = JDBCTools.getConnection();
        System.out.println(connection);
    }

    @Test
    public void release() {
    }

    @Test
    public void release1() {
    }

    @Test
    public void release2() {
    }

    @Test
    public void release3() {
    }

    @Test
    public void release4() {
    }

    @Test
    public void commit() {
    }

    @Test
    public void rollback() {
    }

    @Test
    public void beginTx() {
    }
}