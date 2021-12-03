package jackson;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "\t\"retrieveAccountHolderDetailsResponse\": {\n" +
                "\t\t\"CommonRs\": {\n" +
                "\t\t\t\"OrgCode\": \"0001\"\n" +
                "\t\t},\n" +
                "\t\t\"InqAcctId\": {\n" +
                "\t\t\t\"ProdType\": \"SRS\",\n" +
                "\t\t\t\"ProdCode\": \"223\",\n" +
                "\t\t\t\"AcctId\": \"01200202966223\"\n" +
                "\t\t},\n" +
                "\t\t\"AcctDetl\": {\n" +
                "\t\t\t\"InvestAcctId\": {\n" +
                "\t\t\t\t\"ProdCode\": \"0223\",\n" +
                "\t\t\t\t\"AcctId\": \"01200202966223\",\n" +
                "\t\t\t\t\"OrgCode\": \"0001\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"AcctSignal\": [],\n" +
                "\t\t\t\"AcctSignalReason\": [],\n" +
                "\t\t\t\"BlockCode\": [],\n" +
                "\t\t\t\"AcctAddrDetl\": {\n" +
                "\t\t\t\t\"AcctAddrId\": {\n" +
                "\t\t\t\t\t\"AcctAddrCISId\": {\n" +
                "\t\t\t\t\t\t\"CISAddrCustId\": {\n" +
                "\t\t\t\t\t\t\t\"CISCIN\": \"S7744486F\",\n" +
                "\t\t\t\t\t\t\t\"CISCINsfx\": \"00\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"CISAddrType\": \"HOM\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"AcctAddr\": {\n" +
                "\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\"16FLORADRIVE\",\n" +
                "\t\t\t\t\t\t\"FERRARIAPARKCONDOMINIUM\",\n" +
                "\t\t\t\t\t\t\"\",\n" +
                "\t\t\t\t\t\t\"\"\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"Level\": \"12\",\n" +
                "\t\t\t\t\t\"Unit\": \"12\",\n" +
                "\t\t\t\t\t\"PostalCode\": \"506945\",\n" +
                "\t\t\t\t\t\"City\": \"702\",\n" +
                "\t\t\t\t\t\"Ctry\": \"702\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"LastUpdDate\": \"2021-04-27\",\n" +
                "\t\t\t\t\"LastUpdMainUnit\": \"0352\",\n" +
                "\t\t\t\t\"LastUpdId\": \"CMCP\",\n" +
                "\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\"16FLORADRIVE\",\n" +
                "\t\t\t\t\t\"FERRARIAPARKCONDOMINIUM\"\n" +
                "\t\t\t\t]\n" +
                "\t\t\t},\n" +
                "\t\t\t\"AcctHolderDetl\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"CISInternalId\": {\n" +
                "\t\t\t\t\t\t\"CISCIN\": \"S8383911B\",\n" +
                "\t\t\t\t\t\t\"CISCINsfx\": \"00\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"CMCPId\": \"C21358682R\",\n" +
                "\t\t\t\t\t\"CustName\": {\n" +
                "\t\t\t\t\t\t\"FullName\": \"NMLGAZYIFLH\",\n" +
                "\t\t\t\t\t\t\"Salutation\": \"16\",\n" +
                "\t\t\t\t\t\t\"RegisteredName\": \"NMLGAZYIFLH\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"CustAddrDetl\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"MAIL\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Block\": \"165\",\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"77\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"Ctry\": \"702\",\n" +
                "\t\t\t\t\t\t\t\t\"CtryDesc\": \"SINGAPORE\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"BLK165JAMESPERLROAD\",\n" +
                "\t\t\t\t\t\t\t\t\"#77-11SINGAPORE520165\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"RES\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"5VTLDPGYYCMOPWV\",\n" +
                "\t\t\t\t\t\t\t\t\"SINGAPORE852498\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"MAIL\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Block\": \"84\",\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"31\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"38\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"BLK8418HLYORBLTKJEWMS\",\n" +
                "\t\t\t\t\t\t\t\t\"VTUWQAWQZIN\",\n" +
                "\t\t\t\t\t\t\t\t\"#31-38SINGAPORE558532\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"CustOwner\": []\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"CISInternalId\": {\n" +
                "\t\t\t\t\t\t\"CISCIN\": \"S7744486F\",\n" +
                "\t\t\t\t\t\t\"CISCINsfx\": \"00\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"CMCPId\": \"B21309077H\",\n" +
                "\t\t\t\t\t\"CustName\": {\n" +
                "\t\t\t\t\t\t\"FullName\": \"RELOFFLINETC7B\",\n" +
                "\t\t\t\t\t\t\"Salutation\": \"9\",\n" +
                "\t\t\t\t\t\t\"Alias\": \"AslamKhan_AslamKhan_AslamKhan\",\n" +
                "\t\t\t\t\t\t\"RegisteredName\": \"RELOFFLINETC7B\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"CustAddrDetl\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"MAIL\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"Ctry\": \"702\",\n" +
                "\t\t\t\t\t\t\t\t\"CtryDesc\": \"SINGAPORE\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"16FLORADRIVE\",\n" +
                "\t\t\t\t\t\t\t\t\"FERRARIAPARKCONDOMINIUM\",\n" +
                "\t\t\t\t\t\t\t\t\"#12-12SINGAPORE506945\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"MAIL\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"Ctry\": \"702\",\n" +
                "\t\t\t\t\t\t\t\t\"CtryDesc\": \"SINGAPORE\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"16FLORADRIVE\",\n" +
                "\t\t\t\t\t\t\t\t\"FERRARIAPARKCONDOMINIUM\",\n" +
                "\t\t\t\t\t\t\t\t\"#12-12SINGAPORE506945\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"RES\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"Ctry\": \"702\",\n" +
                "\t\t\t\t\t\t\t\t\"CtryDesc\": \"SINGAPORE\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"16FLORADRIVE\",\n" +
                "\t\t\t\t\t\t\t\t\"FERRARIAPARKCONDOMINIUM\",\n" +
                "\t\t\t\t\t\t\t\t\"#12-11SINGAPORE506945\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"AddrType\": \"MAIL\",\n" +
                "\t\t\t\t\t\t\t\"CustAddr\": {\n" +
                "\t\t\t\t\t\t\t\t\"AddrLine\": [\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull,\n" +
                "\t\t\t\t\t\t\t\t\tnull\n" +
                "\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\"Block\": \"200\",\n" +
                "\t\t\t\t\t\t\t\t\"Level\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"Unit\": \"24\",\n" +
                "\t\t\t\t\t\t\t\t\"Ctry\": \"702\",\n" +
                "\t\t\t\t\t\t\t\t\"CtryDesc\": \"SINGAPORE\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"FormattedAddr\": [\n" +
                "\t\t\t\t\t\t\t\t\"BLK200PTEMPISROAD\",\n" +
                "\t\t\t\t\t\t\t\t\"#11-24SINGAPORE520165\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t],\n" +
                "\t\t\t\t\t\"CustOwner\": []\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        JSONObject jo = mapper.readValue(json, JSONObject.class);
        System.out.println(jo.getJSONObject("retrieveAccountHolderDetailsResponse")
                .getJSONObject("AcctDetl")
                .getJSONObject("AcctAddrDetl")
                .getJSONObject("AcctAddrId")
                .getJSONObject("AcctAddrCISId")
                .getString("CISAddrType"));

        while(true) {
            Thread.sleep(1000);
        }
    }
}
