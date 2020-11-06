package com.hush.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-11-06
 * @Version 1.0
 */
@NoArgsConstructor
public class PageDTO {

    @NoArgsConstructor
    @Data
    public static class PageVO {
        @ApiModelProperty(name = "pageIndex", value = "当前页")
        private Integer pageIndex;

        @ApiModelProperty(name = "pageSize", value = "每页记录数")
        private Integer pageSize;

        @ApiModelProperty(name = "sortPhrase", value = "排序参数")
        private List<SortVO> sortPhrase;
    }

    @NoArgsConstructor
    @Data
    public static class SortVO {
        @ApiModelProperty(name = "sortProp", value = "排序字段")
        private String sortProp;

        @ApiModelProperty(name = "sortDire", value = "排序方向", allowableValues = "ASC,DESC")
        private String sortDire;
    }
}
