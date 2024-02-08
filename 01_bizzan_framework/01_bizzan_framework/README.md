环境搭建概要步骤：

1、准备mysql数据库，创建名称为“bizzan”的数据库
2、准备redis缓存数据库
3、准备kafka流式处理环境（先配置运行zookper，接着配置运行kafka）
4、准备mongodb数据库环境，创建用户admin、bizzan，创建bitrade数据库
5、准备nginx，修改配置文件
6、修改framework代码中的配置文件为准备环境配置参数
7、编译生成jar可执行文件
8、运行cloud.jar（微服务注册中心）
9、运行market.jar（行情中心）
10、运行exchange.jar（交易中心）
11、运行ucenter.jar（用户中心）
12、运行其他模块
13、打开mysql，导入framework代码中的sql文件夹中xxxxxxx.sql文件，注意，trigger的sql如果报错，需要针对wallet表添加trigger
14、运行前端vue项目
15、运行后端vue项目
16、运行钱包


注意事项：
当内存不足时，在linux控制台输入top可以查看java进程占用了大量内存（一个java进程占用1G以上），因为有很多jar包需要运行，所以需要控制某些jar包使用的内存，目前控制以下4个：

java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k  admin-api.jar
java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k  cloud.jar
java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k  wallet.jar
java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k  activity.jar