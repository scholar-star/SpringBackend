package hello.core.lifecycle;

import jakarta.annotation.PostConstruct; // java 지원
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.naming.InitialContext;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: "+url);
    }

    public void call(String message) {
        System.out.println("call: "+url+" message = "+message);
    }

    // 서비스 종료 시 호출
    public void disConnect() {
        System.out.println("close: "+url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지"); // 초기화 과정 콜백
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disConnect(); // 소멸 과정 콜백
    }
}
