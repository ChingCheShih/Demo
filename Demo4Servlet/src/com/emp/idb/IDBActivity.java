package com.emp.idb;

public interface IDBActivity {
	final String TABLE = "activity";
	final String[] COLUMNS = {
		"date",
		"id",
		"behavior"
	};
	
	final String ADD = "ADD";
	final String DELECT = "DELETE";
	final String UPDATE = "UPDATE";
}
