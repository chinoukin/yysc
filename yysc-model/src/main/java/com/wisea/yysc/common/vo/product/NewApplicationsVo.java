package com.wisea.yysc.common.vo.product;

import com.wisea.yysc.common.vo.ApplicationVisitMageListVo;
import com.wisea.yysc.common.vo.CommAttriMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("返回添加应用所需数据NewApplicationsVo")
public class NewApplicationsVo {
    @ApiModelProperty(value="应用关联")
    private List<ApplicationVisitMageListVo> names;

    @ApiModelProperty(value="添加应用所需属性")
    private List<CommAttriMageListVo> commAttriMageListVos;

    @ApiModelProperty(value = "时间计量单位")
    private List<MeasUnitMagePageListVo> measUnitMagePageListVosTime;

    @ApiModelProperty(value = "件数计量单位")
    private List<MeasUnitMagePageListVo> measUnitMagePageListVosCount;

    public List<MeasUnitMagePageListVo> getMeasUnitMagePageListVosTime() {
        return measUnitMagePageListVosTime;
    }

    public void setMeasUnitMagePageListVosTime(List<MeasUnitMagePageListVo> measUnitMagePageListVosTime) {
        this.measUnitMagePageListVosTime = measUnitMagePageListVosTime;
    }

    public List<MeasUnitMagePageListVo> getMeasUnitMagePageListVosCount() {
        return measUnitMagePageListVosCount;
    }

    public void setMeasUnitMagePageListVosCount(List<MeasUnitMagePageListVo> measUnitMagePageListVosCount) {
        this.measUnitMagePageListVosCount = measUnitMagePageListVosCount;
    }

    public List<ApplicationVisitMageListVo> getNames() {
        return names;
    }

    public void setNames(List<ApplicationVisitMageListVo> names) {
        this.names = names;
    }

    public List<CommAttriMageListVo> getCommAttriMageListVos() {
        return commAttriMageListVos;
    }

    public void setCommAttriMageListVos(List<CommAttriMageListVo> commAttriMageListVos) {
        this.commAttriMageListVos = commAttriMageListVos;
    }
}
