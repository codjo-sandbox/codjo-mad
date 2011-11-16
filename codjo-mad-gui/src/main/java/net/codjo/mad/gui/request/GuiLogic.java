package net.codjo.mad.gui.request;
import java.awt.Component;

/**
 * Interface permettant de d�finir les m�thodes des objets "Logic".<br>
 */
public interface GuiLogic<T extends Component> {

    public T getGui() throws Exception;
}
