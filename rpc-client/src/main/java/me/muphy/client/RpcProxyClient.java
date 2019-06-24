package me.muphy.client;

import java.lang.reflect.Proxy;

/**
 * 2019/6/12
 * 莫非
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaces, final String host, final int port){
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class<?>[]{interfaces}, new RemoteInvocationHandler(host, port));
    }

}
