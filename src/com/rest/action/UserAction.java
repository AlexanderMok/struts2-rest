package com.rest.action;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rest.bean.User;
import com.rest.service.UserService;

@Results( value = {
	@Result(name="success", type="redirectAction", params = {"actionName" , "user"})
})
public class UserAction extends ActionSupport implements ModelDriven<Object>{
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	
	//id请求参数
	private Integer id;
	private User model = new User();
	private Collection<User> list;
	
	
	@Override
	public Object getModel() {
		return list != null ? list : model;
	}
	
	//从jsp获取id请求参数，并初始化成对应的User
	public void setId(Integer id) {
        if (id != null) {
            this.model = userService.selectById(id);
        }
        this.id = id;
    }
	
    
    /**
	 * @TODO 处理不带 id 参数的 GET 查询请求，跳页面
	 * @return 进入 添加用户页面  /user/new
	 */
    public String editNew() {
    	model = new User();
    	return "add";
    }
    
    /**
     * @TODO 处理不带 id 参数的 POST 请求 
     * @TODO 增加用户，表单提交的action /user
     */
    public HttpHeaders create() 
    { 
        // 保存用户
        userService.insert(model); 
        addActionMessage("添加用户成功"); 
        return new DefaultHttpHeaders("success").disableCaching();
    }
    
    
    
    
    
    /**
    * @TODO 处理带 id 参数的 DELETE 请求，这个请求需要在jsp页面加点东西
    * @return 删除用户成功页面， /user/1
    */
    public String destroy() {
        userService.deleteById(id);
        addActionMessage("删除用户成功");
        return "success";
    } 
    
    
    
    /**
     * @TODO 处理带 id 参数的 GET 查询请求，负责跳页面
     * @return 进入 编辑特定用户页面 /user/2/edit
     */
    public String edit() {
    	return "edit";
    }
    /**
     * @TODO 处理带 id 参数的 PUT 请求, 这个请求需要在jsp页面加点东西 
     * @return 更新用户成功页面，提交表单action /user/1
     */
    public String update() {
        userService.insert(model);
        addActionMessage("用户更新成功");
        return "success";
    }
    
    
    
    /**
	 * @TODO 处理不带 id 参数的 GET 查询请求
	 * @return 进入首页 /user, index是默认方法，不是execute了
	 */
    public HttpHeaders index() {
    	list = userService.selectUsers();
    	//映射到WEB-INF/content/user-index.jsp上，jsp名称是  控制器-方法名
    	return new DefaultHttpHeaders("index").disableCaching();
    }
    
    /**
	 * @TODO 处理带 id 参数的 GET 查询请求，查单个user
	 * @return 进入 /user/2
	 */
    public HttpHeaders show() {
    	
    	return new DefaultHttpHeaders("show").setLocationId(id);
    }
    

}
