package com.example.hdy.qapp_gate;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    TextView inputDigitText;
    TextView currNum;
    TextView currStr;
    String s;
    int len;
    Handler handler;
    String pnumber;

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputDigitText = (TextView)findViewById(R.id.inputDigitTextView);
        currNum = (TextView)findViewById(R.id.currentWaitingNumber);
        handler = new Handler();
        s = null;
        len = 0;
        pnumber = null;

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);
        Button btn7 = (Button)findViewById(R.id.btn7);
        Button btn8 = (Button)findViewById(R.id.btn8);
        Button btn9 = (Button)findViewById(R.id.btn9);
        Button btn0 = (Button)findViewById(R.id.btn0);
        Button btnSb = (Button)findViewById(R.id.btnSubmit);
        Button btnDel = (Button)findViewById(R.id.btnDel);

        btn1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("1");
                    len++;
                }
            }                                }
        );
        btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("2");
                    len++;
                }
            }                                }
        );
        btn3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("3");
                    len++;
                }
            }                                }
        );
        btn4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("4");
                    len++;
                }
            }                                }
        );
        btn5.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("5");
                    len++;
                }
            }                                }
        );
        btn6.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("6");
                    len++;
                }
            }                                }
        );
        btn7.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("7");
                    len++;
                }
            }                                }
        );
        btn8.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("8");
                    len++;
                }
            }                                }
        );
        btn9.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("9");
                    len++;
                }
            }                                }
        );
        btn0.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(len < 13) {
                    if(len == 3 || len == 8) {
                        inputDigitText.append("-");
                        len++;
                    }
                    inputDigitText.append("0");
                    len++;
                }
            }                                }
        );

        btnDel.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                s = inputDigitText.getText().toString();
                len = s.length();

                if(len > 0) {
                    if (len == 5 || len == 10) {
                        s = s.substring(0, len - 2);
                        inputDigitText.setText(s);
                        len = len - 2;
                    }
                    else if (len != 5 && len != 10) {
                        s = s.substring(0, len - 1);
                        inputDigitText.setText(s);
                        len--;
                    }
                    /*currentWaitingNumber.setText(String.valueOf(len));*/
                }
            }                                }
        );

        btnSb.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                pnumber = inputDigitText.getText().toString().trim();
                len = 0;
                inputDigitText.setText("");
                /*myThread2 thread2 = new myThread2("http://webapp4.cafe24.com/gst_add.php", pnumber);*/
                myThread2 thread2 = new myThread2("http://webapp4.cafe24.com/gst_add.php", pnumber);
                thread2.start();
            }                                }
        );

        myThread thread = new myThread("http://webapp4.cafe24.com/test2.php");
        thread.start();
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
        String pNumStr;
        public myThread2(String inStr, String digitStr) {
            urlStr = inStr;
            pNumStr = digitStr;
        }

        public void run(){
            try{
                final String output = request(urlStr, pNumStr);
            }
            catch(Exception e){}
        }


        private String request(String urlStr, String pNumStr) {
            StringBuilder output = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer sendBuf = new StringBuffer();

                    sendBuf.append("digits=");
                    sendBuf.append(pNumStr);


                    OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                    PrintWriter writer = new PrintWriter(outStream);
                    writer.write(sendBuf.toString());
                    writer.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")) ;
                    String line = null;
                    while(true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        output.append(line + "\n");
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


