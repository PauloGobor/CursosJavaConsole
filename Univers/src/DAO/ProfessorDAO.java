package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import Interfaces.ProfessorInterface;
import Model.Professor;

public class ProfessorDAO extends GenericDAO implements ProfessorInterface {

	Professor professor = new Professor();

	public void salvar(Professor professor) {
		EntityManager em = getEntityManager();
		try {
			if (professor.getId() == null) {
				em.getTransaction().begin();
				em.persist(professor);
				em.getTransaction().commit();
			} else {
				em.getTransaction().begin();
				em.merge(professor);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();

		}
	}

	@Override
	public List<Professor> listarProfessores() {
		EntityManager em = getEntityManager();
		Query q;

		q = em.createQuery("SELECT object(professor) FROM Professor as professor");
		List<Professor> professores = q.getResultList();
		return professores;
	}

	@Override
	public Professor buscarProfessorPorId(Long cod) {
		 if (cod != null) {
		      professor = getEntityManager().find(Professor.class, cod);
		    }		    
		    return professor;
	}

	@SuppressWarnings("finally")
	@Override
	public Professor buscarProfessorPorCpf(String cpf) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("SELECT object(professor)"     +
		                             " FROM Professor as professor" + 
					                 " WHERE cpf=:cpf ");
			q.setParameter("cpf", cpf);

			professor = (Professor) q.getSingleResult();
		} catch (Exception nre) {
			professor = null;

		} finally {
			em.close();
			return professor;
		}
	}

}
