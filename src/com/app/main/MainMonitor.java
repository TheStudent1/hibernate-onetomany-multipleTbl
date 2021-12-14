package com.app.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.IDAO;
import com.app.dao.MonitorIDAOImpl;
import com.app.model.Monitor;
import com.hibernate.utils.HibernateUtils;

public class MainMonitor {

	public static void main(String[] args) {

		IDAO service = new MonitorIDAOImpl();

		Monitor mon1 = new Monitor(3L, "MONITOR3Updated", "male", LocalDate.parse("1999-04-24"));

		// Save:
		// service.save(mon1);

		// Update:
		// service.update(mon1);

		// GETONE:
		mon1 = (Monitor) service.getOne(1L);
		System.out.println(mon1.toString());
		System.out.println(mon1.getLessons().size());

		// Delete:
		// service.delete(mon1);

		// getAll(MC)
//		List<Monitor> monts = new ArrayList<Monitor>();
//		monts = service.getAll("A");
//		for (Monitor m : monts) {
//			System.out.println(m.toString());
//		}
	}

}
