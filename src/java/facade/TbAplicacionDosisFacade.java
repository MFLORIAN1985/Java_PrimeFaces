/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelitos.TbAplicacionDosis;
import modelitos.TbAplicacionDosis_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.TbInventarioVacunas;
import modelitos.TbPersona;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class TbAplicacionDosisFacade extends AbstractFacade<TbAplicacionDosis> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAplicacionDosisFacade() {
        super(TbAplicacionDosis.class);
    }

    public boolean isIdInventarioVacunaEmpty(TbAplicacionDosis entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbAplicacionDosis> tbAplicacionDosis = cq.from(TbAplicacionDosis.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbAplicacionDosis, entity), cb.isNotNull(tbAplicacionDosis.get(TbAplicacionDosis_.idInventarioVacuna)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TbInventarioVacunas findIdInventarioVacuna(TbAplicacionDosis entity) {
        return this.getMergedEntity(entity).getIdInventarioVacuna();
    }

    public boolean isCuiEmpty(TbAplicacionDosis entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbAplicacionDosis> tbAplicacionDosis = cq.from(TbAplicacionDosis.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbAplicacionDosis, entity), cb.isNotNull(tbAplicacionDosis.get(TbAplicacionDosis_.cui)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TbPersona findCui(TbAplicacionDosis entity) {
        return this.getMergedEntity(entity).getCui();
    }
    
}
