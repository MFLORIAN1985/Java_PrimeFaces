/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelitos.CatPais;
import modelitos.CatPais_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.CatLaboratorio;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class CatPaisFacade extends AbstractFacade<CatPais> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatPaisFacade() {
        super(CatPais.class);
    }

    public boolean isCatLaboratorioCollectionEmpty(CatPais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatPais> catPais = cq.from(CatPais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catPais, entity), cb.isNotEmpty(catPais.get(CatPais_.catLaboratorioCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CatLaboratorio> findCatLaboratorioCollection(CatPais entity) {
        CatPais mergedEntity = this.getMergedEntity(entity);
        Collection<CatLaboratorio> catLaboratorioCollection = mergedEntity.getCatLaboratorioCollection();
        catLaboratorioCollection.size();
        return catLaboratorioCollection;
    }
    
}
