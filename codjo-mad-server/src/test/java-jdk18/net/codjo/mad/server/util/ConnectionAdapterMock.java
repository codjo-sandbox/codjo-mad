/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.mad.server.util;
import java.sql.*;
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



    public Clob createClob() throws SQLException {
        return getSubConnection().createClob();
    }

    public Blob createBlob() throws SQLException {
        return getSubConnection().createBlob();
    }

    public NClob createNClob() throws SQLException {
        return getSubConnection().createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return getSubConnection().createSQLXML();
    }

    public boolean isValid(int timeout) throws SQLException {
        return getSubConnection().isValid(timeout);
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        getSubConnection().setClientInfo(name, value);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        getSubConnection().setClientInfo(properties);
    }

    public String getClientInfo(String name) throws SQLException {
        return getSubConnection().getClientInfo(name);
    }

    public Properties getClientInfo() throws SQLException {
        return getSubConnection().getClientInfo();
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return getSubConnection().createArrayOf(typeName, elements);
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return getSubConnection().createStruct(typeName, attributes);
    }

    public void setSchema(String schema) throws SQLException {
        getSubConnection().setSchema(schema);
    }

    public String getSchema() throws SQLException {
        return getSubConnection().getSchema();
    }

    public void abort(Executor executor) throws SQLException {
        getSubConnection().abort(executor);
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        getSubConnection().setNetworkTimeout(executor, milliseconds);
    }

    public int getNetworkTimeout() throws SQLException {
        return getSubConnection().getNetworkTimeout();
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return getSubConnection().unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return getSubConnection().isWrapperFor(iface);
    }
}
