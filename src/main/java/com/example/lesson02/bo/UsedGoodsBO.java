package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {

	// input : X (Controller한테 받아온다.)
	// output : (Repository한테 받은 것을) List<UsedGoods> (Controller한테 준다.)
	public List<UsedGoods> getUsedGoodsList() {
		return ;
	}
	
} // public class UsedGoodsBO