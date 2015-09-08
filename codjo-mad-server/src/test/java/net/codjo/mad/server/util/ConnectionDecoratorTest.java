/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.mad.server.util;
import junit.framework.TestCase;
import net.codjo.test.common.LogCallAssert;
import net.codjo.test.common.LogString;

import java.sql.Connection;

/**
 * Classe de test de {@link ConnectionDecorator}.
 */
public class ConnectionDecoratorTest extends TestCase {
    private ConnectionDecorator decorator;
    private Connection connection;
    private LogString log;


    public void test_getConnection() throws Exception {
        assertSame(connection, decorator.getConnection());
    }


    public void test_delegate() throws Exception {
        LogCallAssert logCallAssert = new LogCallAssert(Connection.class);
        logCallAssert.assertCalls(decorator, log);
    }


    @Override
    protected void setUp() throws Exception {
        log = new LogString();
        connection = new ConnectionMock(log).getStub();
        decorator = new ConnectionDecorator(connection);
    }
}
