package f4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import f4.web.entity.Email;
import f4.web.service.EmailService;

@Controller
public class EmailController {

	@Autowired
    private EmailService emailService;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/email/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Email> selectRoleById(@PathVariable Integer id) {
    	Email email = new Email();
    	email.setId(id);
        return emailService.select(email);
    }
    
    /**
     * 添加
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public @ResponseBody int addRole(@RequestBody Email email) {
        return emailService.insert(email);
    }
    
    /**
     * 修改
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/email", method = RequestMethod.PUT)
    public @ResponseBody int updateRoleById(@RequestBody Email email) {
        return emailService.update(email);
    }
    
    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/email/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteRoleById(@PathVariable Integer id) {
        return emailService.deleteById(id);
    }
}
