package controller;

import modelitos.TbInventarioVacunas;
import modelitos.TbAplicacionDosis;
import java.util.Collection;
import facade.TbInventarioVacunasFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tbInventarioVacunasController")
@ViewScoped
public class TbInventarioVacunasController extends AbstractController<TbInventarioVacunas> {

    @Inject
    private CatTipoVacunaController idTipoVacunaController;
    @Inject
    private CatLaboratorioController idLaboratorioController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTbAplicacionDosisCollectionEmpty;

    public TbInventarioVacunasController() {
        // Inform the Abstract parent controller of the concrete TbInventarioVacunas Entity
        super(TbInventarioVacunas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoVacunaController.setSelected(null);
        idLaboratorioController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTbAplicacionDosisCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the CatTipoVacuna controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoVacuna(ActionEvent event) {
        TbInventarioVacunas selected = this.getSelected();
        if (selected != null && idTipoVacunaController.getSelected() == null) {
            idTipoVacunaController.setSelected(selected.getIdTipoVacuna());
        }
    }

    /**
     * Sets the "selected" attribute of the CatLaboratorio controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdLaboratorio(ActionEvent event) {
        TbInventarioVacunas selected = this.getSelected();
        if (selected != null && idLaboratorioController.getSelected() == null) {
            idLaboratorioController.setSelected(selected.getIdLaboratorio());
        }
    }

    public boolean getIsTbAplicacionDosisCollectionEmpty() {
        return this.isTbAplicacionDosisCollectionEmpty;
    }

    private void setIsTbAplicacionDosisCollectionEmpty() {
        TbInventarioVacunas selected = this.getSelected();
        if (selected != null) {
            TbInventarioVacunasFacade ejbFacade = (TbInventarioVacunasFacade) this.getFacade();
            this.isTbAplicacionDosisCollectionEmpty = ejbFacade.isTbAplicacionDosisCollectionEmpty(selected);
        } else {
            this.isTbAplicacionDosisCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TbAplicacionDosis
     * entities that are retrieved from TbInventarioVacunas and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TbAplicacionDosis page
     */
    public String navigateTbAplicacionDosisCollection() {
        TbInventarioVacunas selected = this.getSelected();
        if (selected != null) {
            TbInventarioVacunasFacade ejbFacade = (TbInventarioVacunasFacade) this.getFacade();
            Collection<TbAplicacionDosis> selectedTbAplicacionDosisCollection = ejbFacade.findTbAplicacionDosisCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TbAplicacionDosis_items", selectedTbAplicacionDosisCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/tbAplicacionDosis/index";
    }

}
