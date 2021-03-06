package com.yss.sqlWord.modules.system.service.impl;

import com.yss.sqlWord.config.Constants;
import com.yss.sqlWord.modules.system.entity.Tables;
import com.yss.sqlWord.modules.system.mapper.TableMapper;
import com.yss.sqlWord.modules.system.service.ITableService;
import com.yss.sqlWord.utils.DateTimeUtils;
import com.yss.sqlWord.utils.TableToWordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * <p> 实现类 </p>
 *
 * @author : yss
 * @description :
 */
@Slf4j
@Service
public class TableService implements ITableService {

    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private TableToWordUtil tableToWordUtil;

    @Override
    public String getTableInfo() {
        // 1、获取数据库所有表信息
        List<Tables> tables = tableMapper.getAllTables(Constants.DATABASE);

        // 2、生成文件名信息 - 年月日时分秒
        String date = null;
        try {
            date = DateTimeUtils.dateFormat(new Date(), DateTimeUtils.PARSE_PATTERNS[12]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String docFileName = Constants.FILE_PATH + "\\" + Constants.FILE_NAME + "-" + date + ".doc";

        // 3、调用工具类生成文件
        tableToWordUtil.toWord(tables, docFileName, Constants.FILE_NAME);

        // 4、返回文件地址
        String filePath = docFileName.replaceAll("\\\\", "/");
        return filePath;
    }
}
