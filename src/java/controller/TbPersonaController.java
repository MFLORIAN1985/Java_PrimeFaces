package controller;

import modelitos.TbPersona;
import modelitos.TbAplicacionDosis;
import java.util.Collection;
import facade.TbPersonaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tbPersonaController")
@ViewScoped
public class TbPersonaController extends AbstractController<TbPersona> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTbAplicacionDosisCollectionEmpty;

    public TbPersonaController() {
        // Inform the Abstract parent controller of the concrete TbPersona Entity
        super(TbPersona.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTbAplicacionDosisCollectionEmpty();
    }

    public boolean getIsTbAplicacionDosisCollectionEmpty() {
        return this.isTbAplicacionDosisCollectionEmpty;
    }

    private void setIsTbAplicacionDosisCollectionEmpty() {
        TbPersona selected = this.getSelected();
        if (selected != null) {
            TbPersonaFacade ejbFacade = (TbPersonaFacade) this.getFacade();
            this.isTbAplicacionDosisCollectionEmpty = ejbFacade.isTbAplicacionDosisCollectionEmpty(selected);
        } else {
            this.isTbAplicacionDosisCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TbAplicacionDosis
     * entities that are retrieved from TbPersona and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TbAplicacionDosis page
     */
    public String navigateTbAplicacionDosisCollection() {
        TbPersona selected = this.getSelected();
        if (selected != null) {
            TbPersonaFacade ejbFacade = (TbPersonaFacade) this.getFacade();
            Collection<TbAplicacionDosis> selectedTbAplicacionDosisCollection = ejbFacade.findTbAplicacionDosisCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TbAplicacionDosis_items", selectedTbAplicacionDosisCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/tbAplicacionDosis/index";
    }

}
