package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Lesson;
import com.app.model.Monitor;
import com.app.model.Vehicle;
import com.hibernate.utils.HibernateUtils;

public class VehicleIDAOImpl implements IDAO<Vehicle> {

	Logger log = Logger.getLogger(VehicleIDAOImpl.class);

	@Override
	public boolean save(Vehicle ent) {
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
	public boolean update(Vehicle ent) {
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
	public Vehicle getOne(Long id) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETONE: begin traitement ...!");

			Vehicle st = new Vehicle();
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

	private static void getLessons(Vehicle mon) {
		List<Lesson> lsns = new ArrayList<Lesson>();
		lsns = mon.getLessons();
		lsns.size();
	}

	@Override
	public boolean delete(Vehicle ent) {
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
	public List<Vehicle> getAll() {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Vehicle> vcls = new ArrayList<Vehicle>();
			vcls = s.getNamedQuery("getAllVehicles").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return vcls;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}

	public List<Vehicle> getAll(String mc) {
		Session s = null;
		Transaction t = null;
		try {
			s = HibernateUtils.getSessionFactory().getCurrentSession();
			t = s.beginTransaction();
			log.info("GETALL: begin traitement ...!");

			List<Vehicle> vcls = new ArrayList<Vehicle>();
			vcls = s.getNamedQuery("getVehiclesMC").setParameter("name", "%" + mc + "%").getResultList();
			t.commit();

			log.info("GETONE: Successfully ...!");
			return vcls;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}
}
