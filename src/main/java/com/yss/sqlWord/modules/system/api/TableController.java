package com.yss.sqlWord.modules.system.api;

import com.yss.sqlWord.modules.common.dto.output.ApiResult;
import com.yss.sqlWord.modules.system.service.ITableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class TableController  {

    @Autowired
    ITableService tableService;

    @GetMapping(value = "/tableToWord", name = "导出数据库表信息生成Word")
    public ApiResult tableToWord() {
        try {
            return ApiResult.ok("导出数据库表信息生成Word成功", tableService.getTableInfo());
        } catch (Exception e) {
            log.error("导出数据库表信息生成Word失败", e);
            return ApiResult.fail(e.getMessage());
        }
    }
}
