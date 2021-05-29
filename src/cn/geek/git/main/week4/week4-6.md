# 多线程

## 相关类

### Thread

#### target(Runnable):run没有返回值

#### start

#### sleep:静态方法让出CPU时间片

#### join：等待某个线程执行完毕

#### Object#wait&notify/notifyAll：释放当前对象的锁，等待被唤醒

### Callable

#### call：有返回值

### Future：ExecutorService.submit方法返回类，通过该类可以在任务线程中捕捉异常

#### get

#### get(long, TimeUnit)

#### cancel(boolean)

#### isCancelled

#### isDone

### Condition:Lock.newCondition创建

#### void await/boolean await(long, TimeUnit) throw InterrruptedException：等待信号

#### void awaitUninterruptibly

#### boolean awaiUntill(Date)

#### signal/signalAll：类似notify/notifyAll

### LockSupport

#### park

#### unpark(Thread)

## 线程池

### 作用

#### 1、降低资源消耗，无需重复创建和销毁线程资源

#### 2、提升响应速度，减少等待线程创建的时间

#### 3、提供线程的统一管理

### Executor：执行者

#### execute：捕捉不到异常

#### submit：返回Future，可以在主线程中捕捉异常

### ExecutorService

#### shutdown：关闭线程池（停止接受新任务，原任务继续）

#### shutdownNow：立即停止，原任务也停止

#### awaitTermination：阻塞当前线程，返回线程池是否成功关闭

### ThreadFactory

### ThreadPoolExecutor

#### corePoolSize

#### BlockingQueue：双缓冲队列

##### ArrayBlockingQueue：规定大小，FIFO

##### LinkedBlockingQueue:不规定大小，FIFO

##### PriorityBlockingQueue:类似LinkedBlockingQueue，但是排序是按照自然对象或Comparator

#### 拒绝策略

##### AbortPolicy:丢弃任务并抛出异常

##### DiscardPolicy：丢弃但不抛出异常

##### DiscardOldestPolicy:丢弃最前面的任务，重新提交被拒绝的任务

##### callerRunsPolicy：由提交任务的线程执行任务，可以缓解线程池压力

## 线程安全

### 关键字

#### volatile

##### 可见性：保证值的修改会立即更新到主存，但不能保证原子性

##### 部分有序性：前后的顺序不会被重排

#### synchronized

##### 无锁

##### 偏向锁

##### 轻量级锁

##### 重量级锁

##### GC标记

#### final

##### 类不允许继承

##### 方法不允许重载

##### 局部变量不允许修改

##### 实例属性赋值后不允许变更

### 锁

#### 原因即与synchronized或wait/notify的区别

#### Lock

##### 方法

###### lock：获取锁，与synchronized(lock)类似

###### lockInterruptibly:获取锁，允许中断

###### tryLock/tryLock(long,TimeUnit)：尝试获取锁，无等待或有等待

###### unlock：释放锁

###### newCondition:新增绑定到当前Lock的条件

##### ReentrantLock

###### 可重入锁

###### 公平锁

##### ReadWriteLock

###### ReentrantReadWriteLock

####### readLock：共享锁

####### writeLock：独斥锁（也排斥读锁）

### 并发原子类

#### Atomic

##### CompareAndSwap(CAS)：乐观锁，自旋重试

#### LongAdder：归并思想，构建长度为线程数的数组，将value复制多份，最后求和

### 并发工具类

#### AbstractQueueeSynchronizer：队列同步器

#### semaphore：信号量
