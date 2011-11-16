package net.codjo.mad.gui.request.util;
import net.codjo.mad.gui.request.DetailDataSource;
import net.codjo.mad.gui.request.FieldType;
import net.codjo.mad.gui.request.wrapper.GuiWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JComponent;
/**
 * Collecte les attributs public d'une classe.
 *
 * @author $Author: gaudefr $
 * @version $Revision: 1.9 $
 */
public final class DetailWindowUtil {
    private DetailWindowUtil() {}

    /**
     * Retourne les attributs public (avec leurs valeurs) d�finit dans l'objet
     * <code>panel</code>
     *
     * @param panel L'objet a scanner
     *
     * @return Une map (key=nom de l'attribut / value = valeur de l'attribut)
     *
     * @throws InternalError si une erreur se produit durant l'introspection
     *
     * @deprecated Cette m�thode demande que des champs soit publiques, ce qui viole nos
     *             normes de programmations. Si le but est de r�cup�rer la liste des
     *             champs d�clar�s sur un DetailDataSource, on peut utiliser la m�thode
     *             {@link net.codjo.mad.gui.request.DetailDataSource#getDeclaredFields()}
     */
    @Deprecated
    public static Map getPublicFields(Object panel) {
        try {
            Map attributes = new HashMap();

            Field[] fields = panel.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.getModifiers() == Modifier.PUBLIC
                    && JComponent.class.isAssignableFrom(field.getType())) {
                    attributes.put(field.getName(), field.get(panel));
                }
            }
            return attributes;
        }
        catch (IllegalAccessException ex) {
            // Cas normalement impossible : Le champ est public
            throw new InternalError("");
        }
    }


    /**
     * Permet de d�clarer les champs publiques d'un composant graphique sur un
     * DetailDataSource
     *
     * @param dataSource Le DetailDataSource
     * @param panel Le composant graphique
     *
     * @deprecated Cette m�thode demande que des champs soit publiques, ce qui viole nos
     *             normes de programmations. Pour �viter cel�, il faut les d�clarer
     *             priv�s et les d�clarer un � un � l'aide de la m�thode {@link
     *             net.codjo.mad.gui.request.DetailDataSource#declare(String, JComponent)}
     */
    public static void declarePublicFields(DetailDataSource dataSource, Object panel) {
        Map declaredFields = getPublicFields(panel);
        for (Iterator i = declaredFields.entrySet().iterator(); i.hasNext();) {
            Map.Entry item = (Map.Entry)i.next();
            dataSource.declare((String)item.getKey(),
                (javax.swing.JComponent)item.getValue());
        }
    }


    /**
     * M�thode g�rant le type d'�dition des champs d'un composant graphique
     *
     * @param dataSource Le DetailDataSource
     * @param frame Le composant graphique
     *
     * @deprecated Cette m�thode demande que des champs soit publiques, ce qui viole nos
     *             normes de programmations. Utiliser la nouvelle m�thode {@link
     *             DetailWindowUtil#manageEditModeFields(net.codjo.mad.gui.request.DetailDataSource)}
     *             en d�clarant les champs priv�s.
     */
    public static void manageFields(DetailDataSource dataSource, JComponent frame) {
        boolean updateMode = dataSource.getLoadFactory() != null;
        Map declaredFields = getPublicFields(frame);
        for (Iterator i = declaredFields.values().iterator(); i.hasNext();) {
            JComponent comp = (JComponent)i.next();
            if (FieldType.NOT_EDITABLE == comp.getClientProperty(FieldType.EDIT_MODE)) {
                comp.setEnabled(false);
            }
            else if (FieldType.NOT_UPDATABLE == comp.getClientProperty(
                        FieldType.EDIT_MODE)) {
                comp.setEnabled(!updateMode);
            }
            else if (FieldType.READ_ONLY == comp.getClientProperty(FieldType.EDIT_MODE)) {
                comp.setEnabled(false);
            }
        }
    }


    /**
     * M�thode g�rant le type d'�dition des champs d'un �cran de d�tail.
     *
     * @param dataSource Le DetailDataSource de l'�cran de d�tail
     */
    public static void manageEditModeFields(DetailDataSource dataSource) {
        boolean updateMode = dataSource.getLoadFactory() != null;

        Map<String, GuiWrapper> declaredFields = dataSource.getDeclaredFields();
        for (String fieldName : declaredFields.keySet()) {
            GuiWrapper wrapper = declaredFields.get(fieldName);
            JComponent comp = wrapper.getGuiComponent();
            if (FieldType.NOT_EDITABLE == comp.getClientProperty(FieldType.EDIT_MODE)) {
                comp.setEnabled(false);
            }
            else if (FieldType.NOT_UPDATABLE == comp.getClientProperty(
                  FieldType.EDIT_MODE)) {
                comp.setEnabled(!updateMode);
            }
            else if (FieldType.READ_ONLY == comp.getClientProperty(FieldType.EDIT_MODE)) {
                comp.setEnabled(false);
            }
        }
    }
}
