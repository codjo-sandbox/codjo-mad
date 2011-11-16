package net.codjo.mad.client.request.util;
/**
 * Factory de JMSHelper par systeme de prototype.
 *
 * @author $Author: gaudefr $
 * @version $Revision: 1.5 $
 *
 * @todo l'initialisation par d�faut est d�sactiv�e (cf. test_createJMSHelper).
 */
public final class ServerWrapperFactory {
    private static ServerWrapper prototype = initWithDefaultPrototype();

    private ServerWrapperFactory() {}

    public static void setPrototype(ServerWrapper proto) {
        prototype = proto;
    }


    public static ServerWrapper getPrototype() {
        return prototype;
    }


    public static ServerWrapper createWrapper() {
        return prototype.copy();
    }


    public static ServerWrapper initWithDefaultPrototype() {
        prototype = null;
//        prototype = new DefaultWrapper();
        return prototype;
    }
}
