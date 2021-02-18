package controller;

import modelitos.CatPais;
import modelitos.CatLaboratorio;
import java.util.Collection;
import facade.CatPaisFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "catPaisController")
@ViewScoped
public class CatPaisController extends AbstractController<CatPais> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isCatLaboratorioCollectionEmpty;

    public CatPaisController() {
        // Inform the Abstract parent controller of the concrete CatPais Entity
        super(CatPais.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCatLaboratorioCollectionEmpty();
    }

    public boolean getIsCatLaboratorioCollectionEmpty() {
        return this.isCatLaboratorioCollectionEmpty;
    }

    private void setIsCatLaboratorioCollectionEmpty() {
        CatPais selected = this.getSelected();
        if (selected != null) {
            CatPaisFacade ejbFacade = (CatPaisFacade) this.getFacade();
            this.isCatLaboratorioCollectionEmpty = ejbFacade.isCatLaboratorioCollectionEmpty(selected);
        } else {
            this.isCatLaboratorioCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CatLaboratorio entities
     * that are retrieved from CatPais and returns the navigation outcome.
     *
     * @return navigation outcome for CatLaboratorio page
     */
    public String navigateCatLaboratorioCollection() {
        CatPais selected = this.getSelected();
        if (selected != null) {
            CatPaisFacade ejbFacade = (CatPaisFacade) this.getFacade();
            Collection<CatLaboratorio> selectedCatLaboratorioCollection = ejbFacade.findCatLaboratorioCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CatLaboratorio_items", selectedCatLaboratorioCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/catLaboratorio/index";
    }

}
