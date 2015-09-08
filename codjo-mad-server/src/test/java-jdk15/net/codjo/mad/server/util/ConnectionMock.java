package net.codjo.mad.server.util;

import net.codjo.test.common.LogString;

import java.sql.Savepoint;

class ConnectionMock extends AbstractConnectionMock {
    ConnectionMock(LogString connectionLog) {
        super(connectionLog);
    }
}
