package com.kammo.alokrabi.be_a_android_developer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.kammo.alokrabi.be_a_android_developer.Common.Common;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {
    ExpandableListAdapter listAdapter ;
    ExpandableListAdapter2 listAdapter2;
    ExpandableListView expListView, expListView2;
    private InterstitialAd interstitialAd;

    // List<String> listDataHeader, listDataHeader2;
    ArrayList<String> listDataHeader;/* = new ArrayList<String>(10);*/
    View myFragment;
    HashMap<String, ArrayList<String>> listDataChild , listDataChild2;




    public static HomeFragment newInstance() {
        HomeFragment HomeFragment = new HomeFragment();
        return HomeFragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_home, container, false);

        expListView = (ExpandableListView) myFragment.findViewById(R.id.lvExp);
        expListView2 = (ExpandableListView) myFragment.findViewById(R.id.lvExp2);

        listDataHeader = new ArrayList<String>(99);
        // listDataHeader.ensureCapacity(99);
        listDataChild = new HashMap<String, ArrayList<String>>(99);

        // preparing list data
        prepareListData();
        //prepareListData2();


        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        //listAdapter2 = new ExpandableListAdapter2(getActivity(), listDataHeader2, listDataChild2);


        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView2.setAdapter(listAdapter);


        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

               /* Toast.makeText(getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
               /* Toast.makeText(getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {


            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) listAdapter.getChild(groupPosition, childPosition);

               /* if (childPosition == 0) {
                    Intent intent = new Intent(getActivity(), Create_new_app.class);
                    startActivity(intent);
                }
                else if (childPosition == 1) {
                    Intent intent1 = new Intent(getActivity(), Supporting_Differ_Dev.class);
                    startActivity(intent1);
                }
                else if (childPosition == 2) {
                    //Intent intent = new Intent(getActivity(), FriendList.class);
                    //startActivity(intent);
                }*/
                Intent intent0;
                switch (selected){
                    case "App Fundamentals":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), AppFundamentals.class);
                            startActivity(intent0);
                        }else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Building Your First App":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Create_new_app.class);
                            startActivity(intent0);
                        }else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Supporting Different Devices":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Supporting_Differ_Dev.class);
                            startActivity(intent0);
                        }else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Building a Dynamic UI with Fragments":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), DynamikUI.class);
                            startActivity(intent0);
                        }
                        else {
                        Intent intent = new Intent(getActivity(), NoInternet.class);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                    }
                        break;
                    case "Providing Resources":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), ProvidingResources.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Accessing Resources":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), AccessingResources.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Handling Runtime Changes":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), HandlingRuntimeChanges.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Localization":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Localization.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Complex XML Resources":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), ComplexXMLResources.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Resource Types":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), ResourceTypes.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "App Manifest File":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), AppManifestFile.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Interacting with other Apps":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), InteractOtherApps.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Working With System Permission":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), WorrkingWithSytemPermission.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Saving Key-Value Sets":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SavingKeyValueSets.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Saving Files":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SavingFiles.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Saving Data Using Room":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SavingData.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Saving Data Using SQLite":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SavingDataSQlite.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Sharing Simple Data":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SharingSimpleData.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Sharing Files":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SharingFiles_grp.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Sharing Files with NFC":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), SharingFilesWithNFC.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Capturing Photos":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), CapturingPhotos.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Printing Content":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), PrintingContent.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Permissions Overview":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), PermissionsOverview.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Request App Permissions":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), RequestAppPermissions.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "App Permissions Best Practices":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), BestPractices.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Define Custom Permissions":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), CustomPermissions.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Introduction to Activities":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), IntroductionActivities.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "The Activity Lifecycle":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), ActivityLifecycle.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Activity State Changes":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), ActivityStateChanges.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Tasks and Back Stack":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), TasksBackStack.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Processes and App Lifecycle":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Processes_and_AppLifecycle.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Parcelables and Bundles":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Parcelables_and_Bundles.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Handling App Links":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), HandlingAppLinks.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Loaders":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Loaders.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Recents Screen":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), RecentsScreen.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Multi-Window Support":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), Multi_WindowSupport.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "App Shortcuts":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), AppShortcuts.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "App Widgets":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(), AppWidgets.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Intents and Intent Filters":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(),IntentFilters.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Common Intents":
                        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
                            intent0 = new Intent(getActivity(),CommonIntents.class);
                            startActivity(intent0);
                        }
                        else {
                            Intent intent = new Intent(getActivity(), NoInternet.class);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
               // TODO Auto-generated method stub
                /*Toast.makeText(
                        getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                return false;
            }
        });
    return myFragment;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {

        listDataHeader = new ArrayList<String>(99);
       // listDataHeader.ensureCapacity(99);
        listDataChild = new HashMap<String, ArrayList<String>>(99);

        // Adding child data
        listDataHeader.add("Getting Started");
        listDataHeader.add("App Resources");
        listDataHeader.add("App Permissions");
        listDataHeader.add("Activities");
        listDataHeader.add("Intents");
        listDataHeader.add("Saving App Data");
        listDataHeader.add("Building apps with content sharing");
        listDataHeader.add("Building Apps with Multimedia");
        // Adding child data
        ArrayList<String> Gettind_Started = new ArrayList<String>();
        Gettind_Started.add("App Fundamentals");
        Gettind_Started.add("Building Your First App");
        Gettind_Started.add("Supporting Different Devices");
        Gettind_Started.add("Building a Dynamic UI with Fragments");
        Gettind_Started.add("Interacting with other Apps");
        Gettind_Started.add("Working With System Permission");

        ArrayList<String> App_Resources = new ArrayList<String>();
        App_Resources.add("Providing Resources");
        App_Resources.add("Accessing Resources");
        App_Resources.add("Handling Runtime Changes");
        App_Resources.add("Localization");
        App_Resources.add("Complex XML Resources");
        App_Resources.add("Resource Types");
        App_Resources.add("App Manifest File");

        ArrayList<String> App_Permissions = new ArrayList<String>();
        App_Permissions.add("Permissions Overview");
        App_Permissions.add("Request App Permissions");
        App_Permissions.add("App Permissions Best Practices");
        App_Permissions.add("Define Custom Permissions");

        ArrayList<String> Activities = new ArrayList<String>();
        Activities.add("Introduction to Activities");
        Activities.add("The Activity Lifecycle");
        Activities.add("Activity State Changes");
        Activities.add("Tasks and Back Stack");
        Activities.add("Processes and App Lifecycle");
        Activities.add("Parcelables and Bundles");
        Activities.add("Handling App Links");
        Activities.add("Loaders");
        Activities.add("Recents Screen");
        Activities.add("Multi-Window Support");
        Activities.add("App Shortcuts");
        Activities.add("App Widgets");
       // Activities.add("Intents and Intent Filters");
       // Activities.add("Common Intents");

        // Activities.add("Handling App Links");

        ArrayList<String> Intents = new ArrayList<String>();
        Intents.add("Intents and Intent Filters");
        Intents.add("Common Intents");

        ArrayList<String> saving_App_Data = new ArrayList<String>();
        saving_App_Data.add("Saving Key-Value Sets");
        saving_App_Data.add("Saving Files");
        saving_App_Data.add("Saving Data Using Room");
        saving_App_Data.add("Saving Data Using SQLite");
        //saving_App_Data.add("Red 2");
        //saving_App_Data.add("The Wolverine");

        ArrayList<String> Building_apps_with_content_sharing = new ArrayList<String>();
        Building_apps_with_content_sharing.add("Sharing Simple Data");
        Building_apps_with_content_sharing.add("Sharing Files");
        Building_apps_with_content_sharing.add("Sharing Files with NFC");
        //Building_apps_with_content_sharing.add("The Canyons");
        //Building_apps_with_content_sharing.add("Europa Report");

        ArrayList<String> Building_Apps_with_Multimedia = new ArrayList<String>();
        Building_Apps_with_Multimedia.add("Capturing Photos");
        Building_Apps_with_Multimedia.add("Printing Content");
        //Building_Apps_with_Multimedia.add("The Spectacular Now");
        //Building_Apps_with_Multimedia.add("The Canyons");
        //Building_Apps_with_Multimedia.add("Europa Report");


        listDataChild.put(listDataHeader.get(0), Gettind_Started); // Header, Child data
        listDataChild.put(listDataHeader.get(1), App_Resources);
        listDataChild.put(listDataHeader.get(2), App_Permissions);
        listDataChild.put(listDataHeader.get(3), Activities);
        listDataChild.put(listDataHeader.get(4), Intents);
        listDataChild.put(listDataHeader.get(5), saving_App_Data);
        listDataChild.put(listDataHeader.get(6), Building_apps_with_content_sharing);
        listDataChild.put(listDataHeader.get(7), Building_Apps_with_Multimedia);
       // listDataChild.put(listDataHeader.get(7), Intents);

    }
    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();

        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        ((MainActivity) getActivity()).toolbar.setTitle(R.string.app_name);
                        new AlertDialog.Builder(getActivity())
                                .setMessage(Html.fromHtml("<font color = #175c36> Are you want to exit...?</font>"))
                                .setCancelable(false)
                                .setIcon(R.mipmap.ic_launcher)
                                .setTitle("Android Training")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        getActivity().moveTaskToBack(true);
                                    }
                                }).setNegativeButton("No", null)
                                .show();
                        // Toast.makeText(getActivity(), "Back Pressed", Toast.LENGTH_SHORT).show();
                        return true;

                    }
                }
                return false;
            }
        });


    }

  /*  private void prepareListData2() {
        listDataHeader2 = new ArrayList<String>();
        listDataChild2 = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader2.add("Gettind Started");
        listDataHeader2.add("Saving App Data");
        listDataHeader2.add("Building apps with content sharing");

        // Adding child data
        List<String> Gettind_Started = new ArrayList<String>();
        Gettind_Started.add("Building Your First App");
        Gettind_Started.add("Supporting Different Devices");
        Gettind_Started.add("Building a Dynamik UI with Fragments");
        Gettind_Started.add("Interacting with other Apps");
        Gettind_Started.add("Working With System Permission");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild2.put(listDataHeader2.get(0), Gettind_Started); // Header, Child data
        listDataChild2.put(listDataHeader2.get(1), nowShowing);
        listDataChild2.put(listDataHeader2.get(2), comingSoon);
    }*/

}
