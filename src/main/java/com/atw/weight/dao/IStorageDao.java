package com.atw.weight.dao;

import java.util.Date;
import java.util.List;

import com.atw.weight.bean.storage.Express;
import com.atw.weight.bean.storage.Goods;
import com.atw.weight.bean.storage.InOutType;
import com.atw.weight.bean.storage.StorageInfo;

public interface IStorageDao {

	/**
	 * 取出入库类型
	 * 
	 * @return
	 */
	public List<InOutType> getInOutTypes();

	/**
	 * 新增出入库类型
	 * 
	 * @return
	 */
	public boolean saveInOutType(InOutType inOutType);

	/**
	 * 取货名信息
	 * 
	 * @return
	 */
	public List<Goods> getGoods();

	/**
	 * 根据名称取货名信息
	 * 
	 * @param id
	 * @return
	 */
	public Goods getGoodsByName(String name);

	/**
	 * 根据ID取货品信息
	 * 
	 * @param id
	 * @return
	 */
	public Goods getGoodsById(int id);

	/**
	 * 新增货名
	 * 
	 * @param goods
	 * @return
	 */
	public boolean saveGoods(Goods goods);

	/**
	 * 取快递单信息
	 * 
	 * @return
	 */
	public List<Express> getExpress(Date startDate, Date endDate);

	/**
	 * 取单货品库存
	 * 
	 * @param name
	 * @return
	 */
	public Double getLeft(String name);

	/**
	 * 取所有库存信息
	 * 
	 * @return
	 */
	public List<StorageInfo> getStorage();

	/**
	 * 保存进出库操作历史
	 * 
	 * @param inOutType
	 * @param num
	 * @param memo
	 * @param goods
	 * @param updateTime
	 * @return
	 */
	public boolean saveInOutHistory(int inOutType, Double num, String memo, String goods, Date updateTime);
}
