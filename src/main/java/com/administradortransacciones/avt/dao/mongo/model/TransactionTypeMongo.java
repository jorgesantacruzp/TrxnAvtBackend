package com.administradortransacciones.avt.dao.mongo.model;

public class TransactionTypeMongo {

	private String name;
	private String dataStructure;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDataStructure() {
		return dataStructure;
	}

	public void setDataStructure(final String dataStructure) {
		this.dataStructure = dataStructure;
	}

}
