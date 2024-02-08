# wallet-rpc

#### 项目介绍
支持各个币种的RPC,RPC的部署及测试都需要有相关钱包节点的支撑
(缺失jar包在jar文件夹中)


####
模块说明

1.act

* act币种RPC

2.bitcoin

* BTC币种RPC

3.ect

* ect币种RPC

4.erc-token

* 基于以太坊的token
* 部署时，eth模块必须先部署
* 如果有多个token，修改配置文件中的coin.name，coin.unit再部署一个

5.eth

* 以太坊相关RPC

6.eth-support

* 对以太坊及其token提供支持

7.rpc-common

* 公共模块

8.usdt

* usdt币种RPC