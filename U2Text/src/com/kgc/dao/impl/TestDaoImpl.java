package com.kgc.dao.impl;

import com.kgc.dao.ITestDao;
import com.kgc.pojo.Invitation;
import com.kgc.pojo.Reply;
import com.kgc.utils.JDBCUtils;
import com.kgc.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestDaoImpl implements ITestDao {
    @Override
    public int more(Invitation invi) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        String sql = "insert into invitation values(null,?,?,?,?)";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Object [] s = invi.toString1().split(",");
            s[s.length-1]=format.format(new Date());//赋予当前时间
            return qr.update(sql,s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(String id) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        String sql = "delete from invitation where id =?";
        try {
            qr.update("delete from reply_detail where invid =?",id);//先删除所新闻对于的评论
            return qr.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(Reply reply) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        String sql = "insert into reply_detail(invid,content,author,createdate) values(?,?,?,?)";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Object [] s = reply.toString1().split(",");
            s[s.length-1]=format.format(new Date());//赋予当前时间
            return qr.update(sql,s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reply> selectReply(String invid) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        try {
            return qr.query("select  * from reply_detail where invid=? ",new BeanListHandler<Reply>(Reply.class),invid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count(PageBean page) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        String sql = "select count(*) from invitation where 1=1 ";
        String title = page.getTitle();//得到查询条件
        if (title!=null&&!title.trim().equals("")){
            sql+=" and title like '%"+title.trim()+"%'";
        }
        try {
            return qr.query(sql,new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List selectPage(PageBean page) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDs());
        String sql = "select * from invitation where 1=1 ";
        String title = page.getTitle();//得到查询条件
        if (title != null && !title.trim().equals("")) {
            sql += " and title like '%" + title.trim() + "%'";
        }

        int first = (page.getCurrPage() - 1) * page.getSize();
        sql += " limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<Invitation>(Invitation.class), first, page.getSize());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
