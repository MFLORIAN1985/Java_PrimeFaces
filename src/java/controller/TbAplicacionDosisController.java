package controller;

import modelitos.TbAplicacionDosis;
import facade.TbAplicacionDosisFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tbAplicacionDosisController")
@ViewScoped
public class TbAplicacionDosisController extends AbstractController<TbAplicacionDosis> {

    @Inject
    private TbInventarioVacunasController idInventarioVacunaController;
    @Inject
    private TbPersonaController cuiController;
    @Inject
    private MobilePageController mobilePageController;

    public TbAplicacionDosisController() {
        // Inform the Abstract parent controller of the concrete TbAplicacionDosis Entity
        super(TbAplicacionDosis.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idInventarioVacunaController.setSelected(null);
        cuiController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TbInventarioVacunas controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInventarioVacuna(ActionEvent event) {
        TbAplicacionDosis selected = this.getSelected();
        if (selected != null && idInventarioVacunaController.getSelected() == null) {
            idInventarioVacunaController.setSelected(selected.getIdInventarioVacuna());
        }
    }

    /**
     * Sets the "selected" attribute of the TbPersona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCui(ActionEvent event) {
        TbAplicacionDosis selected = this.getSelected();
        if (selected != null && cuiController.getSelected() == null) {
            cuiController.setSelected(selected.getCui());
        }
    }

}
