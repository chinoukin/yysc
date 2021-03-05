package com.wisea.yysc.operation.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.po.RegisterUserPo;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.po.UpdateLoginNamePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.security.dao.RoleMenuDao;
import com.wisea.cloud.security.po.UserAuthUpdatePo;
import com.wisea.cloud.security.service.MenuService;
import com.wisea.cloud.security.service.UserBaseService;
import com.wisea.cloud.security.service.UserService;
import com.wisea.cloud.security.service.lcn.UserLcnAbsService;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.FreezeMembUpdPo;
import com.wisea.yysc.common.po.MembInfoPagePo;
import com.wisea.yysc.common.po.memb.*;
import com.wisea.yysc.common.vo.MembInfoListVo;
import com.wisea.yysc.common.vo.memb.MembInfoFindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MembInfoService extends UserBaseService {


    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private RemoteUserMss remoteUserMss;
    @Autowired
    private UserService userService;
    @Autowired
    private UserLcnAbsService userLcnAbsService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuDao roleMenuDao;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<MembInfoListVo>> findPage(MembInfoPagePo po) {
        ResultPoJo<Page<MembInfoListVo>> result = new ResultPoJo<>();
        Page<MembInfoListVo> page = po.getPage();
        //缺少admin用户判断和创建人查询
        User user = SystemUtils.getUser();
        po.setCreateBy(user.getId());
        List<MembInfoListVo> list = membInfoMapper.findPage(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

   // @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo<String> freezeMemb(FreezeMembUpdPo po){
        // 返回参数定义
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 验证参数是否真实存在
        MembInfo exist = membInfoMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isEmpty(exist)){
            result.setCode(ConstantCodeMsg.ERR_513);
            result.setMsg(ConstantCodeMsg.MSG_513);
            return result;
        }
        // 用户的处理
        LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
        // 正常
        if(DictConstants.ACCT_STATE_0.equals(po.getAcctState())){
            loginBatUpdate.setLoginFlag(DictConstants.DEFAULT_FLAG_1);
            po.setAcctState(DictConstants.ACCT_STATE_1);
            // 冻结
        }else if(DictConstants.ACCT_STATE_1.equals(po.getAcctState())){
            loginBatUpdate.setLoginFlag(DictConstants.DEFAULT_FLAG_0);
            po.setAcctState(DictConstants.ACCT_STATE_0);
        }
        loginBatUpdate.setIds(ConverterUtil.toString(exist.getId()));
        ResultPoJo<Object> userResult = remoteUserMss.loginBatUpdate(loginBatUpdate);
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }
        // 保存到表中
        MembInfo info = new MembInfo();
        info.setId(po.getId());
        info.setAcctState(po.getAcctState());
        membInfoMapper.updateByPrimaryKeySelective(info);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<MembInfoFindVo> get(MembInfoFindPo po) {
        ResultPoJo<MembInfoFindVo> result = new ResultPoJo<>();
        MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
        MembInfoFindVo vo = new MembInfoFindVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 注册用户会员信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月12日
     * @version 1.0
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @Transactional(readOnly = false)
    public ResultPoJo<User> addUserMemb(RegisterMembPo po){
        // 返回值初期化处理
        ResultPoJo<User> result = new ResultPoJo<User>();
        if(po != null){
            // 验证登录用户的信息
            User user = SystemUtils.getUser();
            if(ConverterUtil.isEmpty(user)){
                result.setCode(ConstantCodeMsg.ERR_912);
                result.setMsg(ConstantCodeMsg.MSG_912);
                return result;
            }
            // 根据用户名称或者手机号查询用户信息
            LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
            loginNameOrMobilePo.setLoginName(po.getLoginName());
            loginNameOrMobilePo.setMobile(po.getLoginName());
            MembInfo checkMembInfo = membInfoMapper.loginCheck(loginNameOrMobilePo);
            if(checkMembInfo != null && ConverterUtil.isNotEmpty(checkMembInfo.getLoginName())){
                result.setCode("999");
                result.setMsg("账号已存在!");
                return result;
            }
            // 验证密码和确认密码是否相同
            if(!po.getPassword().equals(po.getConPwd())){
                result.setCode(ConstantCodeMsg.ERR_504);
                result.setMsg(ConstantCodeMsg.MSG_504);
                return result;
            }
            MembInfo membInfo = new MembInfo();
            membInfo.preInsert();
            membInfo.setLoginName(po.getLoginName());// 用户名
            //membInfo.setRegistTel(po.getContTel());// 注册手机号
            membInfo.setContName(po.getContName());// 名称
            membInfo.setRemarks(po.getRemarks());
            membInfo.setEmail(po.getEmail());
            membInfo.setContTel(po.getContTel());//联系人手机号
            membInfo.setAcctState(DictConstants.ACCT_STATE_0);// 帐号状态    默认正常 0:正常
            membInfo.setRegistDate(OffsetDateTime.now());// 注册时间
            membInfo.setMembType(DictConstants.MEMB_TYPE_1);// 会员类型是后台
            membInfoMapper.insertSelective(membInfo);
            //  会员表中信息的处理   -------结束
            //  用户表中添加的处理 --- 开始
            RegisterUserPo registerUser = new RegisterUserPo();
            registerUser.setId(membInfo.getId());
            registerUser.setLoginName(membInfo.getLoginName());
            //registerUser.setMobile(membInfo.getRegistTel());
            registerUser.setPassword(po.getPassword());
            registerUser.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
            List<String> roleList = new ArrayList<String>();
            roleList.add("ROLE_person");
            registerUser.setRoleCodes(roleList);// 个人的情况
            //registerUser.setParentId(po.getParentId());//父节点ID
            userLcnAbsService.register(registerUser, null);
            // 用户已经存在修改用户信息
            // 菜单的处理
            if(ConverterUtil.isNotEmpty(po.getMenuIds())){
                UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
                userAuthUpdate.setId(ConverterUtil.toString(membInfo.getId()));
                userAuthUpdate.setMenuIds(po.getMenuIds());
                ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
                if(!ConstantError.NOMAL.equals(menuResult.getCode())){
                    BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
                    throw error;
                }
            }
           // result.setResult(user);
        }else{
            result.setCode(ConstantError.ERR_001);
            result.setMsg(ConstantError.MSG_001);
        }
        return result;
    }

    /**
     * 修改用户会员基础信息操作
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月11日
     * @version 1.0
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @Transactional(readOnly = false)
    public ResultPoJo<String> updUserMembInfo(UpdMembPo value){
        // 返回值初期化处理
        ResultPoJo<String> result = new ResultPoJo<String>();
        // 验证参数
        if(value != null && ConverterUtil.isNotEmpty(value.getId())){
            User user = UserUtils.getById(value.getId());
            if(user == null){
                result.setCode(ConstantError.ERR_907);
                result.setMsg(ConstantError.MSG_907);
                return result;
            }
            if (ConverterUtil.isNotEmpty(value.getPassword()) && ConverterUtil.isNotEmpty(value.getConPwd())){
                // 验证密码和确认密码是否相同
                if(!value.getPassword().equals(value.getConPwd())){
                    result.setCode(ConstantCodeMsg.ERR_504);
                    result.setMsg(ConstantCodeMsg.MSG_504);
                    return result;
                }
            }

            //  会员表中信息的处理   -------开始
            MembInfo membInfo = new MembInfo();
            membInfo.preInsert();
            membInfo.setLoginName(value.getLoginName());// 用户名
            membInfo.setContTel(value.getContTel());//联系人手机号
            membInfo.setContName(value.getContName());// 名称
            membInfo.setRemarks(value.getRemarks());
            membInfo.setEmail(value.getEmail());
            membInfoMapper.insertSelective(membInfo);
            //  会员表中信息的处理   -------结束
            // 用户名处理

            if (ConverterUtil.isNotEmpty(value.getLoginName())) {
                if(!value.getLoginName().equals(user.getLoginName())) {
                    UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
                    updateLoginNamePo.setId(value.getId());
                    updateLoginNamePo.setLoginName(value.getLoginName());
                    ResultPoJo<Object> loginNameResult = userService.updateLoginName(updateLoginNamePo);
                    if (!ConstantError.NOMAL.equals(loginNameResult.getCode())) {
                        BusinessException error = new BusinessException(loginNameResult.getCode(), loginNameResult.getMsg());
                        throw error;
                    }
                }
            }
            // 登录密码的处理
            if(ConverterUtil.isNotEmpty(value.getPassword())){
                ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
                resetPasswordUserPo.setId(value.getId());
                resetPasswordUserPo.setNewPassword(value.getPassword());
                ResultPoJo<Object> passResult = userService.resetPassword(resetPasswordUserPo);
                if(!ConstantError.NOMAL.equals(passResult.getCode())){
                    BusinessException error = new BusinessException(passResult.getCode(), passResult.getMsg());
                    throw error;
                }
            }
            // 菜单的处理
            if(ConverterUtil.isNotEmpty(value.getMenuIds())){
                UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
                userAuthUpdate.setId(ConverterUtil.toString(value.getId()));
                userAuthUpdate.setMenuIds(value.getMenuIds());
                ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
                if(!ConstantError.NOMAL.equals(menuResult.getCode())){
                    BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
                    throw error;
                }
            }
            // 清空菜单的处理
            if(value.isClearMenuFlag()){
                clearMenu(user);
            }
            // 清除缓存
            UserUtils.clearUserLoginCache(user);
        }else{
            result.setCode(ConstantError.ERR_001);
            result.setMsg(ConstantError.MSG_001);
        }
        return result;
    }
    /**
     * 清空菜单的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月14日
     * @version 1.0
     */
    public void clearMenu(User user){
        // 非(当前操作用户是被操作用户的父账户 或 当前操作用户是管理员)
        if (!UserUtils.isParentOrHasAuthor(user, "ROLE_admin", "user:menu")) {
            // 没有修改的权限 抛出权限异常
            throw ConstantError.VER_901;
        }
        // 将原有的角色菜单关系全部删除，再新建新的关系数据
        // 查询自定义的所有角色
        Role diyRole = userRoleDao.findDiyRoleByUserId(user.getId());
        if(diyRole != null && ConverterUtil.isNotEmpty(diyRole.getId())){
            // 删除角色菜单关系表
            roleMenuDao.deleteRoleMenu(diyRole.getId());
        }
        // 清空该User缓存
        UserUtils.clearCache(user);
        // 注销清除oauth信息 避免权限修改后jwt不变
        userService.clearOauthInfo(user.getLoginName());
    }

    /**
     * 删除用户
     * @param po
     * @return
     */
   // @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(MembInfoDelPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //更新用户表
        MembInfo membInfo = new MembInfo();
        membInfo.setId(po.getId());
        membInfo.preUpdate();
        membInfoMapper.deleteLogic(membInfo);
        //删除用户
        ResultPoJo<Object> userResult = remoteUserMss.batDelete(po.getId().toString());
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }
        return result;
    }
}
