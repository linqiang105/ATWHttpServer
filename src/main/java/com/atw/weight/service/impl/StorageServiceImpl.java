package com.atw.weight.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atw.weight.bean.storage.Express;
import com.atw.weight.bean.storage.Goods;
import com.atw.weight.bean.storage.InOutType;
import com.atw.weight.bean.storage.StorageInfo;
import com.atw.weight.dao.IStorageDao;
import com.atw.weight.service.IStorageService;
import com.atw.weight.vo.CommonResult;
import com.atw.weight.vo.storage.ExpressListResult;
import com.atw.weight.vo.storage.GoodsListResult;
import com.atw.weight.vo.storage.InOutTypeListResult;
import com.atw.weight.vo.storage.StorageInfoListResult;

/**
 * @author haibara
 * 
 */
@Service("storageService")
public class StorageServiceImpl implements IStorageService {

	@Resource(name = "storageDao")
	private IStorageDao storageDao;

	public InOutTypeListResult getInOutTypes() {
		// TODO Auto-generated method stub
		List<InOutType> listInOutType = storageDao.getInOutTypes();
		InOutTypeListResult inOutTypeListResult = new InOutTypeListResult();

		inOutTypeListResult.setResult(listInOutType);
		inOutTypeListResult.setCount(listInOutType.size());

		return inOutTypeListResult;
	}

	public CommonResult saveInOutType(InOutType inOutType) {
		// TODO Auto-generated method stub
		CommonResult commonResult = new CommonResult();
		commonResult.setStatus(storageDao.saveInOutType(inOutType) ? 0 : 1);
		return commonResult;
	}

	public GoodsListResult getGoods() {
		// TODO Auto-generated method stub
		GoodsListResult goodsListResult = new GoodsListResult();
		List<Goods> listGoods = storageDao.getGoods();
		goodsListResult.setResult(listGoods);
		goodsListResult.setCount(listGoods.size());
		return goodsListResult;
	}

	public ExpressListResult getExpresses(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		ExpressListResult expressListResult = new ExpressListResult();
		List<Express> listExpress = storageDao.getExpress(startDate, endDate);
		expressListResult.setResult(listExpress);
		expressListResult.setCount(listExpress.size());
		return expressListResult;
	}

	public Double getStorage(String goods) {
		// TODO Auto-generated method stub
		return storageDao.getLeft(goods);
	}

	public StorageInfoListResult getStorage() {
		// TODO Auto-generated method stub
		List<StorageInfo> list = storageDao.getStorage();
		StorageInfoListResult storageInfoListResult = new StorageInfoListResult();
		storageInfoListResult.setResult(list);
		storageInfoListResult.setCount(list.size());
		return storageInfoListResult;
	}

	public CommonResult saveGoods(String name, String spec, String memo, String pGoods) {
		// TODO Auto-generated method stub
		CommonResult commonResult = new CommonResult();

		Goods goods = new Goods();

		// 如果没有从属货名，则先插入从属货名
		if (storageDao.getGoodsByName(pGoods) != null) {
			goods.setName(pGoods);
			goods.setParentGoods(null);
			storageDao.saveGoods(goods);
		}
		goods.setName(name);
		goods.setSpec(spec);
		goods.setMemo(memo);
		goods.setParentGoods(storageDao.getGoodsByName(pGoods));
		commonResult.setStatus(storageDao.saveGoods(goods) ? 0 : 1);
		return commonResult;
	}

	public CommonResult saveInOutHisotry(int inOutType, Double num, String memo, String goods, Date updateTime) {
		// TODO Auto-generated method stub
		CommonResult commonResult = new CommonResult();

		// 没有这种进出库类型
		List<InOutType> listInOutType = storageDao.getInOutTypes();
		boolean hasInOutType = false;
		if ((null != listInOutType) && (listInOutType.size() > 0)) {
			for (int i = 0; i < listInOutType.size(); i++) {
				if (listInOutType.get(i).getId() == inOutType) {
					hasInOutType = true;
					break;
				}
			}
		}
		if (!hasInOutType) {
			commonResult.setStatus(1);
			commonResult.setMessage("未找到进出库类型代码");
			return commonResult;
		}

		// 没有这种货名，无法入库
		if (0 == storageDao.getGoodsByName(goods).getId()) {
			commonResult.setStatus(1);
			commonResult.setMessage("未找到货名");
			return commonResult;
		}

		commonResult.setStatus(storageDao.saveInOutHistory(inOutType, num, memo, goods, updateTime) ? 0 : 1);

		return commonResult;
	}

	public CommonResult saveExpress(String code, String sender, String sendAddr, String sendTel, String receiver,
			String receiveAddr, String receiveTel, String[] goods, Double[] num, Date updateTime, String memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommonResult pack(String[] goods, Double[] num, String newGoods, Double newNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
