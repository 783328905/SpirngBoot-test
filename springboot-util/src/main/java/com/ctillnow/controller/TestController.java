package com.ctillnow.controller;

import com.ctillnow.proto.BINlapArticleMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiping on 2019/10/17.
 */

@RestController
public class TestController {

    @RequestMapping(value = "/test",produces = "application/x-protobuf")
    @ResponseBody
    public BINlapArticleMessage.BINlapArticleResponse getArticleProto(@RequestBody BINlapArticleMessage.BINlpArticleRequest messageRequest){
        BINlapArticleMessage.BINlapArticleResponse.Builder builder = BINlapArticleMessage.BINlapArticleResponse.newBuilder();
        BINlapArticleMessage.BaseResponse baseResponse= BINlapArticleMessage.BaseResponse.newBuilder().setErrorCode(200).setErrorMessage("null").setHintMessage("success").build();
        BINlapArticleMessage.BIArticleParagraph paragraph = BINlapArticleMessage.BIArticleParagraph.newBuilder().setTitle("华为").setSource("新华网").setSummary("heeh")
                .setBiArticleId("1111").setSourceArticleId("111").build();
        BINlapArticleMessage.BIArticleParagraph paragraph1 = BINlapArticleMessage.BIArticleParagraph.newBuilder().setTitle("小米").setSource("央视网").setSummary("heeh")
                .setBiArticleId("1111").setSourceArticleId("111").build();


        System.out.println(messageRequest.getCityId());
        builder.setCityName("上海");
        builder.setFullContent("hello world");
        builder.setResponse(baseResponse);


        builder.addParagraph(paragraph);
        builder.addParagraph(paragraph1);



        return builder.build();



    }
}
