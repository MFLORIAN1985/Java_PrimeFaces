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
import modelitos.CatLaboratorio;
import modelitos.CatLaboratorio_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelitos.CatTipoVacuna;
import modelitos.CatPais;
import modelitos.TbInventarioVacunas;

/**
 *
 * @author MOORIS FLORIAN
 */
@Stateless
public class CatLaboratorioFacade extends AbstractFacade<CatLaboratorio> {

    @PersistenceContext(unitName = "VacunaCovid7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatLaboratorioFacade() {
        super(CatLaboratorio.class);
    }

    public boolean isCatTipoVacunaCollectionEmpty(CatLaboratorio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatLaboratorio> catLaboratorio = cq.from(CatLaboratorio.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catLaboratorio, entity), cb.isNotEmpty(catLaboratorio.get(CatLaboratorio_.catTipoVacunaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CatTipoVacuna> findCatTipoVacunaCollection(CatLaboratorio entity) {
        CatLaboratorio mergedEntity = this.getMergedEntity(entity);
        Collection<CatTipoVacuna> catTipoVacunaCollection = mergedEntity.getCatTipoVacunaCollection();
        catTipoVacunaCollection.size();
        return catTipoVacunaCollection;
    }

    public boolean isIdPaisEmpty(CatLaboratorio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatLaboratorio> catLaboratorio = cq.from(CatLaboratorio.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catLaboratorio, entity), cb.isNotNull(catLaboratorio.get(CatLaboratorio_.idPais)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CatPais findIdPais(CatLaboratorio entity) {
        return this.getMergedEntity(entity).getIdPais();
    }

    public boolean isTbInventarioVacunasCollectionEmpty(CatLaboratorio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CatLaboratorio> catLaboratorio = cq.from(CatLaboratorio.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(catLaboratorio, entity), cb.isNotEmpty(catLaboratorio.get(CatLaboratorio_.tbInventarioVacunasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TbInventarioVacunas> findTbInventarioVacunasCollection(CatLaboratorio entity) {
        CatLaboratorio mergedEntity = this.getMergedEntity(entity);
        Collection<TbInventarioVacunas> tbInventarioVacunasCollection = mergedEntity.getTbInventarioVacunasCollection();
        tbInventarioVacunasCollection.size();
        return tbInventarioVacunasCollection;
    }
    
}
