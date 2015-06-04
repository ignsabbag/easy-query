package org.easyquery.query;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nacho on 17/05/15.
 */
public class SqlQuery<T> extends Query<T> {

    private StringBuffer sql;
    private List<Object> params;

    public SqlQuery(Session session, Class<T> clazz) {
        super(session, clazz);
        this.sql = new StringBuffer();
        this.params = new ArrayList<Object>();
    }

    public  void alias(String expr) {
        this.append(" AS ").append(expr);
    }

    @Override
    public void select(String[] params) {
        this.append("SELECT ");
        for(int i = 0; i < params.length; i++) {
            if(i > 0) {
                this.append(", ");
            }
            this.append(params[i]);
        }
    }

    @Override
    public void selectDistinct(String[] params) {
        this.append("SELECT DISTINCT");
        for(int i = 0; i < params.length; i++) {
            if(i > 0) {
                this.append(", ");
            }
            this.append(params[i]);
        }
    }

    @Override
    public void from(Class<T> clazz, String alias) {
        this.append(" FROM ").append(clazz.getName());
        if( alias != null )
            this.alias(alias);
    }

    @Override
    public void innerJoin(String expr, String alias) {
        this.append(" INNER JOIN ").append(expr);
        if( alias != null )
            this.alias(alias);
    }

    @Override
    public void where(String expr) {
        this.append(" WHERE ").append(expr);
    }

    @Override
    public void and(String expr) {
        this.append(" AND ").append(expr);
    }

    @Override
    public void groupBy(String[] params) {
        this.append(" GROUP BY ");
        for(int i = 0; i < params.length; i++) {
            if(i > 0) {
                this.append(", ");
            }
            this.append(params[i]);
        }
    }

    @Override
    public void having(String expr) {
        this.append(" HAVING ").append(expr);
    }

    @Override
    public void orderBy(String[] params) {
        this.append(" ORDER BY ");
        for(int i = 0; i < params.length; i++) {
            if(i > 0) {
                this.append(", ");
            }
            this.append(params[i]);
        }
    }

    @Override
    public void asc() {
        this.append(" ASC");
    }

    @Override
    public void desc() {
        this.append(" DESC");
    }

    @Override
    public void equal(Object param) {
        this.add(" = ?", param);
    }

    @Override
    public void like(Object param) {
        this.add(" LIKE ?", param);
    }

    @Override
    public void greater(Object param) {
        this.add(" > ?", param);
    }

    @Override
    public void greaterOrEqual(Object param) {
        this.add(" >= ?", param);
    }

    @Override
    public void less(Object param) {
        this.add(" < ?", param);
    }

    @Override
    public void lessOrEqual(Object param) {
        this.add(" <= ?", param);
    }

    @Override
    public void between(Object param1, Object param2) {
        this.add(" BETWEEN ? AND ?", param1, param2);
    }

    @Override
    public org.hibernate.Query getQuery() {
        org.hibernate.Query query = session.createQuery(sql.toString());
        int i = 0;
        Iterator<Object> iterator = params.iterator();
        while( iterator.hasNext() ) {
            query.setParameter(i++, iterator.next());
        }
        return query;
    }

    @Override
    public String toString() {
        String str = sql.toString();
        for(Object param : params) {
            str = str.replaceFirst("\\?", "'" + param.toString() + "'");
        }
        return str;
    }

    protected SqlQuery<T> add(String expr, Object ... params) {
        append(expr);
        for( Object obj : params ) {
            addParam(obj);
        }
        return this;
    }

    protected void addParam(Object obj) {
        params.add(obj);
    }

    protected StringBuffer append(String expr) {
        return sql.append(expr);
    }
}
