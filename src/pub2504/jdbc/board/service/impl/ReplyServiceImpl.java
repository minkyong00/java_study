package pub2504.jdbc.board.service.impl;

import java.util.List;

import pub2504.jdbc.board.dao.ReplyDao;
import pub2504.jdbc.board.model.Reply;
import pub2504.jdbc.board.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	
	private ReplyDao replyDao;

	@Override
	public List<Reply> listReply() {
		return replyDao.listReply();
	}

	@Override
	public Reply getReply(int rid) {
		return replyDao.getReply(rid);
	}

	@Override
	public int registReply(Reply reply) {
		return replyDao.registReply(reply);
	}

	@Override
	public int modifyReply(Reply reply) {
		return replyDao.modifyReply(reply);
	}

	@Override
	public int removeReply(int rid) {
		return replyDao.removeReply(rid);
	}

}
