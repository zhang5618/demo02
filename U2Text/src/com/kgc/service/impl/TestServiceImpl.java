package com.kgc.service.impl;

import com.kgc.dao.ITestDao;
import com.kgc.dao.impl.TestDaoImpl;
import com.kgc.pojo.Invitation;
import com.kgc.pojo.Reply;
import com.kgc.service.ITestService;
import com.kgc.utils.PageBean;

import java.util.List;

public class TestServiceImpl implements ITestService {
    ITestDao dao = new TestDaoImpl();

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public int add(Reply reply) {
        return dao.add(reply);
    }

    @Override
    public List<Reply> selectReply(String invid) {
        return dao.selectReply(invid);
    }

    @Override
    public int more(Invitation invi) {
        return dao.more(invi);
    }

    @Override
    public List selectPage(PageBean page) {
        int count = dao.count(page);
        //System.out.println(count+"count");
        int size = page.getSize();
        int totalPage = count%size==0?(count/size):(count/size+1);
        //System.out.println(totalPage+"totalPage");
        page.setCount(count);
        page.setTotalPage(totalPage);

        return dao.selectPage(page);
    }
}
