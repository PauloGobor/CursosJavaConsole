package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import Interfaces.IDAO;
import Model.Professor;

public class ProfessorDAO extends GenericDAO implements IDAO<Professor> {

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
	public List<Professor> listar() {
		EntityManager em = getEntityManager();
		Query q;

		q = em.createQuery("SELECT object(professor) FROM Professor as professor");
		List<Professor> professores = q.getResultList();
		return professores;
	}

	@Override
	public Professor buscarPorId(Long cod) {
		if (cod != null) {
			professor = getEntityManager().find(Professor.class, cod);
		}
		return professor;
	}

	@SuppressWarnings("finally")
	@Override
	public Professor buscarPorCpf(String cpf) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("SELECT object(professor)" + " FROM Professor as professor" + " WHERE cpf=:cpf ");
			q.setParameter("cpf", cpf);

			professor = (Professor) q.getSingleResult();
		} catch (Exception nre) {
			professor = null;

		} finally {
			em.close();
			return professor;
		}
	}

	@Override
	public Professor buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor alterar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub

	}

}
