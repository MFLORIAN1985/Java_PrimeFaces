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
import modelitos.TbPersona;
import modelitos.TbPersona_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.TbAplicacionDosis;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class TbPersonaFacade extends AbstractFacade<TbPersona> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbPersonaFacade() {
        super(TbPersona.class);
    }

    public boolean isTbAplicacionDosisCollectionEmpty(TbPersona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbPersona> tbPersona = cq.from(TbPersona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbPersona, entity), cb.isNotEmpty(tbPersona.get(TbPersona_.tbAplicacionDosisCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TbAplicacionDosis> findTbAplicacionDosisCollection(TbPersona entity) {
        TbPersona mergedEntity = this.getMergedEntity(entity);
        Collection<TbAplicacionDosis> tbAplicacionDosisCollection = mergedEntity.getTbAplicacionDosisCollection();
        tbAplicacionDosisCollection.size();
        return tbAplicacionDosisCollection;
    }
    
}
