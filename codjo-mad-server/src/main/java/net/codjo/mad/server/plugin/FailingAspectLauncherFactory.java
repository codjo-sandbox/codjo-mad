package net.codjo.mad.server.plugin;
import net.codjo.mad.server.handler.AspectBranchLauncher;
import net.codjo.mad.server.handler.AspectBranchLauncherFactory;
/**
 *
 */
class FailingAspectLauncherFactory implements AspectBranchLauncherFactory {
    public AspectBranchLauncher create() {
        throw new UnsupportedOperationException(
              "Aucun moteur permettant de g�rer les aspects en mode fork n'a �t� configur�."
              + " Avez-vous ajout� le plugin WorkflowServerPlugin apr�s MadServerPlugin ?");
    }
}
