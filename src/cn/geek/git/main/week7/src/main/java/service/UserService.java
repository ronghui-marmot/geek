package service;


import entity.User;

public interface UserService {

    User findUserByFirstDb(long id);

    User findUserBySecondDb(long id);

}
