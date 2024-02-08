<template>
 <div>
   <!-- 待优化 2018年4月16日15:33:35 -->
    <Card>
      <p slot="title">
        预测合约交易对
        <Button type="primary" size="small" @click="refreshPageManual">
          <Icon type="refresh"></Icon>刷新
        </Button>
      </p>
      <Row class="functionWrapper" style='padding:0px 8px 8px 8px'>
        <Col span="24">
          <div class="searchWrapper" style="float:left;">
              <div style="float: left" class="clearfix">
                <div class="poptip">选择交易对：</div>
                <Select  v-model="searchForm.symbol" style="width:120px">
                    <Option v-for="item in coinList" :value="item.symbol" :key="item.symbol">{{ item.symbol }}</Option>
                </Select>
              </div>
              <div class="poptip" style="margin-left: 15px;">
                  <Input placeholder="用户ID" v-model="searchForm.memberId" /></Input>
              </div>
              <div class="poptip">
                  <Input placeholder="投注额" v-model="searchForm.betAmount" /></Input>
              </div>
              <div class="poptip">
                  <Input placeholder="获奖额" v-model="searchForm.rewardAmount" /></Input>
              </div>
              <div class="btns">
                  <Button type="info" @click="search">搜索</Button>
              </div>
          </div>
        </Col>
      </Row>
      <Table
        border
        :columns="columns"
        :data="optionOrderList"
        @on-selection-change="selected"
        :loading="ifLoading">
      </Table>

      <Row class="pageWrapper">
        <Page
        :total="pageNum"
        class="buttomPage"
        :current="currentPage"
        @on-change="changePage"
        show-elevator></Page>
      </Row>
      <p style="font-size:11px;">注意1：</p>
    </Card>
 </div>
</template>


 <script>
import dtime from 'time-formater'
import { queryOptionCoinList, queryOptionOrderList } from '@/service/getData'

export default {
  data() {
    return {
      ifLoading: true,
      pageNum: 1,
      currentPage: 1,
      searchForm: {
        symbol: null,
        memberId: null,
        betAmount: null,
        rewardAmount: null,
        pageNo: 1,
        pageSize: 10
      },
      optionOrderList: [],
      columns: [
        {
          title: '用户ID',
          key:"memberId"
        },
        {
          title: "交易对",
          width: 100,
          key: "symbol",
          render: (h, params) => {
            const row = params.row;
            return h("div", {
                style:{
                  textAlign: "left"
                }
              }, [
                h("span", {style:{fontWeight:"bold"}}, row.symbol)
              ]);
          }
        },
        {
          title: '期数',
          key:"maxOptionNo",
          render: (h, params) => {
            const row = params.row;
            return h("div", {}, [
                h("span", {style:{}}, "第 " + row.optionNo + " 期")
              ]);
          }
        },
        {
          title: "方向",
          key: "status",
          render: (h, params) => {
            const row = params.row;
            var txt = "投注中";
            var color = "#42b983";
            if(row.direction == "BUY") {
              txt = "涨";
              color = "#42b983";
            }else{
              txt = "跌";
              color = "#FF0000";
            }
            
            return h("span", {
              style:{
                  color:color
                }
            }, txt);
          }
        },
        {
          title: "开奖结果",
          key: "result",
          render: (h, params) => {
            const row = params.row;
            var txt = "-";
            var color = "#999";
            if(row.result == "WAIT") {
              txt = "-";
              color = "#999";
            }
            if(row.result == "WIN") {
              txt = "涨";
              color = "#42b983";
            }
            if(row.result == "LOSE") {
              txt = "跌";
              color = "#FF0000";
            }
            if(row.result == "TIED") {
              txt = "平";
              color = "#999";
            }
            return h("span", {
              style:{
                  color:color
                }
            }, txt);
          }
        },
        {
          title: '投注额',
          key:"betAmount"
        },
        {
          title: '开仓手续费',
          key:"fee"
        },
        {
          title: '奖金抽水',
          key:"winFee"
        },
        {
          title: '获奖金额',
          key:"rewardAmount"
        },
        {
          title: "状态",
          key: "status",
          render: (h, params) => {
            const row = params.row;
            var txt = "待开奖";
            if(row.status == "OPEN") txt = "待开奖";
            if(row.status == "CLOSE") txt = "已开奖";
            
            return h("span", {}, txt);
          }
        },
      ],
      coinList: []
    };
  },
  methods: {
    selected(){

    },
    getCoinList(pageIndex) {
      queryOptionCoinList({ pageNo: pageIndex, pageSize: 50}).then( res => {
        this.coinList = res.data.content;
        this.ifLoading = false;
      });
    },
    refreshPageManual(){
      this.ifLoading = true;
      this.refreshdata(this.currentPage);
    },
    refreshdata(pageIndex) {
      this.searchForm.pageNo = pageIndex;
      queryOptionOrderList(this.searchForm).then(res => {
        this.optionOrderList = res.data.content;
        this.pageNum = res.data.totalElements;
        this.ifLoading = false;
      });
    },
    addCoinClick(){

    },
    changePage() {},
    search() {
      this.refreshdata(1);
    }
  },
  created() {
    this.getCoinList(1);
    this.refreshdata(1);
  }
};
</script>

<style lang="less" scoped>
  .auditModel{
    ul {
      padding-left: 20px;
      li {
        position: relative;
        margin-bottom: 18px;
        span{
          position: absolute;
          top: 0;
          left: 0;
          display: inline-block;
          width: 95px;
          text-align: right;
          i{
            font-size: 14px;
            font-weight: 700;
            color: #ec0909;
          }
        }
        p{
          padding-left: 100px;
          min-width: 300px;
          line-height: 32px;
          em{
            position: static;
            color: unset;
          }
        }
      }
    }
  }
  .setting-title{
    font-size:14px;font-weight:bold;padding-bottom:20px;
  }
.auditModel ul li>em{
    position: absolute;
    bottom: -15px;
    font-size:10px;
    margin-left: 100px;
    line-height:12px;
    font-style: normal;
    color: #ec0909;
  }
</style>