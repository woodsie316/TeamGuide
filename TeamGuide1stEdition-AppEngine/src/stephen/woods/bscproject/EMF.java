package stephen.woods.bscproject;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
*
* This class was automatically generated using GAE plugin
*
*/

public final class EMF {
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}