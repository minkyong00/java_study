package pub2504.jdbc.board.dao;

import java.util.List;

import pub2504.jdbc.board.model.Reply;

public interface ReplyDao {

	public abstract List<Reply> listReply();

	public abstract Reply getReply(int rid);

	public abstract int registReply(Reply reply);

	public abstract int modifyReply(Reply reply);

	public abstract int removeReply(int rid);

}
