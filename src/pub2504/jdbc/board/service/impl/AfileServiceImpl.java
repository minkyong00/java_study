package pub2504.jdbc.board.service.impl;

import java.util.List;

import pub2504.jdbc.board.dao.AfileDao;
import pub2504.jdbc.board.model.Afile;
import pub2504.jdbc.board.service.AfileService;

public class AfileServiceImpl implements AfileService {

	private AfileDao afileDao;

	@Override
	public List<Afile> listAfile() {
		return afileDao.listAfile();
	}

	@Override
	public Afile getAfile(int afid) {
		return afileDao.getAfile(afid);
	}

	@Override
	public int registAfile(Afile afile) {
		return afileDao.registAfile(afile);
	}

	@Override
	public int modifyAfile(Afile afile) {
		return afileDao.modifyAfile(afile);
	}

	@Override
	public int removeAfile(int aid) {
		return afileDao.removeAfile(aid);
	}

}
