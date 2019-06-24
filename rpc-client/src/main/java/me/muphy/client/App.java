package me.muphy.client;

import me.muphy.server.IHelloService;
import me.muphy.server.IPaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        RpcProxyClient proxyClient = new RpcProxyClient();
//        IHelloService helloService = proxyClient.clientProxy(IHelloService.class, "localhost", 8080);
//        String result = helloService.sayHello("Muphy");
//        System.out.println(result);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient client = context.getBean(RpcProxyClient.class);

        IHelloService helloService = client.clientProxy(IHelloService.class, "localhost", 8080);
        String s = helloService.sayHello("hhhh");
        System.out.println(s);

        IPaymentService paymentService = client.clientProxy(IPaymentService.class, "localhost", 8080);
        String r = paymentService.doPay();
        System.out.println(r);

    }
}
