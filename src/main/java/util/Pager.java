package util;

import java.util.ArrayList;
import java.util.List;

/*
 * 封装分页的业数据类
 * 泛型编程
 * */
public class Pager<T> extends ArrayList{
    private List<T> data;//数据
    private int total;      //总页数
	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
