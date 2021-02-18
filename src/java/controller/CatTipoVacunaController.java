package controller;

import modelitos.CatTipoVacuna;
import modelitos.TbInventarioVacunas;
import java.util.Collection;
import facade.CatTipoVacunaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "catTipoVacunaController")
@ViewScoped
public class CatTipoVacunaController extends AbstractController<CatTipoVacuna> {

    @Inject
    private CatLaboratorioController idLaboratorioController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTbInventarioVacunasCollectionEmpty;

    public CatTipoVacunaController() {
        // Inform the Abstract parent controller of the concrete CatTipoVacuna Entity
        super(CatTipoVacuna.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idLaboratorioController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTbInventarioVacunasCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the CatLaboratorio controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdLaboratorio(ActionEvent event) {
        CatTipoVacuna selected = this.getSelected();
        if (selected != null && idLaboratorioController.getSelected() == null) {
            idLaboratorioController.setSelected(selected.getIdLaboratorio());
        }
    }

    public boolean getIsTbInventarioVacunasCollectionEmpty() {
        return this.isTbInventarioVacunasCollectionEmpty;
    }

    private void setIsTbInventarioVacunasCollectionEmpty() {
        CatTipoVacuna selected = this.getSelected();
        if (selected != null) {
            CatTipoVacunaFacade ejbFacade = (CatTipoVacunaFacade) this.getFacade();
            this.isTbInventarioVacunasCollectionEmpty = ejbFacade.isTbInventarioVacunasCollectionEmpty(selected);
        } else {
            this.isTbInventarioVacunasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TbInventarioVacunas
     * entities that are retrieved from CatTipoVacuna and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TbInventarioVacunas page
     */
    public String navigateTbInventarioVacunasCollection() {
        CatTipoVacuna selected = this.getSelected();
        if (selected != null) {
            CatTipoVacunaFacade ejbFacade = (CatTipoVacunaFacade) this.getFacade();
            Collection<TbInventarioVacunas> selectedTbInventarioVacunasCollection = ejbFacade.findTbInventarioVacunasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TbInventarioVacunas_items", selectedTbInventarioVacunasCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/tbInventarioVacunas/index";
    }

}
