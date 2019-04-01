package com.kgc.service;

import com.kgc.pojo.Invitation;
import com.kgc.pojo.Reply;
import com.kgc.utils.PageBean;

import java.util.List;

public interface ITestService {
    List selectPage(PageBean page);

    List<Reply> selectReply(String invid);

    int add(Reply reply);

    int delete(String id);

    int more(Invitation invi);
}
