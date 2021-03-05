package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.AppMarketUserPagePo;
import com.wisea.yysc.common.po.MembInfoListPo;
import com.wisea.yysc.common.po.MembInfoPagePo;
import com.wisea.yysc.common.po.memb.LoginNameOrMobilePo;
import com.wisea.yysc.common.po.memb.MembCheckLoginNamePo;
import com.wisea.yysc.common.po.memb.MembCheckMobilePo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import com.wisea.yysc.common.vo.FindMembInfoVo;
import com.wisea.yysc.common.vo.MembInfoListVo;
import com.wisea.yysc.common.vo.memb.MembBaseDetailVo;

import java.util.List;

/**
 * memb_info 表DAO
 * 会员信息
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface MembInfoMapper extends CrudDao<MembInfo> {
    List<MembInfoListVo> findPage(MembInfoPagePo membInfoPagePo);

    List<MembInfoListVo> findList(MembInfoListPo membInfoListPo);

    /**
     * 根据id获取会员的基本信息
     * @param id
     * @return
     */
    MembBaseDetailVo getMembBaseDetail(Long id);

    /**
     * 分页查询应用市场用户列表信息
     * @param po
     * @return
     */
    List<AppMarketUserListVo> findAppMarketUserPageList(AppMarketUserPagePo po);

    /**
     * 验证手机号是否已经存在
     * @param membCheckMobilePo
     * @return
     */
    int checkMobileExist(MembCheckMobilePo membCheckMobilePo);

    /**
     * 会员基础信息（应用市场用户专用）
     * @param id
     * @return
     */
    FindMembInfoVo findMemberInfo(Long id);

    /**
     *  登录的验证处理
     * @param loginNameOrMobilePo
     * @return
     */
    MembInfo loginCheck(LoginNameOrMobilePo loginNameOrMobilePo);

    /**
     * 通过注册手机号查询用户信息(*登录用勿改)
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月11日
     * @version 1.0
     */
    MembInfo getMembInfoByRegTel(String mobile);

    /**
     * 验证用户名称是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2020年4月28日
     * @version 1.0
     */
     int checkLoginNameExist(MembCheckLoginNamePo membCheckLoginNamePo);
}