package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {

	@Autowired // Dependency Injecttion(DI) : 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // Spring bean을 가져온다.
	
	// input : X (Controller한테 받아온다.)
	// output : (Repository한테 받은 것을) List<UsedGoods> (Controller한테 준다.)
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
} // public class UsedGoodsBO