package net.codjo.mad.gui.request.event;
import java.util.EventListener;
/**
 * Ecoute les event lie aux DataSource.
 * 
 * <p>
 * <b>NB</b> : L'evenement beforeLoad n'est pas forcement suivi d'un evenement Load (cas
 * d'un echec).
 * </p>
 *
 * @author $Author: gaudefr $
 * @version $Revision: 1.8 $
 */
public interface DataSourceListener extends EventListener {
    /**
     * Appel� apr�s un chargement r�ussi.
     *
     * @param event
     */
    public void loadEvent(DataSourceEvent event);


    /**
     * Appel� avant de charger. Cette m�thode est appel�e avant l'envoi au serveur.
     *
     * @param event
     */
    public void beforeLoadEvent(DataSourceEvent event);


    /**
     * Appel� avant d'enregistrer en base. Cette m�thode est appel�e avant l'envoi au
     * serveur.
     *
     * @param event
     */
    public void beforeSaveEvent(DataSourceEvent event);


    /**
     * Appel� apr�s un enregistrement en base.
     *
     * @param event
     */
    public void saveEvent(DataSourceEvent event);
}
