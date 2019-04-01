package com.kgc.dao;
//测试更新
import com.kgc.pojo.Invitation;
import com.kgc.pojo.Reply;
import com.kgc.utils.PageBean;

import java.util.List;

public interface ITestDao {
    List selectPage(PageBean page);

    int count(PageBean page);

    List<Reply> selectReply(String invid);

    int add(Reply reply);

    int delete(String id);

    int more(Invitation invi);
}
