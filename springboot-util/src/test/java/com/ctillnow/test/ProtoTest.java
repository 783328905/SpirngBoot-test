package com.ctillnow.test;

import com.ctillnow.proto.PersonEntity;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jayway.jsonpath.internal.JsonFormatter;
import org.springframework.boot.test.json.JsonContent;

import java.util.Arrays;

/**
 * Created by caiping on 2019/10/12.
 */
public class ProtoTest {
    public static void main(String[] args) {
        PersonEntity.Person.Builder builder=  PersonEntity.Person.newBuilder();
        builder.setId(1);
        builder.setName("张三");
        builder.setEmail("783328905@qq.com");

        PersonEntity.Person person = builder.build();
        System.out.println("protobuf数据bytes[]"+ Arrays.toString(person.toByteArray()));
        System.out.println("protobuf数据大小"+person.toByteString().size());

        byte [] bytes = person.toByteArray();
        PersonEntity.Person person1 = null;
        try {
            person1 = PersonEntity.Person.parseFrom(bytes);

            System.out.println("学生Id"+person.getId());
            System.out.println("姓名"+person.getName());
            System.out.println("邮箱"+person.getEmail());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


    }


}
