package com.github.manager.configurer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * Spring MVC 配置
 *
 * @author colg
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	private static final Log log = LogFactory.get();

	/**
	 * 配置HttpMessageConverters用于读取或写入请求或响应的主体。
	 * 
	 * 使用FastJSON解析{@link com.alibaba.fastjson.JSON}
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(
					SerializerFeature.WriteDateUseDateFormat,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullListAsEmpty,
					SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.DisableCircularReferenceDetect
				);
		converter.setFastJsonConfig(config);
		converters.add(converter);
	}

	/**
	 * 配置异常解析器。
	 */
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO colg
		log.info("统一异常处理");
	}

	/**
	 * 处理跨域问题
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO colg
		log.info("处理跨域问题");
	}

	/**
	 * 添加Spring MVC生命周期拦截器，用于控制器方法调用的预处理和后处理。 拦截器可以被注册为适用于所有请求或被限制为一部分URL模式。
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor = new HandlerInterceptor() {
			
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				// 在请求处理之前进行调用（Controller方法调用之前
				log.info("进入拦截器");
				return true;
			}
			
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
			}
			
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
			}
		};
		
		registry.addInterceptor(interceptor);
	}
	
	/**
	 * 添加解析器以支持自定义控制器方法参数类型。
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		log.info("参数解析器");
	}
}
