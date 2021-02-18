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
import modelitos.TbInventarioVacunas;
import modelitos.TbInventarioVacunas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.CatTipoVacuna;
import modelitos.CatLaboratorio;
import modelitos.TbAplicacionDosis;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class TbInventarioVacunasFacade extends AbstractFacade<TbInventarioVacunas> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbInventarioVacunasFacade() {
        super(TbInventarioVacunas.class);
    }

    public boolean isIdTipoVacunaEmpty(TbInventarioVacunas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbInventarioVacunas> tbInventarioVacunas = cq.from(TbInventarioVacunas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbInventarioVacunas, entity), cb.isNotNull(tbInventarioVacunas.get(TbInventarioVacunas_.idTipoVacuna)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CatTipoVacuna findIdTipoVacuna(TbInventarioVacunas entity) {
        return this.getMergedEntity(entity).getIdTipoVacuna();
    }

    public boolean isIdLaboratorioEmpty(TbInventarioVacunas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbInventarioVacunas> tbInventarioVacunas = cq.from(TbInventarioVacunas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbInventarioVacunas, entity), cb.isNotNull(tbInventarioVacunas.get(TbInventarioVacunas_.idLaboratorio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CatLaboratorio findIdLaboratorio(TbInventarioVacunas entity) {
        return this.getMergedEntity(entity).getIdLaboratorio();
    }

    public boolean isTbAplicacionDosisCollectionEmpty(TbInventarioVacunas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TbInventarioVacunas> tbInventarioVacunas = cq.from(TbInventarioVacunas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tbInventarioVacunas, entity), cb.isNotEmpty(tbInventarioVacunas.get(TbInventarioVacunas_.tbAplicacionDosisCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TbAplicacionDosis> findTbAplicacionDosisCollection(TbInventarioVacunas entity) {
        TbInventarioVacunas mergedEntity = this.getMergedEntity(entity);
        Collection<TbAplicacionDosis> tbAplicacionDosisCollection = mergedEntity.getTbAplicacionDosisCollection();
        tbAplicacionDosisCollection.size();
        return tbAplicacionDosisCollection;
    }
    
}
