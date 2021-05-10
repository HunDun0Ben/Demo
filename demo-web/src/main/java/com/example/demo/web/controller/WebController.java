package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xml")
public class WebController {

    @ResponseBody
    @RequestMapping(value = "/demo")
    public String xmlString(){
        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soapenv:Header>\n" +
                "        <_0:MsgDetl xmlns:_0=\"http://schemas.dbs.com/soi/common/4_0\" xmlns:_01=\"http://schemas.dbs.com/soi/retrieveAccountHolderDetails/6_0\" xmlns:_02=\"http://schemas.dbs.com/soi/common/6_0\" xmlns:_03=\"http://schemas.dbs.com/soi/common/4_1\" mustUnderstand=\"false\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "            <_0:MsgVersion>6.0</_0:MsgVersion>\n" +
                "            <_0:MsgUID>8698c612-3a45-4bb1-9aa3-47c59a4df288</_0:MsgUID>\n" +
                "            <_0:SvcVersion>6.0.0</_0:SvcVersion>\n" +
                "        </_0:MsgDetl>\n" +
                "        <_0:Trace xmlns:_0=\"http://schemas.dbs.com/soi/common/4_0\" xmlns:_01=\"http://schemas.dbs.com/soi/retrieveAccountHolderDetails/6_0\" xmlns:_02=\"http://schemas.dbs.com/soi/common/6_0\" xmlns:_03=\"http://schemas.dbs.com/soi/common/4_1\" mustUnderstand=\"false\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "            <_0:RqDateTime>2021-04-12T12:35:51.455+08:00</_0:RqDateTime>\n" +
                "            <_0:RqClient>\n" +
                "                <_0:RqClientId>CIBP</_0:RqClientId>\n" +
                "                <_0:RqClientOrg>0001</_0:RqClientOrg>\n" +
                "                <_0:RqClientCtry>SG</_0:RqClientCtry>\n" +
                "            </_0:RqClient>\n" +
                "            <_0:Operator>\n" +
                "                <_0:OpRole>SYSTEM</_0:OpRole>\n" +
                "            </_0:Operator>\n" +
                "        </_0:Trace>\n" +
                "    </soapenv:Header>\n" +
                "    <soapenv:Body>\n" +
                "        <ns0:retrieveAccountHolderDetailsResponse xmlns:ns0=\"http://schemas.dbs.com/soi/retrieveAccountHolderDetails/6_0\">\n" +
                "            <ns1:CommonRs xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">\n" +
                "                <ns1:OrgCode>0001</ns1:OrgCode>\n" +
                "            </ns1:CommonRs>\n" +
                "            <_01:InqAcctId xmlns:_01=\"http://schemas.dbs.com/soi/retrieveAccountHolderDetails/6_0\" xmlns:_0=\"http://schemas.dbs.com/soi/common/4_0\" xmlns:_02=\"http://schemas.dbs.com/soi/common/6_0\" xmlns:_03=\"http://schemas.dbs.com/soi/common/4_1\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "                <_03:ProdType>CA</_03:ProdType>\n" +
                "                <_03:AcctId>00029064350003</_03:AcctId>\n" +
                "            </_01:InqAcctId>\n" +
                "            <ns0:AcctDetl>\n" +
                "                <ns1:DepAcctId xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">\n" +
                "                    <ns1:ProdType>CA</ns1:ProdType>\n" +
                "                    <ns1:ProdCode>0020</ns1:ProdCode>\n" +
                "                    <ns1:AcctId>00029064350003</ns1:AcctId>\n" +
                "                    <ns1:AcctCur>SGD</ns1:AcctCur>\n" +
                "                    <ns1:OrgCode>0001</ns1:OrgCode>\n" +
                "                </ns1:DepAcctId>\n" +
                "                <ns1:AcctStatus xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">01</ns1:AcctStatus>\n" +
                "                <ns1:AcctSignal xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">01</ns1:AcctSignal>\n" +
                "                <ns0:AcctType>05</ns0:AcctType>\n" +
                "                <ns1:AcctSignType xmlns:ns1=\"http://schemas.dbs.com/soi/common/6_0\">00</ns1:AcctSignType>\n" +
                "                <ns1:AcctName xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">HUA SIN ENGINEERING PTE LTD</ns1:AcctName>\n" +
                "                <ns1:BOA xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">0002</ns1:BOA>\n" +
                "                <ns0:AcctAddrDetl>\n" +
                "                    <ns1:AcctAddrId xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">\n" +
                "                        <ns1:AcctAddrCISId>\n" +
                "                            <ns1:CISAddrCustId>\n" +
                "                                <ns1:CISCIN>C308172011G</ns1:CISCIN>\n" +
                "                                <ns1:CISCINsfx>00</ns1:CISCINsfx>\n" +
                "                            </ns1:CISAddrCustId>\n" +
                "                            <ns1:CISAddrType>OFF</ns1:CISAddrType>\n" +
                "                        </ns1:AcctAddrCISId>\n" +
                "                    </ns1:AcctAddrId>\n" +
                "                    <ns0:AcctAddr>\n" +
                "                        <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">CHIN SWEE ROAD</ns1:AddrLine>\n" +
                "                        <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\"> </ns1:AddrLine>\n" +
                "                        <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\"> </ns1:AddrLine>\n" +
                "                        <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\"> </ns1:AddrLine>\n" +
                "                        <ns1:Block xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">52</ns1:Block>\n" +
                "                        <ns1:Level xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">02</ns1:Level>\n" +
                "                        <ns1:Unit xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">51</ns1:Unit>\n" +
                "                        <ns1:PostalCode xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">160052</ns1:PostalCode>\n" +
                "                        <ns1:Ctry xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">702</ns1:Ctry>\n" +
                "                    </ns0:AcctAddr>\n" +
                "                    <ns1:LastUpdDate xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">2016-03-28</ns1:LastUpdDate>\n" +
                "                    <ns1:LastUpdMainUnit xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">0002</ns1:LastUpdMainUnit>\n" +
                "                    <ns1:LastUpdId xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">MIGRATION</ns1:LastUpdId>\n" +
                "                    <ns0:FormattedAddr>BLK 52 CHIN SWEE ROAD</ns0:FormattedAddr>\n" +
                "                    <ns0:FormattedAddr>#02-51 SINGAPORE 160052</ns0:FormattedAddr>\n" +
                "                </ns0:AcctAddrDetl>\n" +
                "                <ns0:AcctHolderDetl>\n" +
                "                    <ns1:CISInternalId xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">\n" +
                "                        <ns1:CISCIN>C308172011G</ns1:CISCIN>\n" +
                "                        <ns1:CISCINsfx>00</ns1:CISCINsfx>\n" +
                "                    </ns1:CISInternalId>\n" +
                "                    <ns1:CMCPId xmlns:ns1=\"http://schemas.dbs.com/soi/common/6_0\">C181H8265H</ns1:CMCPId>\n" +
                "                    <ns0:JointInd>false</ns0:JointInd>\n" +
                "                    <ns1:CustName xmlns:ns1=\"http://schemas.dbs.com/soi/common/6_0\">\n" +
                "                        <ns1:FullName>HUA SIN ENGINEERING PTE. LTD. </ns1:FullName>\n" +
                "                        <ns1:Salutation/>\n" +
                "                        <ns1:RegisteredName>HUA SIN ENGINEERING PTE. LTD.</ns1:RegisteredName>\n" +
                "                    </ns1:CustName>\n" +
                "                    <ns0:CustAddrDetl>\n" +
                "                        <ns0:AddrType>RES</ns0:AddrType>\n" +
                "                        <ns0:CustAddr>\n" +
                "                            <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">CHIN SWEE ROAD</ns1:AddrLine>\n" +
                "                            <ns1:Block xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">52</ns1:Block>\n" +
                "                            <ns1:Level xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">02</ns1:Level>\n" +
                "                            <ns1:Unit xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">51</ns1:Unit>\n" +
                "                            <ns1:PostalCode xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">160052</ns1:PostalCode>\n" +
                "                            <ns1:City xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\"/>\n" +
                "                            <ns1:Ctry xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">702</ns1:Ctry>\n" +
                "                            <ns1:CtryDesc xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">SINGAPORE</ns1:CtryDesc>\n" +
                "                        </ns0:CustAddr>\n" +
                "                        <ns0:FormattedAddr>BLK 52 CHIN SWEE ROAD</ns0:FormattedAddr>\n" +
                "                        <ns0:FormattedAddr>#02-51 SINGAPORE 160052</ns0:FormattedAddr>\n" +
                "                    </ns0:CustAddrDetl>\n" +
                "                    <ns0:CustAddrDetl>\n" +
                "                        <ns0:AddrType>MAIL</ns0:AddrType>\n" +
                "                        <ns0:CustAddr>\n" +
                "                            <ns1:AddrLine xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">CHIN SWEE ROAD</ns1:AddrLine>\n" +
                "                            <ns1:Block xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">52</ns1:Block>\n" +
                "                            <ns1:Level xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">02</ns1:Level>\n" +
                "                            <ns1:Unit xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">51</ns1:Unit>\n" +
                "                            <ns1:PostalCode xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">160052</ns1:PostalCode>\n" +
                "                            <ns1:City xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\"/>\n" +
                "                            <ns1:Ctry xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">702</ns1:Ctry>\n" +
                "                            <ns1:CtryDesc xmlns:ns1=\"http://schemas.dbs.com/soi/common/4_1\">SINGAPORE</ns1:CtryDesc>\n" +
                "                        </ns0:CustAddr>\n" +
                "                        <ns0:FormattedAddr>BLK 52 CHIN SWEE ROAD</ns0:FormattedAddr>\n" +
                "                        <ns0:FormattedAddr>#02-51 SINGAPORE 160052</ns0:FormattedAddr>\n" +
                "                    </ns0:CustAddrDetl>\n" +
                "                </ns0:AcctHolderDetl>\n" +
                "            </ns0:AcctDetl>\n" +
                "        </ns0:retrieveAccountHolderDetailsResponse>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return a;
    }

}

