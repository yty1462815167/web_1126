package org.aly.yty.biz.impl;

/**
 * @ClassName: UserinfoBizImpl
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/3 14:23
 * @Version: V1.0
 */

import org.aly.yty.biz.UserinfoBiz;
import org.aly.yty.dao.UserinfoDao;
import org.aly.yty.dao.impl.UserinfoDaoImpl;
import org.aly.yty.entity.UserInfo;

import java.util.List;

/**
 * 业务层
 */
public class UserinfoBizImpl implements UserinfoBiz {
//底层对象
    private UserinfoDao dao =new UserinfoDaoImpl();

    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
       return dao.isLogin(userInfo);
    }

    @Override
    public int add(UserInfo userInfo) throws Exception {
       return dao.add(userInfo);
    }

    @Override
    public int del(String id) throws Exception {
        return dao.del(id);
    }

    @Override
    public int update(UserInfo userInfo) throws Exception {
   return dao.update(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
      return dao.findById(id);
    }

    @Override
    public List<UserInfo> all(Object... param) throws Exception {
    return dao.all(param);
    }
}