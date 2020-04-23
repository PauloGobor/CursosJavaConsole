package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Interfaces.MatriculaInterface;
import Model.Matricula;

public class MatriculaDAO extends GenericDAO implements MatriculaInterface {
	Matricula matricula = new Matricula();

	@Override
	public void salvar(Matricula matricula) {
		EntityManager em = getEntityManager();
		try {
			if (matricula.getId() == null) {
				em.getTransaction().begin();
				em.persist(matricula);
				em.getTransaction().commit();
			} else {
				em.getTransaction().begin();
				em.merge(matricula);
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
	public List<Matricula> listarMatriculas() {
		EntityManager em = getEntityManager();
		Query q = em.createQuery("SELECT object(matricula)" + " FROM Matricula as matricula");
		List<Matricula> matriculas = q.getResultList();
		return matriculas;
	}

	@Override
	public List<Matricula> listarMatriculasPorCurso(Long cod, String status) {
		final String verif = "TODOS";
		EntityManager em = getEntityManager();
		if (status.equals(verif)) {
			Query q = em.createQuery(
					"SELECT object(matricula)" + " FROM Matricula as matricula" + " WHERE curso.id = :cod");
			q.setParameter("cod", cod);
			List<Matricula> matriculas = q.getResultList();
			return matriculas;
		} else {
			Query q = em.createQuery("SELECT object(matricula)" + " FROM Matricula as matricula"
					+ " WHERE curso.id = :cod " + " AND status = :status");
			q.setParameter("cod", cod);
			q.setParameter("status", status);
			List<Matricula> matriculas = q.getResultList();
			return matriculas;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Matricula validaUsuarioMatricula(Long usrcod, Long crscod) {
		EntityManager em = getEntityManager();
		try {
		Query q = em.createQuery("SELECT object(matricula)" + " FROM Matricula as matricula"
				+ " WHERE curso.id = :crscod " + " AND usuario.id = :usrcod");
		q.setParameter("usrcod", usrcod);
		q.setParameter("crscod", crscod);
		matricula = (Matricula) q.getSingleResult();

		} catch (Exception nre) {
			matricula = null;

		} finally {
			em.close();
		return matricula;
		}
	}

	// mostrar para o aluno os cursos que ele esta matriculado
	@Override
	public List<Matricula> listarMatriculasPorAluno(Long cod, String status) {
		final String verif = "TODOS";
		EntityManager em = getEntityManager();
		if (status.equals(verif)) {

			Query q = em.createQuery(
					"SELECT object(matricula)" + " FROM Matricula as matricula " + " WHERE usuario.id = :cod ");
			q.setParameter("cod", cod);
			List<Matricula> matriculas = q.getResultList();
			return matriculas;
		} else {
			Query q = em.createQuery("SELECT object(matricula)" + " FROM Matricula as matricula"
					+ " WHERE usuario.id = :cod " + " AND status = :status");
			q.setParameter("cod", cod);
			q.setParameter("status", status);
			List<Matricula> matriculas = q.getResultList();
			return matriculas;
		}

	}
}
