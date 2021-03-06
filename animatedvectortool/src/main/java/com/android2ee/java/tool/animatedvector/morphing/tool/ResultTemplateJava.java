/**
 * <ul>
 * <li>ResultTemplateJava</li>
 * <li>com.android2ee.java.tool.animatedvector.morphing.tool</li>
 * <li>02/12/2015</li>
 * <p/>
 * <li>======================================================</li>
 * <p/>
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 * <p/>
 * /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 * Belongs to <strong>Mathias Seguy</strong></br>
 * ***************************************************************************************************************</br>
 * This code is free for any usage but can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * <p/>
 * *****************************************************************************************************************</br>
 * Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 * Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
 * Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */

package com.android2ee.java.tool.animatedvector.morphing.tool;

/**
 * Created by Mathias Seguy - Android2EE on 02/12/2015.
 */
public class ResultTemplateJava {
        /***********************************************************
         * Java code
         **********************************************************/
        public static final String javaFileName="MainActivity.java";
        public static final String javaCode="package com.android2ee.tool.animatedvector.morphing;\n" +
                "\n" +
                "import android.annotation.TargetApi;\n" +
                "import android.graphics.drawable.AnimatedVectorDrawable;\n" +
                "import android.graphics.drawable.LevelListDrawable;\n" +
                "import android.os.Build;\n" +
                "import android.os.Bundle;\n" +
                "import android.os.Handler;\n" +
                "import android.support.v7.app.AppCompatActivity;\n" +
                "import android.view.View;\n" +
                "import android.widget.ImageView;\n" +
                "\n" +
                "/**\n" +
                " * This class aims to show you the code to use to animated your AnimatedVectorDrawables\n" +
                " * enjoy\n" +
                " * (by the way the bug id is https://code.google.com/p/android/issues/detail?id=195999)\n" +
                " */\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "    /**\n" +
                "     * The ImageViews\n" +
                "     */\n" +
                "    ImageView imageView1, imageView2, imageView3, imageView4;\n" +
                "    /**\n" +
                "     * Too simple AnimatedVectorDrawables for having a simple exemple\n" +
                "     */\n" +
                "    AnimatedVectorDrawable  animatedVector3, animatedVector4;\n" +
                "    /***********************************************************\n" +
                "     * Managing Level List: To chain animations\n" +
                "     **********************************************************/\n" +
                "    //The LevelListDrawable that contains all the AnimatedVectorDrawables\n" +
                "    LevelListDrawable animatedVectorList;\n" +
                "    /**\n" +
                "     * The current VectorDrawable displayed by the animatedVectorList\n" +
                "     */\n" +
                "    AnimatedVectorDrawable currentAnimatedVectorFromList;\n" +
                "    /**\n" +
                "     * The max level of your LevelList animatedVectorList\n" +
                "     */\n" +
                "    int animatedVectorListMaxLevel = 0;\n" +
                "    /**\n" +
                "     * The handler to automaticly launch the next animation\n" +
                "     */\n" +
                "    Handler uiHandler;\n" +
                "    /**\n" +
                "     * The Runnable that launches the next animation\n" +
                "     */\n" +
                "    Runnable uiRunnable;\n" +
                "    /**\n" +
                "     * To know is the animation have been already launched\n" +
                "     */\n" +
                "    boolean animatedVectorFirstLaunched=true;\n" +
                "    /***********************************************************\n" +
                "     * Managing RoundTrip animation (VectorDrawable1 to VectorDrawable 2 and back again\n" +
                "     **********************************************************\n" +
                "    /**\n" +
                "     * The LevelList that contains only two AnimatedVectorDrawable,\n" +
                "     * the ones used to go from on to the other\n" +
                "     */\n" +
                "    LevelListDrawable backupRoundTrip;\n" +
                "    /**\n" +
                "     * The current AnimatedVector diaplsyed by the RoundTrip\n" +
                "     */\n" +
                "    AnimatedVectorDrawable currentBackupDrawable;\n" +
                "    /**\n" +
                "     * To know is the animation have been already launched\n" +
                "     */\n" +
                "    boolean backupRoundTripFirstLaunched=true;\n" +
                "\n" +
                "    /***********************************************************\n" +
                "     * Managing LifeCycle\n" +
                "     **********************************************************/\n" +
                "    @TargetApi(Build.VERSION_CODES.M)\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "\n" +
                "        //managing the levelList to chain animations\n" +
                "        //----------------------------------------------\n" +
                "        animatedVectorListMaxLevel = 4;//TODO can not be compute, you have to set it yourself!!!\n" +
                "        //instantiate drawable and imageView\n" +
                "        imageView1 = (ImageView) findViewById(R.id.imageView1);\n" +
                "        animatedVectorList = (LevelListDrawable) imageView1.getDrawable();\n" +
                "        currentAnimatedVectorFromList = (AnimatedVectorDrawable) animatedVectorList.getCurrent();\n" +
                "        //launch animation when the click is done on the imageView\n" +
                "        imageView1.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                launchAnimVectorList();\n" +
                "            }\n" +
                "        });uiRunnable=new Runnable() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                launchAnimVectorList();\n" +
                "            }\n" +
                "        };\n" +
                "        uiHandler=new Handler();\n" +
                "\n" +
                "        //managing the round trip scenario\n" +
                "        //--------------------------------\n" +
                "        //instantiate drawable and imageView\n" +
                "        imageView2 = (ImageView) findViewById(R.id.imageView2);\n" +
                "        backupRoundTrip = (LevelListDrawable) imageView2.getDrawable();\n" +
                "        currentBackupDrawable= (AnimatedVectorDrawable) backupRoundTrip.getCurrent();\n" +
                "        //launch animation when the click is done on the imageView\n" +
                "        imageView2.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                launchAnimBackup();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "\n" +
                "        //managing simple animated vector drawable\n" +
                "        //------------------------------------------\n" +
                "        imageView3 = (ImageView) findViewById(R.id.imageView3);\n" +
                "        animatedVector3 = (AnimatedVectorDrawable) imageView3.getDrawable();\n" +
                "        imageView4 = (ImageView) findViewById(R.id.imageView4);\n" +
                "        animatedVector4 = (AnimatedVectorDrawable) imageView4.getDrawable();\n" +
                "        //set on click listener on them to launch animation\n" +
                "        imageView3.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                launchAnim3();\n" +
                "            }\n" +
                "        });\n" +
                "        imageView4.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                launchAnim4();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onPause() {\n" +
                "        super.onPause();\n" +
                "        //and insure your remove every runnable from the handler (memory leak else)\n" +
                "        uiHandler.removeCallbacks(uiRunnable);\n" +
                "//        llScreenRecorder.stopRecording();\n" +
                "    }\n" +
                "\n" +
                "    /***********************************************************\n" +
                "     *  Managing LevelListDrawable to chain animations\n" +
                "     **********************************************************/\n" +
                "\n" +
                "    /**\n" +
                "     * Launch the animation on the ImageView1\n" +
                "     * And update the level of the drawable\n" +
                "     */\n" +
                "    private void launchAnimVectorList() {\n" +
                "        if(!animatedVectorFirstLaunched) {\n" +
                "            if (animatedVectorList.getLevel() < animatedVectorListMaxLevel) {\n" +
                "                //then increment\n" +
                "                animatedVectorList.setLevel(animatedVectorList.getLevel() + 1);\n" +
                "                currentAnimatedVectorFromList = (AnimatedVectorDrawable) animatedVectorList.getCurrent();\n" +
                "            } else {\n" +
                "                //go back to the beginning\n" +
                "                animatedVectorList.setLevel(0);\n" +
                "                currentAnimatedVectorFromList = (AnimatedVectorDrawable) animatedVectorList.getCurrent();\n" +
                "            }\n" +
                "        }else {\n" +
                "            animatedVectorFirstLaunched=false;\n" +
                "        }\n" +
                "        //start the animation on the current element\n" +
                "        currentAnimatedVectorFromList.start();\n" +
                "        //launch it again in 300 ms + the time your animation take\n" +
                "        uiHandler.postDelayed(uiRunnable,300+3000);//TODO instead of 3000 set your animation duration !!! \n" +
                "    }\n" +
                "\n" +
                "    /***********************************************************\n" +
                "     *  Managing backup button round trip\n" +
                "     **********************************************************/\n" +
                "    /**\n" +
                "     * Launch the animation on the currentAnimatedVectorDrawable\n" +
                "     */\n" +
                "    private void launchAnimBackup(){\n" +
                "        if(!backupRoundTripFirstLaunched) {\n" +
                "            if (backupRoundTrip.getLevel() == 1) {\n" +
                "                //then reverse\n" +
                "                backupRoundTrip.setLevel(0);\n" +
                "            } else {\n" +
                "                //then reverse\n" +
                "                backupRoundTrip.setLevel(1);\n" +
                "            }\n" +
                "        }else{\n" +
                "            backupRoundTripFirstLaunched=false;\n" +
                "        }\n" +
                "        //find the current AnimatedVectorDrawable displayed\n" +
                "        currentBackupDrawable = (AnimatedVectorDrawable) backupRoundTrip.getCurrent();\n" +
                "        //start the animation\n" +
                "        currentBackupDrawable.start();\n" +
                "    }\n" +
                "\n" +
                "    /***********************************************************\n" +
                "     * Launching simple animation on AnimatedVectorDrawable\n" +
                "     **********************************************************/\n" +
                "  /**\n" +
                "     * Launch the animation on the AnimatedVectorDrawable displayed by the imageView3\n" +
                "     */\n" +
                "    private void launchAnim3() {\n" +
                "//            llScreenRecorder.startRecording();\n" +
                "        animatedVector3.start();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Launch the animation on the AnimatedVectorDrawable displayed by the imageView4\n" +
                "     */\n" +
                "    private void launchAnim4() {\n" +
                "        animatedVector4.start();\n" +
                "    }\n" +
                "\n" +
                "}";

        /***********************************************************
         *  And its associated mainlayout.xml
         **********************************************************/

        public static final String mainLayoutName="activity_main.xml";
        public static final String layoutContent="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:orientation=\"vertical\"\n" +
                "    android:paddingBottom=\"@dimen/activity_vertical_margin\"\n" +
                "    android:paddingLeft=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingRight=\"@dimen/activity_horizontal_margin\"\n" +
                "    android:paddingTop=\"@dimen/activity_vertical_margin\"\n" +
                "    tools:context=\".MainActivity\">\n" +
                "\n" +
                "    <TextView\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_gravity=\"center\"\n" +
                "        android:text=\"Click on the drawables to understand :)\" />\n" +
                "\n" +
                "    <LinearLayout\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\"\n" +
                "        android:orientation=\"horizontal\">\n" +
                "\n" +
                "        <LinearLayout\n" +
                "            android:layout_width=\"0dp\"\n" +
                "            android:layout_height=\"match_parent\"\n" +
                "            android:layout_weight=\"1\"\n" +
                "            android:orientation=\"vertical\">\n" +
                "\n" +
                "            <TextView\n" +
                "                android:layout_width=\"wrap_content\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_gravity=\"center\"\n" +
                "                android:text=\"LevelList\" />\n" +
                "\n" +
                "            <ImageView\n" +
                "                android:id=\"@+id/imageView1\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\"\n" +
                "                android:layout_weight=\"1\"\n" +
                "                android:src=\"@drawable/animated_levellist\" />\n" +
                "\n" +
                "            <TextView\n" +
                "                android:layout_width=\"wrap_content\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_gravity=\"center\"\n" +
                "                android:text=\"Reverse\" />\n" +
                "\n" +
                "            <ImageView\n" +
                "                android:id=\"@+id/imageView2\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\"\n" +
                "                android:layout_weight=\"1\"\n" +
                "                android:src=\"@drawable/animated_backup_roundtrip\" />\n" +
                "        </LinearLayout>\n" +
                "\n" +
                "        <LinearLayout\n" +
                "            android:layout_width=\"0dp\"\n" +
                "            android:layout_height=\"match_parent\"\n" +
                "            android:layout_weight=\"1\"\n" +
                "            android:orientation=\"vertical\">\n" +
                "\n" +
                "            <TextView\n" +
                "                android:layout_width=\"wrap_content\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_gravity=\"center\"\n" +
                "                android:text=\"normal\" />\n" +
                "\n" +
                "            <ImageView\n" +
                "                android:id=\"@+id/imageView3\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\"\n" +
                "                android:layout_weight=\"1\"\n" +
                "                android:src=\"@drawable/animated_android\" />\n" +
                "\n" +
                "\n" +
                "            <TextView\n" +
                "                android:layout_width=\"wrap_content\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_gravity=\"center\"\n" +
                "                android:text=\"stroke only\" />\n" +
                "\n" +
                "            <ImageView\n" +
                "                android:id=\"@+id/imageView4\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\"\n" +
                "                android:layout_weight=\"1\"\n" +
                "                android:src=\"@drawable/animated_favorite\" />\n" +
                "        </LinearLayout>\n" +
                "    </LinearLayout>\n" +
                "</LinearLayout>\n";
}
