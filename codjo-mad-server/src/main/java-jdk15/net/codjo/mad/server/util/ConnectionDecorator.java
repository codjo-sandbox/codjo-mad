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
 * Decorateur de connexion.
 *
 * <p> Chaque appel sur le decorateur est délégué vers la sous-connexion. </p>
 */
public class ConnectionDecorator extends AbstractConnectionDecorator {
    protected ConnectionDecorator(Connection connection) {
        super(connection);
    }
}
