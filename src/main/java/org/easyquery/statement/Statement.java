package org.easyquery.statement;

import org.easyquery.query.Query;
import org.easyquery.query.SqlQuery;
import org.hibernate.QueryException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by nacho on 16/05/15.
 */
abstract class Statement<T> {

    private Query<T> query;

    protected Statement(Query<T> query) {
        this.query = query;
    }

    protected Statement(Session session, Class<T> clazz) {
        this.query = new SqlQuery<T>(session, clazz);
    }

    protected SelectStatement<T> select(Class<T> clazz, String[] params) {
        this.query.select(params);
        return new SelectStatement(this.query);
    }

    protected SelectStatement<T> selectDistinct(Class<T> clazz, String[] params) {
        this.query.selectDistinct(params);
        return new SelectStatement(this.query);
    }

    protected FromStatement<T> from(Class clazz, String alias) {
        this.query.from(clazz, alias);
        return new FromStatement(this.query);
    }

    protected FromStatement<Object[]> innerJoin(String expr, String alias) {
        this.query.innerJoin(expr, alias);
        return new FromStatement(this.query.changeClass(Object[].class));
    }

    protected Condition<WhereStatement<T>, T> where(String expr) {
        this.query.where(expr);
        WhereStatement<T> where = new WhereStatement(this.query);
        return new Condition(where);
    }

    protected <Q extends Statement<T>> Condition<Q, T> and(String expr) {
        this.query.and(expr);
        return new Condition((Q) this);
    }

    protected GroupByStatement<T> groupBy(String[] params) {
        this.query.groupBy(params);
        return new GroupByStatement(this.query);
    }

    protected Condition<HavingStatement<T>, T> having(String expr) {
        this.query.having(expr);
        HavingStatement<T> having = new HavingStatement(this.query);
        return new Condition(having);
    }

    protected OrderByStatement<T> orderBy(String[] params) {
        this.query.orderBy(params);
        return new OrderByStatement(this.query);
    }

    protected FinalStatement<T> asc() {
        this.query.asc();
        return new FinalStatement(this.query);
    }

    protected FinalStatement<T> desc() {
        this.query.desc();
        return new FinalStatement(this.query);
    }

    protected <Q extends Statement<T>> Q equal(Object param) {
        this.query.equal(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q like(Object param) {
        this.query.like(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q greater(Object param) {
        this.query.greater(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q greaterOrEqual(Object param) {
        this.query.greaterOrEqual(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q less(Object param) {
        this.query.less(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q lessOrEqual(Object param) {
        this.query.lessOrEqual(param);
        return (Q) this;
    }

    protected <Q extends Statement<T>> Q between(Object param1, Object param2) {
        this.query.between(param1, param2);
        return (Q) this;
    }

    @Override
    public String toString() {
        return this.query.toString();
    }

    public List<T> list() {
        try {
            return this.query.list();
        } catch (Exception e) {
            throw new QueryException(
                    "A exception was thrown running the following query: "
                            + this.query.toString(), e);
        }
    }

    public T uniqueResult() {
        try {
            return this.query.uniqueResult();
        } catch (Exception e) {
            throw new QueryException(
                    "A exception was thrown running the following query: "
                            + this.query.toString(), e);
        }
    }

}
