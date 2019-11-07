package dao.prototype;

import java.sql.Connection;
import java.util.List;

import entity.Account;
import util.Pager;


public interface IAccountDao {
	//连接参数化
  //  void modify(Account act,Connection conn);//为了确保事务
    //根剧ID查询账号的方法
    Account find(int id);
    //再写修改方法
    void saveOrUpdate(Account act);
    void delete(int id);
    List<Account> findAll();
    //要做分页光数据是不够的
    
    List<Account> find(int offset,int pageSize);//--0 int类型的最大值（Integer.MaxValue）
    Pager<Account> findPaged(int offset,int pageSize);
    int totalItems();
}
