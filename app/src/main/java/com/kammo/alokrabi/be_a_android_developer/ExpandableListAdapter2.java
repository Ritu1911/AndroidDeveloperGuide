package com.kammo.alokrabi.be_a_android_developer;

/**
 * Created by Kamala on 2/8/2018.
 */
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter2 extends BaseExpandableListAdapter{
    private Context _context;
    private List<String> _listDataHeader2; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild2;

    public ExpandableListAdapter2(Context context, List<String> listDataHeader2,
                                 HashMap<String, List<String>> listChildData2) {
        this._context = context;
        this._listDataHeader2 = listDataHeader2;
        this._listDataChild2 = listChildData2;


    }
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild2.get(this._listDataHeader2.get(groupPosition))
                .get(childPosititon);
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item2, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem2);

        txtListChild.setText(childText);
        return convertView;
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild2.get(this._listDataHeader2.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader2.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader2.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle2 = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group2, null);
        }

        TextView lblListHeader2 = (TextView) convertView
                .findViewById(R.id.lblListHeader2);
        lblListHeader2.setTypeface(null, Typeface.BOLD);
        lblListHeader2.setText(headerTitle2);

        return convertView;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
