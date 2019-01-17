package demo.androidclassic.com.androidclassicdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestasyncActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.im);
//        new httputils1(new httputils1.resultcallback() {
//            @Override
//            public void getbitmap(Bitmap bitmap) {
//                imageView.setImageBitmap(bitmap);
//            }
//        }).execute("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3247591418,2964280942&fm=173&app=25&f=JPEG?w=640&h=427&s=21D57F8606C06AE10BAF82660300006F\n");
//

        new httputils().execute("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3247591418,2964280942&fm=173&app=25&f=JPEG?w=640&h=427&s=21D57F8606C06AE10BAF82660300006F");
    }

    public class httputils extends AsyncTask<String ,Void,byte[]> {
        private byte[] bytesInputStream;
        Bitmap bitmap;
        //https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3247591418,2964280942&fm=173&app=25&f=JPEG?w=640&h=427&s=21D57F8606C06AE10BAF82660300006F
        // 一定要实现的是这个方法
        @Override
        protected byte[] doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(6 * 1000);  // 注意要设置超时，设置时间不要超过10秒，避免被android系统回收
                if (conn.getResponseCode() != 200) {
                    return null;
                }
                InputStream inSream = conn.getInputStream();
                bytesInputStream = getBytesInputStream(inSream);
                bitmap = BitmapFactory.decodeByteArray(bytesInputStream, 0, bytesInputStream.length);
                //使用下面这个方法就是会报错
                //bitmap=BitmapFactory.decodeStream(inSream);
                inSream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bytesInputStream;

        }

        // 这个是在异步操作执行之前的操作的方法
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        // 这个是在异步操作之后执行的方法
        @Override
        protected void onPostExecute(byte[] bytes) {
            super.onPostExecute(bytes);
            Log.e("---", "sss");
            if (bitmap!=null) {
                imageView.setImageBitmap(bitmap);
            }
        }


        public byte[] getBytesInputStream(InputStream is) throws IOException {

            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[512];
            int len;
            while ((len = is.read(buff)) != -1) {

                arrayOutputStream.write(buff, 0, len);
            }

            is.close();
            arrayOutputStream.close();

            return arrayOutputStream.toByteArray();

        }
    }
}
