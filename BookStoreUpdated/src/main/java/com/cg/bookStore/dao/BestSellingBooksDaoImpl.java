package com.cg.bookStore.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
 
import com.cg.bookStore.entity.BookInformation;
@Repository
public class BestSellingBooksDaoImpl implements BestSellingBooksDao {
	

	@PersistenceContext
	private EntityManager entityManager;
	

	
	@Override
	public List<BookInformation> getBestSellingBooks() {
		String jpql = "from BookInformation order by copies_sold desc";
		TypedQuery<BookInformation> query = entityManager.createQuery(jpql, BookInformation.class);
		query.setMaxResults(1);
		return query.getResultList();
	}

}
