package com.wisea.yysc.operation.config;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.Encodes;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.operation.utils.LoginUserCheckUtils;
import com.wisea.yysc.operation.utils.ModifyHttpServletRequestWrapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 最先拦截通过手机号或者用户名登录的处理
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月29日
 * @version 1.0
 */
@Configuration
@Order(-9999)
public class MyUserNameOrMobileFilter extends OncePerRequestFilter {

	/**
	 * 拦截后将手机号修改成用户名称
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月29日
	 * @version 1.0
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

		// 只对/login进行拦截
		if (request.getMethod().equalsIgnoreCase(RequestMethod.POST.name()) && request.getRequestURI().endsWith("/login")) {
			logger.debug("LOGIN URL" + ":" + request.getRequestURI());
			//        	// 获取登录类型  默认是后台登录
			String loginType = ConverterUtil.toString(request.getParameter("ltype"), "admin");
			//            // 验证是否是后台登录或者前台登录的情况
			if(loginType.equals("admin") || loginType.equals("web")){
				// 获取auth的值
				String header = request.getHeader("Authorization");
				logger.debug("login authorization" + ":" + request.getHeader(header));
				String[] tokens = extractAndDecodeHeader(header);
				String loginName = tokens[0];
				String password = tokens[1];
				if(ConverterUtil.isNotEmpty(loginName)){
					ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(loginType, loginName,loginName);
					if(checkResult != null && ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
							&& ConverterUtil.isNotEmpty(checkResult.getResult())){
						String basic = "Basic "+ Encodes.encodeBase64(checkResult.getResult() + ":"
								+ password);
						ModifyHttpServletRequestWrapper httpServletRequestWrapper = new ModifyHttpServletRequestWrapper(request);
						httpServletRequestWrapper.putHeader("Authorization", basic);
						filterChain.doFilter(httpServletRequestWrapper, response);
					}else{
						response.sendError(ConverterUtil.toInteger(checkResult.getCode()), checkResult.getMsg());
					}
				}else{
					response.sendError(ConverterUtil.toInteger(ConstantError.ERR_907), ConstantError.MSG_907);
				}
			}else{
				// 获取auth的值
				String header = request.getHeader("Authorization");
				logger.debug("login authorization" + ":" + request.getHeader(header));
				String[] tokens = extractAndDecodeHeader(header);
				String loginName = tokens[0];
				String password = tokens[1];
				if(ConverterUtil.isNotEmpty(loginName)){
					ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(loginType, loginName,loginName);
					if(checkResult != null && ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
							&& ConverterUtil.isNotEmpty(checkResult.getResult())){
						String basic = "Basic "+ Encodes.encodeBase64(checkResult.getResult() + ":"
								+ password);
						ModifyHttpServletRequestWrapper httpServletRequestWrapper = new ModifyHttpServletRequestWrapper(request);
						httpServletRequestWrapper.putHeader("Authorization", basic);
						filterChain.doFilter(httpServletRequestWrapper, response);
					}else{
						response.sendError(ConverterUtil.toInteger(checkResult.getCode()), checkResult.getMsg());
					}
				}else{
					response.sendError(ConverterUtil.toInteger(ConstantError.ERR_907), ConstantError.MSG_907);
				}
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}


	/**
	 * token转换
	 *
	 * @param header
	 * @return
	 * @throws IOException
	 */
	private String[] extractAndDecodeHeader(String header) throws IOException {
		// 操作
		String base64Token = new String(header.substring(6).getBytes("UTF-8"));
		byte[] decoded;
		try {
			decoded = Encodes.decodeBase64(base64Token);
		} catch (IllegalArgumentException e) {
			throw new BadCredentialsException("Failed to decode basic authentication token");
		}
		String token = new String(decoded);
		int delim = token.indexOf(":");
		if (delim == -1) {
			throw new BadCredentialsException("Invalid basic authentication token");
		}
		return new String[] { token.substring(0, delim), token.substring(delim + 1) };
	}
}