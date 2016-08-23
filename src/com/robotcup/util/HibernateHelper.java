package com.robotcup.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateHelper {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 提供一个统一的查询方法
	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql) {
		List list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		list = query.list();
		return list;
	}

	// 分页查询
	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql, String parameters[], int pageNum,
			int pageSize) {
		List list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);// 起始位置
		query.setMaxResults(pageSize); // 获取几行
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		list = query.list();
		return list;
	}

	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql, String[] parameters) {
		List list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// 先判断是否有参数要绑定
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		list = query.list();
		return list;
	}

	// 保存、添加数据
	public void save(Object obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(obj);
	}

	// 更新对象
	public void updateQuery(Object obj) {
		sessionFactory.getCurrentSession().merge(obj);
		// 调用merge方法，此时obj实体状态并没有被持久化

		// 但是数据库中的记录被更新了

		// merge方法与update方法的差别在于针对同样的操作update方法会报错

		// 原因在于update方法使得实体状态成为了持久化状态，而Session中不允许两个持久化实体有同样的持久化标识
		// sessionFactory.getCurrentSession().update(obj);
	}

	// 无参数更新
	public void updateQuery(String hql) {
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		// 保证更新立即生效
		sessionFactory.getCurrentSession().flush();
	}

	// 带参更新
	public void updateQuery(String hql, String[] parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		query.executeUpdate();
		sessionFactory.getCurrentSession().flush();
	}

	// 级联删除
	public void deleteQuery(Object o) {
		sessionFactory.getCurrentSession().delete(o);
	}
}
