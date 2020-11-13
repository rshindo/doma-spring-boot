/*
 * Copyright (C) 2004-2016 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.boot;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcException;
import org.seasar.doma.jdbc.NoResultException;
import org.seasar.doma.jdbc.NonSingleColumnException;
import org.seasar.doma.jdbc.NonUniqueResultException;
import org.seasar.doma.jdbc.OptimisticLockException;
import org.seasar.doma.jdbc.ResultMappingException;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.seasar.doma.jdbc.UniqueConstraintException;
import org.seasar.doma.jdbc.UnknownColumnException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.support.SQLExceptionTranslator;

/**
 * Converts Doma's {@link JdbcException} into Spring's {@link DataAccessException}.
 * @author Toshiaki Maki
 * @author Kazuki Shimizu
 */
public class DomaPersistenceExceptionTranslator implements PersistenceExceptionTranslator {

	private final SQLExceptionTranslator translator;

	public DomaPersistenceExceptionTranslator(
			SQLExceptionTranslator sqlExceptionTranslator) {
		this.translator = sqlExceptionTranslator;
	}

	@Override
	public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
		if (!(ex instanceof JdbcException)) {
			// Fallback to other translators if not JdbcException
			return null;
		}

		if (ex instanceof OptimisticLockException) {
			return new OptimisticLockingFailureException(ex.getMessage(), ex);
		} else if (ex instanceof UniqueConstraintException) {
			return new DuplicateKeyException(ex.getMessage(), ex);
		} else if (ex instanceof NonUniqueResultException
				|| ex instanceof NonSingleColumnException) {
			return new IncorrectResultSizeDataAccessException(ex.getMessage(), 1, ex);
		} else if (ex instanceof NoResultException) {
			return new EmptyResultDataAccessException(ex.getMessage(), 1, ex);
		} else if (ex instanceof UnknownColumnException
				|| ex instanceof ResultMappingException) {
			return new TypeMismatchDataAccessException(ex.getMessage(), ex);
		}

		if (ex.getCause() instanceof SQLException) {
			SQLException e = (SQLException) ex.getCause();
			String sql = null;
			if (ex instanceof SqlExecutionException) {
				sql = ((SqlExecutionException) ex).getRawSql();
			}
			DataAccessException dae = translator.translate(ex.getMessage(), sql, e);
			return (dae != null ? dae : new UncategorizedSQLException("", sql, e));
		}

		return new UncategorizedDataAccessException(ex.getMessage(), ex) {
		};
	}
}
