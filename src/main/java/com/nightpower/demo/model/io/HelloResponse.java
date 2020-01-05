/**
 * 
 */
package com.nightpower.demo.model.io;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jollyja
 *
 */
@ApiModel(description = "Hello返回报文")
public class HelloResponse {

	@ApiModelProperty(value = "姓名", required = true)
	private String helloName;

	@ApiModelProperty(value = "金额", required = true)
	private BigDecimal helloAmount;

	@ApiModelProperty(value = "指示位", required = true)
	private Boolean helloIndication;

	@ApiModelProperty(value = "字符串列表", required = true)
	private List<String> helloStringList;

	@ApiModelProperty(value = "字符串哈希表", required = true)
	private Map<String, String> helloStringMap;

	public HelloResponse() {
	}
	
	public HelloResponse(String helloName, BigDecimal helloAmount, Boolean helloIndication, List<String> helloStringList, Map<String, String> helloStringMap) {
		this.helloName = helloName;
		this.helloAmount = helloAmount;
		this.helloIndication = helloIndication;
		this.helloStringList = helloStringList;
		this.helloStringMap = helloStringMap;
	}

	public String getHelloName() {
		return helloName;
	}

	public HelloResponse setHelloName(String helloName) {
		this.helloName = helloName;
		return this;
	}

	public BigDecimal getHelloAmount() {
		return helloAmount;
	}

	public HelloResponse setHelloAmount(BigDecimal helloAmount) {
		this.helloAmount = helloAmount;
		return this;
	}

	public Boolean getHelloIndication() {
		return helloIndication;
	}

	public HelloResponse setHelloIndication(Boolean helloIndication) {
		this.helloIndication = helloIndication;
		return this;
	}

	public List<String> getHelloStringList() {
		return helloStringList;
	}

	public HelloResponse setHelloStringList(List<String> helloStringList) {
		this.helloStringList = helloStringList;
		return this;
	}

	public Map<String, String> getHelloStringMap() {
		return helloStringMap;
	}

	public HelloResponse setHelloStringMap(Map<String, String> helloStringMap) {
		this.helloStringMap = helloStringMap;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((helloAmount == null) ? 0 : helloAmount.hashCode());
		result = prime * result + ((helloIndication == null) ? 0 : helloIndication.hashCode());
		result = prime * result + ((helloName == null) ? 0 : helloName.hashCode());
		result = prime * result + ((helloStringList == null) ? 0 : helloStringList.hashCode());
		result = prime * result + ((helloStringMap == null) ? 0 : helloStringMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HelloResponse other = (HelloResponse) obj;
		if (helloAmount == null) {
			if (other.helloAmount != null)
				return false;
		} else if (!helloAmount.equals(other.helloAmount))
			return false;
		if (helloIndication == null) {
			if (other.helloIndication != null)
				return false;
		} else if (!helloIndication.equals(other.helloIndication))
			return false;
		if (helloName == null) {
			if (other.helloName != null)
				return false;
		} else if (!helloName.equals(other.helloName))
			return false;
		if (helloStringList == null) {
			if (other.helloStringList != null)
				return false;
		} else if (!helloStringList.equals(other.helloStringList))
			return false;
		if (helloStringMap == null) {
			if (other.helloStringMap != null)
				return false;
		} else if (!helloStringMap.equals(other.helloStringMap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HelloRequest [helloName=" + helloName + ", helloAmount=" + helloAmount + ", helloIndication=" + helloIndication + ", helloStringList="
		        + helloStringList + ", helloStringMap=" + helloStringMap + "]";
	}

}
