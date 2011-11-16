/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.mad.server;
import net.codjo.security.common.api.User;
/**
 * Interface d�crivant un Contexte de requ�te.
 * 
 * <p>
 * Exemple d'utilisation :
 * </p>
 * <pre>
 *  MadRequestContext myContext = ...;
 *  try {
 *  ... // Use context
 *  }
 *  finally {
 *  myContext.close();
 *  }
 *  </pre>
 */
public interface MadRequestContext {
    /**
     * Retourne la transaction de la requ�te.
     *
     * @return une Transaction
     */
    MadTransaction getTransaction();


    /**
     * Retourne le gestionnaire de connexion.
     *
     * @return Un Gestionnaire de connexion.
     */
    MadConnectionManager getConnectionManager();


    /**
     * Retourne le profil de l'utilisateur courant.
     *
     * @return Profil Utilisateur
     */
    User getUserProfil();


    /**
     * Ferme le contexte de la requ�te.
     * 
     * <p>
     * Il devient alors inutilisable (nettoie toutes les ressources utilis�es).
     * </p>
     */
    void close();
}
