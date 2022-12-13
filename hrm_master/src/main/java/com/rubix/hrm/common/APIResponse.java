package com.rubix.hrm.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponse {

	public Integer status;
	public Object error;
	public Object data;

}
