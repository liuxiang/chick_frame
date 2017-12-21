# 启动异常,注意检查`dubbo-server`是否启动
```$xslt
com.alibaba.dubbo.remoting.RemotingException: client(url: dubbo://localhost:2183/com.alibaba.dubbo.registry.RegistryService?application=thirdApp&callbacks=10000&check=false&codec=dubbo&connect.timeout=10000&dubbo=2.5.8&heartbeat=60000&interface=com.alibaba.dubbo.registry.RegistryService&lazy=true&methods=lookup,subscribe,unsubscribe,unregister,register&pid=10439&reconnect=false&register=false&remote.timestamp=1513692321557&send.reconnect=true&sticky=true&subscribe.1.callback=true&timeout=10000&timestamp=1513692321557&unsubscribe.1.callback=false) failed to connect to server localhost/127.0.0.1:2183, error message is:Connection refused
```

# client端通过dubbo协议,直连访问异常
```$xslt
{
    "timestamp": 1513693774910,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "com.alibaba.dubbo.rpc.RpcException",
    "message": "Failed to invoke remote method: queryConnrty, provider: dubbo://localhost:20880/me.liuxiang.chick.client.dubbo.country.CountryService?application=thirdApp&dubbo=2.5.8&interface=me.liuxiang.chick.client.dubbo.country.CountryService&methods=queryConnrty&pid=10724&register.ip=10.57.242.44&side=consumer&timestamp=1513693763122, cause: Failed to send message Request [id=0, version=2.0.0, twoway=true, event=false, broken=false, data=RpcInvocation [methodName=queryConnrty, parameterTypes=[class me.liuxiang.chick.client.dubbo.country.object.CountryDO], arguments=[me.liuxiang.DubboController$1@5853b28e], attachments={path=me.liuxiang.chick.client.dubbo.country.CountryService, interface=me.liuxiang.chick.client.dubbo.country.CountryService, version=0.0.0}]] to /10.57.242.44:20880, cause: Serialized class me.liuxiang.DubboController$1 must implement java.io.Serializable",
    "path": "/queryContry"
}
```
原因:需要继承序列化 `implement java.io.Serializable`

# service端接收到消息,处理后返回异常:断点调试导致超时
```$xslt
{
    "timestamp": 1513694995573,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "com.alibaba.dubbo.rpc.RpcException",
    "message": "Invoke remote method timeout. method: queryConnrty, provider: dubbo://localhost:20880/me.liuxiang.chick.client.dubbo.country.CountryService?application=thirdApp&dubbo=2.5.8&interface=me.liuxiang.chick.client.dubbo.country.CountryService&methods=queryConnrty&pid=10929&register.ip=10.57.242.44&side=consumer&timestamp=1513694899169, cause: Waiting server-side response timeout by scan timer. start time: 2017-12-19 22:49:54.567, end time: 2017-12-19 22:49:55.568, client elapsed: 2 ms, server elapsed: 999 ms, timeout: 1000 ms, request: Request [id=4, version=2.0.0, twoway=true, event=false, broken=false, data=RpcInvocation [methodName=queryConnrty, parameterTypes=[], arguments=[], attachments={path=me.liuxiang.chick.client.dubbo.country.CountryService, interface=me.liuxiang.chick.client.dubbo.country.CountryService, version=0.0.0}]], channel: /10.57.242.44:50125 -> /10.57.242.44:20880",
    "path": "/queryContry"
}
```
原因:远程调用超时`Invoke remote method timeout`

# service端接收到消息,处理后返回异常:序列化异常
```$xslt
{
    "timestamp": 1513695166699,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "com.alibaba.dubbo.rpc.RpcException",
    "message": "Failed to invoke remote method: queryConnrty, provider: dubbo://localhost:20880/me.liuxiang.chick.client.dubbo.country.CountryService?application=thirdApp&dubbo=2.5.8&interface=me.liuxiang.chick.client.dubbo.country.CountryService&methods=queryConnrty&pid=10929&register.ip=10.57.242.44&side=consumer&timestamp=1513694899169, cause: Failed to send response: Response [id=8, version=2.0.0, status=20, event=false, error=null, result=RpcResult [result=[me.liuxiang.chick.dubbo.country.CountryServiceImpl$2@ea56895, me.liuxiang.chick.dubbo.country.CountryServiceImpl$2@4ba7e725, me.liuxiang.chick.dubbo.country.CountryServiceImpl$2@2789879f, me.liuxiang.chick.dubbo.country.CountryServiceImpl$2@7aa66c6d, me.liuxiang.chick.dubbo.country.CountryServiceImpl$2@5f62526c], exception=null]], cause: java.lang.RuntimeException: Serialized class me.liuxiang.mysql.model.Country must implement java.io.Serializable\n Java field: final me.liuxiang.mysql.model.Country me.liuxiang.chick.dubbo.country.CountryServiceImpl$2.val$country1\njava.lang.RuntimeException: Serialized class me.liuxiang.mysql.model.Country must implement java.io.Serializable\n Java field: final me.liuxiang.mysql.model.Country me.liuxiang.chick.dubbo.country.CountryServiceImpl$2.val$country1\n\tat com.alibaba.com.caucho.hessian.io.JavaSerializer$FieldSerializer.serialize(JavaSerializer.java:296)\n\tat com.alibaba.com.caucho.hessian.io.JavaSerializer.writeInstance(JavaSerializer.java:276)\n\tat com.alibaba.com.caucho.hessian.io.JavaSerializer.writeObject(JavaSerializer.java:243)\n\tat com.alibaba.com.caucho.hessian.io.Hessian2Output.writeObject(Hessian2Output.java:383)\n\tat com.alibaba.com.caucho.hessian.io.CollectionSerializer.writeObject(CollectionSerializer.java:98)\n\tat com.alibaba.com.caucho.hessian.io.Hessian2Output.writeObject(Hessian2Output.java:383)\n\tat com.alibaba.dubbo.common.serialize.support.hessian.Hessian2ObjectOutput.writeObject(Hessian2ObjectOutput.java:79)\n\tat com.alibaba.dubbo.rpc.protocol.dubbo.DubboCodec.encodeResponseData(DubboCodec.java:193)\n\tat com.alibaba.dubbo.remoting.exchange.codec.ExchangeCodec.encodeResponse(ExchangeCodec.java:269)\n\tat com.alibaba.dubbo.remoting.exchange.codec.ExchangeCodec.encode(ExchangeCodec.java:70)\n\tat com.alibaba.dubbo.rpc.protocol.dubbo.DubboCountCodec.encode(DubboCountCodec.java:39)\n\tat com.alibaba.dubbo.remoting.transport.netty.NettyCodecAdapter$InternalEncoder.encode(NettyCodecAdapter.java:81)\n\tat org.jboss.netty.handler.codec.oneone.OneToOneEncoder.handleDownstream(OneToOneEncoder.java:66)\n\tat org.jboss.netty.channel.DefaultChannelPipeline.sendDownstream(DefaultChannelPipeline.java:591)\n\tat org.jboss.netty.channel.DefaultChannelPipeline$DefaultChannelHandlerContext.sendDownstream(DefaultChannelPipeline.java:776)\n\tat org.jboss.netty.channel.SimpleChannelHandler.writeRequested(SimpleChannelHandler.java:304)\n\tat com.alibaba.dubbo.remoting.transport.netty.NettyHandler.writeRequested(NettyHandler.java:99)\n\tat org.jboss.netty.channel.SimpleChannelHandler.handleDownstream(SimpleChannelHandler.java:266)\n\tat org.jboss.netty.channel.DefaultChannelPipeline.sendDownstream(DefaultChannelPipeline.java:591)\n\tat org.jboss.netty.channel.DefaultChannelPipeline.sendDownstream(DefaultChannelPipeline.java:582)\n\tat org.jboss.netty.channel.Channels.write(Channels.java:611)\n\tat org.jboss.netty.channel.Channels.write(Channels.java:578)\n\tat org.jboss.netty.channel.AbstractChannel.write(AbstractChannel.java:251)\n\tat com.alibaba.dubbo.remoting.transport.netty.NettyChannel.send(NettyChannel.java:98)\n\tat com.alibaba.dubbo.remoting.transport.AbstractPeer.send(AbstractPeer.java:54)\n\tat com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler.received(HeaderExchangeHandler.java:171)\n\tat com.alibaba.dubbo.remoting.transport.DecodeHandler.received(DecodeHandler.java:52)\n\tat com.alibaba.dubbo.remoting.transport.dispatcher.ChannelEventRunnable.run(ChannelEventRunnable.java:81)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n\tat java.lang.Thread.run(Thread.java:748)\nCaused by: java.lang.IllegalStateException: Serialized class me.liuxiang.mysql.model.Country must implement java.io.Serializable\n\tat com.alibaba.com.caucho.hessian.io.SerializerFactory.getDefaultSerializer(SerializerFactory.java:400)\n\tat com.alibaba.com.caucho.hessian.io.SerializerFactory.getSerializer(SerializerFactory.java:374)\n\tat com.alibaba.com.caucho.hessian.io.Hessian2Output.writeObject(Hessian2Output.java:381)\n\tat com.alibaba.com.caucho.hessian.io.JavaSerializer$FieldSerializer.serialize(JavaSerializer.java:294)\n\t... 30 more\n",
    "path": "/queryContry"
}
```
原因:未序列化
```youtrack
java.lang.IllegalStateException: Serialized class me.liuxiang.mysql.model.Country must implement java.io.Serializable
```
- CountryServiceImpl序列化异常
```youtrack
java.lang.IllegalStateException: Serialized class me.liuxiang.chick.dubbo.country.CountryServiceImpl must implement java.io.Serializable
```
疑惑: 
`Country`对象并没有参与网络的`入参或出参`为什么也需要序列化要求.
[猜测错误]猜测`dubbo`会将整个实现类`CountryServiceImpl`都进行序列化回传客户端,所以需要此类中用到的所有对象都需要支持序列化.

原因: java中this指向的误解.
```youtrack
@Override
public List<CountryDO> queryConnrty(CountryDO countryDO) {
    Country country = new Country() {{
        if (countryDO != null) {
            BeanUtils.copyProperties(countryDO, this);
        }
    }};

    List<CountryDO> countryDOS = new ArrayList<CountryDO>();
    for (Country country1 : countryMapper.select(country)) {
        countryDOS.add(new CountryDO() {{
            BeanUtils.copyProperties(country1, this);//此this是CountryServiceImpl,而非CountryDO
        }});
    }

    return countryDOS;
}
```

# 请求参数,报序列化异常
```youtrack
return countryService.queryConnrty(new CountryDO(){{
}});
```
```youtrack
{
    "timestamp": 1513748659562,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "com.alibaba.dubbo.rpc.RpcException",
    "message": "Failed to invoke remote method: queryConnrty, provider: dubbo://localhost:20880/me.liuxiang.chick.client.dubbo.country.CountryService?application=thirdApp&dubbo=2.5.8&interface=me.liuxiang.chick.client.dubbo.country.CountryService&methods=queryConnrtyJson,queryConnrty&pid=13271&register.ip=10.57.242.44&side=consumer&timestamp=1513748487937, cause: Failed to send message Request [id=12, version=2.0.0, twoway=true, event=false, broken=false, data=RpcInvocation [methodName=queryConnrty, parameterTypes=[class me.liuxiang.chick.client.dubbo.country.object.CountryDO], arguments=[me.liuxiang.DubboController$1@12c25995], attachments={path=me.liuxiang.chick.client.dubbo.country.CountryService, interface=me.liuxiang.chick.client.dubbo.country.CountryService, version=0.0.0}]] to /10.57.242.44:20880, cause: Serialized class me.liuxiang.DubboController must implement java.io.Serializable\n Java field: final me.liuxiang.DubboController me.liuxiang.DubboController$1.this$0",
    "path": "/queryContry2"
}
```
原因:匿名类中会自动包含`当前类`信息,而当前类非序列化类,导致异常
`new CountryDO(){{}}`不等同于`new CountryDO()`,而是会在原类基础上添加`<当前类>`的对象.导致当前类也参与到序列化过程中.
解决:`new CountryDO();`使用即可.