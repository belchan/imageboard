//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.belchan.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class BaseDAODeprecated<T> {
    SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseDAODeprecated() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object save(Object entity) {
        this.sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public Object saveOrUpdate(Object entity) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public boolean delete(Object object) {
        try {
            this.sessionFactory.getCurrentSession().delete(object);
            return true;
        } catch (Exception var3) {
            this.logger.error(var3.getLocalizedMessage());
            return false;
        }
    }

    public <T> T getEntity(Class<T> entityClass, int id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public <T> List<T> getListEntity(Class<T> entityClass, Object... objects) {
        Criterion[] criterions = new Criterion[objects.length / 2 + 1];

        try {
            for(int e = 0; e < objects.length; e += 2) {
                String field = String.valueOf(objects[e]);
                Object value = objects[e + 1];
                criterions[e / 2] = Restrictions.eq(field, value);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return new ArrayList();
        }

        return this.getListEntity(entityClass, criterions);
    }

    public <T> List<T> getListEntity(Class<T> entityClass, Criterion... criterions) {
        try {
            Criteria e = this.getCriteria(entityClass);
            Criterion[] listEntity = criterions;
            int var5 = criterions.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Criterion criterion = listEntity[var6];
                if(criterion != null) {
                    e.add(criterion);
                }
            }

            return e.list();
        } catch (Exception var8) {
            var8.printStackTrace();
            return new ArrayList();
        }
    }

    public <T> Criteria getCriteria(Class<T> entityClass) {
        return this.sessionFactory.getCurrentSession().createCriteria(entityClass);
    }

    public SQLQuery createSQLQuery(String queryString) {
        return this.sessionFactory.getCurrentSession().createSQLQuery(queryString);
    }

    public Query createQuery(String queryString) {
        return this.sessionFactory.getCurrentSession().createQuery(queryString);
    }

    public <T> List<T> getEntitys(Class<T> entityClass) {
        Criteria criteria = this.getCriteria(entityClass);
        return criteria.list();
    }

    public <T> List<T> getEntitys(Class<T> entityClass, Criterion... criterions) {
        Criteria criteria = this.getCriteria(entityClass);
        Criterion[] var4 = criterions;
        int var5 = criterions.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Criterion criterion = var4[var6];
            criteria.add(criterion);
        }

        return criteria.list();
    }

    public <T> T getEntity(Class<T> entityClass, Criterion...criterions) {
        List<T> listEntities = getEntitys(entityClass, criterions);
        switch (listEntities.size()) {
            case 0:
                return null;
            case 1:
                return listEntities.get(0);
            default: {
                for (Criterion c : criterions) {
                    logger.warn(c.toString());
                }
                for (T t : listEntities) {
                    logger.warn(t.toString());
                }
                return listEntities.get(0);
            }
        }
    }


    public <T> T getEntity(List<T> listEntities) {
        switch(listEntities.size()) {
            case 0:
                return null;
            case 1:
                return listEntities.get(0);
            default:
                for (Object t : listEntities) {
                    this.logger.warn(t.toString());
                }
                return listEntities.get(0);
        }
    }

    public <T> T getOneValue(List<T> listEntity) {
        switch(listEntity.size()) {
            case 0:
                return null;
            case 1:
                return listEntity.get(0);
            default:
                this.logger.warn("SIZE > 1" + Arrays.toString(listEntity.toArray()));
                return listEntity.get(0);
        }
    }
}
