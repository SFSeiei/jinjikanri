package com.jinjikanri.common.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * 
 * @author zhangxuping
 *
 */
@Configuration
public class ShiroConfig {

	@Value("${server.session-timeout}")
	private int tomcatTimeout;

	// 不清楚该bean的用处。
	@Bean
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean
	 * 
	 * @return
	 */

	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}

	// 将自己的验证方式加入容器
	@Bean
	public CustomRealm userShiroRealm() {
		CustomRealm customRealm = new CustomRealm();
		customRealm.setCachingEnabled(true);
		customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		// 启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
		customRealm.setAuthenticationCachingEnabled(true);
		// 缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
		customRealm.setAuthenticationCacheName("authenticationCache");
		// 启用授权缓存，即缓存AuthorizationInfo信息，默认false
		customRealm.setAuthorizationCachingEnabled(true);
		// 缓存AuthorizationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
		customRealm.setAuthorizationCacheName("authorizationCache");
		return customRealm;
	}

	/**
	 * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
	 * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
	 *
	 * @return
	 */
	@Bean(name = "ehCacheManager")
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
		return cacheManager;
	}

	@Bean
	public SessionDAO sessionDAO() {
		return new MemorySessionDAO();
	}

	/**
	 * 配置session监听
	 * 
	 * @return
	 */
	@Bean
	public ShiroSessionListener sessionListener() {
		ShiroSessionListener sessionListener = new ShiroSessionListener();
		return sessionListener;
	}

	/**
	 * shiro session的管理
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setGlobalSessionTimeout(tomcatTimeout * 1000);
		// 设置sessionDao对session查询，在查询在线用户service中用到了
		sessionManager.setSessionDAO(sessionDAO());

		// 配置session的监听
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(sessionListener());
		sessionManager.setSessionListeners(listeners);

		// 设置在cookie中的sessionId名称
		sessionManager.setSessionIdCookie(simpleCookie());

		// 全局会话超时时间（单位毫秒），默认30分钟 暂时设置为10秒钟 用来测试
		sessionManager.setGlobalSessionTimeout(1800000);

		// 是否开启删除无效的session对象 默认为true
		sessionManager.setDeleteInvalidSessions(true);

		// 是否开启定时调度器进行检测过期session 默认为true
		sessionManager.setSessionValidationSchedulerEnabled(true);

		// 设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 1个小时
		// 设置该属性 就不需要设置 ExecutorServiceSessionValidationScheduler
		// 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
		// 暂时设置为 5秒 用来测试
		sessionManager.setSessionValidationInterval(3600000);

		return sessionManager;
	}

	@Bean
	public SimpleCookie simpleCookie() {
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setName("jeesite.session.id");
		return simpleCookie;
	}

	// 权限管理，配置主要是Realm的管理认证
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(userShiroRealm());

		// 自定义缓存实现 使用ehCache.
		securityManager.setCacheManager(ehCacheManager());

		// 设置sessionManager.
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	// Filter工厂，设置对应的过滤条件和跳转条件
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> map = new HashMap<>();
		// 登出
		map.put("/logout", "logout");
		// 对所有用户认证
		map.put("/**", "anon");
		// 登录
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 首页
		shiroFilterFactoryBean.setSuccessUrl("/welcome");
		// 错误页面，认证不通过跳转
		shiroFilterFactoryBean.setUnauthorizedUrl("/error");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}

	/**
	 * 让某个实例的某个方法的返回值注入为Bean的实例 Spring静态注入
	 * 
	 * @return
	 */
	@Bean
	public MethodInvokingFactoryBean getMethodInvokingFactoryBean() {
		MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
		factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		factoryBean.setArguments(new Object[] { securityManager() });
		return factoryBean;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}
