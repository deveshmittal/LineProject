package com.example.lineproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

 
@SuppressLint("ResourceAsColor")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {
	LinearLayout.LayoutParams lp;
	RelativeLayout.LayoutParams llp;
	RelativeLayout.LayoutParams innerlp;

	int flag;
	String text;
	TextView tv1;
	ImageView iv1;
	View recent;
	RelativeLayout rr;
	RelativeLayout rlparent;
     int x=0;
     int comm;

String ourtext = new String();
	
	LinearLayout ll;
	Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comm=0;
        rr = new RelativeLayout(MainActivity.this);
        rlparent = (RelativeLayout)findViewById(R.id.rlparent);
      //  rlparent.setLeft(75);
        b1 = (Button)findViewById(R.id.button1);
        recent = b1;
        flag=0;
        ll=new LinearLayout(MainActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
         
        ourtext ="";
       
        
        llp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        
        b1.setOnClickListener(new View.OnClickListener() {

			@Override
            public void onClick(View v) {
				
				comm=comm+1;
				ourtext ="";
				QuantityDialogFragment dialogone = new QuantityDialogFragment();
				dialogone.show(getFragmentManager(), "Dialog");
				
				
				
			//	addtheLayouts(value);

			            
			
			            
			            
			            
			            
			            
			            
			            
			           // Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
			     
			    
			    
		
    }	
            
        
        

    //protected void addtheLayouts(String value) {}
});
           
        //   ((ViewGroup)ll.getParent()).removeView(scrollChildLayout);
	//        rlparent.invalidate();
        if(comm==0)
        {
        	llp.setMargins(0, 80, 0, 0);
        }
    rlparent.addView(ll, llp);
   // rlparent.setLeft(left)
    rlparent.setBackgroundDrawable(getResources().getDrawable(R.drawable.textline));
    
	}




	public static int getHeight(Context context, CharSequence text, int textSize, int deviceWidth, Typeface typeface,int padding) {
        TextView textView = new TextView(context);
        textView.setPadding(padding,padding+10,padding,padding+5);
        textView.setTypeface(typeface);
        textView.setText(text, TextView.BufferType.SPANNABLE);
        //textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        textView.measure(widthMeasureSpec, heightMeasureSpec);
        return textView.getMeasuredHeight();
    }
    @SuppressLint("NewApi")
    public int getDeviceWidth()
    {
     int deviceWidth = 0;
     
     Point size = new Point();
     WindowManager windowManager = getWindowManager();
     
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
     {
     windowManager.getDefaultDisplay().getSize(size);
     deviceWidth = size.x;
     }
     else
     {
     Display display = windowManager.getDefaultDisplay();
     deviceWidth = display.getWidth();
     }
     return deviceWidth;
    }
    
    public void onUserSelectValue(String value) {
        ourtext=value ;
		

        
        
        
        
        
        
	       // Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
	    
			
			// TODO Auto-generated method stub
			
		}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




	public void addtheLayouts(String value) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
    	RelativeLayout innerRelative;

		
 		
		
	       

    	
		
       //View touchView2 = findViewById(R.id.imgview);
       	
       	//x= x+2;
       	Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
       	Canvas canvas = new Canvas(b);
       	ImageView img = new ImageView(getApplicationContext());
       	
       	
       	innerRelative = new RelativeLayout(getApplicationContext());
       	innerlp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
       	
       	float size = new Button(getApplicationContext()).getTextSize();
       	SimpleDateFormat formatter =  new SimpleDateFormat("hh:mm dd/MM/yyyy");
       	Calendar calendar = Calendar.getInstance();
       	calendar.setTimeInMillis(System.currentTimeMillis());


       	String datetime = formatter.format(calendar.getTime());
       	String testString = "Time:"+datetime+"\n\n\n"+value+"\nYour Comment Has Been Added!";
       	Rect bounds = new Rect();
       	Paint paint = new Paint();
       	paint.setTextSize(size);
       	paint.getTextBounds(testString, 0, testString.length(), bounds);

       	int height = (int) Math.ceil( bounds.height());
       	int deviceWidth =getDeviceWidth();
           //public static int getHeight(Context context, CharSequence text, int textSize, int deviceWidth, Typeface typeface,int padding) {

       	height=getHeight(getApplicationContext(), testString,(int)size, deviceWidth, Typeface.DEFAULT, 20);
       	

       	
       	 Bitmap bmp = Bitmap.createBitmap(20,20, Bitmap.Config.ARGB_8888);

       	       Canvas c = new Canvas(bmp);
       	       //c.drawCircle(cx, cy, radius, paint)

       	       img.setBackgroundDrawable(new BitmapDrawable(bmp));
       	
       	
       	tv1 = new TextView(MainActivity.this);
           tv1.setId((int)System.currentTimeMillis());
           tv1.setText(testString);
           
           
           tv1.setPadding(20, 20, 20, 25);
           
           
           tv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.roundshape));
           
           RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
           params.setMargins(20, 0, 0, 0);
          // tvparams.setMargins(20, 20, 0, 0);
           innerRelative.addView(tv1,params);
           
           //int drawableId = R.drawable.mytexture;
          // Bitmap bm = BitmapFactory.decodeResource(getResources(), drawableId);
           
           
           
           
           View view2 = new View(getApplicationContext());
           view2.setBackgroundColor(R.color.green);
           //Log.i("Main Activity", "Heiight of TexView :"+tv1.getHeight());
           RelativeLayout.LayoutParams vuparams=new RelativeLayout.LayoutParams(2,height);
           vuparams.setMargins(10, 0, 0, 0);
           innerRelative.addView(view2, vuparams);
           
           Rect rectf = new Rect();

           innerRelative.getLocalVisibleRect(rectf);
           int cxer = rectf.left;
           int cyer = rectf.top;
           
	    //   c.drawCircle(cxer, cyer, 10, paint);

           //2,ViewGroup.LayoutParamcts.MATCH_PARENT
           
           
           View circlerView=new View(getApplicationContext());
           circlerView.setBackgroundResource(R.drawable.circle);
           ViewGroup.LayoutParams parames = new ViewGroup.LayoutParams(20,20);
           circlerView.setLayoutParams(parames);
           
           innerRelative.addView(circlerView);
           
           //innerlp.addRule(RelativeLayout.LEFT_OF,tv1.getId());
           
           
           
           
           
           
           
           lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
           
           
          // lp.addRule(RelativeLayout.BELOW, recent.getBottom());
          
        
        
        
        
        //int x1=tv1.getLeft();
        int y1= tv1.getTop();
        int y2= tv1.getBottom();

        int  xcal= getWindowManager().getDefaultDisplay().getWidth();
        int ycal =(y1+y2)/2;
        
        Drawable circler = getApplicationContext().getResources().getDrawable(R.drawable.ic_launcher);

        
        int w = circler.getIntrinsicWidth();
        int h = circler.getIntrinsicHeight();
        int x = xcal-w-25;
        int y = ycal/2 - h/2 ;

        circler.setBounds( x, y, x + w, y + h );
        circler.draw( canvas );
        
        
        
        
 //       ((ViewGroup)ll.getParent()).removeView(ll);
        //
        //touchView2.layout(x1, y1, x1+10, y1+10);
        
           ll.addView(innerRelative, lp);
           lp.setMargins(30, 0, 0, 0);
           recent = tv1;
	   
		
	}
    
}
