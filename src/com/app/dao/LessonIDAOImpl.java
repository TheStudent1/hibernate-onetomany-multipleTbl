package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Lesson;
import com.app.model.Vehicle;
import com.hibernate.utils.HibernateUtils;

public class LessonIDAOImpl implements IDAO<Lesson> {

	Logger log = Logger.getLogger(LessonIDAOImpl.class);

	@Override
	public boolean save(Lesson ent) {
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
	public boolean update(Lesson ent) {
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
	public Lesson getOne(Long id) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETONE: begin traitement ...!");

			Lesson ls = new Lesson();
			ls = s.get(ls.getClass(), id);
			t.commit();

			log.info("GETONE: Successfully ...!");
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	@Override
	public boolean delete(Lesson ent) {
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
	public List<Lesson> getAll() {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Lesson> lsns = new ArrayList<Lesson>();
			lsns = s.getNamedQuery("getAllLessons").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return lsns;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}
}
