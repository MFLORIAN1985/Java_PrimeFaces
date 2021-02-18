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
import modelitos.CatTipoVacuna;
import modelitos.CatTipoVacuna_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.CatLaboratorio;
import modelitos.TbInventarioVacunas;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class CatTipoVacunaFacade extends AbstractFacade<CatTipoVacuna> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatTipoVacunaFacade() {
        super(CatTipoVacuna.class);
    }

    public boolean isIdLaboratorioEmpty(CatTipoVacuna entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatTipoVacuna> catTipoVacuna = cq.from(CatTipoVacuna.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catTipoVacuna, entity), cb.isNotNull(catTipoVacuna.get(CatTipoVacuna_.idLaboratorio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CatLaboratorio findIdLaboratorio(CatTipoVacuna entity) {
        return this.getMergedEntity(entity).getIdLaboratorio();
    }

    public boolean isTbInventarioVacunasCollectionEmpty(CatTipoVacuna entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatTipoVacuna> catTipoVacuna = cq.from(CatTipoVacuna.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catTipoVacuna, entity), cb.isNotEmpty(catTipoVacuna.get(CatTipoVacuna_.tbInventarioVacunasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TbInventarioVacunas> findTbInventarioVacunasCollection(CatTipoVacuna entity) {
        CatTipoVacuna mergedEntity = this.getMergedEntity(entity);
        Collection<TbInventarioVacunas> tbInventarioVacunasCollection = mergedEntity.getTbInventarioVacunasCollection();
        tbInventarioVacunasCollection.size();
        return tbInventarioVacunasCollection;
    }
    
}
