/**
 * 
 */
package com.nightpower.demo.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nightpower.demo.model.io.HelloRequest;
import com.nightpower.demo.model.io.HelloResponse;
import com.nightpower.demo.service.HelloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author jollyja
 *
 */
@RestController
@RequestMapping("/hello")
@Api(tags = "hello contraoller")
public class HelloController {

	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;

	/**
	 * required method : get
	 * path variable : pathxxx
	 * parameter : name, amount, indication
	 * url : http://localhost:8080/hello/getHello/pathxxx?name=tom&amount=123.456&indication=true
	 * 
	 * @param path 
	 * @param name
	 * @param amount
	 * @param indication
	 * @return
	 */
	@ApiOperation(value="get method sample", notes="this is a get method sample, it shows how to translate param to controller")
	@RequestMapping(value="/getHello/{path}", method=RequestMethod.GET)
	public HelloResponse getHello(@ApiParam(name = "path", value = "路径", required = true) @PathVariable String path, 
			String name, 
			BigDecimal amount, 
			Boolean indication) {
		log.info("path is : " + path);
		log.info("name :" + name);
		log.info("amount :" + amount.toString());
		log.info("indication :" + indication.toString());
		
		return new HelloResponse(name, amount, indication, null, null).setHelloName("Mr/Ms " + name);
	}

	/**
	 * request method : post
	 * path variable : pathyyy
	 * parameter : HelloRequest
	 * url : http://localhost:8080/hello/postHello/pathyyy
	 * {
	 * "helloName" : "jacky",
	 * "helloAmount" : 12345.678,
	 * "helloIndication" : true,
	 * "helloStringList" : ["aaa", "bbb", "ccc"],
	 * "helloStringMap" : {
	 * 			"key1" : "value1",
	 * 			"key2" : "value2",
	 * 			"key3" : "value3"
	 *     }
	 * }
	 * @param path
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/postHello/{path}", method=RequestMethod.POST)
	public HelloResponse postHelloWithPath(@PathVariable String path,
			@RequestBody HelloRequest req) {
		log.info("path is : " + path);
		log.info("req is : " + req.toString());

		req.getHelloStringList().add("test string from server post hello with path");
		req.getHelloStringMap().put("server key", "server value  post hello with path");
		
		helloService.hello();

		return new HelloResponse()
				.setHelloName("Mr/Ms " + req.getHelloName())
				.setHelloAmount(req.getHelloAmount().add(BigDecimal.TEN))
				.setHelloIndication(!req.getHelloIndication())
				.setHelloStringList(req.getHelloStringList())
				.setHelloStringMap(req.getHelloStringMap());
	}
	
	
	
	@RequestMapping(value="/postHello/abc", method=RequestMethod.POST)
	public HelloResponse postHello(@RequestBody HelloRequest req) {
		log.info("there is no path");
		log.info("req is : " + req.toString());

		req.getHelloStringList().add("test string from server post hello");
		req.getHelloStringMap().put("server key", "server value  post hello");

		helloService.hello();

		return new HelloResponse()
				.setHelloName("Mr/Ms " + req.getHelloName())
				.setHelloAmount(req.getHelloAmount().add(BigDecimal.TEN))
				.setHelloIndication(!req.getHelloIndication())
				.setHelloStringList(req.getHelloStringList())
				.setHelloStringMap(req.getHelloStringMap());
	}
		
}
