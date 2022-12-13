package spring.training.trdmthdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import spring.training.trdmthdemo.model.MyDesk;
@Repository
public class MyDeskRepo {
	@PersistenceContext
	protected EntityManager entityManager;

	public MyDesk getDeskDetail(long deskId) {
		return entityManager.find(MyDesk.class, deskId);
	}

	public long getDeskCount() {
		String jpql = "select count(m) from mydesk m";
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}
    
	public List<MyDesk> getAllDetails() {
		String jpql = "select m from mydesk m";
		TypedQuery<MyDesk> query = entityManager.createQuery(jpql, MyDesk.class);
	    return query.getResultList();
	}
    
	@Transactional
	public void insertNewDeatilOfMydesk(MyDesk my) {
		entityManager.persist(my);
	}
	
	@Transactional
	public void updateOldDeatilsOfMydesk(long deskId, String assetsName) {
		MyDesk myDes = entityManager.find(MyDesk.class, deskId);
		myDes.setAssetsName((myDes.getAssetsName()+assetsName));
	}

	@Transactional
	public void deleteEntireDeskProperties(long deskId) {
		MyDesk myDes = entityManager.find(MyDesk.class, deskId);
		entityManager.remove(myDes);
	}
}
