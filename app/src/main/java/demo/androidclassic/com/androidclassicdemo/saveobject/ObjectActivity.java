package demo.androidclassic.com.androidclassicdemo.saveobject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import demo.androidclassic.com.androidclassicdemo.GsonUtil;
import demo.androidclassic.com.androidclassicdemo.R;

public class ObjectActivity extends AppCompatActivity {

    String data="{\n" +
            "\t\"status\": 1,\n" +
            "\t\"lastDocType\": 1,\n" +
            "\t\"lastDoc\": {\n" +
            "\t\t\"id\": \"3831\",\n" +
            "\t\t\"doc_no\": \"EX1015138724\",\n" +
            "\t\t\"user_id\": \"84\",\n" +
            "\t\t\"sender_name\": \"\",\n" +
            "\t\t\"receive_id\": \"84\",\n" +
            "\t\t\"receive_name\": \"熊政\",\n" +
            "\t\t\"doc_name\": \"包裹送达确认\",\n" +
            "\t\t\"user_company\": \"''\",\n" +
            "\t\t\"receive_company\": \"无\",\n" +
            "\t\t\"create_time\": \"2018-05-15 19:14:08\",\n" +
            "\t\t\"update_time\": \"2018-05-15 19:14:09\",\n" +
            "\t\t\"doc_status\": \"1\",\n" +
            "\t\t\"rec_status\": \"1\",\n" +
            "\t\t\"doc_type\": \"1\",\n" +
            "\t\t\"doc_relation_id\": null,\n" +
            "\t\t\"sign_time\": null,\n" +
            "\t\t\"pay_time\": null,\n" +
            "\t\t\"send_time\": \"2018-05-15 19:14:09\",\n" +
            "\t\t\"receive_time\": null,\n" +
            "\t\t\"role\": 1,\n" +
            "\t\t\"sign_return\": 0,\n" +
            "\t\t\"button\": [{\n" +
            "\t\t\t\"name\": \"催单\",\n" +
            "\t\t\t\"url\": \"\\/v1\\/app\\/hurryDoc\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"name\": \"查看\",\n" +
            "\t\t\t\"url\": \"\\/sys\\/doc\\/docDetail\\/no\\/EX1015138724#item3\"\n" +
            "\t\t}]\n" +
            "\t},\n" +
            "\t\"waitSign\": \"15\",\n" +
            "\t\"waitPayCount\": \"4\",\n" +
            "\t\"waitReceive\": \"13\",\n" +
            "\t\"banner\": [{\n" +
            "\t\t\"name\": \"banner2\",\n" +
            "\t\t\"desc\": \"2.3元全国包邮\",\n" +
            "\t\t\"value\": \"app_image\\/6c51f4b13b21d4717f4de288a875bf50.png\",\n" +
            "\t\t\"url\": \"\\/agent\\/courier\\/express\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"banner1\",\n" +
            "\t\t\"desc\": \"秒签人才介绍\",\n" +
            "\t\t\"value\": \"app_image\\/26ac55c7e109844a75afa254ec1bcb87.png\",\n" +
            "\t\t\"url\": \"\\/ding\\/index\\/select\"\n" +
            "\t}],\n" +
            "\t\"app\": [{\n" +
            "\t\t\"name\": \"app_express\",\n" +
            "\t\t\"desc\": \"秒签快递\",\n" +
            "\t\t\"value\": \"app_image\\/34b452e56c0c895ce9d9710fb3ed6739.png\",\n" +
            "\t\t\"url\": \"\\/agent\\/courier\\/express\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"app_men\",\n" +
            "\t\t\"desc\": \"秒签人才\",\n" +
            "\t\t\"value\": \"app_image\\/16aeb16f7f95b07f266a8452a73bef63.png\",\n" +
            "\t\t\"url\": \"\\/ding\\/index\\/select\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"app_fp\",\n" +
            "\t\t\"desc\": \"电子发票\",\n" +
            "\t\t\"value\": \"app_image\\/fp.png\",\n" +
            "\t\t\"url\": \"\\/\"\n" +
            "\t}],\n" +
            "\t\"add\": [{\n" +
            "\t\t\"name\": \"app_express\",\n" +
            "\t\t\"desc\": \"寄实物包裹\",\n" +
            "\t\t\"value\": \"app_image\\/735fcdff8576038495a84ecdd5a9b4f5.png\",\n" +
            "\t\t\"url\": \"\\/agent\\/courier\\/express\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"app_doc\",\n" +
            "\t\t\"desc\": \"寄电子合同\",\n" +
            "\t\t\"value\": \"app_image\\/6c9bcca99e5f05cd9d174d5c81ba486f.png\",\n" +
            "\t\t\"url\": \"\\/sys\\/waybill\\/quick\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"app_fp\",\n" +
            "\t\t\"desc\": \"电子发票\",\n" +
            "\t\t\"value\": \"app_image\\/210c0f3753903d316d4e44835caa0a09.png\",\n" +
            "\t\t\"url\": \"\\/\"\n" +
            "\t}]\n" +
            "}";
    private Databean savaobject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_view);
        Databean databean = GsonUtil.parseJsonToBean(data, Databean.class);
        Log.e("datas",databean+"");
        savaobject = SpUtils.getObject(this, Databean.class);
        if (savaobject ==null){
            savaobject = SpUtils.getObject(this, Databean.class);
        }
        SpUtils.putObject(this,databean);
        Log.e("getdata", savaobject +"");
        //todo json串中如何覆盖，因为json串的操作就是put操作，能够直接覆盖掉原来的值
        // todo https://blog.csdn.net/GXL_1899/article/details/78114314
        // todo  https://blog.csdn.net/qq_38069688/article/details/81204628
    }
}
