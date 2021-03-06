package com.administradortransacciones.avt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administradortransacciones.avt.common.RepositoryEnum;
import com.administradortransacciones.avt.common.util.RepositoryUtil;
import com.administradortransacciones.avt.dao.mongo.MongoDbTransactionDaoImpl;
import com.administradortransacciones.avt.dao.mysql.MySqlTransactionDaoImpl;

@Service
@SuppressWarnings("rawtypes")
public class RepositoryContext {

	private TransactionDao<?> transactionDao;

	@Autowired
	private MySqlTransactionDaoImpl mySqlRepository;

	@Autowired
	private MongoDbTransactionDaoImpl mongoDbRepository;

	public TransactionDao getDatabaseInstance() {
		return getDatabaseInstance(RepositoryUtil.getChosenRepository());
	}

	public TransactionDao getDatabaseInstance(final String repository) {
		if (RepositoryEnum.MYSQL.name().equals(repository)) {
			transactionDao = mySqlRepository;
		} else if (RepositoryEnum.MONGODB.name().equals(repository)) {
			transactionDao = mongoDbRepository;
		}
		return transactionDao;
	}

}
