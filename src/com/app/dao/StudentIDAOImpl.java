package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Lesson;
import com.app.model.Monitor;
import com.app.model.Student;
import com.hibernate.utils.HibernateUtils;

public class StudentIDAOImpl implements IDAO<Student> {

	Logger log = Logger.getLogger(StudentIDAOImpl.class);

	@Override
	public boolean save(Student ent) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("SAVE: begin traitement ...!");

			s.save(ent);
			t.commit();

			log.info("SAVE: Successfully ...!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public boolean update(Student ent) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("UPDATE: begin traitement ...!");

			s.merge(ent);
			t.commit();

			log.info("UPDATE: Successfully ...!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public Student getOne(Long id) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETONE: begin traitement ...!");

			Student st = new Student();
			st = s.get(st.getClass(), id);
			getLessons(st);
			t.commit();

			log.info("GETONE: Successfully ...!");
			return st;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	private static void getLessons(Student mon) {
		List<Lesson> lsns = new ArrayList<Lesson>();
		lsns = mon.getLessons();
		lsns.size();
	}

	@Override
	public boolean delete(Student ent) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("DELETE: begin traitement ...!");

			s.delete(ent);
			t.commit();

			log.info("DELETE: Successfully ...!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return false;
	}

	@Override
	public List<Student> getAll() {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Student> stds = new ArrayList<Student>();
			stds = s.getNamedQuery("getAllStudents").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return stds;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	public List<Student> getAll(String mc) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Student> stds = new ArrayList<Student>();
			stds = s.getNamedQuery("getStudentsMC").setParameter("name", "%" + mc + "%").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return stds;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}
}
