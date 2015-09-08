/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.mad.server.util;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Classer permettant de simplifier une délégation de connexion JDBC.
 *
 * @version $Revision: 1.3 $
 */
public abstract class ConnectionAdapterMock extends AbstractConnectionAdapterMock {
    public Statement createStatement() throws SQLException {
        return getSubConnection().createStatement();
    }
}
