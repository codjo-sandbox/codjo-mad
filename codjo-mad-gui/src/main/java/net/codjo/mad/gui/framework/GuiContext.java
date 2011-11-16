package net.codjo.mad.gui.framework;
import net.codjo.security.common.api.User;
import java.util.Observer;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
/**
 * D�finit le contexte utilis� dans les IHM de mad.
 */
public interface GuiContext {
    public JFrame getMainFrame();


    public JDesktopPane getDesktopPane();


    public boolean hasProperty(Object propertyName);


    public void executeTask(SwingRunnable task);


    public void sendEvent(GuiEvent evt);


    public void displayInfo(String msg);


    public Object getProperty(Object propertyName);


    public void addObserver(Observer obs);


    public void removeObserver(Observer obs);


    public User getUser();


    public Sender getSender();
}
