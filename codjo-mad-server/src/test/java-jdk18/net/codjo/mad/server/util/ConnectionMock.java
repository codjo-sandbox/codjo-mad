package net.codjo.mad.server.util;

import net.codjo.test.common.LogString;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Executor;

class ConnectionMock extends AbstractConnectionMock {
    ConnectionMock(LogString connectionLog) {
        super(connectionLog);
    }

    public Clob createClob() throws SQLException {
        log.call("createClob");
        return null;
    }

    public Blob createBlob() throws SQLException {
        log.call("createBlob");
        return null;
    }

    public NClob createNClob() throws SQLException {
        log.call("createNClob");
        return null;
    }

    public SQLXML createSQLXML() throws SQLException {
        log.call("createSQLXML");
        return null;
    }

    public boolean isValid(int timeout) throws SQLException {
        log.call("isValid", timeout);
        return false;
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        log.call("setClientInfo", name, value);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        log.call("setClientInfo", properties);
    }

    public String getClientInfo(String name) throws SQLException {
        log.call("getClientInfo", name);
        return null;
    }

    public Properties getClientInfo() throws SQLException {
        log.call("getClientInfo");
        return null;
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        log.call("createArrayOf", typeName, elements);
        return null;
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        log.call("createStruct", typeName, attributes);
        return null;
    }

    public void setSchema(String schema) throws SQLException {
        log.call("setSchema", schema);
    }

    public String getSchema() throws SQLException {
        log.call("getSchema");
        return null;
    }

    public void abort(Executor executor) throws SQLException {
        log.call("abort", executor);
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        log.call("setNetworkTimeout", executor, milliseconds);
    }

    public int getNetworkTimeout() throws SQLException {
        log.call("getNetworkTimeout");
        return 0;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        log.call("unwrap", iface);
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        log.call("isWrapperFor", iface);
        return false;
    }
}
