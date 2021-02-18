package controller;

import modelitos.CatLaboratorio;
import modelitos.CatTipoVacuna;
import modelitos.TbInventarioVacunas;
import java.util.Collection;
import facade.CatLaboratorioFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "catLaboratorioController")
@ViewScoped
public class CatLaboratorioController extends AbstractController<CatLaboratorio> {

    @Inject
    private CatPaisController idPaisController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isCatTipoVacunaCollectionEmpty;
    private boolean isTbInventarioVacunasCollectionEmpty;

    public CatLaboratorioController() {
        // Inform the Abstract parent controller of the concrete CatLaboratorio Entity
        super(CatLaboratorio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPaisController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCatTipoVacunaCollectionEmpty();
        this.setIsTbInventarioVacunasCollectionEmpty();
    }

    public boolean getIsCatTipoVacunaCollectionEmpty() {
        return this.isCatTipoVacunaCollectionEmpty;
    }

    private void setIsCatTipoVacunaCollectionEmpty() {
        CatLaboratorio selected = this.getSelected();
        if (selected != null) {
            CatLaboratorioFacade ejbFacade = (CatLaboratorioFacade) this.getFacade();
            this.isCatTipoVacunaCollectionEmpty = ejbFacade.isCatTipoVacunaCollectionEmpty(selected);
        } else {
            this.isCatTipoVacunaCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CatTipoVacuna entities
     * that are retrieved from CatLaboratorio and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CatTipoVacuna page
     */
    public String navigateCatTipoVacunaCollection() {
        CatLaboratorio selected = this.getSelected();
        if (selected != null) {
            CatLaboratorioFacade ejbFacade = (CatLaboratorioFacade) this.getFacade();
            Collection<CatTipoVacuna> selectedCatTipoVacunaCollection = ejbFacade.findCatTipoVacunaCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CatTipoVacuna_items", selectedCatTipoVacunaCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/catTipoVacuna/index";
    }

    /**
     * Sets the "selected" attribute of the CatPais controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPais(ActionEvent event) {
        CatLaboratorio selected = this.getSelected();
        if (selected != null && idPaisController.getSelected() == null) {
            idPaisController.setSelected(selected.getIdPais());
        }
    }

    public boolean getIsTbInventarioVacunasCollectionEmpty() {
        return this.isTbInventarioVacunasCollectionEmpty;
    }

    private void setIsTbInventarioVacunasCollectionEmpty() {
        CatLaboratorio selected = this.getSelected();
        if (selected != null) {
            CatLaboratorioFacade ejbFacade = (CatLaboratorioFacade) this.getFacade();
            this.isTbInventarioVacunasCollectionEmpty = ejbFacade.isTbInventarioVacunasCollectionEmpty(selected);
        } else {
            this.isTbInventarioVacunasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TbInventarioVacunas
     * entities that are retrieved from CatLaboratorio and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TbInventarioVacunas page
     */
    public String navigateTbInventarioVacunasCollection() {
        CatLaboratorio selected = this.getSelected();
        if (selected != null) {
            CatLaboratorioFacade ejbFacade = (CatLaboratorioFacade) this.getFacade();
            Collection<TbInventarioVacunas> selectedTbInventarioVacunasCollection = ejbFacade.findTbInventarioVacunasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TbInventarioVacunas_items", selectedTbInventarioVacunasCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/tbInventarioVacunas/index";
    }

}
