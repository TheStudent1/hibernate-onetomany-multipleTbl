package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Lesson;
import com.app.model.Monitor;
import com.hibernate.utils.HibernateUtils;

public class MonitorIDAOImpl implements IDAO<Monitor> {

	Logger log = Logger.getLogger(MonitorIDAOImpl.class);

	@Override
	public boolean save(Monitor ent) {
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
	public boolean update(Monitor ent) {
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
	public Monitor getOne(Long id) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETONE: begin traitement ...!");

			Monitor mon = new Monitor();
			mon = s.get(mon.getClass(), id);
			getLessons(mon);
			t.commit();

			log.info("GETONE: Successfully ...!");
			return mon;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	private static void getLessons(Monitor mon) {
		List<Lesson> lsns = new ArrayList<Lesson>();
		lsns = mon.getLessons();
		lsns.size();
	}

	@Override
	public boolean delete(Monitor ent) {
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
	public List<Monitor> getAll() {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Monitor> monts = new ArrayList<Monitor>();
			monts = s.getNamedQuery("getAllMonitors").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return monts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	public List<Monitor> getAll(String mc) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Monitor> monts = new ArrayList<Monitor>();
			monts = s.getNamedQuery("getMonitorsMC").setParameter("name", "%" + mc + "%").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return monts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

}
