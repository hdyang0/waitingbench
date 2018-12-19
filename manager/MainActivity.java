package com.example.hdy.qapp_manager;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView currNum;
    Handler handler;
    Button btnSb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currNum = (TextView) findViewById(R.id.currentWaitingNumber);
        btnSb = (Button) findViewById(R.id.btnSubmit);

        handler = new Handler();

        btnSb.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                
                myThread2 thread2 = new myThread2("http://webapp4.cafe24.com/gst_pop.php");
                thread2.start();
            }                                }
        );

        myThread thread1 = new myThread("http://webapp4.cafe24.com/test2.php");
        thread1.start();
    }

    class myThread extends Thread {
        String urlStr;
        public myThread(String inStr) {
            urlStr = inStr;
        }

        public void run(){
            try{}
            catch(Exception e){}

            while(true) {
                final String output = request(urlStr);
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        currNum.setText(output);
                    }

                });

            }

        }


        private String request(String urlStr) {
            StringBuilder output = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);


                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")) ;
                    String line = null;
                    while(true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        /*output.append(line + "\n");*/
                        output.append(line);
                    }

                    reader.close();
                    conn.disconnect();
                }
            } catch(Exception ex) {
                Log.e("SampleHTTP", "Exception in processing response.", ex);
                ex.printStackTrace();
            }
            return output.toString();
        }

    }

    class myThread2 extends Thread {
        String urlStr;
        public myThread2(String inStr) {
            urlStr = inStr;
        }

        public void run(){
            try{
                final String output = request(urlStr);
            }
            catch(Exception e){}
        }


        private String request(String urlStr) {
            StringBuilder output = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")) ;
                    String line = null;
                    while(true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        /*output.append(line + "\n");*/
                        output.append(line);
                    }

                    reader.close();

                    conn.disconnect();
                }
            } catch(Exception ex) {
                Log.e("SampleHTTP", "Exception in processing response.", ex);
                ex.printStackTrace();
            }
            return output.toString();
        }

    }

}
