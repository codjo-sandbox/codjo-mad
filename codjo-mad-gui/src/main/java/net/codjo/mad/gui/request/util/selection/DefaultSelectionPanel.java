package net.codjo.mad.gui.request.util.selection;
import net.codjo.mad.gui.framework.GuiContext;
import javax.swing.Action;
/**
 * Classe obsol�te.
 *
 * @author $Author: gaudefr $
 * @version $Revision: 1.11 $
 *
 * @see SelectionGui
 * @deprecated Classe renomm�e en SelectionGui
 */
public class DefaultSelectionPanel extends SelectionGui {
    public DefaultSelectionPanel() {
        super(null);
    }

    public void setAddAction(Action addAction) {
        setSelectAction(addAction);
    }


    public void setRemoveAction(Action removeAction) {
        setUnSelectAction(removeAction);
    }


    public void setGuiContext(GuiContext guiCtxt) {
        initFromToolBar(guiCtxt);
    }
}
