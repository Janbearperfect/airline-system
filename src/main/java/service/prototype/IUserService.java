package service.prototype;

import java.util.List;

import entity.User;

public interface IUserService {
   List<User> listUsers(int pageNo,int pageSize);
}
