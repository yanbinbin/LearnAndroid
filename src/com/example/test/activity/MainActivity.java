
package com.example.test.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    ListView mTestsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    /**
     * initViews: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void initViews() {
        // TODO Auto-generated method stub
        setListAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[] {
                    "title"
                }, new int[] {
                    android.R.id.text1
                }));
    }

    /**
     * getData: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private List<Map<String, Object>> getData() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory("android.intent.category.bb");
        PackageManager manager = getPackageManager();
        List<ResolveInfo> infos = manager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo resolveInfo : infos) {
            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("title", getString(resolveInfo.activityInfo.labelRes));
            temp.put(
                    "intent",
                    activityIntent(resolveInfo.activityInfo.packageName,
                            resolveInfo.activityInfo.name));
            result.add(temp);
        }
        // Collections.sort(result, sDisplayNameComparator);
        return result;
    }

    // private final static Comparator<Map<String, Object>>
    // sDisplayNameComparator = new Comparator<Map<String, Object>>() {
    //
    // private final Collator collator = Collator.getInstance();
    //
    // @Override
    // public int compare(Map<String, Object> lhs, Map<String, Object> rhs) {
    // // TODO Auto-generated method stub
    // return collator.compare(lhs.get("title"), rhs.get("title"));
    // }
    // };

    /**
     * activityIntent: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private Intent activityIntent(String packageName, String componentName) {
        // TODO Auto-generated method stub
        Intent intent = new Intent();
        intent.setClassName(packageName, componentName);
        return intent;
    }

    /*
     * (non-Javadoc)
     * @see android.app.ListActivity#onListItemClick(android.widget.ListView,
     * android.view.View, int, long)
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>)l
                .getItemAtPosition(position);

        Intent intent = new Intent((Intent)map.get("intent"));
        intent.addCategory("android.intent.category.bb");
        startActivity(intent);
    }
}
