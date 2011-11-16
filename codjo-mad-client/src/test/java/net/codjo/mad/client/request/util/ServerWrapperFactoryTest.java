package net.codjo.mad.client.request.util;
import junit.framework.TestCase;
import org.easymock.MockControl;
/**
 * @todo le test test_createJMSHelper est commente (en attendant d'eclaircir le cas de la librairie HANDLER).
 */
public class ServerWrapperFactoryTest extends TestCase {
    public ServerWrapperFactoryTest(String str) {
        super(str);
    }


    /**
     * Verifie que la m�thode factory marche bien par d�faut.
     *
     * @throws Exception
     */
    public void test_createJMSHelper() throws Exception {
//        ServerWrapper a = ServerWrapperFactory.createWrapper();
//        ServerWrapper b = ServerWrapperFactory.createWrapper();
//
//        assertTrue("instance diff�rente", a != b);
//        assertTrue("M�me classe", a.getClass() == b.getClass());
//        assertEquals("Classe par d�faut", DefaultWrapper.class, b.getClass());
    }


    /**
     * Verifie que le prototypage est utilis�.
     *
     * @throws Exception
     */
    public void test_createJMSHelper_prototype() throws Exception {
        MockControl control = MockControl.createControl(ServerWrapper.class);
        ServerWrapper mockHelper = (ServerWrapper)control.getMock();

        mockHelper.copy();
        control.setReturnValue(mockHelper);

        control.replay();

        ServerWrapperFactory.setPrototype(mockHelper);
        ServerWrapper wrapper = ServerWrapperFactory.createWrapper();

        control.verify();
        assertTrue(mockHelper == wrapper);
    }


    @Override
    protected void tearDown() {
        ServerWrapperFactory.initWithDefaultPrototype();
    }
}
