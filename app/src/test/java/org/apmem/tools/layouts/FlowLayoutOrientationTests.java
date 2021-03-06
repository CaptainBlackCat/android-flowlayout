package org.apmem.tools.layouts;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import junit.framework.Assert;
import org.apmem.tools.layouts.logic.CommonLogic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", sdk = 21)
public class FlowLayoutOrientationTests {
    TestActivity activity = Robolectric.setupActivity(TestActivity.class);

    @Test
    public void VerticalOrientationLeftTopGravity() {
        final FlowLayout layout = new FlowLayout(activity.getApplicationContext());
        layout.setGravity(Gravity.LEFT | Gravity.TOP);
        layout.setOrientation(CommonLogic.VERTICAL);

        final Button btn1 = new Button(activity);
        FlowLayout.LayoutParams lp1 = new FlowLayout.LayoutParams(30, 40);
        lp1.setMargins(1, 2, 3, 4);
        btn1.setLayoutParams(lp1);
        layout.addView(btn1);

        final Button btn2 = new Button(activity);
        FlowLayout.LayoutParams lp2 = new FlowLayout.LayoutParams(10, 20);
        lp2.setMargins(1, 2, 3, 4);
        btn2.setLayoutParams(lp2);
        layout.addView(btn2);

        layout.measure(
                View.MeasureSpec.makeMeasureSpec(70, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY)
        );
        layout.layout(0, 0, 0, 0);

        Assert.assertEquals(1, btn1.getLeft());
        Assert.assertEquals(2, btn1.getTop());
        Assert.assertEquals(1, btn2.getLeft());
        Assert.assertEquals(40 + 2 + 4 + 2, btn2.getTop());

        Assert.assertEquals(30, btn1.getWidth());
        Assert.assertEquals(40, btn1.getHeight());
        Assert.assertEquals(10, btn2.getWidth());
        Assert.assertEquals(20, btn2.getHeight());
    }

    @Test
    public void VerticalOrientationLeftBottomGravity() {
        final FlowLayout layout = new FlowLayout(activity.getApplicationContext());
        layout.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        layout.setOrientation(CommonLogic.VERTICAL);

        final Button btn1 = new Button(activity);
        FlowLayout.LayoutParams lp1 = new FlowLayout.LayoutParams(30, 40);
        lp1.setMargins(1, 2, 3, 4);
        btn1.setLayoutParams(lp1);
        layout.addView(btn1);

        final Button btn2 = new Button(activity);
        FlowLayout.LayoutParams lp2 = new FlowLayout.LayoutParams(10, 20);
        lp2.setMargins(1, 2, 3, 4);
        btn2.setLayoutParams(lp2);
        layout.addView(btn2);

        layout.measure(
                View.MeasureSpec.makeMeasureSpec(70, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY)
        );
        layout.layout(0, 0, 0, 0);

        Assert.assertEquals(1, btn1.getLeft());
        Assert.assertEquals(80 - (20 + 2 + 4 + 40 + 2 + 4) + 2, btn1.getTop());
        Assert.assertEquals(1, btn2.getLeft());
        Assert.assertEquals(80 - (20 + 2 + 4) + 2, btn2.getTop());

        Assert.assertEquals(30, btn1.getWidth());
        Assert.assertEquals(40, btn1.getHeight());
        Assert.assertEquals(10, btn2.getWidth());
        Assert.assertEquals(20, btn2.getHeight());
    }

    @Test
    public void HorizontalOrientationLeftBottomGravity() {
        final FlowLayout layout = new FlowLayout(activity.getApplicationContext());
        layout.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        layout.setOrientation(CommonLogic.HORIZONTAL);

        final Button btn1 = new Button(activity);
        FlowLayout.LayoutParams lp1 = new FlowLayout.LayoutParams(30, 40);
        lp1.setMargins(1, 2, 3, 4);
        btn1.setLayoutParams(lp1);
        layout.addView(btn1);

        final Button btn2 = new Button(activity);
        FlowLayout.LayoutParams lp2 = new FlowLayout.LayoutParams(10, 20);
        lp2.setMargins(1, 2, 3, 4);
        btn2.setLayoutParams(lp2);
        layout.addView(btn2);

        layout.measure(
                View.MeasureSpec.makeMeasureSpec(70, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY)
        );
        layout.layout(0, 0, 0, 0);

        Assert.assertEquals(1, btn1.getLeft());
        Assert.assertEquals(80 - (40 + 2 + 4) + 2, btn1.getTop());
        Assert.assertEquals(30 + 1 + 3 + 1, btn2.getLeft());
        Assert.assertEquals(80 - (20 + 2 + 4) + 2, btn2.getTop());

        Assert.assertEquals(30, btn1.getWidth());
        Assert.assertEquals(40, btn1.getHeight());
        Assert.assertEquals(10, btn2.getWidth());
        Assert.assertEquals(20, btn2.getHeight());
    }

    @Test
    public void VerticalOrientationRelativeGravity() {
        final FlowLayout layout = new FlowLayout(activity.getApplicationContext());
        layout.setGravity(Gravity.START | Gravity.BOTTOM); // Actually it is not bottom, but right :)
        layout.setOrientation(CommonLogic.VERTICAL);

        final Button btn1 = new Button(activity);
        FlowLayout.LayoutParams lp1 = new FlowLayout.LayoutParams(30, 40);
        lp1.setMargins(1, 2, 3, 4);
        btn1.setLayoutParams(lp1);
        layout.addView(btn1);

        final Button btn2 = new Button(activity);
        FlowLayout.LayoutParams lp2 = new FlowLayout.LayoutParams(10, 20);
        lp2.setMargins(1, 2, 3, 4);
        btn2.setLayoutParams(lp2);
        layout.addView(btn2);

        layout.measure(
                View.MeasureSpec.makeMeasureSpec(70, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(80, View.MeasureSpec.EXACTLY)
        );
        layout.layout(0, 0, 0, 0);

        Assert.assertEquals(70 - (30 + 1 + 3) + 1, btn1.getLeft());
        Assert.assertEquals(2, btn1.getTop());
        Assert.assertEquals(70 - (10 + 1 + 3) + 1, btn2.getLeft());
        Assert.assertEquals(40 + 2 + 4 + 2, btn2.getTop());

        Assert.assertEquals(30, btn1.getWidth());
        Assert.assertEquals(40, btn1.getHeight());
        Assert.assertEquals(10, btn2.getWidth());
        Assert.assertEquals(20, btn2.getHeight());
    }
}
