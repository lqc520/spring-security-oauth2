package cn.lqcnb.oauth2.resource.controller;

import cn.lqcnb.oauth2.resource.domain.TbContent;
import cn.lqcnb.oauth2.resource.dto.ResponseResult;
import cn.lqcnb.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @GetMapping("/")
    public ResponseResult<List<TbContent>> list(){
        return new ResponseResult<List<TbContent>>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),tbContentService.selectAll());
    }
}
