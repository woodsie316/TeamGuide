package stephen.woods.bscproject;

import stephen.woods.bscproject.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/*
*
* This class is automatically generated from Club.java
*
*/

@Api(name = "clubendpoint", namespace = @ApiNamespace(ownerDomain = "woods.stephen", ownerName = "woods.stephen", packagePath = "bscproject"))
public class ClubEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listClub")
	public CollectionResponse<Club> listClub(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Club> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Club as Club");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Club>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Club obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Club> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getClub")
	public Club getClub(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Club club = null;
		try {
			club = mgr.find(Club.class, id);
		} finally {
			mgr.close();
		}
		return club;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param club the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertClub")
	public Club insertClub(Club club) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsClub(club)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(club);
		} finally {
			mgr.close();
		}
		return club;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param club the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateClub")
	public Club updateClub(Club club) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsClub(club)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(club);
		} finally {
			mgr.close();
		}
		return club;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	@ApiMethod(name = "removeClub")
	public Club removeClub(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Club club = null;
		try {
			club = mgr.find(Club.class, id);
			mgr.remove(club);
		} finally {
			mgr.close();
		}
		return club;
	}

	private boolean containsClub(Club club) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Club item = mgr.find(Club.class, club.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
