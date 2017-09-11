package com.hzyc.Ebcus.mapper;

import java.util.List;

import com.hzyc.Ebcus.bean.Address;
import com.hzyc.Ebcus.bean.Book;
import com.hzyc.Ebcus.bean.Downlist;
import com.hzyc.Ebcus.bean.Message;
import com.hzyc.Ebcus.bean.Order;
import com.hzyc.Ebcus.bean.Page;
import com.hzyc.Ebcus.bean.S_Car;
import com.hzyc.Ebcus.bean.User;
import com.hzyc.Ebcus.bean.UserBook;

public interface BookManagerMapper {
	
	/**
	 * �鼮����
	 * @param meg
	 * @return
	 * @throws Exception
	 */
	//ͨ�����ֽ���ģ����ѯ
	public List<Book> queryBookByName(String meg) throws Exception;
	//������������
	public List<Book> queryBookOrderByName(Page page) throws Exception;
	//����ISSN��ѯ�鼮����ϸ����
	public Book queryInfoByISBN(String ISBN);
	//��ҳ
	public List<Book> queryBooksPage(Page page) throws Exception;
	//��ѯ�������� �鼮������
	public Page queryBooksCount(Page page) throws Exception;
	
	/**
	 * ���ﳵ����
	 * @param s_car
	 * @throws Exception
	 */
	//���ﳵ������鼮
	public void addBookToCar(S_Car s_car) throws Exception;
	//��ѯ���ﳵ
	public List<S_Car> selectBooksByUserID(int userID) throws Exception;
	//ɾ�����ﳵ��һ����
	public void deleteBookFormCar(UserBook userbook) throws Exception;
	
	/**
	 * �ջ���ַ����
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	//�����û������ջ���ַ
	public List<Address> selectAddressByUserID(int userID) throws Exception;
	//�����û����ջ���ַ
	public int addAddress(Address address) throws Exception;
	//ɾ���ջ���ַ
	public int deleteAddress(int id) throws Exception;
	//����ΪĬ�ϵ�ַ
	public void updateAddressAsOne(int id) throws Exception;
	//ȡ������ΪĬ�ϵ�ַ
	public void updateAddressAsZero(int id) throws Exception;
	//�����ջ���ַid�����ջ���ַ
	public Address selectAddressByAddressID(int id) throws Exception;
	/**
	 * ��������
	 * @param order
	 * @throws Exception
	 */
	//��Ӷ���
	public int addBooksToOrder(Order order) throws Exception;
	//��ȡ�û������ж���
	public List<Order> getAllOrder(User user) throws Exception;
	//��ѯ����
	public Order selectOrderByid(int id) throws Exception;
	//���¶�����״̬
	public int updateOrderStutas(Order order) throws Exception;
	/**
	 * ��¼����
	 */
	//��ѯ�û����Ƿ����
	public User selectUserByName(String name) throws Exception;
	//�����û�����Ϣ
	public int updateUser(User user) throws Exception;
	//�û�ע��
	public int addUser(User user) throws Exception;
	
	/**
	 * ֪ͨ��Ϣ����
	 */
	public int inserMessage(Message message) throws Exception;
	public List<Message> selectMessageForm(User user) throws Exception;
	//��ӵ�����֪ͨ�б�
	public int addBookToDownlist(Downlist downlist) throws Exception;
	//�����û������ҽ����б�
	public  List<Downlist> selectDownListByUser(int id) throws Exception;
	//������Ǯ
	public void changePrice(Downlist downlist) throws Exception;
}
