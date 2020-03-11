package com.jinjikanri.service;

import java.util.List;

public interface UserCharRightRelService {
//	boolean saveRel(SYST06UserCharRightRelEntity userCharRightRel);

	boolean saveOrUpdateUCRel(Integer usrCd, List<Integer> charCdList);
	
	boolean saveOrUpdateCRRel(Integer charCd, List<Integer> rightCdList);
}
