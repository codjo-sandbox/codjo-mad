package net.codjo.mad.gui.request.requetor;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
/**
 * Cette classe g�re 6 listes en parall�le de la sqlList de la classe SqlRequetor. Pour un index donn�,
 * l'ensemble des �l�ments de ces listes correspond � la ligne de m�me index de la sqlList.
 */
class SqlRequetorRequest {
    static final int EQUAL = 0;
    static final int SUP = 1;
    static final int SUP_EQUAL = 2;
    static final int INF = 3;
    static final int INF_EQUAL = 4;
    static final int DIFFERENT = 5;
    static final int BEGIN_BY = 6;
    static final int NOT_BEGIN_BY = 7;
    static final int END_BY = 8;
    static final int NOT_END_BY = 9;
    static final int CONTAIN = 10;
    static final int NOT_CONTAIN = 11;
    static final int NULL = 12;
    static final int NOT_NULL = 13;

    private static final String QUOTE = "'";
    private static final String PERCENT_QUOTE = "%'";
    private static final String QUOTE_PERCENT = "'%";

    //L'op�rateur logique (and ou or)
    private List<String> logicalOper = new ArrayList<String>();

    //L'objet links
    private List<Link> links = new ArrayList<Link>();

    //Le nom physique du champ de la links courante
    private List<String> field = new ArrayList<String>();

    //L'op�rateur de comparaison (=, like, ...)
    private List<Integer> compareOper = new ArrayList<Integer>();

    //Le pr�fixe de la valeur du champ(', '%, ...)
    private List<String> prefixValue = new ArrayList<String>();

    //La valeur du champ
    private List<String> value = new ArrayList<String>();

    //Le suffixe de la valeur du champ(', %', ...)
    private List<String> suffixValue = new ArrayList<String>();

    //La jointure gauche
    private boolean leftJoin;


    SqlRequetorRequest() {
    }


    /**
     * Constructor par copie
     *
     * @param req Description of Parameter
     */
    SqlRequetorRequest(SqlRequetorRequest req) {
        logicalOper = new ArrayList<String>(req.logicalOper);
        links = new ArrayList<Link>(req.links);
        field = new ArrayList<String>(req.field);
        compareOper = new ArrayList<Integer>(req.compareOper);
        prefixValue = new ArrayList<String>(req.prefixValue);
        value = new ArrayList<String>(req.value);
        suffixValue = new ArrayList<String>(req.suffixValue);
        leftJoin = req.leftJoin;
    }


    /**
     * Met � jour l'op�rateur logique � l'index donn�.
     *
     * @param newLogicalOper La valeur de l'op�rateur
     * @param idx            L'index
     */
    public void setLogicalOper(String newLogicalOper, int idx) {
        logicalOper.set(idx, newLogicalOper);
    }


    /**
     * Met � jour le nom physique du champ � l'index donn�.
     *
     * @param newField Le nom du champ
     * @param idx      L'index
     */
    public void setField(String newField, int idx) {
        field.set(idx, newField);
    }


    /**
     * Met � jour l'op�rateur de comparaison � l'index donn�.
     *
     * @param newCompareOper La valeur de l'op�rateur
     * @param idx            L'index
     */
    public void setCompareOper(int newCompareOper, int idx) {
        compareOper.set(idx, newCompareOper);
    }


    /**
     * Met � jour le pr�fixe de la valeur du champ � l'index donn�.
     *
     * @param newPrefixValue La valeur du pr�fixe
     * @param idx            L'index
     */
    public void setPrefixValue(String newPrefixValue, int idx) {
        prefixValue.set(idx, newPrefixValue);
    }


    /**
     * Met � jour la valeur du champ � l'index donn�.
     *
     * @param newValue La valeur du champ
     * @param idx      L'index
     */
    public void setValue(String newValue, int idx) {
        value.set(idx, addQuote(newValue));
    }


    /**
     * Met � jour le suffixe de la valeur du champ � l'index donn�.
     *
     * @param newSuffixValue La valeur du suffixe
     * @param idx            L'index
     */
    public void setSuffixValue(String newSuffixValue, int idx) {
        suffixValue.set(idx, newSuffixValue);
    }


    /**
     * Met � jour si la requ�te utilise une jointure gauche ou pas.
     *
     * @param isLeftJoin True sijointure gauche, False sinon
     */
    public void setLeftJoin(boolean isLeftJoin) {
        leftJoin = isLeftJoin;
    }


    /**
     * Retourne l'op�rateur logique � l'index donn�.
     *
     * @param idx L'index
     *
     * @return L'op�rateur
     */
    public String getLogicalOper(int idx) {
        return logicalOper.get(idx);
    }


    /**
     * Retourne le nom physique du champ � l'index donn�.
     *
     * @param idx L'index
     *
     * @return Le nom du champ
     */
    public String getField(int idx) {
        return field.get(idx);
    }


    /**
     * Retourne la taille des listes de la requ�te.
     *
     * @return La taille des listes.
     */
    public int getRequestListSize() {
        return field.size();
    }


    /**
     * Retourne l'op�rateur de comparaison � l'index donn�.
     *
     * @param idx L'index
     *
     * @return L'op�rateur
     */
    public int getCompareOperValue(int idx) {
        return compareOper.get(idx);
    }


    /**
     * Retourne l'op�rateur de comparaison � l'index donn�.
     *
     * @param idx L'index
     *
     * @return L'op�rateur
     */
    public String getCompareOperTraducValue(int idx) {
        int oper = getCompareOperValue(idx);
        if (oper != -1) {
            return traductOperator(oper);
        }
        else {
            return "";
        }
    }


    /**
     * Retourne le pr�fixe de la valeur du champ � l'index donn�.
     *
     * @param idx L'index
     *
     * @return Le pr�fixe
     */
    public String getPrefixValue(int idx) {
        return prefixValue.get(idx);
    }


    /**
     * Retourne la valeur du champ � l'index donn�.
     *
     * @param idx L'index
     *
     * @return La valeur du champ
     */
    public String getValue(int idx) {
        return value.get(idx);
    }


    /**
     * Retourne le suffixe de la valeur du champ � l'index donn�.
     *
     * @param idx L'index
     *
     * @return Le suffixe
     */
    public String getSuffixValue(int idx) {
        return suffixValue.get(idx);
    }


    /**
     * Retourne si la requ�te utilise une jointure gauche ou pas.
     *
     * @return True si jointure gauche, False sinon
     */
    public boolean getLeftJoin() {
        return leftJoin;
    }


    /**
     * Retourne l'ensemble des �l�ments des listes � l'index donn�.
     *
     * @param idx L'index
     *
     * @return Les �l�ments des listes
     */
    public String getRequest(int idx) {
        StringBuilder str = new StringBuilder();
        if (!logicalOper.isEmpty() && logicalOper.size() > idx) {
            str.append(getLogicalOper(idx));
        }
        if ((!links.isEmpty() && links.size() > idx) && (!field.isEmpty() && field.size() > idx)) {
            Link link = getLink(idx);
            if (link != null) {
                str.append(link.completeSqlFieldName(getField(idx)));
            }
            else {
                str.append(getField(idx));
            }
        }

        if (!compareOper.isEmpty() && compareOper.size() > idx) {
            str.append(getCompareOperTraducValue(idx));
        }
        if (!prefixValue.isEmpty() && prefixValue.size() > idx) {
            str.append(getPrefixValue(idx));
        }
        if (!value.isEmpty() && value.size() > idx) {
            str.append(getValue(idx));
        }
        if (!suffixValue.isEmpty() && suffixValue.size() > idx) {
            str.append(getSuffixValue(idx));
        }
        return str.toString();
    }


    /**
     * Overview.
     *
     * <p> Description </p>
     *
     * @param idx Description of Parameter
     */
    public void removeElements(int idx) {
        logicalOper.remove(idx);
        field.remove(idx);
        compareOper.remove(idx);
        prefixValue.remove(idx);
        value.remove(idx);
        suffixValue.remove(idx);
        links.remove(idx);
    }


    /**
     * Ajoute un �l�ment vide � chacune des listes pour l'index donn�.
     *
     * @param idx L'index
     */
    public void addElements(int idx) {
        logicalOper.add(idx, "");
        field.add(idx, "");
        compareOper.add(idx, -1);
        prefixValue.add(idx, "");
        value.add(idx, "");
        suffixValue.add(idx, "");
        links.add(idx, null);
    }


    /**
     * Supprime tous les �l�ments des listes.
     */
    public void removeAllElements() {
        for (int i = 0; i < value.size(); i++) {
            removeElements(i);
        }
    }


    /**
     * Met � jour l'objet links � l'index donn�.
     *
     * @param newLink L'objet links
     * @param idx     L'index
     */
    void setLink(Link newLink, int idx) {
        links.set(idx, newLink);
    }


    /**
     * Retourne l'objet links � l'index donn�
     *
     * @param linkIndex L'index
     *
     * @return L'objet links
     */
    Link getLink(int linkIndex) {
        return links.get(linkIndex);
    }


    /**
     * Met � jour le pr�fixe et le suffixe d'une valeur pour l'index donn� en fonction de l'op�rateur de
     * comparaison et du type SQL du champ.
     *
     * @param oper    L'op�rateur de comparaison.
     * @param idx     L'index.
     * @param sqlType Le type SQL du champ.
     */
    void updatePrefSuffValue(int oper, int idx, int sqlType) {
        if (oper == CONTAIN || oper == NOT_CONTAIN) {
            setPrefixValue(QUOTE_PERCENT, idx);
            setSuffixValue(PERCENT_QUOTE, idx);
        }
        else if (oper == BEGIN_BY || oper == NOT_BEGIN_BY) {
            setPrefixValue(QUOTE, idx);
            setSuffixValue(PERCENT_QUOTE, idx);
        }
        else if (oper == END_BY || oper == NOT_END_BY) {
            setPrefixValue(QUOTE_PERCENT, idx);
            setSuffixValue(QUOTE, idx);
        }
        else if (sqlType == Types.BIT
                 || isNumeric(sqlType)
                 || oper == NULL
                 || oper == NOT_NULL) {
            setPrefixValue("", idx);
            setSuffixValue("", idx);
        }
        else {
            setPrefixValue(QUOTE, idx);
            setSuffixValue(QUOTE, idx);
        }
    }


    /**
     * Adds a feature to the Quote attribute of the SqlRequetorRequest object
     *
     * @param param The feature to be added to the Quote attribute
     *
     * @return Description of the Returned Value
     */
    private String addQuote(String param) {
        StringBuilder tmp = new StringBuilder(param);
        char quote = '\'';
        int index = 0;
        while (index < tmp.length()) {
            if (tmp.charAt(index) == quote) {
                tmp.insert(index, quote);
                index++;
            }
            index++;
        }
        return tmp.toString();
    }


    /**
     * Traduit les op�rateurs de comparaison en "langage Sybase".
     *
     * @param oper L'op�rateur s�lection� dans la liste.
     *
     * @return La valeur traduite.
     *
     * @throws IllegalArgumentException si <code>oper</code> est un op�rateur inconnu
     */
    private String traductOperator(int oper) {
        String strOper;
        switch (oper) {
            case EQUAL:
                strOper = " = ";
                break;
            case SUP:
                strOper = " > ";
                break;
            case SUP_EQUAL:
                strOper = " >= ";
                break;
            case INF:
                strOper = " < ";
                break;
            case INF_EQUAL:
                strOper = " <= ";
                break;
            case DIFFERENT:
                strOper = " <> ";
                break;
            case BEGIN_BY:
                strOper = " like ";
                break;
            case NOT_BEGIN_BY:
                strOper = " not like ";
                break;
            case END_BY:
                strOper = " like ";
                break;
            case NOT_END_BY:
                strOper = " not like ";
                break;
            case CONTAIN:
                strOper = " like ";
                break;
            case NOT_CONTAIN:
                strOper = " not like ";
                break;
            case NULL:
                strOper = " is null ";
                break;
            case NOT_NULL:
                strOper = " is not null ";
                break;
            default:
                throw new IllegalArgumentException("Operateur inconnu");
        }
        return strOper;
    }


    /**
     * Indique si le type SQL est de format numerique.
     *
     * @param sqlType type sql.
     *
     * @return <code>true</code> si oui.
     */
    private static boolean isNumeric(int sqlType) {
        return sqlType == Types.INTEGER || sqlType == Types.NUMERIC
               || sqlType == Types.FLOAT || sqlType == Types.DOUBLE || sqlType == Types.DECIMAL
               || sqlType == Types.BIGINT || sqlType == Types.REAL || sqlType == Types.SMALLINT
               || sqlType == Types.TINYINT;
    }
}
