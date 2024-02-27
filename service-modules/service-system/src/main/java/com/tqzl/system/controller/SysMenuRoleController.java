package com.tqzl.system.controller;

import com.tqzl.core.model.CommonResult;
import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.domain.SysMenuVO;
import com.tqzl.system.domain.SysRoleVO;
import com.tqzl.system.handler.MenuRoleHandler;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:35]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Api("菜单角色信息")
@RestController
@RequestMapping("/sys")
public class SysMenuRoleController {

    private final MenuRoleHandler menuRoleHandler;

    public SysMenuRoleController(MenuRoleHandler menuRoleHandler) {
        this.menuRoleHandler = menuRoleHandler;
    }

    @GetMapping("/menu/{id}")
    public CommonResult queryMenuById(@PathVariable("id") int id){
        SysMenuVO sysMenuVO = menuRoleHandler.queryMenuById(id);
        return CommonResult.success(sysMenuVO);
    }

    @PostMapping(value = "/deleteMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult deleteMenuById(@RequestParam int id){
        int flag = menuRoleHandler.deleteMenuById(id);
        return flag > 0 ? CommonResult.success("更新成功!") : CommonResult.error("更新失败");
    }

    @GetMapping("/menuRole/{id}")
    public CommonResult queryMenuRoleById(@PathVariable("id") int id){
        SysMenuRoleVO sysMenuRoleVO = menuRoleHandler.queryMenuRoleById(id);
        return CommonResult.success(sysMenuRoleVO);
    }

    @PostMapping(value = "/deleteMenuRole" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult deleteMenuRoleById(@RequestParam int id){
        int flag = menuRoleHandler.deleteMenuRoleById(id);
        return flag > 0 ? CommonResult.success("更新成功!") : CommonResult.error("更新失败");
    }

    @GetMapping("/role/{id}")
    public CommonResult queryRoleByRoleId(@PathVariable("id") int id){
        SysRoleVO sysRoleVO = menuRoleHandler.queryRoleByRoleId(id);
        return CommonResult.success(sysRoleVO);
    }

    @PostMapping(value = "/deleteRole" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult deleteRoleByRoleId(int id){
        int flag = menuRoleHandler.deleteRoleByRoleId(id);
        return flag > 0 ? CommonResult.success("更新成功!") : CommonResult.error("更新失败");
    }

}
