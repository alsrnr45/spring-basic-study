package org.basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

// 생성시점에 한번만 생성되는 프로토타입 -> 프로토타입으로서의 의미는 크게 없음.
// 사용할때마다 새로운 빈 생성을 원하면 다른 방식으로 해야함.
class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();

        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void addCount(){
            count++;
        }

        @PostConstruct
        public void init(){
            System.out.println("init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
    static class ClientBean {


        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean){
            this.prototypeBean = prototypeBean;
        }

        public int logic(){
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

    }
}
