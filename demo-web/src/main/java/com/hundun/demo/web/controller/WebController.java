package com.hundun.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xml")
public class WebController {

    @ResponseBody
    @RequestMapping(value = "/demo")
    public String xmlString(@RequestBody String body){
        log.error(body);
        String a = "{\n" +
                "  \"retrieveAccountHolderDetailsResponse\": {\n" +
                "    \"CommonRs\": {\n" +
                "      \"OrgCode\": \"0001\"\n" +
                "    },\n" +
                "    \"InqAcctId\": {\n" +
                "      \"ProdType\": \"SRS\",\n" +
                "      \"ProdCode\": \"223\",\n" +
                "      \"AcctId\": \"01200202966223\"\n" +
                "    },\n" +
                "    \"AcctDetl\": {\n" +
                "      \"InvestAcctId\": {\n" +
                "        \"ProdCode\": \"0223\",\n" +
                "        \"AcctId\": \"01200202966223\",\n" +
                "        \"OrgCode\": \"0001\"\n" +
                "      },\n" +
                "      \"AcctSignal\": [],\n" +
                "      \"AcctSignalReason\": [],\n" +
                "      \"BlockCode\": [],\n" +
                "      \"AcctAddrDetl\": {\n" +
                "        \"AcctAddrId\": {\n" +
                "          \"AcctAddrCISId\": {\n" +
                "            \"CISAddrCustId\": {\n" +
                "              \"CISCIN\": \"S7744486F\",\n" +
                "              \"CISCINsfx\": \"00\"\n" +
                "            },\n" +
                "            \"CISAddrType\": \"HOM\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"AcctAddr\": {\n" +
                "          \"AddrLine\": [\n" +
                "            \"16FLORADRIVE\",\n" +
                "            \"FERRARIAPARKCONDOMINIUM\",\n" +
                "            \"\",\n" +
                "            \"\"\n" +
                "          ],\n" +
                "          \"Level\": \"12\",\n" +
                "          \"Unit\": \"12\",\n" +
                "          \"PostalCode\": \"506945\",\n" +
                "          \"City\": \"702\",\n" +
                "          \"Ctry\": \"702\"\n" +
                "        },\n" +
                "        \"LastUpdDate\": \"2021-04-27\",\n" +
                "        \"LastUpdMainUnit\": \"0352\",\n" +
                "        \"LastUpdId\": \"CMCP\",\n" +
                "        \"FormattedAddr\": [\n" +
                "          \"16FLORADRIVE\",\n" +
                "          \"FERRARIAPARKCONDOMINIUM\"\n" +
                "        ]\n" +
                "      },\n" +
                "      \"AcctHolderDetl\": [\n" +
                "        {\n" +
                "          \"CISInternalId\": {\n" +
                "            \"CISCIN\": \"S8383911B\",\n" +
                "            \"CISCINsfx\": \"00\"\n" +
                "          },\n" +
                "          \"CMCPId\": \"C21358682R\",\n" +
                "          \"CustName\": {\n" +
                "            \"FullName\": \"NMLGAZYIFLH\",\n" +
                "            \"Salutation\": \"16\",\n" +
                "            \"RegisteredName\": \"NMLGAZYIFLH\"\n" +
                "          },\n" +
                "          \"CustAddrDetl\": [\n" +
                "            {\n" +
                "              \"AddrType\": \"MAIL\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Block\": \"165\",\n" +
                "                \"Level\": \"77\",\n" +
                "                \"Unit\": \"11\",\n" +
                "                \"Ctry\": \"702\",\n" +
                "                \"CtryDesc\": \"SINGAPORE\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"BLK165JAMESPERLROAD\",\n" +
                "                \"#77-11SINGAPORE520165\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"AddrType\": \"RES\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ]\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"5VTLDPGYYCMOPWV\",\n" +
                "                \"SINGAPORE852498\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"AddrType\": \"MAIL\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Block\": \"84\",\n" +
                "                \"Level\": \"31\",\n" +
                "                \"Unit\": \"38\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"BLK8418HLYORBLTKJEWMS\",\n" +
                "                \"VTUWQAWQZIN\",\n" +
                "                \"#31-38SINGAPORE558532\"\n" +
                "              ]\n" +
                "            }\n" +
                "          ],\n" +
                "          \"CustOwner\": []\n" +
                "        },\n" +
                "        {\n" +
                "          \"CISInternalId\": {\n" +
                "            \"CISCIN\": \"S7744486F\",\n" +
                "            \"CISCINsfx\": \"00\"\n" +
                "          },\n" +
                "          \"CMCPId\": \"B21309077H\",\n" +
                "          \"CustName\": {\n" +
                "            \"FullName\": \"RELOFFLINETC7B\",\n" +
                "            \"Salutation\": \"9\",\n" +
                "            \"Alias\": \"AslamKhan_AslamKhan_AslamKhan\",\n" +
                "            \"RegisteredName\": \"RELOFFLINETC7B\"\n" +
                "          },\n" +
                "          \"CustAddrDetl\": [\n" +
                "            {\n" +
                "              \"AddrType\": \"MAIL\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Level\": \"12\",\n" +
                "                \"Unit\": \"12\",\n" +
                "                \"Ctry\": \"702\",\n" +
                "                \"CtryDesc\": \"SINGAPORE\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"16FLORADRIVE\",\n" +
                "                \"FERRARIAPARKCONDOMINIUM\",\n" +
                "                \"#12-12SINGAPORE506945\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"AddrType\": \"MAIL\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Level\": \"12\",\n" +
                "                \"Unit\": \"12\",\n" +
                "                \"Ctry\": \"702\",\n" +
                "                \"CtryDesc\": \"SINGAPORE\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"16FLORADRIVE\",\n" +
                "                \"FERRARIAPARKCONDOMINIUM\",\n" +
                "                \"#12-12SINGAPORE506945\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"AddrType\": \"RES\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Level\": \"12\",\n" +
                "                \"Unit\": \"11\",\n" +
                "                \"Ctry\": \"702\",\n" +
                "                \"CtryDesc\": \"SINGAPORE\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"16FLORADRIVE\",\n" +
                "                \"FERRARIAPARKCONDOMINIUM\",\n" +
                "                \"#12-11SINGAPORE506945\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"AddrType\": \"MAIL\",\n" +
                "              \"CustAddr\": {\n" +
                "                \"AddrLine\": [\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null,\n" +
                "                  null\n" +
                "                ],\n" +
                "                \"Block\": \"200\",\n" +
                "                \"Level\": \"11\",\n" +
                "                \"Unit\": \"24\",\n" +
                "                \"Ctry\": \"702\",\n" +
                "                \"CtryDesc\": \"SINGAPORE\"\n" +
                "              },\n" +
                "              \"FormattedAddr\": [\n" +
                "                \"BLK200PTEMPISROAD\",\n" +
                "                \"#11-24SINGAPORE520165\"\n" +
                "              ]\n" +
                "            }\n" +
                "          ],\n" +
                "          \"CustOwner\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return a;
    }

}

