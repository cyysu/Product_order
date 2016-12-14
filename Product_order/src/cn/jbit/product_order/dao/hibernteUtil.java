package cn.jbit.product_order.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernteUtil {// ��ʼ��һ��ThreadLocal����
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal sessionTL = new ThreadLocal(); // 1
	private static Configuration configuration;
//	private static AnnotationConfiguration annotationConfiguration;
	private final static SessionFactory sessionFactory;
	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
//			annotationConfiguration = new AnnotationConfiguration().configure();
//			sessionFactory = annotationConfiguration.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	@SuppressWarnings("unchecked")
	public static Session currentSession() {
		Session session = (Session) sessionTL.get(); // 2
		// ���sessionΪnull�����һ���µ�session
		if (session == null) { // 3
			//����һ�����ݿ����Ӷ���session��
			session = sessionFactory.openSession(); // 4
			// ��������ݿ�����session��ThreadLocal�С�
			sessionTL.set(session); // 5
		}
		//�����ǰ�߳��Ѿ����ʹ����ݿ��ˣ�
		//���sessionTL��get()�Ϳ��Ի�ȡ���߳��ϴλ�ȡ�������ݿ����Ӷ���
		return session; // 6
	}
	@SuppressWarnings("unchecked")
	public static void closeSession(){
		Session session = (Session) sessionTL.get(); // 2
		sessionTL.set(null);
		if(session!=null)
			session.close();
	}}
