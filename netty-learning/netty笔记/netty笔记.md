# netty笔记简洁版

这个可能会多给些增删改查之后的可能性

## 一、 NIO基础

面向缓冲区，NIO可以做到一个线程处理多个操作

### 1. 三大组件

### 1.1 Channel&Buffer

Channel就是一个==双向通道==，和流不同

Channel是一个==接口==，其实现类有FileChannel(==文件==)、DatagramChannel（==UDP==）、ServerSocketChannel(==服务器TCP==)和SocketChannel(==TCP==)

Buffer就是一个缓存区，是一个==内存块==，数据的==读写都通过Buffer==。

==Buffer类==最重要的是==ByteBuffer==

### 1.2 Selector

阻塞式IO下，多线程有占用内存高，线程上下文切换成本高，只适合连接少的场景；

线程池在阻塞模式下，一个线程也只能处理一个连接，且仅仅适合短连接的场景

Selector,简单讲，不要扯太高深，就是一选择器，可以==在各个通道上切换==,配合==一个线程来管理多个Channel。==适合==连接多，流量低的场景==。



