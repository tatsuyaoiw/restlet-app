package com.tatsuyaoiw.restlet.persistence.memory;

import com.tatsuyaoiw.restlet.persistence.Persistence;
import com.tatsuyaoiw.restlet.persistence.entity.Trick;
import org.restlet.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryTrickPersistence extends MemoryPersistenceService implements Persistence<Trick> {

	// Singleton pattern
	private static MemoryTrickPersistence trickPersistence = new MemoryTrickPersistence();

	public static synchronized MemoryTrickPersistence getTrickPersistence() {
		return trickPersistence;
	}

	private MemoryTrickPersistence() {}

	@Override
	public Trick add(Trick toAdd) {
		Context.getCurrentLogger().finer("Method add() of MemoryTrickPersistence called.");

		String id = UUID.randomUUID().toString();
		toAdd.setId(id);
		getTricks().put(id, toAdd);

		Context.getCurrentLogger().finer("Method add() of MemoryTrickPersistence finished.");

		return toAdd;
	}

	@Override
	public Boolean remove(String id) {
		Context.getCurrentLogger().finer("Method remove() of MemoryTrickPersistence called");

		Trick trick = getTricks().remove(id);

		Context.getCurrentLogger().finer("Method remove() of MemoryTrickPersistence finished");

		return trick != null;
	}

	@Override
	public List<Trick> findAll() {
		Context.getCurrentLogger().finer("Method findAll() of MemoryTrickPersistence called");

		List<Trick> tricks = new ArrayList<Trick>(getTricks().values());

		Context.getCurrentLogger().finer("Method findAll() of MemoryTrickPersistence called");

		return tricks;
	}

	@Override
	public Trick findById(String id) {
		Context.getCurrentLogger().finer("Method findById() of MemoryTrickPersistence called");

		Trick trick = getTricks().get(id);

		Context.getCurrentLogger().finer("Method findById() of MemoryTrickPersistence finished");

		return trick;
	}

	@Override
	public Trick update(String id, Trick toUpdate) {
		Context.getCurrentLogger().finer("Method update() of MemoryTrickPersistence called");

		toUpdate.setId(id);
		getTricks().put(id, toUpdate);

		Context.getCurrentLogger().finer("Method update() of MemoryTrickPersistence finished");

		return toUpdate;
	}

}
