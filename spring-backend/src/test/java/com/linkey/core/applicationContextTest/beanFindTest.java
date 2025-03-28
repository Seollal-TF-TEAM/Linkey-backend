//package com.linkey.core.applicationContextTest;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//@SpringBootTest
//public class beanFindTest {
//
//    @Autowired
//    AnnotationConfigApplicationContext ac ; // ✅ 패키지 스캔
//
//    @Test
//    @DisplayName("모든 빈 출력하기")
//    void findAllBean() {
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름 조회
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = ac.getBean(beanDefinitionName);// getBean(): Bean 이름으로 Bean 객체(인스턴스)를 조회
//            System.out.println("name = " + beanDefinitionName + " object: " + bean);
//        }
//    }
//
//    @Test
//    @DisplayName("애플리케이션 빈 출력하기")
//    void findApplicationBean() {
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            // getBeanDefinition(): Bean 이름으로 Bean의 메타데이터 조회
//            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//
//            // ROLE.APPLICATION: 개발자가 애플리케이션 개발을 위해 등록한 bean 또는 외부 라이브러리
//            // ROLE.INFRASTRUCTURE: 스프링 내부에서 사용하는 bean
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//                Object bean = ac.getBean(beanDefinitionName); // getBean(): Bean 이름으로 Bean 객체(인스턴스)를 조회
//                System.out.println("name = " + beanDefinitionName + " object: " + bean);
//            }
//        }
//    }
//
//}
