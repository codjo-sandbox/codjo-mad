package net.codjo.mad.server.util;

import net.codjo.test.common.LogString;
import net.codjo.test.common.mock.ConnectionMock;

import java.sql.Savepoint;

abstract class AbstractConnectionMock extends ConnectionMock {
    protected final LogString log;


    AbstractConnectionMock(LogString connectionLog) {
        super(connectionLog);
        this.log = connectionLog;
    }


    @Override
    public Savepoint setSavepoint() {
        log.call("setSavepoint");
        return null;
    }


    @Override
    public void releaseSavepoint(Savepoint savepoint) {
        log.call("releaseSavepoint", savepoint);
    }


    @Override
    public void rollback(Savepoint savepoint) {
        log.call("rollback", savepoint);
    }


    @Override
    public Savepoint setSavepoint(String name) {
        log.call("setSavepoint", name);
        return null;
    }
}
