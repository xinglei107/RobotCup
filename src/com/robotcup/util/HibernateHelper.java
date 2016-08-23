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

	// �ṩһ��ͳһ�Ĳ�ѯ����
	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql) {
		List list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		list = query.list();
		return list;
	}

	// ��ҳ��ѯ
	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql, String parameters[], int pageNum,
			int pageSize) {
		List list = null;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);// ��ʼλ��
		query.setMaxResults(pageSize); // ��ȡ����
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
		// ���ж��Ƿ��в���Ҫ��
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setString(i, parameters[i]);
			}
		}
		list = query.list();
		return list;
	}

	// ���桢�������
	public void save(Object obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(obj);
	}

	// ���¶���
	public void updateQuery(Object obj) {
		sessionFactory.getCurrentSession().merge(obj);
		// ����merge��������ʱobjʵ��״̬��û�б��־û�

		// �������ݿ��еļ�¼��������

		// merge������update�����Ĳ���������ͬ���Ĳ���update�����ᱨ��

		// ԭ������update����ʹ��ʵ��״̬��Ϊ�˳־û�״̬����Session�в����������־û�ʵ����ͬ���ĳ־û���ʶ
		// sessionFactory.getCurrentSession().update(obj);
	}

	// �޲�������
	public void updateQuery(String hql) {
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		// ��֤����������Ч
		sessionFactory.getCurrentSession().flush();
	}

	// ���θ���
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

	// ����ɾ��
	public void deleteQuery(Object o) {
		sessionFactory.getCurrentSession().delete(o);
	}
}
